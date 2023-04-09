package mylib;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mylib.datastructures.nodes.DNode;

public class DNodeTest {
    DNode node;

    @Before
    public void setUp() {
        node = new DNode(10);
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
    public void testGetPrev() {
        assertNull(node.getPrev());
    }

    @Test
    public void testSetPrev() {
        DNode prevNode = new DNode(5);
        node.setPrev(prevNode);
        assertEquals(prevNode, node.getPrev());
    }

    @Test
    public void testGetNext() {
        assertNull(node.getNext());
    }

    @Test
    public void testSetNext() {
        DNode nextNode = new DNode(15);
        node.setNext(nextNode);
        assertEquals(nextNode, node.getNext());
    }
}
