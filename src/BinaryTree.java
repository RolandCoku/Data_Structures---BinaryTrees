public class BinaryTree<T extends Comparable<T>> {
    public BinaryNode<T> root;

    public BinaryTree(T rootElement){
        root = new BinaryNode<>(rootElement,null,null);
    }

    public BinaryTree(BinaryNode<T> root){
        this.root = root;
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
        BinaryNode<T> parent = findParent(element,root);
        if(parent == null){
            System.out.println("The given element is not on the tree!");
            return null;
        }
        return parent;
    }

    private BinaryNode<T> findParent(T element, BinaryNode<T> node){
        if((node.getLeft() != null && node.getLeft().getElement().equals(element)) || (node.getRight() != null && node.getRight().getElement().equals(element))){
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

    public static <T extends Comparable<T>> int countNodes(BinaryNode<T> node){
        if(node == null){
            return 0;
        }

        return 1 + countNodes(node.getLeft()) + countNodes(node.getRight());
    }

    public static <T extends Comparable<T>> int countLeaves(BinaryNode<T> node){
        if(node.isLeaf() ){
            return 1;
        }

        if(node.getLeft() == null){
            return countLeaves(node.getRight());
        }
        if(node.getRight() == null){
            return countLeaves(node.getLeft());
        }
        return countLeaves(node.getLeft()) + countLeaves(node.getRight());
    }

    public static <T extends Comparable<T>> int countFullNodes(BinaryNode<T> node){
        if(node == null){
            return 0;
        }

        if((node.getLeft() != null && node.getRight() != null)){
            return 1 + countFullNodes(node.getRight()) + countFullNodes(node.getLeft());
        }else
            return countFullNodes(node.getRight()) + countFullNodes(node.getLeft());
    }

//10. Ndertoni nje funksion rekursiv qe merr nje pointer ne rrenjen e nje peme T dhe kthen pemen pas fshirjes se te gjitha gjetheve ne T.

    public static <T extends Comparable<T>> BinaryNode<T> removeTreeLeaves(BinaryNode<T> root){
        if(root == null || root.isLeaf()){
            return null;
        }
        root.setLeft(removeTreeLeaves(root.getLeft()));
        root.setRight(removeTreeLeaves(root.getRight()));
        return root;
    }

//11. Ndertoni nje funksion qe merr si parameter nje peme binare T dhe kthen thellesine e saj.

    public static <T extends Comparable<T>> int treeDepth(BinaryTree<T> tree){
        if(tree.root == null){
            return -1;
        }

        return 1 + Math.max(treeDepth(new BinaryTree<>(tree.root.getLeft())), treeDepth(new BinaryTree<>(tree.root.getRight())));
    }

//12. Ndertoni nje funksion qe gjen thellesine e nje nyjeje me vlere k te dhene nje peme binare T.
    public int nodeDepth(T element){
        if(isEmpty()){
            System.out.println("Empty tree!");
        }
        return nodeDepth(element,root);
    }

    private int nodeDepth(T element, BinaryNode<T> node){
        if(node == null){
            return -1;
        }

        if (node.getElement().equals(element)){
            return 0;
        }

        int leftDepth = nodeDepth(element, node.getLeft());
        int rightDepth = nodeDepth(element, node.getRight());

        if(leftDepth == -1 && rightDepth == -1){
            return -1;
        }

        return 1 + Math.max(leftDepth,rightDepth);
    }

//13. Ndërtoni një funksion që gjen thellësinë e një peme
    public int depth(){
        if(isEmpty()){
            System.out.println("Empty list!");
            return -1;
        }
        return depth(root);
    }

    private int depth(BinaryNode<T> root){
        if(root == null){
            return -1;
        }

        return 1 + Math.max(depth(root.getLeft()), depth(root.getRight()));
    }

//14. Ndertoni nje funksion qe ne nje peme binare T gjen numrin e cifteve prind-femije te nyjeve, shuma e vlerave te te cileve eshte nje numer k.

    public int pairsWithSum(int sum){
        if (isEmpty()){
            System.out.println("Empty tree!");
            return -1;
        }
        return pairsWithSum(sum, root);
    }
    private int pairsWithSum(int sum, BinaryNode<T> root){
        if(root == null){
            return 0;
        }

        if((root.getLeft() != null) && (((Integer)root.getElement() + (Integer)root.getLeft().getElement()) == sum)){
            return 1 + pairsWithSum(sum, root.getLeft());
        }else if((root.getRight() != null) && (((Integer)root.getElement() + (Integer)root.getRight().getElement()) == sum)){
            return 1 + pairsWithSum(sum, root.getRight());
        }else
            return pairsWithSum(sum, root.getLeft()) + pairsWithSum(sum, root.getRight());
    }

//15. Ndertoni nje funksion qe kontrollon nqs dy peme binare te dhena jane ose jo te barabarta.
    public static <T extends Comparable<T>> boolean areEqual(BinaryNode<T> root1, BinaryNode<T> root2){
        if (root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        if(!root1.getElement().equals(root2.getElement())){
            return false;
        }

        return areEqual(root1.getLeft(), root2.getLeft()) && areEqual(root1.getRight(), root2.getRight());
    }

//16. Ndertoni nje funksion linear rekursiv qe kontrollon nqs nje pemen binare ploteson karakteristikat e nje PBK.
    public boolean isBST(){
        if(isEmpty()){
            System.out.println("Empty tree!");
            return false;
        }
        return isBST(root);
    }
    private boolean isBST(BinaryNode<T> root){
        if(root == null){
            return true;
        }

        if((root.getLeft() != null) && (root.getLeft().getElement().compareTo(root.getElement()) > 0)){
            return false;
        }

        if((root.getRight() != null) && (root.getRight().getElement().compareTo(root.getElement()) < 0)){
            return false;
        }

        return isBST(root.getLeft()) && isBST(root.getRight());
    }

//17. Ndertoni nje funksion linear rekursiv qe kontrollon nqs nje pemen binare ploteson karakteristikat e nje Peme Binare te Balancuar.
    public boolean isBalanced(){
        if(isEmpty()){
            System.out.println("Empty tree!");
            return false;
        }
        return isBalanced(root);
    }
    private boolean isBalanced(BinaryNode<T> root){
        if(root == null){
            return true;
        }

        if((root.getRight() != null && root.getLeft() != null) && (Math.abs(root.getLeft().height() - root.getRight().height()) > 1)){
            return false;
        }

        return isBalanced(root.getLeft()) && isBalanced(root.getRight());
    }

//19. Ndertoni nje funksion qe per nje peme binare T dhe nje numer k dhe:
//a. Printon vlerat e nyjeve ne thellesine k te pemes T
//b. Kthen shumen e elementeve ne thellesine k te pemes T
//c. Kthen elementin me te madh ne thellesine k te pemes T
//d. Kthen numrin e nyjeve me dy femije ne thellesine k te pemes T

    public void printAtDepth(int depth){
        if (isEmpty()){
            System.out.println("Empty tree!");
            return;
        }
        System.out.print("[ ");
        printAtDepth(depth, root);
        System.out.println("]");
    }

    private void printAtDepth(int depth, BinaryNode<T> root){
        if(root == null){
            return;
        }

        if(depth == 0){
            System.out.print(root.getElement() + " ");
        }else{
            printAtDepth(depth - 1, root.getLeft());
            printAtDepth(depth - 1, root.getRight());
        }
    }

    public int sumAtDepth(int depth){
        if(isEmpty()){
            System.out.println("Empty tree!");
            return 0;
        }
        return sumAtDepth(depth, root);
    }
    private int sumAtDepth(int depth, BinaryNode<T> root){
        if(root == null){
            return 0;
        }

        if(depth == 0){
            return (Integer) root.getElement();
        }

        return sumAtDepth(depth-1, root.getLeft()) + sumAtDepth(depth - 1, root.getRight());
    }

    public T maxAtDepth(int depth){
        if(isEmpty()){
            System.out.println("Empty tree!");
            return null;
        }

        return maxAtDepth(depth, root);
    }
    private T maxAtDepth(int depth, BinaryNode<T> root){
        if(root == null){
            return null;
        }
        if(depth == 0){
            return root.getElement();
        }

        T rightMax = maxAtDepth(depth - 1, root.getRight());
        T leftMax = maxAtDepth(depth - 1, root.getLeft());

        if(rightMax == null && leftMax == null){
            return null;
        }

        if (rightMax == null){
            return leftMax;
        }

        if (leftMax == null){
            return rightMax;
        }

        return (rightMax.compareTo(leftMax) > 0) ? rightMax : leftMax;
    }

    public int fullNodesAtDepth(int depth){
        if(isEmpty()){
            System.out.println("Empty tree!");
            return 0;
        }
        return fullNodesAtDepth(depth, root);
    }
    private int fullNodesAtDepth(int depth, BinaryNode<T> root){
        if(root == null){
            return 0;
        }

        if(depth == 0 && root.getLeft() != null && root.getRight() != null){
            return 1;
        }

        return fullNodesAtDepth(depth-1, root.getLeft()) + fullNodesAtDepth(depth-1, root.getRight());
    }

//20. Ndertoni nje funksion qe merr pemen binare T dhe kthen nje peme simetrike me te.
    public BinaryTree<T> mirror(){
        if(isEmpty()){
            System.out.println("Empty tree!");
            return null;
        }

        return new BinaryTree<>(mirror(root));
    }

    private BinaryNode<T> mirror(BinaryNode<T> root){
        if(root == null){
            return null;
        }
        BinaryNode<T> newRoot = new BinaryNode<>(root.getElement());
        newRoot.setLeft(mirror(root.getRight()));
        newRoot.setRight(mirror(root.getLeft()));
        return newRoot;
    }
}
