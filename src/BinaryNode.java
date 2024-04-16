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
        return size(this);
    }

    public int height(){
        return height(this);
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
        System.out.print("PreOrder: [ ");
        this.printPreOrder(this);
        System.out.println("]");
    }

    public void printInOrder(){
        System.out.print("InOrder: [ ");
        this.printInOrder(this);
        System.out.println("]");
    }

    public void printPostOrder(){
        System.out.print("PostOrder: [ ");
        printPostOrder(this);
        System.out.println("]");
    }

    private int size(BinaryNode<T> root){
        if(root == null){
            return 0;
        }
        return 1+size(root.left)+size(root.right);
    }

    private int height(BinaryNode<T> root){
        if(root == null){
            return 0;
        }
        return 1+Math.max(height(root.left),height(root.right));
    }

    private void printPreOrder(BinaryNode<T> root){
        System.out.print(root.element+" ");
        if(root.left != null){
            printPreOrder(root.left);
        }
        if(root.right != null){
            printPreOrder(root.right);
        }
    }

    private void printInOrder(BinaryNode<T> root){
        if(root.left != null){
            printInOrder(root.left);
        }
        System.out.print(root.element+" ");
        if(root.right != null){
            printInOrder(root.right);
        }
    }
    private void printPostOrder(BinaryNode<T> root){
        if(root.left != null){
            printPostOrder(root.left);
        }
        if(root.right != null){
            printPostOrder(root.right);
        }
        System.out.print(root.element+" ");
    }
}

