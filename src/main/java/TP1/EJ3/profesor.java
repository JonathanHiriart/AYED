package TP1.EJ3;

public class profesor {
    private String nombre;
    private String apellido;
    private String email;
    private int catedras;
    private String facutad;

    public String getApellido() {
        return apellido;
    }

    public int getCatedras() {
        return catedras;
    }

    public String getFacutad() {
        return facutad;
    }

    public void setFacutad(String facutad) {
        this.facutad = facutad;
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

    public String tudatos (){
        String aux = "el nombre del profesor "+ this.nombre+ "/n" +
                "apellido "+ this.apellido + "/n"+
                " email " + this.email + "/n" +
                " catedra "+ this.catedras+ "/n" +
                " facultad " + this.facutad;
        return aux;
    }
}
