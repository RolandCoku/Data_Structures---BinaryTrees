public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(8);
        tree.insert(3);
        tree.insert(6);
        tree.insert(10);
        tree.insert(4);
        tree.insert(7);
        tree.insert(1);
        System.out.println(tree.root.getElement());
        tree.printPreOrder();
        System.out.println("Size: " + tree.size());
        System.out.println("Height: " + tree.height());
        System.out.println("Min: " + tree.findMin());
        System.out.println("Max: " + tree.findMax());
        System.out.println("Find 4: " + tree.find(4));
        System.out.println("Find 10: "+ tree.find(10));

        tree.removeMin();
        tree.printPreOrder();
        tree.removeMin();
        tree.printPreOrder();
        tree.removeMin();
        tree.printPreOrder();
        tree.removeMin();
        tree.printPreOrder();
        tree.remove(7);
        tree.printPreOrder();
        tree.remove(10);
        tree.printPreOrder();

        BinaryTree<Integer> tree2 = new BinaryTree<>();
        tree2.insert(8);
        tree2.insert(3);
        tree2.insert(6);
        tree2.insert(10);
        tree2.insert(4);
        tree2.printPreOrder();
        tree2.printEven();
        System.out.println("Max: " + tree2.findMax());
        System.out.println("Parent of 4: " + tree2.findParent(4).getElement());

    }
}