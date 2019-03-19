package personaje;

public class Atributos {
    
    String nombre;
    int valor;

    public Atributos() {
    }

    public Atributos(String nombre, int valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return  nombre + ": d" + valor ;
    }
    
    
    
    
}
