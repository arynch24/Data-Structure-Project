package main.deque;

public class DequeUtils {

    public static <T> void printDeque(Deque<T> deque) {
        Deque<T> tempDeque = new Deque<>();
        while (!deque.isEmpty()) {
            T data = deque.removeFront();
            System.out.print(data + " ");
            tempDeque.addRear(data);
        }
        while (!tempDeque.isEmpty()) {
            deque.addRear(tempDeque.removeFront());
        }
    }
}
