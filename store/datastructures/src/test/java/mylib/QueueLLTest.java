package mylib;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mylib.datastructures.linear.QueueLL;
import mylib.datastructures.nodes.SNode;

public class QueueLLTest {
    private QueueLL queue;

    @BeforeEach
    public void setUp() {
        queue = new QueueLL();
    }

    @Test
    public void testEnqueue() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        queue.enqueue(node1);
        queue.enqueue(node2);

        assertEquals(2, queue.getSize());
        assertEquals(1, queue.peek().getData());
    }

    @Test
    public void testDequeue() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        queue.enqueue(node1);
        queue.enqueue(node2);

        SNode dequeuedNode = queue.dequeue();

        assertEquals(1, dequeuedNode.getData());
        assertEquals(1, queue.getSize());
        assertEquals(2, queue.peek().getData());
    }

    @Test
    public void testPeek() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        queue.enqueue(node1);
        queue.enqueue(node2);

        assertEquals(1, queue.peek().getData());
        assertEquals(2, queue.getSize());
    }

    @Test
    public void testEmptyQueue() {
        assertThrows(IllegalStateException.class, () -> queue.peek());
        assertThrows(IllegalStateException.class, () -> queue.dequeue());
    }
}
