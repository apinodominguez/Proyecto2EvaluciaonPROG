package Archivos;

import Utils.MetodosVarios;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import personaje.Atributos;
import personaje.Metodos;


public class Escritura {
    
    
    
    public void crearArchivo(ArrayList <Atributos> atrList,int dureza,String raza,String tamano, int paso) throws IOException{
        File file = new File(MetodosVarios.pedirString("Introduce el nombre del archivo: ") + ".txt");
        PrintWriter ps = null;
        try {
            ps = new PrintWriter(file);
            
            ps.println("Nombre: " + MetodosVarios.pedirString("Introduce el nombre del personaje: "));
            ps.println("Raza: " + raza);
            ps.println("Tamaño: " + tamano);
            ps.println("");
            
            ps.println("Atributos:");
            ps.println("");
            for (Atributos atr : atrList) {
            ps.println(atr);
        }
            ps.println("");
            ps.println("Valores asociados: ");
            ps.println("Dureza: " + dureza);
            ps.println("Paso: " + paso);
        ps.close();
        } catch (FileNotFoundException e) {
        System.out.println("Fichero no encontrado "+file);
        } finally{
            ps.close();
        }

    }
    
}
