package com.hussani.lgbtqia.datastructure;

public class MinHeap {

    private final int[] heap;
    private final int capacity;
    private int currentSize = 0;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
    }

    public MinHeap(int[] keys) {
        this.heap = new int[keys.length];
        this.capacity = keys.length;
        for (int key : keys) {
            this.add(key);
        }
    }

    public void add(int element) {
        if (currentSize == capacity) {
            throw new IllegalStateException("Heap is full");
        }
        heap[currentSize] = element;
        int childIndex = currentSize;
        int parentIndex = parent(childIndex);
        while (heap[childIndex] < heap[parentIndex]) {
            swap(childIndex, parentIndex);
            childIndex = parentIndex;
            parentIndex = parent(childIndex);
        }
        currentSize++;
    }

    public int extractMin() {
        if (currentSize == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int min = heap[0];
        heap[0] = heap[currentSize - 1];
        currentSize--;
        heapifyMin(0);
        return min;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void decreaseKey(int i, int newValue) {
        if (newValue > heap[i]) {
            throw new IllegalArgumentException("New value is greater than current value");
        }
        heap[i] = newValue;
        while (i != 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void heapifyMin(int i) {
        int l = leftChild(i);
        int r = rightChild(i);
        int smallest = i;
        if (l < currentSize && heap[l] < heap[i]) {
            smallest = l;
        }
        if (r < currentSize && heap[r] < heap[smallest]) {
            smallest = r;
        }
        if (smallest != i) {
            swap(i, smallest);
            heapifyMin(smallest);
        }
    }
}
