package TP2.EJ7;

import TP2.EJ1.BinaryTree;

public class ParcialArboles {
    BinaryTree<Integer> arbol;

    public ParcialArboles(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public boolean isLeftTree(int num){
        if (arbol.isEmpty()){ // mientras no este vacio
            return false;
        }
        if (num==arbol.getData()){ // encontrar el nodo
            int left=0;
            int right=0;

            if (arbol.hasLeftChild() && arbol.hasRightChild()){ // si tiene los 2 no hay problema
                if(arbol.hasLeftChild()){
                    left =contadorDeArbolUnicoHijo(arbol.getLeftChild());
                }else { // si le falta se le resta
                    left=-1;
                }
                if(arbol.hasRightChild()){
                    right =contadorDeArbolUnicoHijo(arbol.getRightChild());
                }else {
                    right=-1;
                }
            }
            return left>right; // Resultado final
        }
        // recorrer hasta encontrar el num

        if (arbol.hasLeftChild()){ // si tiene hijo creo una instancia nueva pasandole ese hijo y llamo a la funcion
            if (new ParcialArboles(arbol.getLeftChild()).isLeftTree(num)){
                return true;
            }
        }
        if (arbol.hasRightChild()){
            if (new ParcialArboles(arbol.getRightChild()).isLeftTree(num)){
                return true;
            }
        }
        return false;// si no existe termina
    }
    public int contadorDeArbolUnicoHijo(BinaryTree<Integer> ab){
        if (ab.isEmpty()){ // si esta vacio
            return 0;
        }
        int cant=0;
        if (ab.hasRightChild() ^ ab.hasLeftChild()){ // xor solo me interesa si tiene uno solo
            cant=1;
            if (ab.hasLeftChild()){
                cant+=contadorDeArbolUnicoHijo(ab.getLeftChild());
            }
            else {
                cant+=contadorDeArbolUnicoHijo(ab.getRightChild());
            }
        }
        return cant;
    }
}
