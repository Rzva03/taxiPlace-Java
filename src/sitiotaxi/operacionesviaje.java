/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sitiotaxi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author abigail
 */
public class operacionesviaje {

    public void Escritura(String nomArchivo, viaje e) {
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
    public DefaultTableModel listaviaje(){
        Vector ca = new Vector();
        ca.addElement("Zona");
        ca.addElement("Usuario");
        ca.addElement("Num. Personas");
        DefaultTableModel tabla= new DefaultTableModel(ca,0);
        try{
            FileReader fr = new FileReader("viajes.txt");
            BufferedReader br = new BufferedReader(fr);
            String d;
            while((d=br.readLine())!=null){
                StringTokenizer dato= new StringTokenizer(d,",");
                Vector x = new Vector();
                while(dato.hasMoreElements()){
                    x.addElement(dato.nextToken());
                }
                tabla.addRow(x);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return tabla;
    }
}
