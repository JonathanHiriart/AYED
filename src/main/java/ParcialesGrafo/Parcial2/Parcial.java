package ParcialesGrafo.Parcial2;

import TP1.EJ8.Queue;
import TP3.Grafos.Edge;
import TP3.Grafos.Graph;
import TP3.Grafos.Vertex;
import com.sun.source.doctree.SinceTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Parcial {
    public List<Usuario> invitacionMasterClass (Graph<String>red , String usuario, int distancia, int limite){
        List<Usuario> result = new ArrayList<Usuario>();
        Vertex<String> inicio = buscarusuario(red, usuario);
        if(!red.isEmpty()&& inicio!=null){
            bfs(red,inicio,distancia,limite,result);
        }
        return result;
    }
    private Vertex<String> buscarusuario(Graph<String>red , String u){
        Vertex<String>encontrado = null;
        List<Vertex<String>> l =  red.getVertices();
        for(Vertex<String> e: l){
            if(e.getData().equals(u)){
                encontrado= e;
            }
        }
        return encontrado;
    }
    private void bfs (Graph<String> red, Vertex<String> actual,int dist,int limite, List<Usuario> r){
        boolean[] marcas = new boolean[red.getSize()];
        int cant= 0;
        int grado = 1;
        marcas[actual.getPosition()]= true;
        Queue<Vertex<String>> cola = new Queue<Vertex<String>>();
        cola.enqueue(actual);
        cola.enqueue(null);
        // si la cola no esta vacia
        while (!cola.isEmpty()&& cant<limite && grado<=dist){
            Vertex<String> aux = cola.dequeue();
            // saco al actual y lo proceso
            if(aux !=null){
                List<Edge<String>> l = red.getEdges(aux);
                Iterator<Edge<String>> iter = l.iterator();
                // si tiene adycentes y no llegue al limite
                while (iter.hasNext()&& cant<limite){
                    Vertex<String> ady =iter.next().getTarget();
                    int posActual = ady.getPosition();
                    // si no estan marcados los cargo en la cola para recorrerlos
                    if(!marcas[posActual]){
                        marcas[posActual]=true;
                        cola.enqueue(ady);
                        r.add(new Usuario(ady.getData(),grado));
                        cant++;
                    }
                }
            }else if(!cola.isEmpty()){
                grado++;
                cola.enqueue(null);
            }
        }
    }
}

