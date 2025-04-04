package TP1.EJ8;

public class DoubleEndedQueue<T> extends Queue {
    public void enqueueFirst(T data){
        this.data.add(0, data);
    }
    public static void main(String[] args) {
        DoubleEndedQueue<Integer> deque = new DoubleEndedQueue<>();

        deque.enqueue(10);
        deque.enqueue(20);
        deque.enqueue(30);

        System.out.println("Cola original: " + deque);

        deque.enqueueFirst(5);
        System.out.println("Después de enqueueFirst(5): " + deque);

        deque.dequeue();
        System.out.println("Después de dequeue(): " + deque);
    }
}
