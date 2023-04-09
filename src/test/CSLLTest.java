
//package main.java.mylib.datastructures.linear;


package test;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import main.java.mylib.datastructures.nodes.SNode;
import main.java.mylib.datastructures.linear.CSLL;

//import static org.junit.jupiter.api.Assertions.*;

public class CSLLTest {

    private CSLL csll;

    @Before
    public void setUp() {
        csll = new CSLL();
    }

    @Test
    public void testInsertHead() {
        csll.insertHead(new SNode(5));
        csll.insertHead(new SNode(3));
        assertEquals(3, csll.getHead().getData());
        assertEquals(5, csll.getHead().getNext().getData());
        assertEquals(2, csll.getSize());
    }

    @Test
    public void testInsertTail() {
        csll.insertTail(new SNode(5));
        csll.insertTail(new SNode(3));
        assertEquals(5, csll.getHead().getData());
        assertEquals(3, csll.getTail().getData());
        assertEquals(2, csll.getSize());
    }

    @Test
    public void testInsert() {
        csll.insert(new SNode(5), 1);
        csll.insert(new SNode(3), 2);
        csll.insert(new SNode(7), 3);
        csll.insert(new SNode(4), 2);
        assertEquals(5, csll.getHead().getData());
        assertEquals(4, csll.getHead().getNext().getData());
        //assertEquals(3, csll.getTail().getPrev().getData());
        assertEquals(7, csll.getTail().getData());
        assertEquals(4, csll.getSize());
    }

    @Test
    public void testSearch() {
        csll.insertHead(new SNode(5));
        csll.insertHead(new SNode(3));
        assertNotNull(csll.search(5));
        assertNull(csll.search(7));
    }

    @Test
    public void testDeleteHead() {
        csll.insertHead(new SNode(5));
        csll.insertHead(new SNode(3));
        csll.deleteHead();
        assertEquals(5, csll.getHead().getData());
        assertEquals(1, csll.getSize());
    }

    @Test
    public void testDeleteTail() {
        csll.insertHead(new SNode(5));
        csll.insertHead(new SNode(3));
        csll.deleteTail();
        assertEquals(3, csll.getHead().getData());
        assertEquals(1, csll.getSize());
    }

    @Test
    public void testDelete() {
        csll.insertHead(new SNode(5));
        csll.insertHead(new SNode(3));
        csll.insertHead(new SNode(7));
        SNode nodeToDelete = csll.search(5);
        if (nodeToDelete != null) {
            csll.delete(nodeToDelete);
        }
        assertEquals(7, csll.getHead().getData());
        assertEquals(3, csll.getHead().getNext().getData());
        assertEquals(2, csll.getSize());
    }

    @Test
    public void testSort() {
        csll.insertHead(new SNode(5));
        csll.insertHead(new SNode(3));
        csll.insertHead(new SNode(7));
        csll.insertHead(new SNode(4));
        csll.sort();
        assertEquals(3, csll.getHead().getData());
        assertEquals(4, csll.getHead().getNext().getData());
        assertEquals(5, csll.getHead().getNext().getNext().getData());
        assertEquals(7, csll.getTail().getData());
    }

    @Test
    public void testClear() {
        csll.insertHead(new SNode(5));
        csll.insertHead(new SNode(3));
        csll.insertHead(new SNode(7));
        csll.clear();
        assertNull(csll.getHead());
        assertNull(csll.getTail());
        assertEquals(0, csll.getSize());
    }

}
    
