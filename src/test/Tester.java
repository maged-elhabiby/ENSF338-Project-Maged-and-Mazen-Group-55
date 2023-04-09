package test;
/*import java.util.*;
import main.java.mylib.datastructures.nodes
import org.junit.Test;
import static org.junit.Assert.*;

public class SinglyLLTest {
    @Test
    public void testInsertHead() {
        SinglyLL list = new SLL();
        Node node = new Node(1);
        list.insertHead(node);
        assertEquals(node, list.getHead());
    }

    @Test
    public void testInsertTail() {
        SinglyLL list = new SLL();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        list.insertHead(node1);
        list.insertTail(node2);
        assertEquals(node2, list.getTail());
    }

    @Test
    public void testInsertAtPosition() {
        SinglyLL list = new SLL();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        list.insertHead(node1);
        list.insertTail(node3);
        list.insert(node2, 2);
        assertEquals(node2, list.getNodeAt(2));
    }
    @Test
    public void testInsertAtPosition2() {
        SinglyLL list = new SLL();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        list.insertHead(node1);
        list.insertTail(node3);
        list.insert(node2, 1);
        assertEquals(node2, list.getNodeAt(1));
    }
    // test for deleteHead
    @Test
    public void testDeleteHead() {
        SinglyLL list = new SLL();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        list.insertHead(node1);
        list.insertTail(node3);
        list.insert(node2, 1);
        list.deleteHead();
        assertEquals(node2, list.getNodeAt(0));
    }
    // test for deleteTail
    @Test
    public void testDeleteTail() {
        SinglyLL list = new SLL();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        list.insertHead(node1);
        list.insertTail(node3);
        list.insert(node2, 1);
        list.deleteTail();
        assertEquals(node2, list.getNodeAt(1));
    }
    // test for deleteAtPosition
    @Test
    public void testDeleteAtPosition() {
        SinglyLL list = new SLL();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        list.insertHead(node1);
        list.insertTail(node3);
        list.insert(node2, 1);
        list.deleteAtPosition(1);
        assertEquals(node3, list.getNodeAt(1));
    }
    // test for clear
    @Test
    public void testClear() {
        SinglyLL list = new SLL();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        list.insertHead(node1);
        list.insertTail(node3);
        list.insert(node2, 1);
        list.clear();
        assertEquals(null, list.getNodeAt(0));
    }
    // test for isEmpty
    @Test
    public void testIsEmpty() {
        SinglyLL list = new SLL();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        list.insertHead(node1);
        list.insertTail(node3);
        list.insert(node2, 1);
        list.clear();
        assertEquals(true, list.isEmpty());
    }
    // test for isSorted
    @Test
    public void testIsSorted() {
        SinglyLL list = new SLL();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        list.insertHead(node1);
        list.insertTail(node3);
        list.insert(node2, 1);
        assertEquals(true, list.isSorted());
    }
    // test for sort
    @Test
    public void testSort() {
        SinglyLL list = new SLL();
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(1);
        list.insertHead(node1);
        list.insertTail(node3);
        list.insert(node2, 1);
        list.sort();
        assertEquals(node3, list.getNodeAt(0));
    }
    // test for dll
    @Test
    public void testDll() {
        SinglyLL list = new SLL();
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(1);
        list.insertHead(node1);
        list.insertTail(node3);
        list.insert(node2, 1);
        list.sort();
        assertEquals(node3, list.getNodeAt(0));
    }
    // test for print
    @Test
    public void testPrint() {
        SinglyLL list = new SLL();
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(1);
        list.insertHead(node1);
        list.insertTail(node3);
        list.insert(node2, 1);
        list.sort();
        assertEquals(node3, list.getNodeAt(0));
    }
    // dll test for insertHead
    @Test
    public void testDllInsertHead() {
        DoublyLL list = new DLL();
        Node node = new Node(1);
        list.insertHead(node);
        assertEquals(node, list.getHead());
    }
    // dll test for insertTail
    @Test
    public void testDllInsertTail() {
        DoublyLL list = new DLL();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        list.insertHead(node1);
        list.insertTail(node2);
        assertEquals(node2, list.getTail());
    }
    // dll test for insertAtPosition
    @Test
    public void testDllInsertAtPosition() {
        DoublyLL list = new DLL();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        list.insertHead(node1);
        list.insertTail(node3);
        list.insert(node2, 2);
        assertEquals(node2, list.getNodeAt(2));
    }
    // dll test for deleteHead
    @Test
    public void testDllDeleteHead() {
        DoublyLL list = new DLL();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        list.insertHead(node1);
        list.insertTail(node3);
        list.insert(node2, 2);
        list.deleteHead();
        assertEquals(node2, list.getNodeAt(1));
    }
    // dll test for deleteTail
    @Test
    public void testDllDeleteTail() {
        DoublyLL list = new DLL();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        list.insertHead(node1);
        list.insertTail(node3);
        list.insert(node2, 2);
        list.deleteTail();
        assertEquals(node2, list.getNodeAt(1));
    }
    // dll test for deleteAtPosition
    @Test
    public void testDllDeleteAtPosition() {
        DoublyLL list = new DLL();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        list.insertHead(node1);
        list.insertTail(node3);
        list.insert(node2, 2);
        list.deleteAtPosition(2);
        assertEquals(node3, list.getNodeAt(2));
    }
    // dll test for clear
    @Test
    public void testDllClear() {
        DoublyLL list = new DLL();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        list.insertHead(node1);
        list.insertTail(node3);
        list.insert(node2, 2);
        list.clear();
        assertEquals(null, list.getNodeAt(0));
    }



}   

    // Add more test cases for other methods...
}*/