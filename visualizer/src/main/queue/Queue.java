package main.queue;

import java.util.NoSuchElementException;

public class Queue<T> {
    private Node<T> front;
    private Node<T> rear;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public void enqueue(T data) {
        Node<T> node = new Node<>(data);
        if (rear != null) {
            rear.next = node;
        }
        rear = node;
        if (front == null) {
            front = rear;
        }
    }

    public T dequeue() {
        if (front == null) {
            throw new NoSuchElementException();
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    public T peek() {
        if (front == null) {
            throw new NoSuchElementException();
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
