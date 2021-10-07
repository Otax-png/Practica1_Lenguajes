package Lectura;

import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class LecturaTexto {


    public static String LeerArchivos(){

        JFileChooser cargar = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Carga de datos","txt");
        cargar.setFileFilter(filtro);
        cargar.showOpenDialog(null);
        cargar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        File archivo = cargar.getSelectedFile();
        String texto = "";
        try{
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();
                    
            while(lectura != null)  {
                texto = texto + lectura + "\n";
                lectura = entrada.readLine();
            }
            entrada.close();
            return texto;
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error al cargar el archivo");
            System.out.println(ex);
            return "";
        }

    }
}
