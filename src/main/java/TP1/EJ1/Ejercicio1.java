package TP1.EJ1;
import java.util.Scanner;
public class Ejercicio1 {

    public static void ImprimirFor(int a,int b ) {
        for (int i=a; i<=b; i++) {
            System.out.print(i + " ");
        }
    }
    public static void ImprimirWhile(int a,int b ) {
        while(a<=b){
            System.out.print(a+ " ");
            a++;
        }
    }
    public static void ImprimirSinEstruc(int a,int b){
        if (a<=b){
            System.out.print(a+ " ");
            a++;
            ImprimirSinEstruc(a,b);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el primer numero: ");
        int a = sc.nextInt();
        System.out.print("Ingrese el segundo numero: ");
        int b = sc.nextInt();
        ImprimirFor(a,b);
        System.out.println(" ");
        ImprimirWhile(a,b);
        System.out.println(" ");
        ImprimirSinEstruc(a,b);
    }
}

