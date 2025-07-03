package Parciales.Parcial7;

import TP3.EJ1.GeneralTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestParcialArbol7 {
    public static void main(String[] args) {

        GeneralTree<Compuesto> raiz = new GeneralTree<>(new Compuesto(0,"padre"));
        GeneralTree<Compuesto> hoja1 = new GeneralTree<>(new Compuesto(10, "Soft"));
        GeneralTree<Compuesto> hoja2 = new GeneralTree<>(new Compuesto(10, "Soft"));
        GeneralTree<Compuesto> hoja3 = new GeneralTree<>(new Compuesto(30, "Hard"));
        GeneralTree<Compuesto> hoja4 = new GeneralTree<>(new Compuesto(20, "Hard"));
        GeneralTree<Compuesto> hoja5 = new GeneralTree<>(new Compuesto(30, "Hard"));
        GeneralTree<Compuesto> hoja6 = new GeneralTree<>(new Compuesto(15, "Med"));
        GeneralTree<Compuesto> hoja7 = new GeneralTree<>(new Compuesto(15, "Med"));
        GeneralTree<Compuesto> hoja8 = new GeneralTree<>(new Compuesto(35, "Hard"));
        GeneralTree<Compuesto> hoja9 = new GeneralTree<>(new Compuesto(15, "Soft"));

        raiz.addChild(hoja1);
        raiz.addChild(hoja4);
        raiz.addChild(hoja8);

        hoja1.addChild(hoja2);
        hoja2.addChild(hoja3);

        hoja4.addChild(hoja5);
        hoja4.addChild(hoja6);
        hoja6.addChild(hoja7);

        hoja8.addChild(hoja9);

        ParcialArbol7 carrera = new ParcialArbol7(raiz);
        System.out.println("Camino menor:");
        List<Compuesto> lista = carrera.estrategia(raiz);
        System.out.println(lista);
    }
}
