package mylib;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mylib.datastructures.linear.StackLL;
import mylib.datastructures.nodes.SNode;

public class StackLLTest {
    private StackLL stack;

    @BeforeEach
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
