public class BinaryTree<T extends Comparable<T>> {
    public BinaryNode<T> root;

    public BinaryTree(T rootElement){
        root = new BinaryNode<>(rootElement,null,null);
    }
    public BinaryTree(){
        root = null;
    }
    public int size(){
        if(isEmpty()){
            return 0;
        }
        return root.size();
    }
    public int height(){
        if(isEmpty()){
            return 0;
        }
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
        tree1 = new BinaryTree<>(rootElement);
        tree2 = new BinaryTree<>(rootElement);
        root = new BinaryNode<>(rootElement,tree1.root,tree2.root);
    }
    public void insert(T newElement){
        root = insert(newElement,root);
    }
    private BinaryNode<T> insert(T newElement, BinaryNode<T> node){
        if(node == null){
            return new BinaryNode<>(newElement);
        }
        if(newElement.compareTo(node.getElement()) < 0){
            node.setLeft(insert(newElement,node.getLeft()));
        }else{
            node.setRight(insert(newElement,node.getRight()));
        }
        return node;
    }

//**********************************************************************************************************************
    //EXERCISES

//3. Ndertoni nje funksion gjen vleren me te madhe ne nje:
//a. Peme binare

    public T findMax(){
        if(isEmpty()){
            return null;
        }
        return findMax(root);
    }

    private T findMax(BinaryNode<T> node){
        T max = node.getElement();
        if(node.getLeft() != null){
            T leftMax = findMax(node.getLeft());
            max = (leftMax.compareTo(max) > 0) ? leftMax : max;
        }
        if(node.getRight() != null){
            T rightMax = findMax(node.getRight());
            max = (rightMax.compareTo(max) > 0) ? rightMax : max;
        }
        return max;
    }

//4. Ndertoni nje funksion qe printon te gjitha nyjet me vlere cift te nje peme binare.
    public void printEven(){
        if(isEmpty()){
            System.out.println("Empty tree!");
        }
        System.out.print("Even elements: [ ");
        printEven(root);
        System.out.println("]");
    }

    private void printEven(BinaryNode<T> node){
        if((Integer)node.getElement() % 2 == 0){
            System.out.print(node.getElement() + " ");
        }
        if(node.getLeft() != null){
            printEven(node.getLeft());
        }
        if(node.getRight() != null){
            printEven(node.getRight());
        }
    }

//5. Ndertoni nje funksion qe gjen prindin e nje elementi te dhene X ne nje:
//a. Peme binare
    public BinaryNode<T> findParent(T element){
        if(isEmpty()){
            System.out.println("Empty tree!");
        }
        return findParent(element,root);
    }

    private BinaryNode<T> findParent(T element, BinaryNode<T> node){
        if(node.getLeft() != null && node.getLeft().getElement().equals(element)){
            return node;
        }
        if(node.getRight() != null && node.getRight().getElement().equals(element)){
            return node;
        }

        BinaryNode<T> parent = null;

        if(node.getLeft() != null){
            parent = findParent(element,node.getLeft());
        }
        if(parent == null && node.getRight() != null){
            parent = findParent(element,node.getRight());
        }
        return parent;
    }

//6. Ndertoni funksione eficente qe marrin nje pointer ne rrenjen e nje peme binare, T dhe kthejne:
//a. Numrin e nyjeve ne T
//b. Numrin e gjetheve ne T
//c. Numrin e nyjeve te plota ne T (nyje e plote = nyje qe ka saktesisht 2 femije)

//10. Ndertoni nje funksion rekursiv qe merr nje pointer ne rrenjen e nje peme T dhe kthen pemen pas fshirjes se te gjitha gjetheve ne T.

//11. Ndertoni nje funksion qe merr si parameter nje peme binare T dhe kthen thellesine e saj.

//12. Ndertoni nje funksion qe gjen thellesine e nje nyjeje me vlere k te dhene nje peme binare T.

//13. Ndërtoni një funksion që gjen thellësinë e një peme

//14. Ndertoni nje funksion qe ne nje peme binare T gjen numrin e cifteve prind-femije te nyjeve, shuma e vlerave te te cileve eshte nje numer k.

//15. Ndertoni nje funksion qe kontrollon nqs dy peme binare te dhena jane ose jo te barabarta.

//16. Ndertoni nje funksion linear rekursiv qe kontrollon nqs nje pemen binare ploteson karakteristikat e nje PBK.

//17. Ndertoni nje funksion linear rekursiv qe kontrollon nqs nje pemen binare ploteson karakteristikat e nje Peme Binare te Balancuar.

//19. Ndertoni nje funksion qe per nje peme binare T dhe nje numer k dhe:
//a. Printon vlerat e nyjeve ne thellesine k te pemes T
//b. Kthen shumen e elementeve ne thellesine k te pemes T
//c. Kthen elementin me te madh ne thellesine k te pemes T
//d. Kthen numrin e nyjeve me dy femije ne thellesine k te pemes T

//20. Ndertoni nje funksion qe merr pemen binare T dhe kthen nje peme simetrike me te.
}
