package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


import org.junit.Before;
import org.junit.Test;

import main.java.mylib.datastructures.linear.SLL;
import main.java.mylib.datastructures.nodes.SNode;

public class SLLTest {
    private SLL sll;

    @Before
    public void setUp() {
        sll = new SLL();
    }

    @Test
    public void testInsertHead() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);

        sll.insertHead(node1);
        assertEquals(1, sll.getSize());
        assertEquals(node1, sll.getHead());

        sll.insertHead(node2);
        assertEquals(2, sll.getSize());
        assertEquals(node2, sll.getHead());
        assertEquals(node1, sll.getHead().getNext());
    }

    @Test
    public void testInsertTail() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);

        sll.insertTail(node1);
        assertEquals(1, sll.getSize());
        assertEquals(node1, sll.getHead());

        sll.insertTail(node2);
        assertEquals(2, sll.getSize());
        assertEquals(node1, sll.getHead());
        assertEquals(node2, sll.getHead().getNext());
    }

    @Test
    public void testInsert() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);

        sll.insert(node1, 1);
        assertEquals(1, sll.getSize());
        assertEquals(node1, sll.getHead());

        sll.insert(node2, 1);
        assertEquals(2, sll.getSize());
        assertEquals(node2, sll.getHead());
        assertEquals(node1, sll.getHead().getNext());

        sll.insert(node3, 2);
        assertEquals(3, sll.getSize());
        assertEquals(node2, sll.getHead());
        assertEquals(node3, sll.getHead().getNext());
        assertEquals(node1, sll.getHead().getNext().getNext());
    }

    @Test
    public void testSearch() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);

        sll.insertHead(node1);
        sll.insertHead(node2);

        assertEquals(node2, sll.search(2));
        assertEquals(node1, sll.search(1));
        assertNull(sll.search(3));
    }

    @Test
    public void testDeleteHead() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);

        sll.insertHead(node1);
        sll.insertHead(node2);
        sll.deleteHead();

        assertEquals(1, sll.getSize());
        assertEquals(node1, sll.getHead());
    }

    @Test
    public void testDeleteTail() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);

        sll.insertHead(node1);
        sll.insertHead(node2);
        sll.deleteTail();

        assertEquals(1, sll.getSize());
        assertEquals(node2, sll.getHead());
        assertNull(sll.getHead().getNext());
    }
    @Test
    public void testDelete() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);

        sll.insertHead(node1);
        sll.insertHead(node2);
        sll.insertHead(node3);

        // Test deleting head
        sll.delete(node3);
        assertEquals(2, sll.getSize());
        assertEquals(node2, sll.getHead());
        assertEquals(node1, sll.getHead().getNext());

        // Test deleting middle node
        sll.insertHead(node3);
        sll.delete(node2);
        assertEquals(2, sll.getSize());
        assertEquals(node3, sll.getHead());
        assertEquals(node1, sll.getHead().getNext());

        // Test deleting tail
        sll.insertHead(node2);
        sll.delete(node1);
        assertEquals(2, sll.getSize());
        assertEquals(node2, sll.getHead());
        assertEquals(node3, sll.getHead().getNext());
    }
}