package StackAndQueue;//Ushtrimi 3
//Dy stiva jane vendosur ne nje vektor me madhesi 1000. Ndertoni nje tip abstrakt te dhenash qe implementon veprimet qe kryhen me kete strukture.

public class DoubleStackArray <T>{
    private T[] theArray;
    private final int DEFAULT_CAPACITY = 1000;
    private int topOfStack1;
    private int topOfStack2;

    public DoubleStackArray(){
        theArray = (T[]) new Object[DEFAULT_CAPACITY];
        topOfStack1 = -1;
        topOfStack2 = theArray.length;
    }
    public boolean isEmpty1(){
        return topOfStack1 == -1;
    }
    public boolean isEmpty2(){
        return topOfStack2 == theArray.length;
    }
    public void clear1(){
        topOfStack1 = -1;
    }
    public void clear2(){
        topOfStack2 = theArray.length;
    }
    public void push1(T newElement){
        if(topOfStack1+1 == topOfStack2){
            doubleArray();
        }
        theArray[++topOfStack1] = newElement;
    }
    public void push2(T newElement){
        if(topOfStack2 - 1 == topOfStack1){
            doubleArray();
        }
        theArray[--topOfStack2] = newElement;
    }
    public T peek1(){
        if(isEmpty1()){
            System.out.println("Stack1 empty!");
            return null;
        }
        return theArray[topOfStack1];
    }
    public T peek2(){
        if(isEmpty2()){
            System.out.println("Stack2 empty!");
            return null;
        }
        return theArray[topOfStack2];
    }
    public T pop1(){
        if(isEmpty1()){
            System.out.println("Stack1 empty!");
            return null;
        }
        return theArray[topOfStack1--];
    }
    public T pop2(){
        if(isEmpty2()){
            System.out.println("Stack2 empty!");
            return null;
        }
        return theArray[topOfStack2++];
    }
    public void doubleArray(){
        T[] newArray = (T[]) new Object[theArray.length*2];
        for (int i = 0; i <= topOfStack1; i++){
            newArray[i] = theArray[i];
        }
        for (int i = theArray.length-1; i >= topOfStack2; i--){
            newArray[i] = theArray[i];
        }
        theArray = newArray;
    }
    public void print1(){
        System.out.print("[ ");
        for (int i = 0; i<=topOfStack1; i++){
            System.out.print(theArray[i]+" ");
        }
        System.out.println("]");
    }
    public void print2(){
        System.out.print("[ ");
        for (int i = theArray.length-1; i>=topOfStack2; i--){
            System.out.print(theArray[i]+" ");
        }
        System.out.println("]");
    }
}
