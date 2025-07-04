package ParcialesArboles.Parcial3;

import TP3.EJ1.GeneralTree;
public class Parcial3 {
    public static boolean esDeSeleccion(GeneralTree<Integer> a){
        if(a!=null&& !a.isEmpty()) return sel(a);
        return false;
    }
    private static boolean sel(GeneralTree<Integer>a){
        if(a.isLeaf()) return true;
        int menor=99999;
        for(GeneralTree<Integer> hijo: a.getChildren()){
            if(hijo.getData()<menor) menor = hijo.getData();
            if(!sel(hijo)) return false;
        }
        return a.getData()==menor;
    }
    public static void main(String[] args) {
        GeneralTree<Integer> tree = new GeneralTree<>(12);

        GeneralTree<Integer> tree1 = new GeneralTree<>(12);
        GeneralTree<Integer> tree2 = new GeneralTree<>(25);

        GeneralTree<Integer> tree11 = new GeneralTree<>(35);
        GeneralTree<Integer> tree12 = new GeneralTree<>(12);

        GeneralTree<Integer> tree111 = new GeneralTree<>(35);

        GeneralTree<Integer> tree121 = new GeneralTree<>(12);
        GeneralTree<Integer> tree122 = new GeneralTree<>(35);
        GeneralTree<Integer> tree123 = new GeneralTree<>(23);

        GeneralTree<Integer> tree21 = new GeneralTree<>(25);

        GeneralTree<Integer> tree211 = new GeneralTree<>(25);

        tree.addChild(tree1);
        tree.addChild(tree2);

        tree1.addChild(tree11);
        tree1.addChild(tree12);

        tree2.addChild(tree21);

        tree11.addChild(tree111);

        tree12.addChild(tree121);
        tree12.addChild(tree122);
        tree12.addChild(tree123);

        tree21.addChild(tree211);

        System.out.println(esDeSeleccion(tree));
    }

}
