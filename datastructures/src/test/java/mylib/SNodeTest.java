package mylib;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mylib.datastructures.nodes.SNode;

public class SNodeTest {
    SNode node;

    @Before
    public void setUp() {
        node = new SNode(10);
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
    public void testGetNext() {
        assertNull(node.getNext());
    }

    @Test
    public void testSetNext() {
        SNode nextNode = new SNode(15);
        node.setNext(nextNode);
        assertEquals(nextNode, node.getNext());
    }
}
