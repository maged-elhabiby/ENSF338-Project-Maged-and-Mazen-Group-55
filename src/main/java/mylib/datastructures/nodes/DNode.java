package main.java.mylib.datastructures.nodes;

public class DNode<T> {
    private T data;
    private DNode<T> prev;
    private DNode<T> next;

    public DNode(T data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
    public T getData(){
        return this.data;
    }
    public DNode<T> getPrev(){
        return this.prev;
    }
    public void setPrev(DNode<T> prev){
        this.prev = prev;
    }
    public DNode<T> getNext(){
        return this.next;
    }
    public void setNext(DNode<T> next){
        this.next = next;
    }

}
