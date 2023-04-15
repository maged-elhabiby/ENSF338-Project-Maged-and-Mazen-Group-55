package mylib;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mylib.datastructures.linear.SLL;
import mylib.datastructures.nodes.SNode;

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

        assertEquals("Node2 should be found in the list", node2, sll.search(node2));
        assertEquals("Node1 should be found in the list", node1, sll.search(node1));
        SNode node3 = new SNode(3);
        assertNull("Node3 should not be found in the list", sll.search(node3));
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
    @Test
    public void testSort() {
        SNode node1 = new SNode(5);
        SNode node2 = new SNode(3);
        SNode node3 = new SNode(1);
        SNode node4 = new SNode(4);
        SNode node5 = new SNode(2);

        sll.insertHead(node1);
        sll.insertHead(node2);
        sll.insertHead(node3);
        sll.insertHead(node4);
        sll.insertHead(node5);

        sll.sort();

        assertEquals(5, sll.getSize());
        assertEquals(node3, sll.getHead());
        assertEquals(node5, sll.getHead().getNext());
        assertEquals(node2, sll.getHead().getNext().getNext());
        assertEquals(node4, sll.getHead().getNext().getNext().getNext());
        assertEquals(node1, sll.getHead().getNext().getNext().getNext().getNext());
    }

    @Test
    public void testSortedInsert() {
        SLL list = new SLL();
        list.sort(); // Ensure the list is sorted before calling sortedInsert()
    
        SNode node1 = new SNode(3);
        SNode node2 = new SNode(1);
        SNode node3 = new SNode(5);
    
        list.sortedInsert(node1);
        list.sortedInsert(node2);
        list.sortedInsert(node3);
    
        assertEquals(1, list.getHead().getData());
        assertEquals(3, list.getHead().getNext().getData());
        assertEquals(5, list.getTail().getData());
    }

    @Test
    public void testInsertAtFifthPosition() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        SNode node4 = new SNode(4);
        SNode node5 = new SNode(5);

        sll.insertHead(node1);
        sll.insertTail(node2);
        sll.insertTail(node3);
        sll.insertTail(node4);

        sll.insert(node5, 5);

        assertEquals(5, sll.getSize());
        assertEquals(node1, sll.getHead());
        assertEquals(node2, sll.getHead().getNext());
        assertEquals(node3, sll.getHead().getNext().getNext());
        assertEquals(node4, sll.getHead().getNext().getNext().getNext());
        assertEquals(node5, sll.getHead().getNext().getNext().getNext().getNext());
    }

}