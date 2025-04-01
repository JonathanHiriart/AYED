package TP1.EJ3;
import  java.util.Scanner;
public class test {
    public static void llenarvector(estudiante[] est , profesor[] prof) {
        for (int i = 0; i < est.length; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("ingrese el nombre del estudiante");
            String nombre = sc.nextLine();
            System.out.println("ingrese el apellido del estudiante");
            String apellido = sc.nextLine();
            System.out.println("ingrese la comision del estudiante");
            int comision = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea
            System.out.println("ingrese la dirrecion del estudiante");
            String dirrecion = sc.nextLine();
            System.out.println("ingrese el email del estudiante");
            String email = sc.nextLine();
            est[i] = new estudiante(nombre, apellido, comision, dirrecion, email);
        }
        for (int i = 0; i < prof.length; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("ingrese el nombre del profesor");
            String nombre = sc.nextLine();
            System.out.println("ingrese el apellido del profesor");
            String apellido = sc.nextLine();
            System.out.println("ingrese el email del profesor");
            String email = sc.nextLine();
            System.out.println("ingrese la catedra del profesor");
            int catedras = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea
            System.out.println("ingrese la facultad del profesor");
            String facultad = sc.nextLine();
            prof[i] = new profesor(nombre, apellido, email, catedras, facultad);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        estudiante[] estu1= new estudiante[1];
        profesor[] prof= new profesor[1];
        llenarvector(estu1, prof);
        for (int i = 0; i < estu1.length; i++) {
            System.out.println(estu1[i].tusDatos());
        }
        for (int i = 0; i < prof.length; i++) {
            System.out.println(prof[i].tusDatos());
        }
    }
}
