import java.util.NoSuchElementException;

public abstract class TreeIterator<T extends Comparable<T>> {
    protected BinaryTree<T> theTree;
    protected BinaryNode<T> currentNode;

    public TreeIterator(BinaryTree<T> theTree){
        this.theTree = theTree;
        currentNode = null;
    }
    final public boolean isValid(){
        return currentNode != null;
    }
    final public T retrieve(){
        if(!isValid()){
            throw new NoSuchElementException();
        }
        return currentNode.getElement();
    }
    abstract public void first();
    abstract public void advance();
}
