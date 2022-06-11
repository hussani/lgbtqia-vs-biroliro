package com.hussani.lgbtqia.datastructure;

public class AdjNode {

    private final int vertex;
    private final int weight;
    private AdjNode next;

    public AdjNode(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    public AdjNode(int vertex, int weight, AdjNode next) {
        this.vertex = vertex;
        this.weight = weight;
        this.next = next;
    }

    public int getVertex() {
        return vertex;
    }

    public int getWeight() {
        return weight;
    }

    public AdjNode getNext() {
        return next;
    }

    public void setNext(AdjNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "AdjNode{" +
                "vertex=" + vertex +
                ", weight=" + weight +
                ", next=" + next +
                '}';
    }
}
