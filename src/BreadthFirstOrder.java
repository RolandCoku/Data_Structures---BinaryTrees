import StackAndQueue.ArrayQueue;
import java.util.NoSuchElementException;

public class BreadthFirstOrder <T extends Comparable<T>> extends TreeIterator<T>{
    private ArrayQueue<BinaryNode<T>> queue;
    public BreadthFirstOrder(BinaryTree<T> theTree){
        super(theTree);
        queue = new ArrayQueue<>();
        queue.enqueue(super.theTree.root);
    }
    @Override
    public void first(){
        queue.clear();
        if(super.theTree.root != null){
            queue.enqueue(super.theTree.root);
            this.advance();
        }
    }
    @Override
    public void advance(){
        if(queue.isEmpty()){
            if(super.currentNode == null)
                throw new NoSuchElementException();
            super.currentNode = null;
            return;
        }
        BinaryNode<T> currentBinaryNode = queue.dequeue();
        if(currentBinaryNode.getLeft() != null){
            queue.enqueue(currentBinaryNode.getLeft());
        }
        if(currentBinaryNode.getRight() != null){
            queue.enqueue(currentBinaryNode.getRight());
        }
        super.currentNode = currentBinaryNode;
    }

}
