/**
@author Maged El Habiby <a
href="mailto:maged.elhabiby@ucalgary.ca">maged.elhabiby@ucalgary.ca</a>
@author Mazen El Habiby <a
 href="mailto:mazen.elhabiby@ucalgary.ca">mazen.elhabiby@ucalgary.ca</a>
 */
package mylib;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mylib.datastructures.nodes.TNode;
import mylib.datastructures.tree.AVL;

public class AVLTest {
    private AVL tree;

    @Before
    public void setUp() {
        tree = new AVL();
    }
    @Test
    public void testInsertAVL() {
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.insert(4);

        assertEquals(5, tree.getRoot().getData());
        assertEquals(3, tree.getRoot().getLeft().getData());
        assertEquals(7, tree.getRoot().getRight().getData());
        assertEquals(1, tree.getRoot().getLeft().getLeft().getData());
        assertEquals(4, tree.getRoot().getLeft().getRight().getData());
    }

    @Test
    public void testDeleteAVL() {
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        tree.delete(1);

        assertNull(tree.search(1));
        assertEquals(5, tree.getRoot().getData());
        assertEquals(3, tree.getRoot().getLeft().getData());
        assertEquals(7, tree.getRoot().getRight().getData());
        assertNull(tree.getRoot().getLeft().getLeft());
        assertEquals(4, tree.getRoot().getLeft().getRight().getData());
    }

    @Test
    public void testInsertAndBalanceAVL() {
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(13);
        tree.insert(17);
        tree.insert(1);
        tree.insert(9);

        assertEquals(10, tree.getRoot().getData());
        assertEquals(5, tree.getRoot().getLeft().getData());
        assertEquals(15, tree.getRoot().getRight().getData());
        assertEquals(3, tree.getRoot().getLeft().getLeft().getData());
        assertEquals(7, tree.getRoot().getLeft().getRight().getData());
        assertEquals(1, tree.getRoot().getLeft().getLeft().getLeft().getData());
        assertEquals(9, tree.getRoot().getLeft().getRight().getRight().getData());
        assertEquals(13, tree.getRoot().getRight().getLeft().getData());
        assertEquals(17, tree.getRoot().getRight().getRight().getData());
    }

    @Test
    public void testDeleteAndBalanceAVL() {
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(13);
        tree.insert(17);
        tree.insert(1);
        tree.insert(9);

        tree.delete(1);

        assertEquals(10, tree.getRoot().getData());
        assertEquals(5, tree.getRoot().getLeft().getData());
        assertEquals(15, tree.getRoot().getRight().getData());
        assertEquals(3, tree.getRoot().getLeft().getLeft().getData());
        assertEquals(7, tree.getRoot().getLeft().getRight().getData());
        assertNull(tree.getRoot().getLeft().getLeft().getLeft());
        assertEquals(9, tree.getRoot().getLeft().getRight().getRight().getData());
        assertEquals(13, tree.getRoot().getRight().getLeft().getData());
        assertEquals(17, tree.getRoot().getRight().getRight().getData());
    }

    @Test
    public void testSearch() {
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(13);
        tree.insert(17);
        tree.insert(1);
        tree.insert(9);

        TNode foundNode = tree.search(7);
        assertNotNull(foundNode);
        assertEquals(7, foundNode.getData());

        TNode notFoundNode = tree.search(100);
        assertNull(notFoundNode);
    }
    @Test
    public void testDeleteNotFound() {
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.insert(4);

        tree.delete(10); // Value not found in the tree.

        assertEquals(5, tree.getRoot().getData());
        assertEquals(3, tree.getRoot().getLeft().getData());
        assertEquals(7, tree.getRoot().getRight().getData());
        assertEquals(1, tree.getRoot().getLeft().getLeft().getData());
        assertEquals(4, tree.getRoot().getLeft().getRight().getData());
        }
}
