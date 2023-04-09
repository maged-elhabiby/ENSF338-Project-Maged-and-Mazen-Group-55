package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

import main.java.mylib.datastructures.linear.QueueLL;
import main.java.mylib.datastructures.nodes.SNode;

public class QueueLLTest {
    private QueueLL queue;

    @Before
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
