package Parciales.Parcial7;

public class Compuesto {

    private int vueltas;
    private String tipo;

    public Compuesto(int vueltas, String tipo){
        this.tipo=tipo;
        this.vueltas=vueltas;
    }

    public int getVueltas(){
        return this.vueltas;
    }

    public double getTipo(){
        if(this.tipo.equals("Hard")){
            return 0.7;
        }
        else if(this.tipo.equals("Med")){
            return 0.4;
        }
        else return 0.0;
    }

    public String toString(){
        return this.tipo+this.vueltas+",";
    }
}
