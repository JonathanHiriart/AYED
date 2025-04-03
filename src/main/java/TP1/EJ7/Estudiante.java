package TP1.EJ7;

public class Estudiante {
    private String nombre;
    private String apellido;
    private int comision;
    private String direccion;
    private String email;

    public Estudiante(String nombre, String apellido, int comision, String direccion, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.comision = comision;
        this.direccion = direccion;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String tusDatos() {
        return "El nombre del estudiante: " + getNombre()+ "\n" +
                "Apellido: " + getApellido()+ "\n" +
                "Dirección: " + getDireccion() + "\n" +
                "Comisión: " + getComision() + "\n" +
                "Email: " + getEmail() + "\n";
    }
}