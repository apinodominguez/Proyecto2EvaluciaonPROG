/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personaje;

import Utils.MetodosVarios;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Angel
 */
public class Metodos implements IInitAtrRaza {
    int [] dados = {4,6,8,10,12};
    String [] atrNombre = {"Agilidad","Astucia","Espiritu","Fuerza","Vigor"};
    int maxAtr;
    int dureza;
    String raza;
    String tamano;
    int paso;

    @Override
    public void initAtributoRaza(ArrayList<Atributos> atrList) {
       }
   
    public void initAtributos(ArrayList <Atributos> atrList){
        for (int i = 0; i < atrNombre.length; i++) {
            Atributos atr = new Atributos (atrNombre[i], dados[0]);
            atrList.add(atr);
        }
        maxAtr = 5;
        initDureza(atrList);
        setPaso(6);
        setTamano("Medio");
    }

    public void initDureza (ArrayList <Atributos> atrList){
        for(Atributos atr : atrList){
            if(atr.getNombre().equalsIgnoreCase("Vigor"))
              setDureza(2 +(atr.getValor()/2));
        }
    }
    
    public void mostrarAtr(ArrayList <Atributos> atrList){
        for (Atributos atr : atrList){
            System.out.println(atr.toString());
    }
        System.out.println(getDureza());
    }
    
    public int darAtr (ArrayList <Atributos> atrList){
        
        String op;int puntos = 0;int totalpuntos = 0;int aux ;
        
        do{
            op = MetodosVarios.pedirNombreAtr("Introduce el nombre del Atributo que deseas modificar\n\n1 -> Agilidad\n2 -> Astucia\n3 -> Espiritu\n4 -> Fuerza\n5 -> Vigor\n0 -> Salir\n\n" +
                    "Tienes disponibles " + (maxAtr - totalpuntos) + " puntos para repartir");
            if(!"salir".equalsIgnoreCase(op)){
            puntos = MetodosVarios.pedirPuntosAtr("Introduce los puntos deseados");
            totalpuntos= totalpuntos + puntos;
            if (maxAtr >= totalpuntos)
                for (Atributos atr : atrList){
                    if(op.equalsIgnoreCase(atr.getNombre())){
                            atr.setValor(atr.getValor() + puntos*2);
                            if(atr.getValor() > 12){
                                atr.setValor(atr.getValor() - puntos*2);
                                totalpuntos = totalpuntos - puntos;
                                MetodosVarios.ErrorMaxSuperado("La cantidad a introducir es incorrecta, ya que superas el máximo valor de atributo disponible");
                            }
                        }
            }
            else {
                MetodosVarios.ErrorMaxSuperado("No puedes introducir esa cantidad, ya que superas el máximo de puntos");
                totalpuntos = totalpuntos - puntos;    
            }
        }
        aux = maxAtr - totalpuntos;    
    }while(!"salir".equals(op) && aux != 0);
        initDureza(atrList);
        maxAtr = maxAtr - totalpuntos;
        return maxAtr ;
}
  
  public int quitarAtr(ArrayList<Atributos> atrList){
      String op; int puntos = 0; int totalpuntos = 0;int puntosAQuitar = 5 - maxAtr;
      
      
      do {
          op = MetodosVarios.pedirNombreAtr("Introduce el nombre del Atributo que deseas modificar\n\n1 -> Agilidad\n2 -> Astucia\n3 -> Espiritu\n4 -> Fuerza\n5 -> Vigor\n0 -> Salir\n\n" +
                    "Tienes disponibles " + (maxAtr - totalpuntos) + " puntos para repartir");
          if(!"salir".equals(op)){
            puntos = MetodosVarios.pedirPuntosAtr("Introduce los puntos deseados");
            totalpuntos= totalpuntos + puntos;
            if (totalpuntos <=maxAtr)
                for (Atributos atr : atrList){
                    if(op.equalsIgnoreCase(atr.getNombre())){
                            atr.setValor(atr.getValor() - puntos*2);
                            if(atr.getValor() < 4){
                            atr.setValor(atr.getValor() - puntos*2);
                            totalpuntos= totalpuntos + puntos;    
                            MetodosVarios.ErrorMaxSuperado("Introduce el atributo a modificar\n salir para volver\n tienes " +(maxAtr - totalpuntos));    
                            }
                        }
            }
            else {
                MetodosVarios.ErrorMaxSuperado("No puedes introducir esa cantidad, ya que superas el máximo de puntos");
                totalpuntos = totalpuntos - puntos;    
            }
        }    
      }while(!"salir".equals(op));
  initDureza(atrList);
  maxAtr = maxAtr + totalpuntos;    
  return maxAtr;
  }  

    public int getDureza() {
        return dureza;
    }

    public void setDureza(int dureza) {
        this.dureza = dureza;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public int getPaso() {
        return paso;
    }

    public void setPaso(int paso) {
        this.paso = paso;
    }

    public int getMaxAtr() {
        return maxAtr;
    }

    public void setMaxAtr(int maxAtr) {
        this.maxAtr = maxAtr;
    }
     
   
    
    public void escogerRaza(ArrayList <Atributos> atrList){
        String op;
        do{
            op = MetodosVarios.pedirNombreRaza("Escoge una de las siguientes razas (Por defecto eres Humano):\n"
                    + "1 -> Humano\n2 -> Elfo\n3 -> Mediano\n4 -> Enano\n5 -> Orco\n0 -> Salir");
            switch(op.toLowerCase()){
                case "humano": 
                    Humano objHum = new Humano();
                    objHum.initAtributoRaza(atrList);
                    setRaza(op);
                    break;
                case "elfo":
                    Elfo objElf = new Elfo();
                    objElf.initAtributoRaza(atrList);
                    setRaza(op);
                    setTamano("Medio");
                    setPaso(8);
                    break;
                case "enano":
                    Enano objEna = new Enano();
                    objEna.initAtributoRaza(atrList);
                    setRaza(op);
                    initDureza(atrList);
                    setTamano("Pequeño");
                    setPaso(5);
                    break;
                case "orco":
                    Orco objOrco = new Orco();
                    objOrco.initAtributoRaza(atrList);
                    setRaza(op);
                    setTamano("Grande");
                    setPaso(6);
                    break;
                case "mediano":
                    Mediano objMed = new Mediano();
                    objMed.initAtributoRaza(atrList);
                    setRaza(op);
                    setTamano("Pequeño");
                    setPaso(5);
                    break;    
                default:
                    if (!"salir".equalsIgnoreCase(op))
                    MetodosVarios.ErrorMaxSuperado("La opcion introducida es incorrecta, intentalo de nuevo");
            }
        }while (!"salir".equalsIgnoreCase(op));
}
    
  
}