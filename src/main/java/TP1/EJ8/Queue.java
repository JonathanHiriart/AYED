package TP1.EJ8;

import java.util.LinkedList;
import java.util.List;

public class Queue<T> extends Secuence{
    List<T> data;
    public Queue(){
        this.data= new LinkedList<T>();
    }
    public void enqueue(T dato){
        data.add(dato);
    }
    public T dequeue(){
        return data.removeFirst();
    }
    public T head(){
        return data.getFirst();
    }
    public String toString(){
        String str ="[";
        for(T d:data)
            str = str + d + ", ";
        str+= "]";
        return str;
    }
    @Override public boolean isEmpty(){
        if (data.size()==0){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        System.out.println("Cola vacía: " + queue);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Después de agregar elementos: " + queue);

        System.out.println("Primer elemento (head): " + queue.head());

        queue.dequeue();
        System.out.println("Después de dequeue(): " + queue);

        queue.dequeue();
        queue.dequeue();


        System.out.println("¿Está vacía?: " + queue.isEmpty());
    }
}

