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
    }

//**********************************************************************************************************************
    //EXERCISES

//3. Ndertoni nje funksion gjen vleren me te madhe ne nje:
//a. Peme binare

//4. Ndertoni nje funksion qe printon te gjitha nyjet me vlere cift te nje peme binare.

//5. Ndertoni nje funksion qe gjen prindin e nje elementi te dhene X ne nje:
//a. Peme binare

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
