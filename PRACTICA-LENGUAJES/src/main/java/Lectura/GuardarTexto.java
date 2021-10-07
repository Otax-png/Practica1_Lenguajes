package Lectura;

import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class GuardarTexto {
    
    public static void guardarArchivo(JTextArea texto){
        String text = texto.getText();
            if(text.length() > 0){
            JFileChooser save = new JFileChooser();
            save.showSaveDialog(null);
            FileWriter fw = null;
            save.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            try{
                File file = save.getSelectedFile();
                if(!file.exists()){
                    PrintWriter pw = new PrintWriter(file.getPath() + ".txt");
                    pw.print(text); 
                    pw.close();
                }
                else{
                    JOptionPane.showConfirmDialog(null, "El archivo ya existe");
                }
            }catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al guardar, ponga nombre al archivo");
            }
            finally{
                try{
                    if(fw!=null){
                    fw.close();
                    }
                }catch(Exception ex){
                    ex.printStackTrace(System.out);
                }
            }
        }
    }
}
