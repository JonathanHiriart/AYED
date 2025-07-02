package ParcialesGrafo.Parcial4;

import java.util.ArrayList;
import java.util.List;

public class Camino {
    private ArrayList<String> cam;
    private int cuadras;

    public Camino(ArrayList<String> cam, int cuadras) {
        this.cam = cam;
        this.cuadras = cuadras;
    }

    public List<String> getCam() {
        return cam;
    }

    public void setCam(ArrayList<String> cam) {
        this.cam = cam;
    }

    public int getCuadras() {
        return cuadras;
    }

    public void setCuadras(int cuadras) {
        this.cuadras = cuadras;
    }
    @Override
    public String toString() {
        return cam.toString() + " = " + cuadras + " cuadras.";
    }
}
