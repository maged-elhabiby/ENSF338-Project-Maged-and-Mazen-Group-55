package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

import main.java.mylib.datastructures.linear.StackLL;
import main.java.mylib.datastructures.nodes.SNode;

public class StackLLTest {
    private StackLL stack;

    @Before
    public void setUp() {
        stack = new StackLL();
    }

    @Test
    public void testPush() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        stack.push(node1);
        stack.push(node2);

        assertEquals(2, stack.getSize());
        assertEquals(2, stack.peek().getData());
    }

    @Test
    public void testPop() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        stack.push(node1);
        stack.push(node2);

        SNode poppedNode = stack.pop();

        assertEquals(2, poppedNode.getData());
        assertEquals(1, stack.getSize());
        assertEquals(1, stack.peek().getData());
    }

    @Test
    public void testPeek() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        stack.push(node1);
        stack.push(node2);

        assertEquals(2, stack.peek().getData());
        assertEquals(2, stack.getSize());
    }

    @Test
    public void testEmptyStack() {
        assertThrows(IllegalStateException.class, () -> stack.peek());
        assertThrows(IllegalStateException.class, () -> stack.pop());
    }
}
