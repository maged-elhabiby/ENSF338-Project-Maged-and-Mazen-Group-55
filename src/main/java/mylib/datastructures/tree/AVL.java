package main.java.mylib.datastructures.tree;

import java.util.ArrayList;
import java.util.List;

import main.java.mylib.datastructures.nodes.TNode;

public class AVL extends BST{
    public AVL(){
        super();
    }
    public AVL(int value){
        super(value);
    }
    public AVL(TNode obj){
        super();
        this.setRoot(obj);
        if(obj.getLeft() != null || obj.getRight() != null){
            createBalancedTree(obj);
        }
    }

    @Override
    public void setRoot(TNode root){
        super.setRoot(root);
        if(root.getLeft() != null || root.getRight() != null){
            createBalancedTree(root);
        }
    }
    @Override
    public void insert(int val) {
        TNode newNode = new TNode(val, 0, null, null, null);
        super.insert(newNode);
        balanceTree(newNode.getParent());
    }

    @Override
    public void insert(TNode node) {
        super.insert(node);
        balanceTree(node.getParent());
    }

    @Override
    public void delete(int val) {
        TNode nodeToDelete = search(val);
        if (nodeToDelete == null) {
            System.out.println("Value not found in the tree");
            return;
        }
        super.delete(val);
        balanceTree(nodeToDelete.getParent());
    }

    
    // Private helper function to create a balanced AVL tree from an existing node
    private void createBalancedTree(TNode node) {
        List<TNode> nodes = new ArrayList<>();
        inOrderTraversal(node, nodes);
        int n = nodes.size();
        this.setRoot(createBalancedTreeHelper(nodes, 0, n - 1));
    }

    private TNode createBalancedTreeHelper(List<TNode> nodes, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TNode node = nodes.get(mid);
        node.setLeft(createBalancedTreeHelper(nodes, start, mid - 1));
        node.setRight(createBalancedTreeHelper(nodes, mid + 1, end));
        return node;
    }

    // Private helper function to traverse the tree in-order and store nodes in a list
    private void inOrderTraversal(TNode node, List<TNode> nodes) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.getLeft(), nodes);
        nodes.add(node);
        inOrderTraversal(node.getRight(), nodes);
    }

    // Private helper function to balance the tree
    private void balanceTree(TNode node) {
        while (node != null) {
            int balanceFactor = calculateBalanceFactor(node);
            if (balanceFactor > 1) {
                if (calculateBalanceFactor(node.getLeft()) >= 0) {
                    rightRotate(node);
                } else {
                    leftRightRotate(node);
                }
            } else if (balanceFactor < -1) {
                if (calculateBalanceFactor(node.getRight()) <= 0) {
                    leftRotate(node);
                } else {
                    rightLeftRotate(node);
                }
            }
            node = node.getParent();
        }
    }

    // Private helper functions for rotating the tree
    private void rightRotate(TNode node) {
        TNode leftChild = node.getLeft();
        TNode parent = node.getParent();

        node.setLeft(leftChild.getRight());
        if (leftChild.getRight() != null) {
            leftChild.getRight().setParent(node);
        }

        leftChild.setRight(node);
        node.setParent(leftChild);

        leftChild.setParent(parent);
        if (parent == null) {
            this.setRoot(leftChild);
        } else if (parent.getLeft() == node) {
            parent.setLeft(leftChild);
        } else {
            parent.setRight(leftChild);
        }
    }

    private void leftRotate(TNode node) {
        TNode rightChild = node.getRight();
        TNode parent = node.getParent();

        node.setRight(rightChild.getLeft());
        if (rightChild.getLeft() != null) {
            rightChild.getLeft().setParent(node);
        }

        rightChild.setLeft(node);
        node.setParent(rightChild);

        rightChild.setParent(parent);
        if (parent == null) {
            this.setRoot(rightChild);
        } else if (parent.getLeft() == node) {
            parent.setLeft(rightChild);
        } else {
            parent.setRight(rightChild);
        }
    }

    private void leftRightRotate(TNode node) {
        leftRotate(node.getLeft());
        rightRotate(node);
    }

    private void rightLeftRotate(TNode node) {
        rightRotate(node.getRight());
        leftRotate(node);
    }

    // Private helper function to calculate the balance factor of a node
    private int calculateBalanceFactor(TNode node) {
        int leftHeight = -1;
        if (node.getLeft() != null) {
            leftHeight = node.getLeft().getBalance();
        }
    
        int rightHeight = -1;
        if (node.getRight() != null) {
            rightHeight = node.getRight().getBalance();
        }
    
        return leftHeight - rightHeight;
    }    
}

