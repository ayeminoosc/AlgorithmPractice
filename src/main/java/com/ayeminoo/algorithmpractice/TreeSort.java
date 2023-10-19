package com.ayeminoo.algorithmpractice;

import java.util.Arrays;

public class TreeSort {
    int[] sorted;
    Node root;
    int currentIndex;
    int size;
    public TreeSort(int[]data){
        if(data == null || data.length < 1) throw new IllegalArgumentException("Wrong arg");
        size = data.length;
        root = new Node(data[0]);
        for(int i= 1; i<data.length ;i++){
            root.insert(data[i]);
        }
        currentIndex = 0;
        this.sorted = new int[size];
        add(root);
    }

    public int[] get(){
        return this.sorted;
    }

    private void add(Node node){
//        int[] sortedData = new int[size];
//        int i = 0;
        Node current = node;
        if(current.getLeft() != null)
            add(current.getLeft());
        sorted[currentIndex++]= current.getData();
        if(current.getRight() != null)
            add(current.getRight());
    }

    public static void main(String[]args){
        TreeSort treeSort = new TreeSort(new int[]{4, 2,3, 5});
        System.out.println(Arrays.toString(treeSort.get()));
    }

}

class Node{
    private Node left;
    private int data;
    private Node right;

    public Node getLeft() {
        return left;
    }

    public int getData() {
        return data;
    }

    public Node getRight() {
        return right;
    }

    public Node(int data) {
        this.data = data;
    }

    public void insert(int newData){
        if(newData <= data){
            if(left != null){
                left.insert(newData);
            }else{
                left = new Node(newData);
            }
        }else{
            if(right != null){
                right.insert(newData);
            }else{
                right = new Node(newData);
            }
        }
    }
}
