package tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E extends Comparable<E>> implements Tree<E> {

    private TreeNode<E> root;
    private int size = 0;

    BinarySearchTree() {
    }

    BinarySearchTree(E[] objects) {
        for (E object : objects) {
            insert(object);
        }
    }


    /* Interface Methods */
    @Override
    public boolean search(E element) {
        TreeNode<E> current = root;

        while (current != null) {
            if (element.equals(current.element)) {
                return true;
            } else if (element.compareTo(current.element) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }


    @Override
    public boolean insert(E element) {
        if (root == null) {
            root = createNewNode(element, null);
        } else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;

            while (current != null) {
                if (element.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (element.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    return false;
                }
            }

            if (element.compareTo(parent.element) < 0) {
                parent.left = createNewNode(element, parent);
            } else {
                parent.right = createNewNode(element, parent);
            }
        }
        size++;
        return true;
    }

    @Override
    public boolean delete(E element) {
      TreeNode<E> parent = null;
      TreeNode<E> current = root;

      /* Locate the node to be deleted and also locate its parent node */
        while(current != null) {
            if (element.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (element.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else {
                break;
            }
        }

        if (current == null) {
            return false; // element is not in the tree
        }

        // Case 1: current has no left child
        if (current.left == null) {
            // Connect the parent with the right child of the current node
            if (parent == null) { // We delete root, simply replace root with right child
                root = current.right;
                root.parent = null;
            } else { // Connect the parent with the right child
                if (element.compareTo(parent.element) < 0) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            }
        } else {
            // Case 2: The current node has a left child
            // Locate the rightmost node in the left subtree of the current node
            // and also its parent
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }

            // Replace the element in current by the element in rightmost
            current.element = rightMost.element;

            // Eliminate rightmost node
            if (parentOfRightMost.right == rightMost) {
                parentOfRightMost.right = rightMost.left;
            } else { // Special case: parentOfRightMost == current
                parentOfRightMost.left = rightMost.left;
            }
        }
        size--;
        return true;
    }

    @Override
    public void inOrder() {
        traverse(root, Traversal.IN_ORDER);
    }

    @Override
    public void postOrder() {
        traverse(root, Traversal.POST_ORDER);
    }

    @Override
    public void preOrder() {
        traverse(root, Traversal.PRE_ORDER);
    }

    private TreeNode<E> getNode(E element) {
        TreeNode<E> current = root;

        while (current != null) {
            if (element.compareTo(current.element) < 0) {
                current = current.left;
            } else if (element.compareTo(current.element) > 0) {
                current = current.right;
            } else {
                break;
            }
        }
        return current;
    }


    /* Returns a path from the specified element leading to the root */
    ArrayList<E> getPathToRoot(E e) {
        ArrayList<E> list = new ArrayList<>();
        TreeNode<E> node = getNode(e);
        while (node != null) {
            list.add(node.element);
            node = node.parent;
        }
        return list;
    }

    /* Returns a path from the root leading to the specified element */
    ArrayList<E> getPathFromRoot(E e) {
        ArrayList<E> list = new ArrayList<>();
        TreeNode<E> current = root;

        while (current != null) {
            list.add(current.element);
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else
                break;
        }
        return list;
    }

    int getNumberOfLeaves() {
        return getNumberOfLeaves(root);
    }

    private int getNumberOfLeaves(TreeNode<E> node) {
        if (node == null) { return 0; }
        if (isLeaf(node)) { return 1; }
        return getNumberOfLeaves(node.left) + getNumberOfLeaves(node.right);
    }

    int getNumberOfNonLeaves() {
        return size - getNumberOfLeaves();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new InOrderIterator();
    }

    /* Additional Methods */

    void clear() {
        root = null;
        size = 0;
    }

    private TreeNode<E> getRoot() {
        return root;
    }

    int height() {
        if (size == 1) { return 0; }
        return height(root);
    }

    private int height(TreeNode<E> node) {
        if (node == null) { return -1; }
        return (1 + Math.max(height(node.left), height(node.right)));
    }

    void depthFirstTraversal() {
        traverse(root, Traversal.IN_ORDER);
    }

    void breadthFirstTraversal() {
        if (root == null) { return; }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.element + " ");
            if (node.left != null) { queue.offer(node.left);}
            if (node.right != null) { queue.offer(node.right); }
        }
        System.out.println();
    }

    /* Helper Methods */

    private TreeNode<E> createNewNode(E element, TreeNode<E> parent) {
        TreeNode<E> node = new TreeNode<>(element);
        node.parent = parent;
        return node;
    }

    private void traverse(TreeNode<E> node, Traversal mode) {
        if (node == null) {
            return;
        }

        if (mode == Traversal.PRE_ORDER) {
            System.out.print(node.element + " ");
        }
        traverse(node.left, mode);
        if (mode == Traversal.IN_ORDER) {
            System.out.print(node.element + " ");
        }
        traverse(node.right, mode);
        if (mode == Traversal.POST_ORDER) {
            System.out.print(node.element + " ");
        }
    }

    private boolean isLeaf(TreeNode<E> node) {
        if (node == null) { return false; }
        return node.left == null && node.right == null;
    }


    static class TreeNode<T extends Comparable<T>> {
        T element;
        TreeNode<T> left;
        TreeNode<T> right;
        TreeNode<T> parent;

        TreeNode(T element) {
            this.element = element;
        }
    }

    private class InOrderIterator implements java.util.Iterator<E> {
        /* Store the elements in a list */
        private ArrayList<E> list = new ArrayList<>();
        private int current = 0; // Point to the current element in the list.

        InOrderIterator() {
            inOrder(); // Traverse binary tree and store elements in the list
        }

        /* In order traversal from the root */
        private void inOrder() {
            inOrder(getRoot());
        }

        /* In order traversal from a subtree */
        private void inOrder(TreeNode<E> root) {
            if (root == null) return;
            inOrder(root.left);
            list.add(root.element);
            inOrder(root.right);
        }

        /* Next element for traversing? */
        @Override
        public boolean hasNext() {
            return current < list.size();
        }

        /* Get the current element and move cursor to the next */
        public E next() {
            return list.get(current++);
        }

        /* Remove the current element and refresh the list */
        public void remove() {
            delete(list.get(current)); // Delete the current element
            list.clear(); // Clear the list
            inOrder(); // Rebuild the list
        }
    }

    protected enum Traversal {
        IN_ORDER, POST_ORDER, PRE_ORDER
    }

}
