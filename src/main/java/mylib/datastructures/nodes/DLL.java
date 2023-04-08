package main.java.mylib.datastructures.nodes;

public class DLL <T extends Comparable<T>> extends SLL<T> {
    private DNode<T> head;
    private DNode<T> tail;
    private int size;

    public DLL(){
        super();
        this.head = null;
        this.tail = null;
    }
    public DLL(DNode<T> head){
        //super(head);
        this.head = head;
        this.tail = head;
    }
    @Override
    public void insertHead(SNode<T> node) {
        DNode<T> dNode = new DNode<T>(node.getData());
        if (isEmpty()) {
            this.head = dNode;
            this.tail = dNode;
        } else {
            dNode.setNext(this.head);
            this.head.setPrev(dNode);
            this.head = dNode;
        }
        this.size++;
    }

    @Override
    public void insertTail(SNode<T> node) {
        DNode<T> dNode = new DNode<T>(node.getData());
        if (isEmpty()) {
            this.head = dNode;
            this.tail = dNode;
        } else {
            dNode.setPrev(this.tail);
            this.tail.setNext(dNode);
            this.tail = dNode;
        }
        this.size++;
    }
    
    @Override
    public void insert(SNode<T> node, int position) {
        if (position < 0 || position > this.size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        if (position == 0) {
            this.insertHead(node);
        } else if (position == this.size) {
            this.insertTail(node);
        } else {
            DNode<T> current = this.head;
            for (int i = 0; i < position - 1; i++) {
                current = (DNode<T>) current.getNext();
            }
            DNode<T> dNode = new DNode<T>(node.getData());
            dNode.setNext(current.getNext());
            dNode.setPrev(current);
            current.setNext(dNode);
            this.size++;
        }
    }
    @Override
    public void deleteHead() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        this.head = this.head.getNext();
        if (this.head == null) {
            this.tail = null;
        } else {
            this.head.setPrev(null);
        }
        this.size--;
    }
    @Override
    public void deleteTail(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("List is empty");
        }
        this.tail = this.tail.getPrev();
        if(this.tail == null){
            this.head = null;
        } else {
            this.tail.setNext(null);
        }
        this.size--;
        
    }
    public void delete(DNode<T> node){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("List is empty");
        }
        if(node.getPrev() == this.head){
            this.deleteHead();
        } else if(node.getNext() == this.tail){
            this.deleteTail();
        } else {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
            this.size--;
        }
    }
    public void printReverse(){
        System.out.println("List length: " + this.size);
        System.out.println("Sorted list: "+ (this.isSorted() ? "sorted" : "not sorted"));
        System.out.println("Reversed list content: ");
        DNode<T> current = this.tail;
        while(current != null){
            System.out.println(current.getData());
            if(current.getPrev() != null){
                System.out.println(" -> ");
            }
            current = current.getPrev();
        }
        System.out.println();
    }

    
}
