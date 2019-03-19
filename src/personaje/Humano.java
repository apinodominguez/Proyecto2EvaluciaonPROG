package personaje;

import java.util.ArrayList;


public class Humano extends Metodos implements IInitAtrRaza {

    @Override
    public void initAtributoRaza(ArrayList<Atributos> atrList) {
       for (Atributos atr : atrList){
           atr.setValor(dados[0]);
       }
       setTamano("Medio");
       setPaso(6);
    }    
}
