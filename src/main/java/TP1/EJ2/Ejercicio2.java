package TP1.EJ2;
import java.util.Scanner;
public class Ejercicio2 {
    public static int[] crearAregloMult(int n){
        int[] vectorMulti = new int[n];
        for(int i=0;i<n;i++ ) {
            vectorMulti[i] = n * (i + 1);

        }
        return vectorMulti;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese n ");
        int n = sc.nextInt();
        int [] vector = crearAregloMult(n);
        for (int i=0;i<n;i++){
            System.out.println(vector[i]);
        }
    }
}
