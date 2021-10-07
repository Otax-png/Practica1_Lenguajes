package Frontend;

import Backend.Inicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaGame{

    int puntosVida;
    static JLabel vida;
    static JPanel panel2 = new JPanel();
    static JPanel centerPane = new JPanel();
    static JPanel northPane = new JPanel();


    public PantallaGame(JFrame pantalla1) {
        panel2(pantalla1);
    }

    public static void panel2(JFrame pantalla1){

        panel2.setLayout(new BorderLayout());
        
        //****************HEADER****************//
        northPane.setLayout(new GridLayout());
        panel2.add(northPane, BorderLayout.NORTH);
        

        //****************BODDY****************//
        centerPane.setLayout(new GridLayout(5,5));
        panel2.add(centerPane, BorderLayout.CENTER);

        for (int i = 0; i < 25; i++) {
            generarCelda();
        }

        //Agregando panel2 a Pantalla1
        pantalla1.setContentPane(panel2);
        pantalla1.setVisible(true);

        //************************Generando Paneles de Opciones************************//
        JPanel panelUsuario = new JPanel();
        JButton comprarTierra = new JButton("Comprar Tierra");
        comprarTierra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                generarCelda();
                int dinero = Granjero.getCantidadDinero();
                dinero = dinero - 1000;
                Granjero.setCantidadDinero(dinero);
            }
        });
        //Boton Alimentar
        JButton alimentar = new JButton("Alimentar");
        alimentar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        panelUsuario.setLayout(new BoxLayout(panelUsuario,BoxLayout.Y_AXIS));

        panelUsuario.add(comprarTierra);
        panelUsuario.add(alimentar);
        panel2.add(panelUsuario, BorderLayout.WEST);
        panel2.add(controlPanelOpciones.obtenerPanel(), BorderLayout.EAST); //panel de Opciones

    }

//****************ESTADISTICAS JUGADOR****************//
    public static void mostrarVida(int puntosVida){
        vida.setText("Vida " + puntosVida);
        //SwingUtilities.updateComponentTreeUI(vida);
    }

    public static void mensajeMuerte(){
        panel2.removeAll();
        JButton again = new JButton("Reintentar");
        JButton exit = new JButton("Salir");

        JPanel muerte = new JPanel();
        JLabel mensajeMuerte = new JLabel("Estas Muerto",JLabel.CENTER);
        panel2.remove(northPane);
        panel2.remove(centerPane);
        panel2.add(muerte, BorderLayout.SOUTH);
        panel2.add(mensajeMuerte);
        muerte.add(again);
        muerte.add(exit);
        SwingUtilities.updateComponentTreeUI(panel2);

        //BOTON REINTENTAR
        again.addActionListener(actionEvent -> {
            Juego newMYFARM = new Juego();
            newMYFARM.iniciarJuego();
        });
        //BOTON SALIR
        exit.addActionListener(actionEvent -> System.exit(0));

    }

//****************Metodos para Botones****************//
    public static void generarCelda() {
        Boton  Botoncillo;

        int random = Utilidades.generarRandom(0, 100);

        if (random >= 0 && random <= 40) {
            Botoncillo = new Boton(new Grama());
            Botoncillo.setBackground(Color.GREEN);
            Botoncillo.setText("Grama");
            centerPane.add(Botoncillo);
        }

        else if (random >= 41 && random <= 75) {
            Botoncillo = new Boton(new Agua());
            Botoncillo.setBackground(Color.BLUE);
            centerPane.add(Botoncillo);
            Botoncillo.setText("Agua");
        }

        else if (random >= 76 && random <= 100) {
            Botoncillo = new Boton(new Desierto());
            Botoncillo.setBackground(Color.YELLOW);
            centerPane.add(Botoncillo);
            Botoncillo.setText("Desierto");
            Botoncillo.setEnabled(false);
        }
    }

}
