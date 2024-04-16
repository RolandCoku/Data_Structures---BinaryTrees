package StackAndQueue;

//Implement a stack using two queues.
public class QueueStack <T extends Comparable<T>>{

    private ListQueue<T> queue1;
    private ListQueue<T> queue2;

    public QueueStack(){
        queue1 = new ListQueue<>();
        queue2 = new ListQueue<>();
    }

    public void push(T element){
        if(queue1.isEmpty()){
            queue1.enqueue(element);
            while(!queue2.isEmpty()){
                queue1.enqueue(queue2.dequeue());
            }
        }else{
            queue2.enqueue(element);
            while(!queue1.isEmpty()){
                queue2.enqueue(queue1.dequeue());
            }
        }
    }

    public T peek(){
        if(queue1.isEmpty()){
            return queue2.getFront();
        }else{
            return queue1.getFront();
        }
    }

    public T pop(){
        if(queue1.isEmpty()){
            return queue2.dequeue();
        }else{
            return queue1.dequeue();
        }
    }

    public int Size(){
        return queue1.size() + queue2.size();
    }

    public void printStack(){
        if(queue1.isEmpty()){
            queue2.printQueue();
        }else{
            queue1.printQueue();
        }
    }
}
