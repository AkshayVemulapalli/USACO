package com.company.practice.graphProblems;

public class BinaryDepthFirstSearch {
    static class BinaryTree {
        int value;
        BinaryTree leftNode;
        BinaryTree rightNode;
        public BinaryTree(int value) {
            this.value = value;
        }
    }
    static void search(BinaryTree node){
        System.out.print(node.value+" ");
        if(node.leftNode != null){
            search(node.leftNode);
        }
        if(node.rightNode != null){
            search(node.rightNode);
        }
    }
    public static void main(String[] args) {
        BinaryTree topNode = new BinaryTree(1);
        BinaryTree node2 = new BinaryTree(2);
        BinaryTree node3 = new BinaryTree(3);
        BinaryTree node4 = new BinaryTree(4);
        BinaryTree node5 = new BinaryTree(5);
        BinaryTree node6 = new BinaryTree(6);
        BinaryTree node7 = new BinaryTree(7);
        BinaryTree node8 = new BinaryTree(8);
        BinaryTree node9 = new BinaryTree(9);
        BinaryTree node10 = new BinaryTree(10);
        BinaryTree node11 = new BinaryTree(11);
        BinaryTree node12 = new BinaryTree(12);
        BinaryTree node13 = new BinaryTree(13);
        BinaryTree node14 = new BinaryTree(14);
        BinaryTree node15 = new BinaryTree(15);
        topNode.leftNode = node2;
        topNode.rightNode = node3;
        node2.leftNode = node4;
        node2.rightNode = node5;
        node3.leftNode = node6;
        node3.rightNode = node7;
        node4.leftNode = node8;
        node4.rightNode = node9;
        node5.leftNode = node10;
        node5.rightNode = node11;
        node6.leftNode = node12;
        node6.rightNode = node13;
        node7.leftNode = node14;
        node7.rightNode = node15;
        search(topNode);
    }
}
