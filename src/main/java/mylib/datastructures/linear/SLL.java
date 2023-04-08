package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SNode;

public class SLL<T extends Comparable<T>>{
    private SNode<T> head;
    private SNode<T> tail;
    private int size;

    
    public SLL(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public SLL(SNode<T> head){
        this.head = head;
        this.tail = head;
        this.size = 1;
    }
    public void insertHead(SNode<T> node){
        if(isEmpty()){
            this.head = node;
            this.tail = node;
        } else {
            node.setNext(this.head);
            this.head = node;
        }
        this.size++;
    }
    public void insertTail(SNode<T> node){
        if(isEmpty()){
            this.head = node;
            this.tail = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
        this.size++;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(SNode<T> node, int position){
        if(position < 0 || position > this.size){
            throw new IndexOutOfBoundsException("Invalid position");
        }
        if(position == 0){
            this.insertHead(node);
        } else if(position == this.size){
            this.insertTail(node);
        } else {
            SNode<T> current = this.head;
            for(int i = 0; i < position - 1; i++){
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            this.size++;
        }
    }
    public boolean isSorted(){

        if(isEmpty()){
            return true;
        }

        SNode<T> current = this.head;
        while(current.getNext() != null){
            if(current.getData().compareTo(current.getNext().getData()) > 0){
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

    public void sortedInsert(SNode<T> node) {
        if (!isSorted()) {
            sort();
        }

        if (isEmpty() || node.getData().compareTo(head.getData()) <= 0) {
            insertHead(node);
        } else if (node.getData().compareTo(tail.getData()) >= 0) {
            insertTail(node);
        } else {
            SNode<T> current = head;
            while (current.getNext() != null && current.getNext().getData().compareTo(node.getData()) < 0) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            size++;
        }
    }
    public SNode<T> search(T data) {
        SNode<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public void deleteHead() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        head = head.getNext();
        size--;
        if (isEmpty()) {
            tail = null;
        }
    }
    public void deleteTail() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
    
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            SNode<T> current = head;
            while (current.getNext() != tail) {
                current = current.getNext();
            }
            current.setNext(null);
            tail = current;
        }
        size--;
    }
    public void delete(SNode<T> node) {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
    
        if (head == node) {
            deleteHead();
        } else if (tail == node) {
            deleteTail();
        } else {
            SNode<T> current = head;
            while (current.getNext() != null && current.getNext() != node) {
                current = current.getNext();
            }
    
            if (current.getNext() != null) {
                current.setNext(current.getNext().getNext());
                size--;
            }
        }
    }
    public void sort(){
        if(isEmpty()){
            return;
        }
        SNode<T> current = this.head;
        SNode<T> sortedList = null;
        
        while(current != null){
            SNode<T> next = current.getNext();
            if(sortedList == null || current.getData().compareTo(sortedList.getData()) < 0){
                current.setNext(sortedList);
                sortedList = current;
            } else {
                SNode<T> sortedCurrent = sortedList;
                while(sortedCurrent.getNext() != null && current.getData().compareTo(sortedCurrent.getNext().getData()) > 0){
                    sortedCurrent = sortedCurrent.getNext();
                }
                current.setNext(sortedCurrent.getNext());
                sortedCurrent.setNext(current);
            }
            current = next;
            
        }
        this.head = sortedList;

        //update the tail reference
        SNode<T> tail = this.head;
        while(tail.getNext() != null){
            tail = tail.getNext();
        }
        this.tail = tail;
    }
    public void clear(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void print() {
        System.out.println("List length: " + size);
        System.out.println("Sorted status: " + (isSorted() ? "sorted" : "not sorted"));
    
        System.out.print("List content: ");
        SNode<T> current = head;
        while (current != null) {
            System.out.print(current.getData());
            if (current.getNext() != null) {
                System.out.print(" -> ");
            }
            current = current.getNext();
        }
        System.out.println();
    }
}
