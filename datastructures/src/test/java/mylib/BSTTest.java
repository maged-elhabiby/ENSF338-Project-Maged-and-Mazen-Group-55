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
import mylib.datastructures.tree.BST;

public class BSTTest {
    private BST tree;

    @Before
    public void setUp() {
        tree = new BST();
    }

    @Test
    public void testInsert() {
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        assertEquals(50, tree.getRoot().getData());
        assertEquals(30, tree.getRoot().getLeft().getData());
        assertEquals(70, tree.getRoot().getRight().getData());
        assertEquals(20, tree.getRoot().getLeft().getLeft().getData());
        assertEquals(40, tree.getRoot().getLeft().getRight().getData());
        assertEquals(60, tree.getRoot().getRight().getLeft().getData());
        assertEquals(80, tree.getRoot().getRight().getRight().getData());
    }

    @Test
    public void testDelete() {
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        tree.delete(50);
        assertEquals(60, tree.getRoot().getData());
        assertNull(tree.getRoot().getRight().getLeft());
    }

    @Test
    public void testSearch() {
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        TNode foundNode = tree.search(40);
        assertNotNull(foundNode);
        assertEquals(40, foundNode.getData());

        TNode notFoundNode = tree.search(100);
        assertNull(notFoundNode);
    }
}
