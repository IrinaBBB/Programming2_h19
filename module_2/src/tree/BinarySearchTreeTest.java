package tree;

import java.util.ArrayList;
import java.util.Iterator;

public class BinarySearchTreeTest {

    public static void main(String[] args) {
        // Create a BST
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");


        // Simple tree traversal
        System.out.println("In-order (sorted): ");
        tree.inOrder();
        System.out.println("\nPost-order: ");
        tree.postOrder();
        System.out.println("\nPre-order: ");
        tree.preOrder();
        System.out.println("\n");

        // Advanced tree traversal
        System.out.print("Depth first traversal: ");
        tree.depthFirstTraversal();
        System.out.print("\nBreadth first traversal: ");
        tree.breadthFirstTraversal();
        System.out.println("\n");

        // Basic operations
        System.out.printf("The height of tree is: %2d%n", tree.height());
        System.out.printf("The number of nodes is: %2d%n", tree.getSize());
        System.out.printf("Is the tree empty? %s%n", tree.isEmpty() ? "Yes!" : "No!");
        System.out.printf("Is Clarice in the tree? %s%n", tree.search("Clarice") ? "Yes!" : "No!");
        System.out.println("How many leaf nodes are there in the tree? " + tree.getNumberOfLeaves());
        System.out.println("How many non-leaf nodes are there in the tree? " + tree.getNumberOfNonLeaves());
        System.out.println();
        System.out.println();

        // Paths
        ArrayList<String> toPeter = tree.getPathFromRoot("Peter");

        System.out.println("A path from the root to the node \"Peter\"");
        for (String node : toPeter) {
            System.out.print(node + " ");
        }

        System.out.println();
        System.out.println();

        ArrayList<String> toTom = tree.getPathFromRoot("Tom");


        System.out.println("A path from the root to the node \"Tom\"");
        for (String node : toTom) {
            System.out.print(node + " ");
        }

        System.out.println();
        System.out.println();

        System.out.println("A path from the node \"Peter\" to the root");
        ArrayList<String> fromPeter = tree.getPathToRoot("Peter");

        for (String node : fromPeter) {
            System.out.print(node + " ");
        }

        System.out.println();
        System.out.println();

        System.out.println("A path from the node \"Tom\" to the root");
        ArrayList<String> fromTom = tree.getPathToRoot("Tom");

        for (String node : fromTom) {
            System.out.print(node + " ");
        }

        System.out.println();
        System.out.println();


        // Iterating through the tree
        System.out.print("\nIterator test: ");
        Iterator iter = tree.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.print("\nEnhanced for loop: ");
        for (Object element : tree) {
            System.out.print(element + " ");
        }

        System.out.print("\nforEach / Lambda: ");
        tree.forEach((e) -> System.out.print(e + " "));
        System.out.println("\n");

        // Tree manipulation
        Integer[] numbers = {2, 4, 3, 1, 8, 5, 6, 7};
        BinarySearchTree<Integer> intTree = new BinarySearchTree<>(numbers);
        System.out.print("Tree of numbers: ");
        intTree.inOrder();
        System.out.printf("%nCan insert 1? %s%n", intTree.insert(1) ? "Yes!" : "No!");
        System.out.printf("Can insert 9? %s%n", intTree.insert(9) ? "Yes!" : "No!");
        System.out.printf("Can delete 1? %s%n", intTree.delete(1) ? "Yes!" : "No!");
        System.out.printf("Can delete 10? %s%n", intTree.delete(10) ? "Yes!" : "No!");
        System.out.print("Tree before clearing: ");
        intTree.inOrder();
        System.out.print("\nTree after clearing: ");
        intTree.clear();
        intTree.inOrder();
        System.out.printf("%nIs the tree empty now? %s%n", intTree.isEmpty() ? "Yes!" :"No!");



    }
}
