import StackAndQueue.ListStack;
import java.util.NoSuchElementException;

public class PostOrder<T extends Comparable<T>> extends TreeIterator<T> {

    protected static class StackNode<T extends Comparable<T>> implements Comparable<StackNode<T>>{
        public BinaryNode<T> node;
        public int timesPopped;
        public StackNode(BinaryNode<T> node){
            this.node = node;
            timesPopped = 0;
        }
        @Override
        public int compareTo(StackNode<T> other){
            return this.node.getElement().compareTo(other.node.getElement());
        }
    }

    protected ListStack<StackNode<T>> stack;

    public PostOrder(BinaryTree<T> theTree){
        super(theTree);
        stack = new ListStack<>();
        stack.push(new StackNode<>(super.theTree.root));
    }

    @Override
    public void first(){
        this.stack.clear();
        if(super.theTree.root != null){
            stack.push(new StackNode<>(super.theTree.root));
            this.advance();
        }
    }

    @Override
    public void advance() {
        if(stack.isEmpty()){
            if (super.currentNode == null)
                throw new NoSuchElementException();
            super.currentNode = null;
            return;
        }

        StackNode<T> currentStackNode;
        for (; ;){
            currentStackNode = stack.pop();
            if (++currentStackNode.timesPopped == 3){
                currentNode = currentStackNode.node;
                return;
            }
            stack.push(currentStackNode);
            if (currentStackNode.timesPopped == 1){
                if (currentStackNode.node.getLeft() != null){
                    stack.push(new StackNode<>(currentStackNode.node.getLeft()));
                }
            }else {
                if(currentStackNode.node.getRight() != null){
                    stack.push(new StackNode<>(currentStackNode.node.getRight()));
                }
            }
        }
    }
}
