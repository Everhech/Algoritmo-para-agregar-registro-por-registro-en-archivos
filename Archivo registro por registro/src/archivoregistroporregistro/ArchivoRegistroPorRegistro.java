package archivoregistroporregistro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ArchivoRegistroPorRegistro {

    public static void main(String[] args) {
        int registros = 1;
        File archivo;
        FileReader leer;
        BufferedReader almacenamiento;
        String cadena, nombre = "", dir = "", email = "";
        archivo = new File("usuarios.txt");

        try {
            leer = new FileReader(archivo);
            almacenamiento = new BufferedReader(leer);
            cadena = "";
            while (cadena != null) {
                try {
                    cadena = almacenamiento.readLine();
                    nombre = cadena;
                    cadena = almacenamiento.readLine();
                    dir = cadena;
                    cadena = almacenamiento.readLine();
                    email = cadena;

                    if (cadena != null) {
                        JOptionPane.showMessageDialog(null, "Nombre: " + nombre + "\nDirección: " + dir + "\nEmail: " + email, "Datos del usuario #" + registros, 1);
                        registros++;
                    }

                } catch (IOException ex) {
                    Logger.getLogger(ArchivoRegistroPorRegistro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                almacenamiento.close();
                leer.close();
            } catch (IOException ex) {
                Logger.getLogger(ArchivoRegistroPorRegistro.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArchivoRegistroPorRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
