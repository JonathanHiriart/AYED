package ParcialesGrafo.Parcial4;

import TP3.Grafos.Edge;
import TP3.Grafos.Graph;
import TP3.Grafos.Vertex;
import TP3.Grafos.adjList.AdjListGraph;

import java.util.ArrayList;
import java.util.List;

public class Parcial4 {
    public static List<Camino> resolver(Graph<String> red,String origen,String destino,List<String> evitar){
        List<Camino> result = new ArrayList<Camino>();
        Vertex<String> inicio = buscarOrigen(red,origen);
        if(!red.isEmpty() && inicio!= null){
            boolean[]marcas = new boolean[red.getSize()];
            resoverl(red,inicio,destino,evitar,marcas,new ArrayList<>(),result,0);
        }
        return result;
    }
    private static void resoverl(Graph<String>red, Vertex<String> actual, String destino, List<String> evitar, boolean[] marcas,ArrayList<String> act,List<Camino> result, int cuadras){
        marcas[actual.getPosition()]= true;
        act.add(actual.getData());

        if(actual.getData().equals(destino)){// agregar camino a mi lista de caminos
            result.add(new Camino(new ArrayList<String>(act),cuadras));
            cuadras=0;
        }
        for(Edge<String> ady: red.getEdges(actual)){
            Vertex<String> dest = ady.getTarget();
            int PosActual = dest.getPosition();
            if(!marcas[PosActual] && !verificarEvitar(evitar,dest.getData()) ){
                resoverl(red,dest,destino,evitar,marcas,act,result,cuadras+ ady.getWeight());
            }
        }
        act.remove(act.size()-1);
        marcas[actual.getPosition()]=false;
    }
    private static Vertex<String> buscarOrigen(Graph<String> red, String origen){
        for(Vertex<String> a: red.getVertices()) if(a.getData().equals(origen)) return a;
        return null;
    }
    private static boolean verificarEvitar(List<String> evitar, String nombreCalle){
        for(String a: evitar){
            if(a.equals(nombreCalle))return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Graph<String> grafo = new AdjListGraph<>();

        Vertex<String> dam = grafo.createVertex("Estado Diego Armando Maradona");
        Vertex<String> macla = grafo.createVertex("MACLA");
        Vertex<String> catedral = grafo.createVertex("Catedral La Plata");
        Vertex<String> rectorado = grafo.createVertex("Rectorado UNLP");
        Vertex<String> museo = grafo.createVertex("Museo UNLP");
        Vertex<String> palacio = grafo.createVertex("Palacio Campodónico");
        Vertex<String> coliseo = grafo.createVertex("Coliseo Podestá");
        Vertex<String> legislatura = grafo.createVertex("Legislatura");

        grafo.connect(dam, catedral, 40);
        grafo.connect(dam, macla, 35);
        grafo.connect(dam, coliseo, 20);
        grafo.connect(dam, legislatura, 25);

        grafo.connect(legislatura, coliseo, 25);
        grafo.connect(coliseo, palacio, 10);
        grafo.connect(palacio, rectorado, 30);
        grafo.connect(rectorado, museo, 15);

        grafo.connect(macla, catedral, 8);
        grafo.connect(catedral, rectorado, 5);
        grafo.connect(rectorado, palacio, 30);

        List<String> evitar = List.of("Legislatura", "MACLA");
        System.out.println(resolver(grafo, "Estado Diego Armando Maradona", "Palacio Campodónico", evitar));
    }
}
