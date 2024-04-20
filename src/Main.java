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
        tree.insert(5);
        System.out.println(tree.root.getElement());
        tree.printPreOrder();
        System.out.println("Size: " + tree.size());
        System.out.println("Height: " + tree.height());
        System.out.println("Min: " + tree.findMin());
        System.out.println("Max: " + tree.findMax());
        System.out.println("Find 4: " + tree.find(4));
        System.out.println("Find 10: "+ tree.find(11));
        System.out.println("Parent of 4: " + tree.findParent(4).getElement());
        System.out.println("Parent of 10: " + tree.findParent(10).getElement());
        System.out.println("Parent of 1: " + tree.findParent(1).getElement());
        System.out.println("Parent of 7: " + tree.findParent(7).getElement());

        BinaryTree<Integer> tree2 = new BinaryTree<>();
        tree2.insert(8);
        tree2.insert(3);
        tree2.insert(6);
        tree2.insert(10);
        tree2.insert(4);
        tree2.insert(7);
        tree2.insert(1);
        tree2.insert(5);
        tree2.printPreOrder();
        tree2.printEven();
        System.out.println("Max: " + tree2.findMax());
        System.out.println("Parent of 4: " + tree2.findParent(4).getElement());
        System.out.println("Parent of 10: " + tree2.findParent(10).getElement());
        System.out.println("Parent of 1: " + tree2.findParent(1).getElement());
        System.out.println("Parent of 7: " + tree2.findParent(7).getElement());

        System.out.println("Nodes on tree2: " + BinaryTree.countNodes(tree2.root));
        System.out.println("Leaves on tree2: " + BinaryTree.countLeaves(tree2.root));
        System.out.println("Full nodes on tree2: " + BinaryTree.countFullNodes(tree2.root));
        System.out.println("Tree after removing leaves: ");
//        BinaryTree.removeTreeLeaves(tree2.root);
        tree2.printPreOrder();
        System.out.println("tree2 depth: " + BinaryTree.treeDepth(tree2));
        System.out.println("Node 3 depth: "+ tree2.nodeDepth(3));
        System.out.println("Node 6 depth: "+ tree2.nodeDepth(6));
        System.out.println("Node 5 depth: "+ tree2.nodeDepth(5));
        System.out.println("Node 11 depth: "+ tree2.nodeDepth(11));
        System.out.println("tree2 depth: " + tree2.depth());
        System.out.println("Pairs with sum 9: " + tree2.pairsWithSum(9));
        System.out.println("Are equal: " + BinaryTree.areEqual(tree.root,tree2.root));
        System.out.println("Is BST: " + tree.isBST());
        tree2.root.setElement(11);
        System.out.println("Is BST: " + tree2.isBST());
        System.out.println("Is Balanced: " + tree2.isBalanced());

        BinaryTree<Integer> balancedTree = new BinaryTree<>();
        balancedTree.insert(8);
        balancedTree.insert(3);
        balancedTree.insert(9);
        balancedTree.insert(2);
        balancedTree.insert(4);
        balancedTree.insert(10);
        balancedTree.insert(11);
        System.out.println("Is Balanced: " + balancedTree.isBalanced());

        System.out.print("Elements at depth 2: " );
        tree.printAtDepth(2);

        tree.printPreOrder();
        System.out.print("Mirror tree: ");
        BinaryTree<Integer> mirrorTree = tree.mirror();
        mirrorTree.printPreOrder();

        System.out.println("Sum at depth 1: " + tree.sumAtDepth(1));
        System.out.println("Max at depth 2: " + tree.maxAtDepth(3));
        System.out.println("Full nodes at depth 2: " + tree.fullNodesAtDepth(2));
        tree.insert(9);
        tree.insert(12);
        System.out.println("Full nodes at depth 1: " + tree.fullNodesAtDepth(1));

        System.out.print("Elements greater than 5: ");
        tree.printElementsGreaterThan(5);
    }
}