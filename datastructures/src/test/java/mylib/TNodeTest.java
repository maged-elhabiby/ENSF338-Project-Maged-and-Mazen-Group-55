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
public class TNodeTest {
    private TNode node;

    @Before
    public void setUp() {
        node = new TNode(10, 0, null, null, null);
    }

    @Test
    public void testGetData() {
        assertEquals(10, node.getData());
    }

    @Test
    public void testSetData() {
        node.setData(20);
        assertEquals(20, node.getData());
    }

    @Test
    public void testGetBalance() {
        assertEquals(0, node.getBalance());
    }

    @Test
    public void testSetBalance() {
        node.setBalance(1);
        assertEquals(1, node.getBalance());
    }

    @Test
    public void testGetLeft() {
        assertNull(node.getLeft());
    }

    @Test
    public void testSetLeft() {
        TNode leftNode = new TNode(5, 0, node, null, null);
        node.setLeft(leftNode);
        assertEquals(leftNode, node.getLeft());
    }

    @Test
    public void testGetRight() {
        assertNull(node.getRight());
    }

    @Test
    public void testSetRight() {
        TNode rightNode = new TNode(15, 0, node, null, null);
        node.setRight(rightNode);
        assertEquals(rightNode, node.getRight());
    }

    @Test
    public void testGetParent() {
        assertNull(node.getParent());
    }

    @Test
    public void testSetParent() {
        TNode parentNode = new TNode(20, 0, null, node, null);
        node.setParent(parentNode);
        assertEquals(parentNode, node.getParent());
    }
}
