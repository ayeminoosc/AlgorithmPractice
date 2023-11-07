package com.ayeminoo.algorithmpractice.util;

public class Node<T extends Comparable<?>> {
    public Node<T> left, right, parent;
    public T data;

    public Node(T data) {
        this.data = data;
    }
}