package Juego;

import Juego.enemigos.*;
import Juego.personaje.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Nivel_2 extends Logica_Juego {

    //variables de la apariencia del juego
    private JFrame ventana = new JFrame();

    //-----------------------------VARIABLES DE LA LOGICA DEL JUEGO---------------------------------
    private NaveNodriza_Nivel_2 nave1 = new NaveNodriza_Nivel_2(60, 20);
    private NaveNodriza_Nivel_2 nave2 = new NaveNodriza_Nivel_2(360, 20);
    private JLabel ondas_Nave1[] = new JLabel[12];
    private JLabel ondas_Nave2[] = new JLabel[12];
    private Timer hiloNave_Nodriza1 = null;
    private Timer hiloNave_Nodriza2 = null;

    //----------------------------------------------------------------------------------------------
    //metodo constructor del juego que inicializa el frame y coloca los paneles respectivos
    public Nivel_2(byte tipoJuego) {
        this.tipoJuego = tipoJuego;//variable que determina la apariencia del jugador
    }

    //-------------------------------CREACION DE LA VENTANA Y LLAMADA A LOS METODOS IMPORNTANTES-----
    /**
     * En este metodo se crea el Jframe y se instancia el panel para poder
     * llamar a la logica del juego.
     */
    public void inicializarFrame() {
        //colocacion del frame
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Image miIcono = miPantalla.getImage("src/source/extra/spaceinvaders_512_icon.png");
        ventana.setIconImage(miIcono);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setTitle("Space Invader-Nivel 2");
        ventana.setSize(600, 750);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        ventana.add(principal);
        ventana.setVisible(true);

        //agregando el panel
        principal.setBackground(Color.BLACK);
        principal.setLayout(new BorderLayout());
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        principal.add(vista_superior, BorderLayout.NORTH);
        principal.add(panel, BorderLayout.CENTER);
        principal.add(vista_inferior, BorderLayout.SOUTH);
        ventana.setVisible(true);

        //metodo que se encarga de la logica del juego
        Logica_Juego();

        CrearNaveNodriza1();
        CrearNaveNodriza2();
        /**
         * en esta parte llamamos a un evento de teclado y hacemos uso de una
         * clase anonima para poder llamar al metodo KeyPressed que se encarga
         * de mover la nave y crear los objetos de disparo de la nave
         */
        ventana.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                minave.mover(e);

                //crear el disparo
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    crearDisparo();
                }
            }
        });
        ventana.setFocusable(true);

        //llamar al metodo que se encarga de la animacion del juego
        hiloJuego(ventana);

    }

    //--------------------------------METODOS DE LA LOGICA DEL JUEGO------------------------------------------
    private void CrearNaveNodriza1() {
        panel.add(nave1);

        hiloNave_Nodriza1 = new Timer(100, new ActionListener() {
            int i = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (nave1 != null && disparo != null) {
                        if (nave1.getBounds().intersects(disparo.getBounds())) {
                            nave1.golpes++;
                            if (nave1.golpes == 2) {
                                vista_superior.SumarPuntos(nave1.getPuntos());
                                panel.remove(nave1);
                                nave1 = null;
                                panel.remove(disparo);
                                disparo = null;
                                RemoverTodasLasOndas();
                            }
                        }
                    }

                    if (minave != null && nave1 != null) {
                        if (minave.getBounds().x >= nave1.getBounds().x && (minave.getBounds().x + minave.getBounds().width) <= (nave1.getBounds().x + nave1.getBounds().width)) {
                            CrearOndas1(i);
                            if (i != ondas_Nave1.length) {
                                i++;
                            }
                        } else {
                            if (i != 0) {
                                i--;
                            }
                            EliminarOndas(i);
                        }
                    }
                    Muertejugador();
                    panel.revalidate();
                    panel.repaint();
                } catch (Exception ex) {
                }
            }
        });
        hiloNave_Nodriza1.start();
    }

    private void CrearNaveNodriza2() {
        panel.add(nave2);

        hiloNave_Nodriza2 = new Timer(100, new ActionListener() {
            int i = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (nave2 != null && disparo != null) {
                        if (nave2.getBounds().intersects(disparo.getBounds())) {
                            nave2.golpes++;
                            if (nave2.golpes == 2) {
                                vista_superior.SumarPuntos(nave2.getPuntos());
                                panel.remove(nave2);
                                nave2 = null;
                                panel.remove(disparo);
                                disparo = null;
                                RemoverTodasLasOndas();
                            }
                        }
                    }

                    if (minave != null && nave2 != null) {
                        if (minave.getBounds().x >= nave2.getBounds().x && (minave.getBounds().x + minave.getBounds().width) <= (nave2.getBounds().x + nave2.getBounds().width)) {
                            CrearOndas2(i);
                            if (i != ondas_Nave2.length) {
                                i++;
                            }
                        } else {
                            if (i != 0) {
                                i--;
                            }
                            EliminarOndas(i);
                        }
                    }
                    Muertejugador();
                    panel.revalidate();
                    panel.repaint();
                } catch (Exception ex) {
                }
            }
        });
        hiloNave_Nodriza2.start();
    }

    private void CrearOndas1(int i) {
        try {
            if (ondas_Nave1 != null && nave1 != null) {
                ondas_Nave1[i] = new JLabel();
                int anchoIncrementado = nave1.getBounds().width + (i * 10);
                ondas_Nave1[i] = nave1.laser(60 - (i * 5), nave1.getBounds().height * i + nave1.getBounds().y, anchoIncrementado, nave1.getBounds().height);
                panel.add(ondas_Nave1[i]);
            }
        } catch (Exception e) {
        }
    }

    private void CrearOndas2(int i) {
        try {
            if (ondas_Nave2 != null && nave2 != null) {
                ondas_Nave2[i] = new JLabel();
                int anchoIncrementado = nave2.getBounds().width + (i * 10);
                ondas_Nave2[i] = nave2.laser(360 - (i * 5), nave2.getBounds().height * i + nave2.getBounds().y, anchoIncrementado, nave2.getBounds().height);
                panel.add(ondas_Nave2[i]);
            }
        } catch (Exception e) {
        }
    }

    private void EliminarOndas(int i) {
        try {
            if (ondas_Nave1 != null && ondas_Nave1[i] != null) {
                panel.remove(ondas_Nave1[i]);
                ondas_Nave1[i] = null;
            }

            if (ondas_Nave2 != null && ondas_Nave2[i] != null) {
                panel.remove(ondas_Nave2[i]);
                ondas_Nave2[i] = null;
            }
        } catch (Exception e) {
        }
    }

    private void RemoverTodasLasOndas() {
        try {
            if (ondas_Nave1 != null) {
                for (int i = 0; i < ondas_Nave1.length; i++) {
                    if (ondas_Nave1[i] != null) {
                        panel.remove(ondas_Nave1[i]);
                        ondas_Nave1[i] = null;
                    }
                }
            }

            if (ondas_Nave2 != null) {
                for (int i = 0; i < ondas_Nave2.length; i++) {
                    if (ondas_Nave2[i] != null) {
                        panel.remove(ondas_Nave2[i]);
                        ondas_Nave2[i] = null;
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    private void Muertejugador() {
        if (ondas_Nave1 != null && ondas_Nave1[ondas_Nave1.length - 1] != null && ondas_Nave1[ondas_Nave1.length - 1].getBounds().intersects(minave.getBounds())) {
            vista_inferior.QuitarVida();
            panel.remove(minave);
            minave = null;
            minave = new nave(tipoJuego);
            panel.add(minave);
            RemoverTodasLasOndas();
        }

        if (ondas_Nave2 != null && ondas_Nave2[ondas_Nave2.length - 1] != null && ondas_Nave2[ondas_Nave2.length - 1].getBounds().intersects(minave.getBounds())) {
            vista_inferior.QuitarVida();
            panel.remove(minave);
            minave = null;
            minave = new nave(tipoJuego);
            panel.add(minave);
            RemoverTodasLasOndas();
        }

        if (finalJuego2) {
            FinalJuego();
        }
    }
}
