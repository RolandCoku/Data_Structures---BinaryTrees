public class BinaryNode<T> {
    private T element;
    private BinaryNode<T> left;
    private BinaryNode<T> right;

    public BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right){
        this.element = element;
        this.left = left;
        this.right = right;
    }
    public BinaryNode(){
        this(null,null,null);
    }
    public BinaryNode(T element){
        this(element,null,null);
    }
    public T getElement(){
        return element;
    }
    public void setElement(T element){
        this.element = element;
    }
    public BinaryNode<T> getLeft(){
        return left;
    }
    public void setLeft(BinaryNode<T> left){
        this.left = left;
    }
    public BinaryNode<T> getRight(){
        return right;
    }
    public void setRight(BinaryNode<T> right){
        this.right = right;
    }
    public boolean isLeaf(){
        return left == null && right == null;
    }
    public int size(){
        if(this.right == null && this.left == null){
            return 0;
        }
        return 1 + this.left.size() + this.right.size();
    }
    public int height(){
        if(this.right==null && this.left==null){
            return 0;
        }
        return 1+Math.max(this.left.height(),this.right.height());
    }
    public BinaryNode<T> dublicate(){
        BinaryNode<T> root = new BinaryNode<>(element);
        if()
    }
    public void printPreOrder(){
    }
    public void printInOrder(){

    }
    public void printPostOrder(){

    }
}

