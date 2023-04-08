package main.java.mylib.datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;

import main.java.mylib.datastructures.nodes.TNode;

public class BST {
    private TNode root;

    public BST(){
        this.root = null;
    }
    public BST (int value){
        this.root = new TNode(value,0,null,null,null);
    }
    public BST (TNode obj){
        this.root = obj;
    }

    // Getter and Setter
    public TNode getRoot(){
        return this.root;
    }

    public void setRoot(TNode root){
        this.root = root;
    }

    // Insert a new node with value
    public void insert(int value){
        TNode newNode = new TNode(value, 0, null, null, null);
        insertNode(newNode, this.root);
    }
    // Insert an existing node into the tree
    public void insert(TNode node) {
        insertNode(node, this.root);
    }

    private void insertNode(TNode newNode, TNode currNode) {
        if (this.root == null) {
            this.root = newNode;
            return;
        }

        if (newNode.getData() < currNode.getData()) {
            if (currNode.getLeft() == null) {
                currNode.setLeft(newNode);
                newNode.setParent(currNode);
            } 
            else {
                insertNode(newNode, currNode.getLeft());
            }
        } 
        else if (newNode.getData() > currNode.getData()) {
            if (currNode.getRight() == null) {
                currNode.setRight(newNode);
                newNode.setParent(currNode);
            } 
            else {
                insertNode(newNode, currNode.getRight());
            }
        }
    }

    // Delete node with data val
    public void delete(int value) {
        TNode nodeToDelete = search(value);
        if (nodeToDelete == null) {
            System.out.println("Value not found in the tree");
            return;
        }
        deleteNode(nodeToDelete);
    }

    private void deleteNode(TNode node) {
        if (node.getLeft() == null && node.getRight() == null) {
            if (node == this.root) {
                this.root = null;
            } else if (node.getParent().getLeft() == node) {
                node.getParent().setLeft(null);
            } else {
                node.getParent().setRight(null);
            }
        } else if (node.getLeft() != null && node.getRight() == null) {
            if (node == this.root) {
                this.root = node.getLeft();
                this.root.setParent(null);
            } else if (node.getParent().getLeft() == node) {
                node.getParent().setLeft(node.getLeft());
                node.getLeft().setParent(node.getParent());
            } else {
                node.getParent().setRight(node.getLeft());
                node.getLeft().setParent(node.getParent());
            }
        } else if (node.getRight() != null && node.getLeft() == null) {
            if (node == this.root) {
                this.root = node.getRight();
                this.root.setParent(null);
            } else if (node.getParent().getLeft() == node) {
                node.getParent().setLeft(node.getRight());
                node.getRight().setParent(node.getParent());
            } else {
                node.getParent().setRight(node.getRight());
                node.getRight().setParent(node.getParent());
            }
        } else {
            TNode successor = findSuccessor(node);
            node.setData(successor.getData());
            deleteNode(successor);
        }
    }

    private TNode findSuccessor(TNode node) {
        TNode currNode = node.getRight();
        while (currNode.getLeft() != null) {
            currNode = currNode.getLeft();
        }
        return currNode;
    }

    // Search for a node with data val
    public TNode search(int value) {
        return searchNode(value, this.root);
    }

    private TNode searchNode(int value, TNode currNode) {
        if (currNode == null) {
            return null;
        }
        if (value == currNode.getData()) {
            return currNode;
        }
        if (value < currNode.getData()) {
            return searchNode(value, currNode.getLeft());
        }
        return searchNode(value, currNode.getRight());
    }

    // Print tree content in ascending order
    public void printInOrder() {
        printInOrder(this.root);
    }

    private void printInOrder(TNode currNode) {
        if (currNode == null) {
            return;
        }
        printInOrder(currNode.getLeft());
        System.out.print(currNode.getData() + " ");
        printInOrder(currNode.getRight());
    }

    // Print tree content in Breadth-First order
    public void printBF() {
        if (this.root == null) {
            return;
        }
        Queue<TNode> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TNode currNode = queue.poll();
                System.out.print(currNode.getData() + " ");
                if (currNode.getLeft() != null) {
                    queue.add(currNode.getLeft());
                }
                if (currNode.getRight() != null) {
                    queue.add(currNode.getRight());
                }
            }
            System.out.println();
        }
    }
}

