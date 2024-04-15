public class BinaryTree<T> {
    private BinaryNode<T> root;
    public BinaryTree(T rootElement){
        root = new BinaryNode<>(rootElement,null,null);
    }
    public BinaryTree(){
        root = null;
    }
    public BinaryNode<T> getRoot(){
        return root;
    }
    public int size(){
        return root.size();
    }
    public int height(){
        return root.height();
    }

    public void printPreOrder(){
        if(!isEmpty()){
            root.printPreOrder();
        }
    }
    public void printInOrder(){
        if(!isEmpty()){
            root.printInOrder();
        }
    }
    public void printPostOrder(){
        if(!isEmpty()){
            root.printPostOrder();
        }
    }
    public void clear(){
        root = null;
    }
    public boolean isEmpty(){
        return root == null;
    }
    public void merge(T rootElement){
        BinaryTree<T> tree1;
        BinaryTree<T> tree2;
    }
}
