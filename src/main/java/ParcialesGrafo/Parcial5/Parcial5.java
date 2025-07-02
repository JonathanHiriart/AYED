//package ParcialesGrafo.Parcial5;
//
//import TP3.Grafos.Edge;
//import TP3.Grafos.Graph;
//import TP3.Grafos.Vertex;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//
//public class Parcial5 {
//    public ArrayList<String> recorrido (Graph<String> ciudad, int cantLocalidades, int cantNafta,ArrayList<String> locaclidadesExceptudas){
//        ArrayList<String> result = new ArrayList<>();
//        if(!ciudad.isEmpty()){
//            Vertex<String> mendoza = buscar(ciudad,"mendoza");
//            if(mendoza!=null){
//                boolean[] marcas = new boolean[ciudad.getSize()];
//                recorrdiop(ciudad,mendoza,marcas,cantLocalidades,cantNafta,locaclidadesExceptudas,result);
//            }
//        }
//        return result;
//    }
//    private boolean recorrdiop(Graph<String> ciudad , Vertex<String> actual, boolean[]marcas , int cantLocalidades, int cantNafta, ArrayList<String> evitar,ArrayList<String> res){
//        marcas[actual.getPosition()]= true;
//        res.add(actual.getData());
//        if(res.size()>=cantLocalidades){
//            return true;
//        }else{
//            for(Edge<String> ady: ciudad.getEdges(actual)){
//                int costo = ady.getWeight();
//                int pos = ady.getTarget().getPosition();
//                Vertex<String> sig = ady.getTarget();
//                if(!marcas[pos] && cantNafta>= costo && evitar.contains(sig.getData())){
//                    if(recorrdiop(ciudad,sig,marcas,cantLocalidades,(cantNafta-costo),evitar,res)){
//                        return true;
//                    }
//                }
//            }
//        }
//        marcas[actual.getPosition()]=false;
//        if(!res.isEmpty()){
//            res.remove(res.size()-1);
//        }
//        return false;
//    }
//
//    private Vertex<String> buscar(Graph<String>ciudad, String partida){
//        Iterator<Vertex<String>> iter = ciudad.getVertices().iterator();
//        Vertex<String> aux = null;
//        Vertex<String> inicio = null;
//        while (iter.hasNext()&& aux==null){
//            aux=iter.next();
//            if(aux.getData().equals(partida)){
//                inicio=aux;
//            }
//        }
//        return inicio;
//    }
//}
////public static List<String> recorrido(Graph<String> grafo, int cantLocalidades, int cantNafta, List<String> evitar) {
////    // encontrar Mendoza
////    List<String> lista = new ArrayList<>();
////    for (Vertex<String> v : grafo.getVertices())
////        if (v.getData().equals("Mendoza")) {
////            if (recorrido(grafo, v, lista, cantLocalidades, cantNafta, evitar, new boolean[grafo.getSize()]))
////                return lista;
////            else return new ArrayList<>();
////        }
////    return lista;
////}
