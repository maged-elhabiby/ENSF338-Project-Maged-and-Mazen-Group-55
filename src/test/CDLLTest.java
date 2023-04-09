package test;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import main.java.mylib.datastructures.linear.CDLL;
import main.java.mylib.datastructures.nodes.DNode;

public class CDLLTest {
    private CDLL cdll;

    @Before
    public void setUp() {
        cdll = new CDLL();
    }

    @Test
    public void testInsertHead() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);

        cdll.insertHead(node1);
        assertEquals(1, cdll.getSize());
        assertSame(node1, cdll.getHead());
        assertSame(node1, cdll.getTail());

        cdll.insertHead(node2);
        assertEquals(2, cdll.getSize());
        assertSame(node2, cdll.getHead());
        assertSame(node1, cdll.getTail());
        assertSame(node1, cdll.getHead().getNext());
        assertSame(node2, cdll.getTail().getPrev());
    }

    @Test
    public void testInsertTail() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);

        cdll.insertTail(node1);
        assertEquals(1, cdll.getSize());
        assertSame(node1, cdll.getHead());
        assertSame(node1, cdll.getTail());

        cdll.insertTail(node2);
        assertEquals(2, cdll.getSize());
        assertSame(node1, cdll.getHead());
        assertSame(node2, cdll.getTail());
        assertSame(node2, cdll.getHead().getNext());
        assertSame(node1, cdll.getTail().getPrev());
    }

    @Test
    public void testDeleteHead() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);

        cdll.insertHead(node1);
        cdll.insertHead(node2);
        cdll.deleteHead();

        assertEquals(1, cdll.getSize());
        assertSame(node1, cdll.getHead());
        assertSame(node1, cdll.getTail());
        assertSame(node1, cdll.getHead().getNext());
        assertSame(node1, cdll.getTail().getPrev());
    }

    @Test
    public void testDeleteTail() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);

        cdll.insertHead(node1);
        cdll.insertHead(node2);
        cdll.deleteTail();

        assertEquals(1, cdll.getSize());
        assertSame(node2, cdll.getHead());
        assertSame(node2, cdll.getTail());
        assertSame(node2, cdll.getHead().getNext());
        assertSame(node2, cdll.getTail().getPrev());
    }

    @Test
    public void testDelete() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        cdll.insertHead(node1);
        cdll.insertHead(node2);
        cdll.insertHead(node3);

        cdll.delete(node2);

        assertEquals(2, cdll.getSize());
        assertSame(node3, cdll.getHead());
        assertSame(node1, cdll.getTail());
        assertSame(node1, cdll.getHead().getNext());
        assertSame(node3, cdll.getTail().getPrev());
    }
    @Test
    public void testClear() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        cdll.insertHead(node1);
        cdll.insertHead(node2);
        cdll.clear();

        assertEquals(0, cdll.getSize());
        assertNull(cdll.getHead());
        assertNull(cdll.getTail());
    }
}
