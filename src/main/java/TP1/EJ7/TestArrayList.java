package TP1.EJ7;

import java.util.*;

public class TestArrayList {
    public static void main(String[] args) {
        System.out.println("Starting main with String[] args");
        int[] vect = new int[4];
        for (int i = 0; i < vect.length; i++) {
            vect[i] = i;
        }
        main(vect);
        System.out.println("------------inciso f-----------------");
        ArrayList<Integer> v = new ArrayList<Integer>();
        v.add(1);
        v.add(2);
        v.add(2);
        v.add(1);
        if (esCapicua(v)){
            System.out.println("si es capicua");
        }
        else {
            System.out.println("no es capicua");
        }
        System.out.println("------------inciso g-----------------");
        List<Integer> incisoG =  incisoG( 6);
        for (int a: incisoG){
            System.out.println(a + "");
        }
        System.out.println("------------inciso h-----------------");
        invertir(incisoG);
        for (int a: incisoG){
            System.out.println(a + "");
        }
        System.out.println("-------------inciso i ----------------");
        System.out.println(sumarLista(incisoG));

        System.out.println("-------------inciso j ----------------");
        ArrayList<Integer> a = new ArrayList<Integer>(List.of(1,4,12,14,17));
        ArrayList<Integer> b = new ArrayList<>(List.of(3,5,11,21,23,25));
        ArrayList<Integer> merge = combinarOrdenado(a,b);
        for (int d: merge){
            System.out.println(d + "");
        }
    }

    public static void main(int[] enter) {
        System.out.println("Starting main with int[] enter");
        ArrayList<Integer> lista = new ArrayList<>();
        for (int j : enter) {
            lista.add(j);
        }

        System.out.println("los numeros ingresados son : ");
        for (int k : lista) {
            System.out.println(k + " ");
        }
        incisoD();
    }

    public static void imprimir(ArrayList<Estudiante> imput  ){
        for (Estudiante i : imput) {
            System.out.println(i.tusDatos());
        }
    }
    public static void incisoD() {
        System.out.println("Starting incisoC");
        ArrayList<Estudiante> est = new ArrayList<>();
        est.add(new Estudiante("tiki", "tour", 12, "avenida 13", "martintoru@gmail.com"));
        est.add(new Estudiante("yoni", "hiriart", 1, "calle 13", "yoni@gmail.com"));
        est.add(new Estudiante("freedy", "ferrada", 3, "ruta 204", "ferradafredy@gmail.com"));

        ArrayList<Estudiante> copiada = new ArrayList<>(est); // copio la lista de estudiantes
        System.out.println("------------- lista original -------------");
        imprimir(est);

        System.out.println("------------- lista copia -------------");
        imprimir(copiada);

        System.out.println("------------- Modificacion a la lista -------------");
        copiada.remove(1);

        System.out.println("------------- lista copia -------------");
        imprimir(copiada);

        System.out.println("------------- lista original -------------");
        imprimir(est);

        incisoE(est);
    }
    public static void incisoE(ArrayList<Estudiante> lista){
        Estudiante nuevo = new Estudiante( "valen", "kvolek",4,"diagonal 73", "valenbros@gmail.com");
        Iterator i = lista.iterator();
        while (i.hasNext()){
            if (!(i.next().equals(nuevo))){
                lista.add(nuevo);
                System.out.println("agregado exitoso");
                break;
            }
        }
    }
    public static Boolean esCapicua(ArrayList<Integer> lista){
        int fin = lista.size()-1;
        for(int i=0; i<lista.size()/2 ; i++){
            if (!lista.get(i).equals(lista.get(fin-i))){
                return false;
            }
        }
        return true;
    }
    public static List<Integer> incisoG(int n){
        List<Integer> sucesion= new ArrayList<Integer>();
        if (n != 1){
            if ((n % 2) == 0){
                n= n/2;
                sucesion.add(n);
                sucesion.addAll(incisoG(n));
            }else {
                n= 3*n +1;
                sucesion.add(n);
                sucesion.addAll(incisoG(n));
            }
        }
        return sucesion;
    }
    public static void invertir (List<Integer> lista){
        if (!lista.isEmpty()){
            int elem = lista.getFirst();
            lista.removeFirst();
            invertir(lista);
            lista.add(elem);
        }
    }
    public static int sumarLista (List<Integer> l ){
        if (!l.isEmpty()){
            int pri = l.removeFirst();
            int resto = sumarLista(l);
            l.addFirst(pri);
            return pri + resto;
        }
        return 0;
    }
    public static ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1, ArrayList<Integer> lista2){
        ArrayList<Integer> merge = new ArrayList<>();
        int i=0;
        int j = 0;

        while (i < lista1.size()&& j < lista2.size()){
            if (lista1.get(i) <= lista2.get(j)){
                merge.add(lista1.get(i));
                i++;
            }else{
                merge.add(lista2.get(j));
                j++;
            }
        }
        // Añadir los elementos restantes de lista1
        for (int i2= i; i2< lista1.size(); i2++)
            merge.add(lista1.get(i2));

        // Añadir los elementos restantes de lista2
        for (int j2=j; j2< lista2.size(); j2++)
            merge.add(lista2.get(j2));

        return merge;
    }
}