package StackAndQueue;

import StackAndQueue.List.DoublyListNode;
public class ListDoubleEndedQueue<T extends Comparable<T>> {
    private DoublyListNode<T> front;
    private DoublyListNode<T> back;
    private int size;
    private final int MAX_CAPACITY = 10;

    public ListDoubleEndedQueue(){
        this.front = null;
        this.back = null;
    }

    public void enqueueFront(T newElement){
        size++;

        if(isEmpty()){
            front = new DoublyListNode<>(newElement);
            back = front;
        }else {
            front.next = new DoublyListNode<>(newElement,null,front);
            front = front.next;
        }
    }

    public void enqueueBack(T newElement){
        size++;

        if (isEmpty()){
            back = new DoublyListNode<>(newElement);
            front = back;
        }else {
            back.previous = new DoublyListNode<>(newElement,back,null);
            back = back.previous;
        }
    }

    public T getFront(){
        if(isEmpty()){
            System.out.println("Empty Queue!");
            return null;
        }
        return front.element;
    }

    public T getBack(){
        if (isEmpty()){
            System.out.println("Empty Queue");
            return null;
        }
        return back.element;
    }

    public boolean isEmpty(){
        return ((back == null) && (front == null));
    }

    public boolean isFull(){
        return size == MAX_CAPACITY;
    }

    public void printQueue(){
        DoublyListNode<T> current = back;
        while(current != null){
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println();
    }
}
