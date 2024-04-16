package StackAndQueue;

public class ArrayDoubleEndedQueue<T> {
    private T[] theArray;
    private int front;
    private int back;
    private final int DEFAULT_CAPACITY = 10;

    public ArrayDoubleEndedQueue(){
        theArray = (T[]) new Object[DEFAULT_CAPACITY];
        front = -1;
        back = -1;
    }
    public void enqueueFront(T newElement){
        if (isEmpty()){
            theArray[++front] = newElement;
            back++;
        }else if((front != theArray.length - 1)&&(front + 1 != back)){
            theArray[++front] = newElement;
        }else if((front == theArray.length - 1)&&(back != 0)){
            front = 0;
            theArray[front] = newElement;
        }else
            System.out.println("Queue full");
    }
    public void enqueueBack(T newElement){
        if(isEmpty()){
            theArray[++back] = newElement;
            front++;
        }else if((back > 0)&&(back - 1 != front)){
            theArray[--back] = newElement;
        }else if ((back == 0) && (front != theArray.length - 1)){
            back = theArray.length - 1;
            theArray[back] = newElement;
        }else
            System.out.println("Queue full");
    }
    public T getFront(){
        if(isEmpty()){
            System.out.println("Empty queue");
            return null;
        }
        return theArray[front];
    }
    public T getBack(){
        if(isEmpty()){
            System.out.println("Empty queue");
            return null;
        }
        return theArray[back];
    }
    public boolean isEmpty(){
        return (front == -1)&&(back == -1);
    }
    public boolean isFull(){
        return (((back == 0)&&(front == theArray.length-1)) || (front+1 == back) || (back-1 == front));
    }
    public void clear(){
        front = -1;
        back = -1;
    }
    public void printQueue(){
        if(isEmpty()){
            System.out.println("Empty queue");
            return;
        }
        for (int i = 0; i < theArray.length; i++){
            System.out.print(theArray[i]+" ");
        }
        System.out.println();
    }
    public T dequeueFront(){
        if(isEmpty()){
            System.out.println("Empty Queue!");
            return null;
        }
        T temp = theArray[front];
        if (front-1 != 0){
            front--;
        }else{
            front = theArray.length-1;
        }
        return temp;
    }
    public T dequeueBack(){
        if(isEmpty()){
            System.out.println("Empty Queue!");
            return null;
        }
        T temp = theArray[back];
        if(back != theArray.length-1){
            back++;
        }else {
            back = 0;
        }
        return temp;
    }
}
