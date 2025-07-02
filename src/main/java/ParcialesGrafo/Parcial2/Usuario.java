package ParcialesGrafo.Parcial2;

public class Usuario {
    private int numero;
    private String nombre;

    public Usuario(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
