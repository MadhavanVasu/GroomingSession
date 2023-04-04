package com.mv.week3;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("unchecked")
class MyArrayList<T> {
    // T, ?, E
    private Object[] arr;
    private int size;
    private int capacity;

    public MyArrayList() {
        this.capacity = 10;
        arr = new Object[capacity];
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void increaseCapacity() {
        Object[] temp = Arrays.copyOf(arr, size);
        this.capacity *= 2;
        this.arr = Arrays.copyOf(temp, capacity);
    }

    public void add(T x) {
        if (size == capacity) {
            increaseCapacity();
        }
        arr[size++] = x;
    }

    public T get(int i) {
        return (T) arr[i];
    }

    public void clear() {
        for (int to = size, i = size = 0; i < to; i++)
            arr[i] = null;
        size = 0;
    }

    public void add(int i, T element) {
        if (size == capacity)
            increaseCapacity();

        int j = i;
        Object temp = arr[j];
        while (j < size) {
            arr[j + 1] = arr[j];

        }
    }

    public void remove(int i) {

    }


}


public class CustomArrayList {

    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList<Integer>();
        for (int i = 0; i < 11; i++)
            arrayList.add(i);
        System.out.println(arrayList.getCapacity());
        System.out.println(arrayList.getSize());
        arrayList.clear();

    }


}
