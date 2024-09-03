package Juego;

import static Implementacion.App.ventana;
import Juego.enemigos.*;
import Juego.personaje.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import logica.musica;

/**
 * Esta clase se encarga del panel y de todo el hilo del juego en esta clase se
 * desarollaran la mayoria de la logica del programa esta clase tendra un hilo
 * que se encargara de repintar todo el Panel para poder una vista a tiempo real
 */
public class Game extends JFrame {

    private JPanel principal = new JPanel();
    private nave minave = new nave();
    private JPanel panel = new JPanel();
    private Vista_Inferior vista_inferior = new Vista_Inferior();
    private Vista_Superior vista_superior = new Vista_Superior();
    private NaveNodriza naveNodriza = new NaveNodriza(20, 20);
    private Pause pause = new Pause();
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

    private Timer t = null;
    private Disparo_Personaje disparo = null;
    private boolean bandera = true;
    private Timer hilo = null;
    private Timer hiloMovimiento = null;

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
        Toolkit miPantalla =   Toolkit.getDefaultToolkit();
        Image miIcono = miPantalla.getImage("src/source/extra/spaceinvaders_512_icon.png");
        setIconImage(miIcono);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 750);
        setLocationRelativeTo(null);
        setResizable(false);
        add(principal);

        /**
         * en esta parte llamamos a un evento de teclado y hacemos uso de una
         * clase anonima para poder llamar al metodo KeyPressed que se encarga
         * de mover la nave y crear los objetos de disparo de la nave
         */
        MoverEnemigos();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                minave.mover(e);

                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    crearDisparo();
                }
            }
        });
        panel.add(naveNodriza);
        panel.add(minave);

        /**
         * Agrega la matriz de los enemigos al panel
         */
        for (int i = 0; i < enemigos.length; i++) {
            for (int j = 0; j < enemigos[i].length; j++) {
                enemigos[i][j].AnimacionYSkin(tipoJuego);
                //panel.add(enemigos[i][j]);
            }
        }
        setFocusable(true);

        /**
         * esta Timer se encarga de revalidar y repintar el panel para tener una
         * vista refresacada del juego
         */
        hilo = new Timer(150, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vista_superior.band) {
                    hiloMovimiento.stop();
                    panel.add(pause);
                    vista_superior.band = false;
                }
                if (pause.bandera) {
                    hiloMovimiento.start();
                    panel.remove(pause);
                    pause.bandera = false;
                }
                if (pause.detener) {
                    dispose();
                }
                naveNodriza.update();
                panel.revalidate();
                panel.repaint();
            }
        });
        hilo.start();
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
                                }
                            }
                        }
                    }
                }

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

    private void MoverEnemigos() {
        /**
         * Este hilo crea la animacion de movimiento de los enemigos y tiene un
         * condicional que pregunta si los enemigos con el personaje han
         * colisionado.
         */
        hiloMovimiento = new Timer(700, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * Recorre la matriz y pregunta si la ultima fila de los
                 * enemigos llego a la cordenada 550, si es asi baja la fila. En
                 * caso contrario si llega a 0 baja. Pregunta si la nave a sido
                 * intersectada por alguno de los enemigos
                 */
                new musica("src/source/music/Movimiento de enemigo.wav").reproducirClic();
                for (int i = 0; i < enemigos.length; i++) {
                    for (int j = 0; j < enemigos[i].length; j++) {
                        if (enemigos[i][j].getBounds().intersects(minave.getBounds())) {
                            panel.add(new GameOver());
                            hiloMovimiento.stop();
                        }
                        if (enemigos[i][j].getX() > 550 && bandera) {
                            moverTodasAbajo();
                            bandera = false;
                        }
                        if (enemigos[i][j].getX() < 0 && !bandera) {
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
             * Y
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
}
