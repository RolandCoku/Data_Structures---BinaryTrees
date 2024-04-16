package StackAndQueue;

public class ArrayQueue <T>{
    private T[] theArray;
    private int front;
    private int back;
    private int size;
    private final static int DEFAULT_CAPACITY = 5;

    public ArrayQueue(){
        theArray = (T[]) new Object[DEFAULT_CAPACITY];
        clear();
    }

    public boolean isEmpty(){
        return (front == -1)&&(back == -1);
    }
    public void enqueue(T newElement){
        //If back+1 index equals front that means our circular array is full, and we have to double the size
        //The array will also be full in case that back index has reached the end of the array but the front is still at the beginning
        if((back+1 == front)||((front == 0)&&(back == theArray.length - 1))){
            doubleArray();
        }
        size++;//Every time that the method enqueue is called the size of the queue must increase by 1
        if (isEmpty()){//In the case that theArray is empty we have to increment front and back
            theArray[++back] = newElement;
            front++;
        } else if ((back != theArray.length-1)){//If back index hasn't reached the end of theArray we simply increment back and add the element
            theArray[++back] = newElement;
        }else{
            back = 0;//If back index is at the end we start adding elements in the beginning of theArray if there is space, creating the circular array
            theArray[back] = newElement;
        }

    }
    public T dequeue(){
        if (isEmpty()){
            System.out.println("Empty queue!");
            return null;
        }
        size--;
        if(front != theArray.length-1){
            return theArray[front++];
        }else{
            T temp = theArray[front];
            front = 0;
            return temp;
        }
    }
    public T getFront(){
        if (isEmpty()){
            System.out.println("Empty queue!");
            return null;
        }
        return theArray[front];
    }
    public void clear(){
        front = -1;
        back = -1;
        size = 0;
    }
    public void printQueue(){
        int index = 0;
        System.out.print("[ ");
        while (index < size){
            System.out.print(this.getFront()+" ");
            this.enqueue(this.dequeue());
            index++;
        }
        System.out.println("]");
    }

    public void doubleArray(){
        T[] newArray = (T[]) new Object[theArray.length*2];
        int index = 0;
        while (index < size){
            newArray[index] = this.getFront();
            this.enqueue(this.dequeue());
            index++;
        }
        theArray = newArray;
        front = 0;
        back = size-1;
    }

}
