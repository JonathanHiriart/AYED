package ParcialesArboles.Parcial6;

import TP3.EJ1.GeneralTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Parcial6 {
    public static List<List<Character>> caminosPares(GeneralTree<Character> arbol){
        if(arbol!=null&&(!arbol.isEmpty())){
            List<List<Character>> posibles = new ArrayList<List<Character>>();
            recorrido(arbol,posibles,new ArrayList<Character>());
            return posibles;
        }
        return null;
    }
    private static void recorrido(GeneralTree<Character> a,List<List<Character>> result, List<Character> camActual){
        camActual.add(a.getData());
        if(a.isLeaf()){
            if(camActual.size()%2==0){
                result.add(new ArrayList<>(camActual));
            }
        }
        for(GeneralTree<Character> hijo:a.getChildren()){
            recorrido(hijo,result,camActual);
        }
        camActual.remove(camActual.size()-1);
    }
    public static void main(String[] args) {
        List<GeneralTree<Character>> subChildren1 = new LinkedList<GeneralTree<Character>>();
        subChildren1.add(new GeneralTree<Character>('E'));
        GeneralTree<Character> a1 = new GeneralTree<Character>('B', subChildren1);

        List<GeneralTree<Character>> subChildren2 = new LinkedList<GeneralTree<Character>>();
        subChildren2.add(new GeneralTree<Character>('H'));
        subChildren2.add(new GeneralTree<Character>('I'));
        GeneralTree<Character> subAb1 = new GeneralTree<Character>('F', subChildren2);
        List<GeneralTree<Character>> subChildren3 = new LinkedList<GeneralTree<Character>>();
        subChildren3.add(subAb1);
        subChildren3.add(new GeneralTree<Character>('G'));
        GeneralTree<Character> a2 = new GeneralTree<Character>('C', subChildren3);

        List<GeneralTree<Character>> arbol = new LinkedList<GeneralTree<Character>>();
        arbol.add(a1);
        arbol.add(a2);
        arbol.add(new GeneralTree<Character>('D'));
        GeneralTree<Character> a = new GeneralTree<Character>('A', arbol);
        List<List<Character>> lis = caminosPares(a);
        for(List<Character>l: lis) {
            System.out.println(l);
        }
    }
}
