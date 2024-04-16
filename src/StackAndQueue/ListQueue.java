package StackAndQueue;

import StackAndQueue.List.ListNode;
public class ListQueue<T extends Comparable<T>> {
    private ListNode<T> front;
    private ListNode<T> back;
    public ListQueue(){
        this.front = null;
        this.back = null;
    }
    public boolean isEmpty(){
        return front == null;
    }
    public void enqueue(T element){
        if(isEmpty()){
            front = new ListNode<>(element);
            back = front;
        }else{
            back.next = new ListNode<>(element);
            back = back.next;
        }
    }
    public T dequeue(){
        if(isEmpty()){
            return null;
        }else{
            T element = front.element;
            front = front.next;
            return element;
        }
    }
    public T getFront(){
        if(isEmpty()){
            return null;
        }else{
            return front.element;
        }
    }
    public void clear(){
        front = null;
        back = null;
    }

    public void printQueue(){
        ListNode<T> current = front;
        while(current != null){
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int size(){
        int count = 0;
        ListNode<T> current = front;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }

//**********************************************************************************************************************
//EXERCISES

//Ushtrimi 5
//Invertoni nje radhe duke perdorur nje radhe tjeter nepermjet metodave te implementuara te radhes (Rradhë e implementuar me liste).
    public void reverseQueue(){
        ListQueue<T> tempQueue = new ListQueue<>();
        int size = 0;
        while (!this.isEmpty()){
            tempQueue.enqueue(this.dequeue());
            size++;
        }

        while (!tempQueue.isEmpty()) {
            for (int i = 0; i < size-1; i++){
                tempQueue.enqueue(tempQueue.dequeue());
            }
            this.enqueue(tempQueue.dequeue());
            size--;
        }
    }

}
