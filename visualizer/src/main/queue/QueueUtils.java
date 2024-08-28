package main.queue;

public class QueueUtils {

    public static <T> void printQueue(Queue<T> queue) {
        Queue<T> tempQueue = new Queue<>();
        while (!queue.isEmpty()) {
            T data = queue.dequeue();
            System.out.print(data + " ");
            tempQueue.enqueue(data);
        }
        while (!tempQueue.isEmpty()) {
            queue.enqueue(tempQueue.dequeue());
        }
    }
}
