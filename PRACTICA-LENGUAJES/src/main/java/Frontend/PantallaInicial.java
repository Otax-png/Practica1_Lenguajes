    package Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaInicial {

    public PantallaInicial(JFrame pantalla1) {
        //***************************PANTALLA 1***************************//
        Principal Programa = new Principal();
        JPanel Panel = new JPanel();
        JPanel northPane = new JPanel();
        JPanel centerPane = new JPanel();
        JLabel texto1 = new JLabel("Bienvenido");
        //JLabel texto2 = new JLabel("MY FARM", JLabel.CENTER);
        


        Panel.setLayout(new BorderLayout());

        //HEADER
        northPane.add(texto1);
        Panel.add(northPane, BorderLayout.NORTH);

        //BODY

        //Panel.add(texto2, BorderLayout.CENTER);

        //BOTTOM
        Panel.add(centerPane, BorderLayout.SOUTH);
        JButton boton1 = new JButton("Iniciar");
        centerPane.add(boton1);
        
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Panel.removeAll();                
                pantalla1.remove(Panel);
                pantalla1.setSize(600,500);
                pantalla1.add(Programa);
            }
        });
       
        
        //Iniciando Pantalla
        pantalla1.setContentPane(Panel);
        pantalla1.setBounds(400, 150, 200, 150);
        pantalla1.setVisible(true);
        pantalla1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}