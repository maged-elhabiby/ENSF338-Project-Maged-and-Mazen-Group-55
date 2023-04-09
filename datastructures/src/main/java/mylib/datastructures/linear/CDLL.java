package mylib.datastructures.linear;
import mylib.datastructures.nodes.DNode;

public class CDLL extends DLL {

    public CDLL() {
        super();
    }

    public CDLL(DNode head) {
        super(head);
        head.setNext(head);
        head.setPrev(head);
    }

    @Override
    public void insertHead(DNode node) {
        if (getSize() == 0) {
            super.insertHead(node);
            node.setNext(node);
            node.setPrev(node);
        } else {
            super.insertHead(node);
            getHead().setPrev(getTail());
            getTail().setNext(getHead());
        }
    }

    @Override
    public void insertTail(DNode node) {
        if (getSize() == 0) {
            super.insertTail(node);
            node.setNext(node);
            node.setPrev(node);
        } else {
            super.insertTail(node);
            getHead().setPrev(getTail());
            getTail().setNext(getHead());
        }
    }

    @Override
    public void deleteHead() {
        if (getSize() == 0) {
            throw new IllegalStateException("List is empty");
        } else if (getSize() == 1) {
            clear();
        } else {
            super.deleteHead();
            getHead().setPrev(getTail());
            getTail().setNext(getHead());
        }
    }

    @Override
    public void deleteTail() {
        if (getSize() == 0) {
            throw new IllegalStateException("List is empty");
        } else if (getSize() == 1) {
            clear();
        } else {
            super.deleteTail();
            getHead().setPrev(getTail());
            getTail().setNext(getHead());
        }
    }
}
