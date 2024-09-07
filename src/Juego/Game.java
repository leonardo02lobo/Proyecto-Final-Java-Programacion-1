package Juego;

import Juego.enemigos.*;
import Juego.personaje.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import logica.*;

/**
 * Esta clase se encarga del panel y de todo el hilo del juego en esta clase se
 * desarollaran la mayoria de la logica del programa esta clase tendra un hilo
 * que se encargara de repintar todo el Panel para poder una vista a tiempo real
 */
public class Game extends JFrame {

    //variables necesarias para el funcionamiento de la app
    //variables de la apariencia del juego
    private JPanel principal = new JPanel();
    private JPanel panel = new JPanel();
    private Vista_Inferior vista_inferior = new Vista_Inferior();
    private Vista_Superior vista_superior = new Vista_Superior();
    private Pause pause = new Pause();
    private GameOver game_over = new GameOver();
    private byte tipoJuego;

    //variables de la logica del juego
    private nave minave;
    private NaveNodriza naveNodriza = null;
    private Disparo_Enemigo dis;
    private Alienigenas enemigos[][] = {
        {new Calamar(45, 100), new Calamar(90, 100), new Calamar(135, 100), new Calamar(180, 100), new Calamar(225, 100), new Calamar(270, 100), new Calamar(315, 100), new Calamar(360, 100), new Calamar(405, 100), new Calamar(450, 100), new Calamar(495, 100)},
        {new Cangrejo(45, 145), new Cangrejo(90, 145), new Cangrejo(135, 145), new Cangrejo(180, 145), new Cangrejo(225, 145), new Cangrejo(270, 145), new Cangrejo(315, 145), new Cangrejo(360, 145), new Cangrejo(405, 145), new Cangrejo(450, 145), new Cangrejo(495, 145)},
        {new Cangrejo(45, 190), new Cangrejo(90, 190), new Cangrejo(135, 190), new Cangrejo(180, 190), new Cangrejo(225, 190), new Cangrejo(270, 190), new Cangrejo(315, 190), new Cangrejo(360, 190), new Cangrejo(405, 190), new Cangrejo(450, 190), new Cangrejo(495, 190)},
        {new Pulpo(45, 235), new Pulpo(90, 235), new Pulpo(135, 235), new Pulpo(180, 235), new Pulpo(225, 235), new Pulpo(270, 235), new Pulpo(315, 235), new Pulpo(360, 235), new Pulpo(405, 235), new Pulpo(450, 235), new Pulpo(495, 235)},
        {new Pulpo(45, 280), new Pulpo(90, 280), new Pulpo(135, 280), new Pulpo(180, 280), new Pulpo(225, 280), new Pulpo(270, 280), new Pulpo(315, 280), new Pulpo(360, 280), new Pulpo(405, 280), new Pulpo(450, 280), new Pulpo(495, 280)},};
    private boolean band[][] = {
        {false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false, false, false},};

    //variables extras para el funcionamiento del juego
    private Timer t = null;
    private Disparo_Personaje disparo = null;
    private boolean bandera = true;
    private Timer hilo = null;
    private Timer hiloMovimiento = null;
    private Timer hiloNave = null;
    public static boolean band_finalizar_Juego = false;
    private int MoverEnemigo = 700;

