package main.deque;

import java.util.NoSuchElementException;

public class Deque<T> {
    private Node<T> front;
    private Node<T> rear;

    private static class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addFront(T data) {
        Node<T> node = new Node<>(data);
        if (front != null) {
            front.prev = node;
        }
        node.next = front;
        front = node;
        if (rear == null) {
            rear = front;
        }
    }

    public void addRear(T data) {
        Node<T> node = new Node<>(data);
        if (rear != null) {
            rear.next = node;
            node.prev = rear;
        }
        rear = node;
        if (front == null) {
            front = rear;
        }
    }

    public T removeFront() {
        if (front == null) {
            throw new NoSuchElementException();
        }
        T data = front.data;
        front = front.next;
        if (front != null) {
            front.prev = null;
        } else {
            rear = null;
        }
        return data;
    }

    public T removeRear() {
        if (rear == null) {
            throw new NoSuchElementException();
        }
        T data = rear.data;
        rear = rear.prev;
        if (rear != null) {
            rear.next = null;
        } else {
            front = null;
        }
        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
