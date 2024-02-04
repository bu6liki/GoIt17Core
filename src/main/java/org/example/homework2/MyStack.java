package org.example.homework2;

public class MyStack {
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyStack() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void push(Object value) {
        if (size == array.length) {

            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[size++] = value;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return array[size - 1];
    }

    public Object pop() {
        Object value = peek();
        array[--size] = null;
        return value;
    }
}

