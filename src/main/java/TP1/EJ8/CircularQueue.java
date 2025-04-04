package TP1.EJ8;

public class CircularQueue<T>  extends Queue{
    public T shift(){
        T pri = (T) head();
        dequeue();
        enqueue(pri);
        return pri;

    }
    public static void main(String[] args) {
        CircularQueue<Integer> circularQueue = new CircularQueue<>();

        // Agregamos elementos a la cola
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        circularQueue.enqueue(4);

        System.out.println("Cola original: " + circularQueue);

        // Realizamos una operación shift (mueve el primero al final)
        circularQueue.shift();
        System.out.println("Después de shift(): " + circularQueue);

    }
}
