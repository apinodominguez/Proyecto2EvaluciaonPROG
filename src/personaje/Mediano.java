package personaje;

import java.util.ArrayList;

public class Mediano extends Metodos implements IInitAtrRaza {
   
    @Override
    public void initAtributoRaza(ArrayList<Atributos> atrList) {
        for (Atributos atr : atrList){
            if("Agilidad".equalsIgnoreCase(atr.getNombre())){
                atr.setValor(dados[1]);
            }
            else{
                atr.setValor(dados[0]);
            }
        }
        setTamano("Pequeño");
       setPaso(5);
    }
}
