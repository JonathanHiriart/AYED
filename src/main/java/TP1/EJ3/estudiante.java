package TP1.EJ3;

public class estudiante {
    private String nombre;
    private String apellido;
    private int comision;
    private String direccion;
    private String email;

    public estudiante(String nombre, String apellido, int comision, String direccion, String email) {
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
        return "El nombre del estudiante: " + this.nombre + "\n" +
                "Apellido: " + this.apellido + "\n" +
                "Dirección: " + this.direccion + "\n" +
                "Comisión: " + this.comision + "\n" +
                "Email: " + this.email;
    }
}