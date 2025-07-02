package ParcialesGrafo.Parcial3;

import TP3.Grafos.Edge;
import TP3.Grafos.Graph;
import TP3.Grafos.Vertex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Parcial3 {
    public List<String> caminosSeguro(Graph<String>ciudad){
        List<String> cam = new ArrayList<String>();
        Vertex<String> inicio = encontrarInicio(ciudad,"Casa del Intendente");
        if(!ciudad.isEmpty() && inicio!=null)
        {
            boolean[] marcas = new boolean[ciudad.getSize()];
            recorrerCiudadSegura(ciudad,inicio,cam,marcas);
        }
        return cam;
    }
    private Vertex<String> encontrarInicio(Graph<String>ciudad,String calle){
        for(Vertex<String>a: ciudad.getVertices()) if(a.getData().equals(calle))return a;
        return null;
    }
    private boolean recorrerCiudadSegura(Graph<String> ciudad, Vertex<String> actual,List<String> cam,boolean[] marcas){
        marcas[actual.getPosition()]= true;
        cam.add(actual.getData());
        boolean encontre=false;
        if(actual.getData().equals("Municipalidad")) {
            return true;
        }else {
            // para cada uno de mis calles en la que estoy parado pregunto si esta siendo controlado por la mafia
            Iterator<Edge<String>> iter = ciudad.getEdges(actual).iterator();
            while (iter.hasNext()&& !encontre){
                Edge<String> hijos = iter.next();
                int posActual = hijos.getTarget().getPosition();
                if(!marcas[posActual] && hijos.getWeight()==0){ // tomo que 0 no hay mafia y 1 que hay mafia
                    Vertex<String> calleSegura = hijos.getTarget();
                    encontre=(recorrerCiudadSegura(ciudad,calleSegura,cam,marcas));
                }
            }
            cam.remove(cam.size()-1);
            marcas[actual.getPosition()] = false;
            return encontre;
        }
    }
}
