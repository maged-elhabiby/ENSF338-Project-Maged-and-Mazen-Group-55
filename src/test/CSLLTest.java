package test;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import main.java.mylib.datastructures.nodes.SNode;
import main.java.mylib.datastructures.linear.CSLL;

public class CSLLTest {

    private CSLL csll;

    @Before
    public void setUp() {
        csll = new CSLL();
    }

    @Test
    public void testInsertHead() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        csll.insertHead(node1);
        csll.insertHead(node2);

        assertEquals(2, csll.getSize());
        assertEquals(2, csll.getHead().getData());
        assertEquals(1, csll.getTail().getData());
        assertEquals(csll.getHead(), csll.getTail().getNext());
    }

    @Test
    public void testInsertTail() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        csll.insertTail(node1);
        csll.insertTail(node2);

        assertEquals(2, csll.getSize());
        assertEquals(1, csll.getHead().getData());
        assertEquals(2, csll.getTail().getData());
        assertEquals(csll.getHead(), csll.getTail().getNext());
    }

    @Test
    public void testDeleteHead() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        csll.insertHead(node1);
        csll.insertHead(node2);

        csll.deleteHead();

        assertEquals(1, csll.getSize());
        assertEquals(1, csll.getHead().getData());
        assertEquals(csll.getHead(), csll.getTail().getNext());
    }

    @Test
    public void testDeleteTail() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        csll.insertHead(node1);
        csll.insertHead(node2);

        csll.deleteTail();

        assertEquals(1, csll.getSize());
        assertEquals(2, csll.getHead().getData());
        assertEquals(csll.getHead(), csll.getTail().getNext());
    }

    @Test
    public void testClear() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        csll.insertHead(node1);
        csll.insertHead(node2);

        csll.clear();

        assertEquals(0, csll.getSize());
        assertNull(csll.getHead());
        assertNull(csll.getTail());
    }

}
    
