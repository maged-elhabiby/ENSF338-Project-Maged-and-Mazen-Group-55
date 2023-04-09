package mylib.datastructures.linear;
import mylib.datastructures.nodes.SNode;

public class StackLL extends SLL {
    public StackLL() {
        super();
    }

    public StackLL(SNode head) {
        super(head);
    }

    @Override
    public void insertTail(SNode node) {
        // Override with empty body to prevent misuse
    }

    @Override
    public void insert(SNode node, int position) {
        // Override with empty body to prevent misuse
    }

    @Override
    public void sortedInsert(SNode node) {
        // Override with empty body to prevent misuse
    }

    @Override
    public void deleteTail() {
        // Override with empty body to prevent misuse
    }

    @Override
    public void delete(SNode node) {
        // Override with empty body to prevent misuse
    }

    @Override
    public void sort() {
        // Override with empty body to prevent misuse
    }

    public void push(SNode node) {
        super.insertHead(node);
    }

    public SNode pop() {
        if (super.getSize() == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        SNode headNode = super.getHead();
        super.deleteHead();
        return headNode;
    }

    public SNode peek() {
        if (super.getSize() == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return super.getHead();
    }
}
