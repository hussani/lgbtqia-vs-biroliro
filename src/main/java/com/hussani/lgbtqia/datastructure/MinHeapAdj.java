package com.hussani.lgbtqia.datastructure;

public class MinHeapAdj {

    private final AdjNode[] heap;
    private final int capacity;
    private int currentSize = 0;

    public MinHeapAdj(int capacity) {
        this.capacity = capacity;
        this.heap = new AdjNode[capacity];
    }

    public MinHeapAdj(AdjNode[] keys) {
        this.heap = new AdjNode[keys.length];
        this.capacity = keys.length;
        for (AdjNode key : keys) {
            this.add(key);
        }
    }

    public void add(AdjNode element) {
        if (currentSize == capacity) {
            throw new IllegalStateException("Heap is full");
        }
        heap[currentSize] = element;
        int childIndex = currentSize;
        int parentIndex = parent(childIndex);
        while (heap[childIndex].getWeight() < heap[parentIndex].getWeight()) {
            swap(childIndex, parentIndex);
            childIndex = parentIndex;
            parentIndex = parent(childIndex);
        }
        currentSize++;
    }

    public AdjNode extractMin() {
        if (currentSize == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        AdjNode min = heap[0];
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
        AdjNode temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void heapifyMin(int i) {
        int l = leftChild(i);
        int r = rightChild(i);
        int smallest = i;
        if (l < currentSize && heap[l].getWeight() < heap[i].getWeight()) {
            smallest = l;
        }
        if (r < currentSize && heap[r].getWeight() < heap[smallest].getWeight()) {
            smallest = r;
        }
        if (smallest != i) {
            swap(i, smallest);
            heapifyMin(smallest);
        }
    }
}
