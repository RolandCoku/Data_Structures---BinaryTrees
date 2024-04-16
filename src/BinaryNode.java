public class BinaryNode<T extends Comparable<T>> {
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
        if(this.isLeaf()){
            return 0;
        }
        return 1 + this.left.size() + this.right.size();
    }
    public int height(){
        if(this.isLeaf()){
            return 0;
        }
        return 1+Math.max(this.left.height(),this.right.height());
    }
    public BinaryNode<T> dublicate(){
        BinaryNode<T> root = new BinaryNode<>(this.element);
        if(this.left != null){
            root.left = this.dublicate();
        }
        if (this.right != null){
            root.right = this.dublicate();
        }
        return root;
    }
    public void printPreOrder(){
        System.out.print(this.element+" ");
        if(this.left != null){
            this.left.printPreOrder();
        }
        if(this.right != null){
            this.right.printPreOrder();
        }
    }
    public void printInOrder(){
        if(this.right != null){
            this.right.printInOrder();
        }
        System.out.println(this.element+" ");
        if(this.left != null){
            this.left.printInOrder();
        }
    }
    public void printPostOrder(){
        if(this.left != null){
            this.left.printPreOrder();
        }
        if(this.right != null){
            this.right.printPreOrder();
        }
        System.out.print(this.element+" ");
    }
}

