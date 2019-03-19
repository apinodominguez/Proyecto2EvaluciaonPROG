package App;

import Archivos.Escritura;
import Utils.MetodosVarios;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import personaje.Atributos;
import personaje.Metodos;

public class Cliente {
   
   Escritura objArch = new Escritura(); 
   Metodos objMet = new Metodos(); 
   ArrayList <Atributos> atr = new ArrayList<>();
   
   public void clienteAtributos(){
   String op;

    objMet.initAtributos(atr);
   
    do{
        op = MetodosVarios.pedirString("****MENU****\n\n Escribe la primera palabra para escoger una opcion\n\n1 -> Elegir raza\n2 -> Dar atributos\n3-> Quitar atributos\n4-> Mostrar atributos\n5 -> Imprimir archivo\n0 -> Salir\n");
        switch(op.toLowerCase()){
            case "dar":
                objMet.darAtr(atr);
                break;
            case "quitar":
                objMet.quitarAtr(atr);
                break;
            case "mostrar":
                objMet.mostrarAtr(atr);
                break;
            case "imprimir":
                if(objMet.getMaxAtr() == 0){
        {
            try {
                objArch.crearArchivo(atr,objMet.getDureza(),objMet.getRaza(),objMet.getTamano(),objMet.getPaso());
            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }}
                else{
                    JOptionPane.showMessageDialog(null, "Aun tienes puntos de atributo sin usar, usalos para poder imprimir");
                }
                break;
            case "elegir":
                objMet.escogerRaza(atr);
                break;
            default:
                if(!"salir".equalsIgnoreCase(op))
                JOptionPane.showMessageDialog(null,"La opción introducida no es correcta");
        }
    }while (!"salir".equalsIgnoreCase(op));    
} 
    
}
