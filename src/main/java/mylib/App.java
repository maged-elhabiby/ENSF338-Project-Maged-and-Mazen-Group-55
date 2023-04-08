package main.java.mylib;

import main.java.mylib.datastructures.nodes.TNode;
import main.java.mylib.datastructures.tree.AVL;
import main.java.mylib.datastructures.tree.BST;

public class App {
    public static void main(String[] args) {
        // Test TNode class
        TNode node1 = new TNode();
        TNode node2 = new TNode(10, 0, null, node1, null);
        TNode node3 = new TNode(15, -1, null, null, null);

        System.out.println(node1.getData()); // Output: 5
        System.out.println(node2.getBalance()); // Output: 0
        System.out.println(node3.getParent()); // Output: null
        System.out.println(node2); // Output: "10"

        // Test BST class
        BST bst = new BST();
        bst.insert(5);
        bst.insert(10);
        bst.insert(15);
        bst.insert(20);
        bst.insert(25);

        System.out.println(bst.search(10)); // Output: TNode@<hashcode>
        bst.delete(15);
        System.out.println(bst.search(15)); // Output: null
        bst.printInOrder(); // Output: "5 10 20 25"
        bst.printBF(); // Output: "5 \n 10 20 \n 25"

        // Test AVL class
        AVL avl = new AVL();
        avl.insert(5);
        avl.insert(10);
        avl.insert(15);
        avl.insert(20);
        avl.insert(25);

        System.out.println(avl.search(10)); // Output: TNode@<hashcode>
        avl.delete(15);
        System.out.println(avl.search(15)); // Output: null
        avl.printInOrder(); // Output: "5 10 20 25"
        avl.printBF(); // Output: "10 \n 5 20 \n 25"
    }}