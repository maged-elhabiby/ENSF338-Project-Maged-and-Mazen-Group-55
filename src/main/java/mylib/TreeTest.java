package main.java.mylib;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

import main.java.mylib.datastructures.nodes.TNode;
import main.java.mylib.datastructures.tree.AVL;
import main.java.mylib.datastructures.tree.BST;

public class TreeTest {
    @Test
    public void testTNode() {
        // Test default constructor
        TNode node1 = new TNode();
        assertEquals(0, node1.getData());
        assertEquals(null, node1.getLeft());
        assertEquals(null, node1.getRight());
        assertEquals(null, node1.getParent());
        assertEquals(0, node1.getBalance());

        // Test overloaded constructor
        TNode node2 = new TNode(5, -1, null, null, null);
        assertEquals(5, node2.getData());
        assertEquals(null, node2.getLeft());
        assertEquals(null, node2.getRight());
        assertEquals(null, node2.getParent());
        assertEquals(-1, node2.getBalance());

        // Test setters
        node1.setData(10);
        node1.setLeft(node2);
        node1.setBalance(1);
        assertEquals(10, node1.getData());
        assertEquals(node2, node1.getLeft());
        assertEquals(1, node1.getBalance());

        // Test getters
        assertEquals(5, node2.getData());
        assertEquals(-1, node2.getBalance());
    }
    @Test
    public void testBST() {
        // Create a new BST and insert some nodes
        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        // Test search
        TNode node1 = bst.search(5);
        TNode node2 = bst.search(9);
        assertNotNull(node1);
        assertNull(node2);

        /*
        // Test printInOrder
        String expectedInOrder = "2 3 4 5 6 7 8 ";
        assertEquals(expectedInOrder, bst.printInOrder());

        // Test printBF
        String expectedBF = "5 \n3 7 \n2 4 6 8 \n";
        assertEquals(expectedBF, bst.printBF());
        */
        // Test delete
        bst.delete(7);
        TNode node3 = bst.search(7);
        assertNull(node3);
    }

    @Test
    public void testAVL() {
        // Create a new AVL and insert some nodes
        AVL avl = new AVL();
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(2);
        avl.insert(4);
        avl.insert(6);
        avl.insert(8);

        // Test search
        TNode node1 = avl.search(5);
        TNode node2 = avl.search(9);
        assertNotNull(node1);
        assertNull(node2);

        // Test printInOrder
        String expectedInOrder = "2 3 4 5 6 7 8 ";
        //assertEquals(expectedInOrder, avl.printInOrder());

        // Test printBF
        String expectedBF = "5 \n3 7 \n2 4 6 8 \n";
        //assertEquals(expectedBF, avl.printBF());

        // Test delete
        avl.delete(7);
        TNode node3 = avl.search(7);
        assertNull(node3);
    }
}
