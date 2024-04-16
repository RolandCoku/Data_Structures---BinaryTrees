package StackAndQueue;

//Ushtrimi 4
//Implementoni ADT per radhen ne nje strukture qe perdor dy stiva duke perdorur metodat e implementuara per stiven.
public class StackQueue <T extends Comparable<T>> {
    private ListStack<T> stack1;
    private ListStack<T> stack2;

    public StackQueue(){
        stack1 = new ListStack<>();
        stack2 = new ListStack<>();
    }

    public boolean isEmpty(){
        return stack1.isEmpty();
    }
    public T dequeue(){
        if(isEmpty()){
            System.out.println("Empty Queue!");
            return null;
        }
        return stack1.pop();
    }
    public void enqueue(T newElement){
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(newElement);
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }
    public T getFront(){
        if (stack1.isEmpty()){
            System.out.println("Empty Queue!");
            return null;
        }
        return stack1.peek();
    }
    public void clear(){
        stack1.clear();
    }
    public void printQueue(){
        stack1.printStack();
    }
    public int size(){
        return stack1.size();
    }
}
