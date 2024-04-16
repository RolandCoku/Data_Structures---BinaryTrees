public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

    public BinarySearchTree(){
        super();
    }

    public BinarySearchTree(T element){
        super(element);
    }

    public void insert(T element){
        super.root = insert(element,super.root);
    }

    public void remove(T element){
        root = remove(element,root);
    }

    public void removeMin(){
        root = removeMin(root);
    }

    public T findMin(){
        return elementAt(findMin(root));
    }

    public T findMax(){
        return elementAt(findMax(root));
    }

    public T find(T element){
        return elementAt(find(element,root));
    }

    private T elementAt(BinaryNode<T> node){
        if (node == null){
            return null;
        }
        return node.getElement();
    }

    private BinaryNode<T> find(T element, BinaryNode<T> node){
        if(node.getElement().equals(element)){
            return node;
        }else if(element.compareTo(node.getElement()) < 0){
            return this.find(element, node.getLeft());
        }else
            return this.find(element, node.getRight());
    }

    private BinaryNode<T> findMin(BinaryNode<T> node){
        if(node.getLeft() == null){
            return node;
        }
        return this.findMin(node.getLeft());
    }

    private BinaryNode<T> findMax(BinaryNode<T> node){
        if(node.getRight() == null){
            return node;
        }

        return this.findMax(node.getRight());
    }

    private BinaryNode<T> insert(T element, BinaryNode<T> node){
        if(node == null){
            return new BinaryNode<>(element);
        }

        if(element.compareTo(node.getElement()) < 0){
            node.setLeft(this.insert(element, node.getLeft()));
        }else if(element.compareTo(node.getElement()) > 0){
            node.setRight(this.insert(element, node.getRight()));
        }

        return node;
    }
    private BinaryNode<T> removeMin(BinaryNode<T> node){
        if(node.getLeft() == null){
            return node.getRight();
        }
        node.setLeft(this.removeMin(node.getLeft()));
        return node;
    }

    private BinaryNode<T> remove(T element, BinaryNode<T> node){
        if(node == null){
            return null;
        }

        if(element.compareTo(node.getElement()) < 0){
            node.setLeft(this.remove(element, node.getLeft()));
        }else if(element.compareTo(node.getElement()) > 0){
            node.setRight(this.remove(element, node.getRight()));
        }else if(node.getLeft() != null && node.getRight() != null){
            node.setElement(this.findMin(node.getRight()).getElement());
            node.setRight(this.removeMin(node.getRight()));
        }else{
            node = (node.getLeft() != null) ? node.getLeft() : node.getRight();
        }

            return node;
    }

//**********************************************************************************************************************
    //EXERCISES

//3. Ndertoni nje funksion gjen vleren me te madhe ne nje:
//b. Peme binare kerkimi

//5. Ndertoni nje funksion qe gjen prindin e nje elementi te dhene X ne nje:
//b. Peme binare kerkimi

//18. Ndertoni nje funksion qe printon dhe numeron elementet e nje PBK qe jane me te medhenj se nje vlere e dhene k.


}
