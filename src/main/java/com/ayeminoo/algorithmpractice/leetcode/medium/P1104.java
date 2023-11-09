package com.ayeminoo.algorithmpractice.leetcode.medium;


import com.ayeminoo.algorithmpractice.util.BTreePrinter;
import com.ayeminoo.algorithmpractice.util.Node;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/
 */
//java version - 17.0.7+7-Ubuntu-0ubuntu120.04
public class P1104 {

    public List<Integer> pathInZigZagTree2(int max) {
        Node<Integer> root = new Node<>(1);
        LinkedList<Node> children = new LinkedList<>();
        children.add(root);
        int[] current = new int[]{1};
        Node<Integer> lastNode = root;
        int row = 1;
        while (children.size() > 0) {
            LinkedList<Node> tempChildren = new LinkedList<>();
            row++;
            boolean even = row % 2 == 0;
            for (int i = 0; i < children.size(); i++) {
                Node node = children.get(even ? children.size() - i - 1 : i);
                Node temp1 = createNode(++current[0], max, node);
                Node temp2 = createNode(++current[0], max, node);
                if (temp1 != null) {
                    if (even) {
                        tempChildren.addFirst(temp1);
                    } else {
                        tempChildren.add(temp1);
                    }
                    lastNode = temp1;
                }
                if (temp2 != null) {
                    if (even) {
                        tempChildren.addFirst(temp2);
                    } else {
                        tempChildren.add(temp2);
                    }
                    lastNode = temp2;

                }

                if (even) {
                    //even row
                    node.left = temp2;
                    node.right = temp1;
                } else {
                    //odd row
                    node.left = temp1;
                    node.right = temp2;
                }
//                if (node.left != null) {
//                    tempChildren.add(node.left);
//                }
//                if (node.right != null) {
//                    tempChildren.add(node.right);
//                }
            }
            children = tempChildren;
        }
//        row--;
        Node<Integer> tempNode = lastNode;
        LinkedList<Integer> result = new LinkedList<>();
        while (tempNode != null) {
            result.addFirst(tempNode.data);
            tempNode = tempNode.parent;
        }
        BTreePrinter.printNode(root);
        return result;
    }

    private Node createNode(int data, int max, Node parent) {
        if (data <= max) {
            Node node = new Node(data);
            node.parent = parent;
            return node;
        } else return null;
    }

//    class Node<T extends Comparable<?>> {
//        public Node<T> left, right, parent;
//        public T data;
//
//        public Node(T data) {
//            this.data = data;
//        }
//    }

    public static void main(String[] args) {
        System.out.println(new P1104().pathInZigZagTree(16));
//        System.out.println(new P1104().findParentPosition(19, 5));
//        System.out.println(new P1104().findParentPosition(12, 4));
    }

    public List<Integer> pathInZigZagTree(int max) {
        if(max == 1) return Arrays.asList(1);
        int row = findRow(max);
        LinkedList<Integer> result = new LinkedList<>();
        result.addFirst(max);

        do {
            boolean even = row % 2 == 0;
            int parentPosition = even ? findRLParentPosition(max, row) : findLRParentPosition(max, row);
            --row;
            max = !even ? findRLData(parentPosition, row) : findLRData(parentPosition, row);
            if (max > 0)
                result.addFirst(max);
        } while (row > 0);

        return result;
    }

    int findRow(int max) {
        return (int) Math.floor((Math.log(max) / Math.log(2)+1));
    }

    int findParentPosition(int data, int row) {
        return row % 2 == 0 ? findRLParentPosition(data, row) : findLRParentPosition(data, row);
    }

    int findData(int position, int row) {
        return row % 2 == 0 ? findRLData(position, row) : findLRData(position, row);
    }

    int findLRParentPosition(int data, int row) {
        int previousRow = (int) Math.pow(2, row - 1) - 1;
        double diff = (double) data - previousRow;
        int position = (int) Math.ceil(diff / 2);
        return position;
    }

    int findRLParentPosition(int data, int row) {
        double previousRow = Math.pow(2, row - 1) - 1;
        double maxPosition = (Math.pow(2, row) - 1 - previousRow) / 2;
        return (int) (maxPosition - Math.ceil((data - previousRow) / 2)) + 1;
    }

    int findLRData(int position, int row) {
        int previousRow = (int) Math.pow(2, row - 1) - 1;
        return previousRow + position;
    }

    int findRLData(int position, int row) {
        int currentRow = (int) Math.pow(2, row);
        return currentRow - position;
    }


}
