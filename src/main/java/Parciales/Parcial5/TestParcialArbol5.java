package Parciales.Parcial5;

import TP3.EJ1.GeneralTree;

import java.util.List;

public class TestParcialArbol5 {
    public static void main(String[] args) {

        // Crear nodos
        GeneralTree<Character> a = new GeneralTree<>('A');
        GeneralTree<Character> b = new GeneralTree<>('B');
        GeneralTree<Character> c = new GeneralTree<>('C');
        GeneralTree<Character> d = new GeneralTree<>('D');
        GeneralTree<Character> e = new GeneralTree<>('E');
        GeneralTree<Character> f = new GeneralTree<>('F');
        GeneralTree<Character> g = new GeneralTree<>('G');
        GeneralTree<Character> h = new GeneralTree<>('H');
        GeneralTree<Character> i = new GeneralTree<>('I');

        // Armar estructura
        a.addChild(b);
        a.addChild(c);
        a.addChild(d);

        b.addChild(e);

        c.addChild(f);
        c.addChild(g);

        f.addChild(h);
        f.addChild(i);

        // Probar método caminosPares

        ParcialArbol5 p = new ParcialArbol5();
        List<Character> caminosPares= p.caminoPares(a);
        System.out.println("Caminos con cantidad de nodos PAR:");
        System.out.println(caminosPares);
    }
}
