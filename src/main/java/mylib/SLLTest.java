package main.java.mylib;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import main.java.mylib.datastructures.linear.SLL;
import main.java.mylib.datastructures.nodes.SNode;

public class SLLTest {
    private SLL<Integer> sll;

    @Before
    public void setUp() {
        sll = new SLL<>((a, b) -> a - b);
    }

    @Test
    public void testInsertHead() {
        sll.insertHead(new SNode<>(5));
        assertEquals(1, sll.getSize());
        assertEquals((Integer)5, sll.getHead().getData());
        assertEquals((Integer)5, sll.getTail().getData());
    }

    @Test
    public void testInsertTail() {
        sll.insertTail(new SNode<>(5));
        sll.insertTail(new SNode<>(10));
        assertEquals(2, sll.getSize());
        assertEquals((Integer)5, sll.getHead().getData());
        assertEquals((Integer)10, sll.getTail().getData());
    }

    @Test
    public void testInsert() {
        sll.insert(new SNode<>(5), 0);
        sll.insert(new SNode<>(10), 1);
        sll.insert(new SNode<>(15), 2);
        sll.insert(new SNode<>(20), 3);
        sll.insert(new SNode<>(25), 4);
        sll.insert(new SNode<>(30), 5);
        sll.insert(new SNode<>(7), 1);

        assertEquals(7, sll.getSize());
        assertEquals((Integer)5, sll.getHead().getData());
        assertEquals((Integer)30, sll.getTail().getData());
        assertEquals((Integer)7, sll.getHead().getNext().getData());
    }

    @Test
    public void testSortedInsert() {
        sll.sortedInsert(new SNode<>(5));
        sll.sortedInsert(new SNode<>(10));
        sll.sortedInsert(new SNode<>(3));
        sll.sortedInsert(new SNode<>(15));
        sll.sortedInsert(new SNode<>(2));
        assertEquals(5, sll.getSize());
        assertEquals((Integer)2, sll.getHead().getData());
        assertEquals((Integer)15, sll.getTail().getData());
        assertTrue(sll.isSorted());
    }

    @Test
    public void testSearch() {
        sll.insertTail(new SNode<>(5));
        sll.insertTail(new SNode<>(10));
        sll.insertTail(new SNode<>(15));
        assertNotNull(sll.search(10));
        assertEquals((Integer)10, sll.search(10).getData());
        assertNull(sll.search(7));
    }

    @Test
    public void testDeleteHead() {
        sll.insertTail(new SNode<>(5));
        sll.insertTail(new SNode<>(10));
        sll.insertTail(new SNode<>(15));
        sll.deleteHead();
        assertEquals(2, sll.getSize());
        assertEquals((Integer)10, sll.getHead().getData());
    }

    @Test
    public void testDeleteTail() {
        sll.insertTail(new SNode<>(5));
        sll.insertTail(new SNode<>(10));
        sll.insertTail(new SNode<>(15));
        sll.deleteTail();
        assertEquals(2, sll.getSize());
        assertEquals((Integer)10, sll.getTail().getData());
    }

    @Test
    public void testDelete() {
        sll.insertTail(new SNode<>(5));
        sll.insertTail(new SNode<>(10));
        sll.insertTail(new SNode<>(15));
        sll.delete(10);
        assertEquals(2, sll.getSize());
        assertEquals((Integer)5, sll.getHead().getData());
        assertEquals((Integer)15, sll.getTail().getData());
    }

    @Test
    public void testSort() {
        sll.insertTail(new SNode<>(5));
        sll.insertTail(new SNode<>(10));
        sll.insertTail(new SNode<>(3));
        sll.insertTail(new SNode<>(15));
        sll.insertTail(new SNode<>(2));
        sll.sort();
        assertEquals(5, sll.getSize());
        assertEquals((Integer)2, sll.getHead().getData());
        assertEquals((Integer)15, sll.getTail().getData());
        assertTrue(sll.isSorted());
    }

    @Test
    public void testClear() {
        sll.insertTail(new SNode<>(5));
        sll.insertTail(new SNode<>(10));
        sll.insertTail(new SNode<>(15));
        sll.clear();
        assertEquals(0, sll.getSize());
        assertNull(sll.getTail());
        assertNull(sll.getTail());
    }

    @Test
    public void testPrint() {
        sll.insertTail(new SNode<>(5));
        sll.insertTail(new SNode<>(10));
        sll.insertTail(new SNode<>(15));
        sll.print();
    }
}
