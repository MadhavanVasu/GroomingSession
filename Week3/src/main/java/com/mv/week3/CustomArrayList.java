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
        System.out.println(Arrays.toString(arr));
    }

    public T get(int i) {
        if (i < 0 || i >= size) throw new IndexOutOfBoundsException();
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
        Object temp = arr[i];
        arr[i] = element;
        int j = i + 1;
        while (j <= size) {
            Object t = arr[j];
            arr[j++] = temp;
            temp = t;
        }
    }

//    public void remove(int i) {
//        if(i==)
//        while (i < size){
//        }
//
//    }

}

public class CustomArrayList {

    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList<Integer>();
        for (int i = 0; i < 11; i++)
            arrayList.add(i);
        System.out.println(arrayList.getCapacity());
        System.out.println(arrayList.getSize());
        arrayList.add(2, 15);
        arrayList.clear();

    }


}