    //metodo constructor del juego que inicializa el frame y coloca los paneles respectivos
    public Game(byte tipoJuego) {
        //agregando el panel
        principal.setBackground(Color.BLACK);
        principal.setLayout(new BorderLayout());
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        principal.add(vista_superior, BorderLayout.NORTH);
        principal.add(panel, BorderLayout.CENTER);
        principal.add(vista_inferior, BorderLayout.SOUTH);

        //colocacion del frame
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Image miIcono = miPantalla.getImage("src/source/extra/spaceinvaders_512_icon.png");
        setIconImage(miIcono);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Space Invader");
        setSize(600, 750);
        setLocationRelativeTo(null);
        setResizable(false);
        add(principal);

        //variable que determina la apariencia del jugador
        this.tipoJuego = tipoJuego;

        //metodo que se encarga de la logica del juego
        Logica_Juego();
    }

//--------------------------------METODOS DE LA LOGICA DEL JUEGO---------------------------------------------
    /**
     * Este metodo se encarga de llamar e craer toda la logica del juego
     */
    private void Logica_Juego() {
        //metodo para el movimiento de los enemigos
        MoverEnemigos();

        /**
         * en esta parte llamamos a un evento de teclado y hacemos uso de una
         * clase anonima para poder llamar al metodo KeyPressed que se encarga
         * de mover la nave y crear los objetos de disparo de la nave
         */
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                minave.mover(e);

                //crear el disparo
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    crearDisparo();
                }
            }
        });
        setFocusable(true);
        //Instanciar y agregar la nave
        minave = new nave(tipoJuego);
        panel.add(minave);

        /**
         * Agrega la matriz de los enemigos al panel
         */
        for (int i = 0; i < enemigos.length; i++) {
            for (int j = 0; j < enemigos[i].length; j++) {
                enemigos[i][j].AnimacionYSkin(tipoJuego);
                panel.add(enemigos[i][j]);
            }
        }

        /**
         * esta Timer se encarga de revalidar y repintar el panel para tener una
         * vista refresacada del juego, tambien esta al pendiente cuando los
         * enemigos disparan y si el disparo colisiona con el disparo del
         * enemigo o llega al final del panel, este un delay de 15 milisegundo
         * para que la respuesta sea lo mas rapida posible
         */
        hilo = new Timer(15, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vista_superior.band) {
                    hiloMovimiento.stop();
                    detenerAnimacionEnemigos();
                    hiloNave.stop();
                    panel.add(pause);
                    vista_superior.band = false;
                }
                if (pause.bandera) {
                    hiloMovimiento.start();
                    hiloNave.start();
                    panel.remove(pause);
                    seguirAnimacion();
                    pause.bandera = false;

                }
                if (pause.detener || band_finalizar_Juego) {
                    dispose();
                }
                //revisa si el disparo del enemigo a sido colisionado con el del jugador 
                ColisionDisparoEnemigoPersonaje();

                panel.revalidate();
                panel.repaint();
            }

        });
        hilo.start();
        /**
         * Este hilo se encarga de la nave nodriza y esta configurado para un
         * timer entre 30 a 40segundos para volver a aparecer, la variable
         * tiempo se encarga de almacenar un numero entre el rango dicho, y
         * calula el tiempo
         */
        hiloNave = new Timer(1000, new ActionListener() {
            int tiempo = (int) (Math.random() * (40 - 30) + 30);
            int cont = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (tiempo == cont) {
                    naveNodriza = new NaveNodriza(-20, 20);
                    panel.add(naveNodriza);
                    naveNodriza.update();
                    cont = 0;
                    tiempo = (int) (Math.random() * (40 - 30) + 30);
                }
                cont++;
            }
        });
        hiloNave.start();
    }

    /**
     * este metodo se encarga de crear un objeto de tipo Disparo_Personaje y
     * mandarlo hacia arriba, crerando la ilusion de que el disparo va directo a
     * un enemigo
     */
    private void crearDisparo() {
        /**
         * Pregunta si el disparo no se a eliminado
         */
        if (disparo == null) {
            //crea la musica
            new musica("src/source/music/disparo.wav").reproducirClic();
            //crea un disparo y lo posiciona y lo añade al panel
            int x = minave.getRectangle().x + (minave.getRectangle().width / 2);
            disparo = new Disparo_Personaje(x, minave.getRectangle().y - 50);
            panel.add(disparo);
            /**
             * pregunta si el timer existente esta activo todavia
             */
            if (t != null) {
                t.stop();
                t = null;
            }
            //comienza un nuevo Timer
            t = new Timer(20, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (disparo != null) {
                        //crea la animacion de disparo 
                        if (disparo.getY() != -10) {
                            disparo.setLocation(x, disparo.movimientoDisparo());
                        } else {
                            panel.remove(disparo);
                            disparo = null;
                            t.stop();
                            t = null;
                        }
                        /**
                         * Se crea una etiqueta para determinar si el usuario le
                         * disparo a un enemigo. En el condicional pregunta si
                         * el disparo fue intersectado por el enemigo, si la
                         * posicion existe un enemigo y si el objeto enemigo es
                         * difernete de null. Elimina los disparos y el enemigo
                         * y coloca la posicion como eliminada. Detiene el Timer
                         * y el disparo lo coloca en null y corta el bucle
                         * directamente por la etiqueta
                         */
                        enemigo:
                        for (int i = 0; i < enemigos.length; i++) {
                            for (int j = 0; j < enemigos[i].length; j++) {
                                if (disparo != null && enemigos[i][j].getRectangle().intersects(disparo.getRectangle()) && !band[i][j]) {
                                    new musica("src/source/music/muere enemigo.wav").reproducirClic();
                                    panel.remove(disparo);
                                    panel.remove(enemigos[i][j]);
                                    band[i][j] = true;
                                    sumaPuntos(i, j);
                                    t.stop();
                                    t = null;
                                    disparo = null;
                                    break enemigo;
                                } else if (naveNodriza != null) {
                                    try {
                                        if (disparo.getRectangle().intersects(naveNodriza.getRectangle())) {
                                            panel.remove(disparo);
                                            panel.remove(naveNodriza);
                                            vista_superior.SumarPuntos(naveNodriza.getPuntos());
                                            disparo = null;
                                            t = null;
                                            t.stop();
                                        }
                                    } catch (Exception ex) {
                                    }
                                }
                            }
                        }
                    }
                }

                /**
                 * Este metodo se encarga de determinar la clase que proviene la
                 * posicion de la matriz de enemigos y con ello poder determinar
                 * el puntaje del personaje.
                 */
                private void sumaPuntos(int i, int j) {
                    if (enemigos[i][j] instanceof Calamar) {
                        vista_superior.SumarPuntos(30);
                    } else if (enemigos[i][j] instanceof Cangrejo) {
                        vista_superior.SumarPuntos(20);
                    } else if (enemigos[i][j] instanceof Pulpo) {
                        vista_superior.SumarPuntos(10);
                    }
                }
            });
            t.start();
        }
    }

    /**
     * Este metodo se encarga de mover los enemigos de manera que cuando falten
     * pocos el timer se valla incremnetando de velocidad para que sea mas
     * dificil ganar.
     */
    private void MoverEnemigos() {
        /**
         * Este hilo crea la animacion de movimiento de los enemigos y tiene un
         * condicional que pregunta si los enemigos con el personaje han
         * colisionado.
         */
        hiloMovimiento = new Timer(MoverEnemigo, new ActionListener() {
            boolean colision = false;

            @Override
            public void actionPerformed(ActionEvent e) {

                //va revisando la matriz de booleanos para determinar el total de vivos
                DeterminarTotalEnemigos();

                //crear colision  para que muera el personaje
                if (vista_inferior.VidasTotales < 1) {
                    Game_Over();
                }
                if (dis != null) {
                    colision = false;
                }
                try {
                    panel.add(dis);
                    dis.setLocation(dis.getX(), dis.movimientoDisparo());
                    if (dis.getRectangle().intersects(minave.getRectangle()) && !colision) {
                        panel.remove(dis);
                        vista_inferior.QuitarVida();
                        panel.remove(minave);
                        minave = null;
                        dis = null;
                        minave = new nave(tipoJuego);
                        panel.add(minave);
                        colision = true;
                    }
                } catch (Exception ex) {
                }
                /**
                 * Recorre la matriz y pregunta si la ultima fila de los
                 * enemigos llego a la cordenada 550, si es asi baja la fila, En
                 * caso contrario si llega a 0 baja, Pregunta si la nave a sido
                 * intersectada por alguno de los enemigos.
                 */
                new musica("src/source/music/Movimiento de enemigo.wav").reproducirClic();
                for (int i = 0; i < enemigos.length; i++) {
                    for (int j = 0; j < enemigos[i].length; j++) {
                        if (enemigos[i][j].getBounds().intersects(minave.getBounds()) && !band[i][j]) {
                            Game_Over();
                        }
                        if (enemigos[i][j].getX() > panel.getWidth()-50 && bandera && !band[i][j]) {
                            moverTodasAbajo();
                            bandera = false;
                        }
                        if (enemigos[i][j].getX() < 0 && !bandera && !band[i][j]) {
                            moverTodasAbajo();
                            bandera = true;
                        }
                        if (bandera) {
                            enemigos[i][j].moverX();
                        } else {
                            enemigos[i][j].moverXNegativo();
                        }
                    }
                }
            }

            /**
             * Este metodo se activa si la ultima fila de la matriz de enemigos
             * llega al final o al inicio del panel parta bajar la coordenada en
             * Y.
             */
            private void moverTodasAbajo() {
                for (int i = 0; i < enemigos.length; i++) {
                    for (int j = 0; j < enemigos[i].length; j++) {
                        enemigos[i][j].moverY();
                    }
                }
            }
        });
        hiloMovimiento.start();
    }

    /**
     * Este metodo se encarga de revisar si el disparo de los enemigos fue
     * colisionado con el disparo de la nave, si es asi se elimina y se vuelve a
     * crear el disparo.
     */
    private void ColisionDisparoEnemigoPersonaje() {
        //traer el objeto de disparo enemigo a este metod y hacer todas las comprobaciones
        int aux = (int) (Math.random() * band.length);
        if (!band[band.length - 1][aux] && dis == null) {
            dis = new Disparo_Enemigo(enemigos[band.length - 1][aux].getX(), enemigos[band.length - 1][aux].getY());
            panel.add(dis);
            dis.setLocation(dis.getX(), dis.movimientoDisparo());
        }
        try {
            if (disparo.getRectangle().intersects(dis.getRectangle()) || dis.getY() > 520) {
                new musica("src/source/music/Muerte pistola.wav").reproducirClic();
                panel.remove(dis);
                panel.remove(disparo);
                dis = null;
            }
        } catch (Exception e) {
        }
    }

    private void Game_Over() {
        panel.add(game_over);
        hiloMovimiento.stop();
        detenerAnimacionEnemigos();
        hiloNave.stop();
        if (naveNodriza != null) {
            naveNodriza.animacion.stop();
        }
    }

    private void detenerAnimacionEnemigos() {
        try {
            panel.remove(dis);
        } catch (Exception e) {
        }
        panel.remove(minave);
        for (int i = 0; i < enemigos.length; i++) {
            for (int j = 0; j < enemigos[i].length; j++) {
                enemigos[i][j].animacion.stop();
                panel.remove(enemigos[i][j]);
            }
        }
    }

    private void seguirAnimacion() {
        try {
            panel.add(dis);
        } catch (Exception e) {
        }
        panel.add(minave);
        for (int i = 0; i < enemigos.length; i++) {
            for (int j = 0; j < enemigos[i].length; j++) {
                enemigos[i][j].animacion.start();
                panel.add(enemigos[i][j]);
            }
        }
    }

    private void DeterminarTotalEnemigos() {
        int total = 0;

        for (int i = 0; i < band.length; i++) {
            for (int j = 0; j < band[i].length; j++) {
                if (!band[i][j]) {
                    total++;
                }
            }
        }

        if (total == 10) {
            MoverEnemigo /= 2;
            hiloMovimiento.stop();
            hiloMovimiento = null;
            MoverEnemigos();
        }
    }
}
