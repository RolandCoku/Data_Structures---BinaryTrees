public class BinarySearchTree<T extends Comparable<T>> {
    private BinaryNode<T> root;

    public BinarySearchTree(){
        root = null;
    }

    public void insert(T element){
        root = insert(element,root);
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

    public void clear(){
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    private T elementAt(BinaryNode<T> node){
        if (node == null){
            return null;
        }
        return node.getElement();
    }

    private BinaryNode<T> find(T element, BinaryNode<T> startingNode){
        if (startingNode == null){
            return null;
        }

        if(element.compareTo(startingNode.getElement()) < 0){
            return find(element, startingNode.getLeft());
        }else if(element.compareTo(startingNode.getElement()) > 0){
            return find(element, startingNode.getRight());
        }else
            return startingNode;
    }

    private BinaryNode<T> findMin(BinaryNode<T> startingNode){
        if (startingNode == null){
            return null;
        }
        if(startingNode.getLeft() != null){
            return findMin(startingNode.getLeft());
        }
        return startingNode;
    }
    private BinaryNode<T> findMax(BinaryNode<T> startingNode){
        if(startingNode == null){

        }
    }
    private BinaryNode<T> insert(T element, BinaryNode<T> startingNode){

    }
    private BinaryNode<T> removeMin(BinaryNode<T> startingNode){

    }
    private BinaryNode<T> remove(T element, BinaryNode<T> startingNode){

    }

//**********************************************************************************************************************
    //EXERCISES

//3. Ndertoni nje funksion gjen vleren me te madhe ne nje:
//b. Peme binare kerkimi

//5. Ndertoni nje funksion qe gjen prindin e nje elementi te dhene X ne nje:
//b. Peme binare kerkimi

//18. Ndertoni nje funksion qe printon dhe numeron elementet e nje PBK qe jane me te medhenj se nje vlere e dhene k.


}
