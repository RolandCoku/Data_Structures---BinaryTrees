package StackAndQueue;

public class ArrayStack <T>{
    private T[] theArray;
    private int topOfStack;
    private static final int DEFAULT_CAPACITY = 10;
    public ArrayStack(){
        theArray = (T[]) new Object[DEFAULT_CAPACITY];
        topOfStack = -1;
    }
    public boolean isEmpty(){
        return topOfStack == -1;
    }
    public void clear(){
        topOfStack = -1;
    }
    public void push(T newElement){
        if(topOfStack + 1 == theArray.length){
            this.doubleArray();
        }
        theArray[++topOfStack] = newElement;
    }
    public T peek(){
        if(isEmpty()){
            return null;
        }
        return theArray[topOfStack];
    }
    public T pop(){
        if(isEmpty()){
            return null;
        }
        return theArray[topOfStack--];
    }
    private void doubleArray(){
        T[] newArray = (T[]) new Object[theArray.length * 2];
        System.arraycopy(theArray, 0, newArray, 0, theArray.length);
        theArray = newArray;
    }

//**********************************************************************************************************************
//EXERCISES

//Ushtrimi 1

//Ne klasen ArrayStack te implementuar ne leksion (Stiva implementohet nepermjet nje vektori) implementoni funksionet e meposhtme:
//a. Ndertoni nje funksion qe kthen gjatesine e stives.
//b. Ndertoni nje funksion qe printon nje stive.
//c. Ndertoni nje funksion qe rendit stiven.
//d. Ndertoni nje funksion qe kopjon nje Stive S1 ne nje stive S2.
//e. Jepen dy stiva S1 dhe S2 elementet e te cilave jane 0 ose 1. Duke i menduar stivat si numra te paraqitur ne sistemin binar, te shkruhet nje program qe afishon stiven qe permban numrin me te madh.
//f. Ndertoni funksionin qe i zhvendos ne peek te stives elementin e k-te te saj.

    public int getStackSize(){
        return topOfStack + 1;
    }
    public void printStack(){
        System.out.print("[ ");
        for (int i = topOfStack; i >= 0; i--){
            System.out.print(theArray[i]+" ");
        }
        System.out.println("]");
    }
    public void sortStack(){
        ArrayStack<T> sortedStack = new ArrayStack<>();
        while (!this.isEmpty()){
            T temp = this.pop();
            while (!sortedStack.isEmpty() && ((Comparable)temp).compareTo(sortedStack.peek()) < 0){
                this.push(sortedStack.pop());
            }
            sortedStack.push(temp);
        }
        this.topOfStack = sortedStack.topOfStack;
        this.theArray = sortedStack.theArray;
    }
    public void copyStack(ArrayStack<T> stack){
        stack.clear();
        ArrayStack<T> copyStack = new ArrayStack<>();
        while (!this.isEmpty()){
            copyStack.push(this.pop());
        }
        while (!copyStack.isEmpty()){
            T temp = copyStack.pop();
            this.push(temp);
            stack.push(temp);
        }
    }
    public static void printBiggestBinary(ArrayStack<Integer> stack1, ArrayStack<Integer> stack2){
        if(stack1.isEmpty() && stack2.isEmpty()){
            System.out.println("Empty stacks");
        }else if(stack1.isEmpty()){
            stack2.printStack();
        }else if(stack2.isEmpty())
            stack1.printStack();

        int nr1 = 0;
        int nr2 = 0;
        int pow1 = stack1.getStackSize()-1;
        int pow2 = stack2.getStackSize()-1;

        while (!stack1.isEmpty() || !stack2.isEmpty()){
            if(!stack1.isEmpty()){
                nr1 += stack1.pop()*((int) Math.pow(2,pow1));
                pow1--;
            }
            if(!stack2.isEmpty()){
                nr2 += stack2.pop()*((int)Math.pow(2,pow2));
                pow2--;
            }
        }

        int temp1 = nr1;
        int temp2 = nr2;
        while (temp1 > 0 || temp2 > 0){
            if(temp1 > 0){
                stack1.push(temp1%2);
                temp1 /= 2;
            }
            if (temp2 > 0){
                stack2.push(temp2%2);
                temp2 /= 2;
            }
        }

        if(nr1 > nr2){
            stack1.printStack();
        } else if (nr2 > nr1) {
            stack2.printStack();
        } else
            System.out.println("Both numbers are equal!");
    }
    public void moveToTheTop(int k){
        int stackSize = this.getStackSize();
        if(k < 0 || k > stackSize){
            System.out.println("Invalid position!");
            return;
        } else if (this.isEmpty()){
            System.out.println("Empty Stack!");
            return;
        }
        ArrayStack<T> tempStack = new ArrayStack<>();
        int i = 0;
        while (i < stackSize - k ){
            tempStack.push(this.pop());
            i++;
        }
        T temp = this.pop();
        while (!tempStack.isEmpty()){
            this.push(tempStack.pop());
        }
        this.push(temp);
    }

//Ushtrimi 2
//Duke perdorur metodat e implementuara per stivat implementoni nje program qe perdor nje stive
//per te konvertuar nje numer nga sistemi me baze 10 ne sistemin me baze 16.
    public static void convertToHex(int nr){
        ArrayStack<Integer> stack = new ArrayStack<>();
        while (nr > 0){
            stack.push(nr%16);
            nr /= 16;
        }
        while (!stack.isEmpty()){
            int temp = stack.pop();
            if(temp < 10){
                System.out.print(temp);
            }else {
                switch (temp){
                    case 10:
                        System.out.print("A");
                        break;
                    case 11:
                        System.out.print("B");
                        break;
                    case 12:
                        System.out.print("C");
                        break;
                    case 13:
                        System.out.print("D");
                        break;
                    case 14:
                        System.out.print("E");
                        break;
                    case 15:
                        System.out.print("F");
                        break;
                }
            }
        }
    }

}
