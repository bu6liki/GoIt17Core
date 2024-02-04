package org.example.homework2;

public class MyQueue {
    private Object[] queue;
    private int size;
    private int capacity;
    private int front;
    private int rear;

    public MyQueue(int capacity) {
        this.capacity = capacity;
        queue = new Object[capacity];
        size = 0;
        front = 0;
        rear = -1;
    }

    public void add(Object value) {
        if (size == capacity) {
            System.out.println("Queue is full. Cannot add more elements.");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
    }

    public void clear() {
        queue = new Object[capacity];
        size = 0;
        front = 0;
        rear = -1;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return null;
        }
        return queue[front];
    }

    public Object poll() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot poll.");
            return null;
        }
        Object element = queue[front];
        front = (front + 1) % capacity;
        size--;
        return element;
    }

    private boolean isEmpty() {
        return size == 0;
    }
}
