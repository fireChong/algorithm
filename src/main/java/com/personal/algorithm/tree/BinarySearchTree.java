package com.personal.algorithm.tree;

/**
 * 二叉查找树
 */
public class BinarySearchTree<T extends Comparable> {
    private BinaryNode<T> root;

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T element) {
        return contains(root, element);
    }

    private boolean contains(BinaryNode<T> node, T element) {
        if (node == null)
            return false;
        int compareResult = element.compareTo(node.element);
        if (compareResult > 0) {
            return contains(node.right, element);
        } else if (compareResult < 0) {
            return contains(node.left, element);
        } else {
            return true;
        }
    }

    public void insert(T element) {
        root = insert(root, element);
    }


    public BinaryNode<T> insert(BinaryNode<T> node, T element) {
        if (node == null) {
            node = new BinaryNode<>(element, null, null);
            return node;
        }

        int compareResult = element.compareTo(node.element);
        if (compareResult > 0) {
            node.right = insert(node.right, element);
        } else if (compareResult < 0) {
            node.left = insert(node.left, element);
        } else {
            // do nothing
        }

        return node;
    }

    public void remove(T element) {
        root = remove(root, element);
    }

    private BinaryNode<T> remove(BinaryNode<T> node, T element) {
        if (node == null)
            return null;
        int compareResult = element.compareTo(node.element);
        if (compareResult < 0) {
            node.left = remove(node.left, element);
        } else if (compareResult > 0) {
            node.right = remove(node.right, element);
        } else if (node.left != null && node.right != null) {
            // 删除有左右孩子的节点
            node.element = findMin(node.right);
            node.right = remove(node.right, node.element);
        } else {
            node = node.left == null ? node.right : node.left;
        }

        return node;
    }

    public T findMax() {
        return findMax(root);
    }

    public T findMin() {
        return findMin(root);
    }

    private T findMax(BinaryNode<T> node) {
        if (node == null) {
            return null;
        }

        if (node.right == null) {
            return node.element;
        } else {
            return findMax(node.right);
        }
    }

    public T findMin(BinaryNode<T> node) {
        if (node == null) {
            return null;
        }

        if (node.left == null) {
            return node.element;
        } else {
            return findMin(node);
        }
    }

    public void printTree() {
        if (isEmpty()) {
            System.out.println("Empty tree");
        }else {
            printTree(root);
        }
    }

    private void printTree(BinaryNode<T> node) {
        if (node != null) {
            printTree(node.left);
            System.out.println(node.element);
            printTree(node.right);
        }
    }


    private class BinaryNode<T extends Comparable> {
        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;

        public BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(5);
        tree.insert(8);

        tree.printTree();
        System.out.println(tree.findMax());
    }
}
