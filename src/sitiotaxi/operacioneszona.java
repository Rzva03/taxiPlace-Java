/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sitiotaxi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author abigail
 */
public class operacioneszona {

    public void Escritura(String nomArchivo, zona e) {
        try {
            FileWriter fw = new FileWriter(nomArchivo, true);
            BufferedWriter archivoEscritura = new BufferedWriter(fw);
            String guardar = e.toString();
            archivoEscritura.write(guardar);
            archivoEscritura.newLine();//como salto de linea
            archivoEscritura.flush();//para borrar el bufferedWrite
            archivoEscritura.close();//cierra el archivo
        } catch (IOException a) {
            System.out.println(a);

        }

    }

    public zona buscarObj(String nomArchivo, int i) {
        zona al = new zona();
        String cadena = "";
        FileReader fr;
        try {
            fr = new FileReader(nomArchivo);
            BufferedReader archivoLectura = new BufferedReader(fr);
            cadena = archivoLectura.readLine();
            while (cadena != null) {
                StringTokenizer st = new StringTokenizer(cadena, ",");
                int indice = Integer.parseInt(st.nextToken());
                if (indice == i) {
                    al.setId_zona(indice);
                    al.setZona(st.nextToken());
                    al.setCosto(Double.parseDouble(st.nextToken()));

                    //System.out.println(al.toString());
                }

                cadena = archivoLectura.readLine();
            }
            archivoLectura.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el archivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("No se puede leer el archivo");
            e.printStackTrace();

        }
        return al;
    }

    public boolean modificar(String Archivo, int c, zona al, String temporal) {
    String cadenaEncontrada = "";
        FileReader fr;
        try {
            fr = new FileReader(Archivo);
            BufferedReader archivoLectura = new BufferedReader(fr);
            cadenaEncontrada = archivoLectura.readLine();
            while (cadenaEncontrada != null) {
                StringTokenizer st = new StringTokenizer(cadenaEncontrada, ",");
                int indice = Integer.parseInt(st.nextToken());
                if (indice != c) {
                    try {
                        FileWriter fw = new FileWriter(temporal, true);
                        BufferedWriter archivoEscritura = new BufferedWriter(fw);
                        String guardar = al.toString();
                        archivoEscritura.write(guardar);
                        archivoEscritura.newLine();
                        al.setId_zona(indice);
                        al.setZona(st.nextToken());
                        al.setCosto(Double.parseDouble(st.nextToken()));
                        String guardar2 = al.toString();
                        archivoEscritura.write(guardar2);
                        archivoEscritura.newLine();
                        archivoEscritura.flush();
                        archivoEscritura.close();
                        fw.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
                cadenaEncontrada = archivoLectura.readLine();
            }
            archivoLectura.close();
            fr.close();
            File file = new File(Archivo);
            file.delete();
            File file2 = new File(temporal);
            file2.renameTo(file);
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo");
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo");
        }
        return false;    
    }
}
