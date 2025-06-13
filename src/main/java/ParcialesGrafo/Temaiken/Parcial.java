package ParcialesGrafo.Temaiken;

import TP3.Grafos.Edge;
import TP3.Grafos.Graph;
import TP3.Grafos.Vertex;
import TP3.Grafos.adjList.AdjListGraph;

import java.util.Iterator;
import java.util.List;

public class Parcial {
    public int resolver(Graph<sitios> sit, int tiempo)
    {
        List<Vertex<sitios>> l = sit.getVertices(); // cargo todos los vertices en la lista
        Vertex<sitios> entrada= null;
        Vertex<sitios> aux = null;
        Iterator<Vertex<sitios>> iter = l.iterator();
        // busco la entrada del zoologico
        while (iter.hasNext() && entrada == null){
            aux = iter.next();
            if(aux.getData().get_lugar().equals("Entrada")){
                entrada = aux;
            }
        }
        int resultado = 0;
        if(entrada != null){
            System.out.println("entre al zoologico");
            System.out.println("Tiempo: "+ tiempo);
            boolean[]marcas = new boolean[l.size()];
            resultado= dfs(entrada,sit,tiempo,marcas);
        }
        return resultado;
    }
    private int dfs(Vertex<sitios> actual , Graph<sitios> grafo,int tiempo, boolean[] visitado){
        visitado[actual.getPosition()] = true;
        int tiempoRestante = tiempo - actual.getData().getTiempo();
        if( tiempoRestante<0){
            return 0;
        }
        int max= 0;
        // por cada arista que tenga mi grafo actual
        for (Edge<sitios> arista: grafo.getEdges(actual)){
            Vertex<sitios> vecino = arista.getTarget();
            int costoTotal = arista.getWeight() + vecino.getData().getTiempo();
            // si no lo tengo
            if((!visitado[vecino.getPosition()]) &&(costoTotal<= tiempoRestante)){
                int cant = dfs(vecino,grafo,tiempoRestante- arista.getWeight(),visitado);
                if(cant> max)max= cant;
            }
        }
        visitado[actual.getPosition()]= false;
        return max + 1;
    }
    public static void main(String args[]) {
        Graph<sitios> grafo = new AdjListGraph<sitios>();
        Vertex<sitios> Entrada = grafo.createVertex(new sitios("Entrada", 15));
        Vertex<sitios> Cebras = grafo.createVertex(new sitios("Cebras", 10));
        Vertex<sitios> Tigres = grafo.createVertex(new sitios("Tigres", 10));
        Vertex<sitios> Flamencos = grafo.createVertex(new sitios("Flamencos", 10));
        Vertex<sitios> Murcielagos = grafo.createVertex(new sitios("Murciélagos", 20));
        Vertex<sitios> Wallabies = grafo.createVertex(new sitios("Wallabies", 30));
        Vertex<sitios> Tortugas = grafo.createVertex(new sitios("Tortugas", 10));
        Vertex<sitios> Pumas = grafo.createVertex(new sitios("Pumas", 10));

        grafo.connect(Entrada, Cebras, 10);
        grafo.connect(Cebras, Entrada, 10);
        grafo.connect(Entrada, Tigres, 10);
        grafo.connect(Tigres, Entrada, 10);
        grafo.connect(Entrada, Murcielagos, 20);
        grafo.connect(Murcielagos, Entrada, 20);
        grafo.connect(Entrada, Flamencos, 25);
        grafo.connect(Flamencos, Entrada, 25);

        grafo.connect(Tigres, Cebras, 8);
        grafo.connect(Cebras, Tigres, 8);
        grafo.connect(Cebras, Tortugas, 10);
        grafo.connect(Tortugas, Cebras, 10);
        grafo.connect(Flamencos, Murcielagos, 25);
        grafo.connect(Murcielagos, Flamencos, 25);
        grafo.connect(Murcielagos, Wallabies, 10);
        grafo.connect(Wallabies, Murcielagos, 10);
        grafo.connect(Wallabies, Tortugas, 10);
        grafo.connect(Tortugas, Wallabies, 10);
        grafo.connect(Tortugas, Pumas, 15);
        grafo.connect(Pumas, Tortugas, 15);

        Parcial p = new Parcial();

        System.out.println(p.resolver(grafo, 100));
        System.out.println(p.resolver(grafo, 30));
    }
}
