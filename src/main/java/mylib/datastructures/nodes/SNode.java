package main.java.mylib.datastructures.nodes;

public class SNode<T> {
    private T data;
    private SNode<T> next;

    public SNode(T data){
        this.data = data;
        this.next = null;
    }
    public T getData(){
        return this.data;
    }
    public SNode<T> getNext(){
        return this.next;
    }
    public void setNext(SNode<T> next){
        this.next = next;
    }
}
