package TP1.EJ3;

public class estudiante {
    private String nombre;
    private String apellido;
    private int comision;
    private String dirrecion;
    private String email;

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

    public String getDirrecion() {
        return dirrecion;
    }

    public void setDirrecion(String dirrecion) {
        this.dirrecion = dirrecion;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String tudatos () {
        String aux = "el nombre del profesor " + this.nombre + "/n" +
                "apellido " + this.apellido + "/n" +
                " email " + this.dirrecion + "/n" +
                " catedra " + this.comision + "/n" +
                " facultad " + this.email;
        return aux;
    }
}


