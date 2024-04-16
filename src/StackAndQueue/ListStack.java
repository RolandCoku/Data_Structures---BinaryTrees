package StackAndQueue;
import StackAndQueue.List.ListNode;
public class ListStack<T extends Comparable<T>> {
    private ListNode<T> topOfStack;

    public ListStack(){
        topOfStack = null;
    }
    public boolean isEmpty(){
        return topOfStack == null;
    }
    public void clear(){
        topOfStack = null;
    }
    public void push(T newElement){
        this.topOfStack = new ListNode<>(newElement, topOfStack);
    }
    public T peek(){
        if(this.isEmpty()){
            System.out.println("Stack empty!");
            return null;
        }
        return topOfStack.element;
    }
    public T pop(){
        if (isEmpty()){
            System.out.println("Stack empty!");
            return null;
        }
        T element = topOfStack.element;
        topOfStack=topOfStack.next;
        return element;
    }
    public void printStack(){
        if(isEmpty()){
            System.out.println("Empty list!");
            return;
        }
        ListNode<T> temp = topOfStack;
        System.out.print("[ ");
        while (!isEmpty()){
            System.out.print(temp.element+" ");
        }
        System.out.println("]");
    }
    public int size(){
        int size = 0;
        while (!isEmpty()){
            size++;
        }
        return size;
    }

}
