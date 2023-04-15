package mylib;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mylib.datastructures.linear.DLL;
import mylib.datastructures.nodes.DNode;

public class DLLTest {
    private DLL dll;

    @Before
    public void setUp() {
        dll = new DLL();
    }

    @Test
    public void testInsertHead() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);

        dll.insertHead(node1);
        assertEquals(1, dll.getSize());
        assertEquals(node1, dll.getHead());

        dll.insertHead(node2);
        assertEquals(2, dll.getSize());
        assertEquals(node2, dll.getHead());
    }

    @Test
    public void testInsertTail() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);

        dll.insertTail(node1);
        assertEquals(1, dll.getSize());
        assertEquals(node1, dll.getTail());

        dll.insertTail(node2);
        assertEquals(2, dll.getSize());
        assertEquals(node2, dll.getTail());
    }

    @Test
    public void testInsert() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        dll.insert(node1, 1);
        dll.insert(node2, 2);
        dll.insert(node3, 2);

        assertEquals(3, dll.getSize());
        assertEquals(node1, dll.getHead());
        assertEquals(node3, dll.getHead().getNext());
        assertEquals(node2, dll.getTail());
    }

    @Test
    public void testSearch() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        dll.insertHead(node1);
        dll.insertHead(node2);

        assertEquals("Node1 should be found in the list", node1, dll.search(node1));
        assertEquals("Node2 should be found in the list", node2, dll.search(node2));
        DNode node3 = new DNode(3);
        assertNull("Node3 should not be found in the list", dll.search(node3));
    }

    @Test
    public void testSortedInsert() {
        dll.sortedInsert(new DNode(3));
        dll.sortedInsert(new DNode(1));
        dll.sortedInsert(new DNode(4));
        dll.sortedInsert(new DNode(2));

        assertEquals(4, dll.getSize());
        assertEquals(1, dll.getHead().getData());
        assertEquals(4, dll.getTail().getData());
    }

    @Test
    public void testSort() {
        dll.insertTail(new DNode(3));
        dll.insertTail(new DNode(1));
        dll.insertTail(new DNode(4));
        dll.insertTail(new DNode(2));

        dll.sort();

        assertEquals(4, dll.getSize());
        assertEquals(1, dll.getHead().getData());
        assertEquals(4, dll.getTail().getData());
    }

    @Test
    public void testEmptyList() {
        assertNull(dll.getHead());
        assertNull(dll.getTail());
        assertEquals(0, dll.getSize());
    }

    @Test
    public void testDeleteHead() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);

        dll.insertHead(node1);
        dll.insertHead(node2);
        dll.deleteHead();

        assertEquals(1, dll.getSize());
        assertEquals(node1, dll.getHead());
    }

    @Test
    public void testDeleteTail() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);

        dll.insertHead(node1);
        dll.insertHead(node2);
        dll.deleteTail();

        assertEquals(1, dll.getSize());
        assertEquals(node2, dll.getHead());
        assertNull(dll.getHead().getNext());
    }

    @Test
    public void testDelete() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        
    
        dll.insertHead(node1);
        dll.insertHead(node2);
        dll.insertHead(node3);
    
        // Test deleting head
        dll.delete(node3);
        assertEquals(2, dll.getSize());
        assertEquals(node2, dll.getHead());
        assertEquals(node1, dll.getHead().getNext());
    
        // Test deleting middle node
        dll.insertHead(node3);
        dll.delete(node2);
        assertEquals(2, dll.getSize());
        assertEquals(node3, dll.getHead());
        assertEquals(node1, dll.getHead().getNext());
    
        // Test deleting tail
        dll.insertHead(node2);
        dll.delete(node1);
        assertEquals(2, dll.getSize());
        assertEquals(node2, dll.getHead());
        assertEquals(node3, dll.getHead().getNext());
        assertNull(dll.getTail().getNext());
    }
    

    @Test
    public void testClear() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);

        dll.insertHead(node1);
        dll.insertHead(node2);
        dll.clear();

        assertEquals(0, dll.getSize());
        assertNull(dll.getHead());
        assertNull(dll.getTail());
    }
    @Test
    public void testSorts() {
        dll.insertTail(new DNode(3));
        dll.insertTail(new DNode(1));
        dll.insertTail(new DNode(4));
        dll.insertTail(new DNode(2));

        dll.sort();

        assertEquals(4, dll.getSize());
        assertEquals(1, dll.getHead().getData());
        assertEquals(2, dll.getHead().getNext().getData());
        assertEquals(3, dll.getHead().getNext().getNext().getData());
        assertEquals(4, dll.getTail().getData());
}

}