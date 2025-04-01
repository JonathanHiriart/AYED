package TP1.EJ3;

public class profesor {
    private String nombre;
    private String apellido;
    private String email;
    private int catedras;
    private String facultad;

    public profesor(String nombre, String apellido, String email, int catedras, String facultad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.catedras = catedras;
        this.facultad = facultad;
    }

    public String getApellido() {
        return apellido;
    }

    public int getCatedras() {
        return catedras;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCatedras(int catedras) {
        this.catedras = catedras;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String tusDatos() {
        return "El nombre del profesor: " + this.nombre + "\n" +
                "Apellido: " + this.apellido + "\n" +
                "Email: " + this.email + "\n" +
                "Cátedras: " + this.catedras + "\n" +
                "Facultad: " + this.facultad;
    }
}