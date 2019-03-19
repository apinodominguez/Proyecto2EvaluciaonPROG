package personaje;

import java.util.ArrayList;

public class Orco extends Metodos implements IInitAtrRaza {
   
    @Override
    public void initAtributoRaza(ArrayList<Atributos> atrList) {
        for (Atributos atr : atrList){
            if("Fuerza".equalsIgnoreCase(atr.getNombre())){
                atr.setValor(dados[1]);
            }
            else{
                atr.setValor(dados[0]);
            }
        }
    }
    
}
