package com.personal.algorithm.tree;

/**
 * AVL 树
 *
 *  1. 左子树(B)的左儿子(D)添加节点F,进行右旋.旋转点左子树
 *       A                      B
 *      / \                    / \
 *     B   C  ------>         D   A
 *    / \                    /   / \
 *   D  E                   F   E  C
 *  /
 * F
 *
 * 2. 左子树(B)的右儿子(E)添加节点F,先进行左旋,再进行右旋.左旋旋转点右儿子,右旋旋转点左子树
 *       A                      A                      E
 *      / \                    / \                    / \
 *     B   C  ------>         E   C   ------>        B   A
 *    / \                    / \                    /   / \
 *   D  E                   B   F                  D   F   C
 *       \                 /
 *        F               D
 *
 * 3. 右子树(C)的左儿子(D)添加节点F,先进行右旋,再进行左旋.右旋旋转点左儿子, 左旋旋转点右子树
 *       A                      A                      D
 *      / \                    / \                    / \
 *     B   C  ------>         B   D   ------>        A   C
 *        / \                    / \                / \   \
 *       D   E                  F  C               B  F    E
 *      /                           \
 *     F                            E
 *
 * 4. 右子树(C)右儿子(E)添加节点F,进行左旋.旋转点右子树
 *     A                                  C
 *    / \                                / \
 *   B   C           ------>            A   E
 *      / \                            / \   \
 *     D   E                          B   D   F
 *         \
 *          F
 *
 */
public class AVLTree<T extends Comparable<T>> {
    private AVLNode<T> root;

    private int height(AVLNode<T> node) {
        return node == null ? -1 : node.height;
    }


    /**
     * 左旋
     *
     * @param node
     * @return
     */
    private AVLNode<T> leftRotate(AVLNode<T> node) {
        if (node == null) return null;
        AVLNode<T> right = node.right;
        node.right = right.left;
        right.left = node;

        // 更新height
        node.height = 1 + Math.max(height(node.left), height(node.right));
        right.height = 1 + Math.max(height(right.left), height(right.right));
        return right;
    }

    /**
     * 右旋
     *
     * @param node
     * @return
     */
    private AVLNode<T> rightRotate(AVLNode<T> node) {
        if (node == null) return null;
        AVLNode<T> left = node.left;
        node.left = left.right;
        left.right = node;

        // 更新height
        node.height = 1 + Math.max(height(node.left), height(node.right));
        left.height = 1 + Math.max(height(left.left), height(left.right));
        return left;
    }

    /**
     * 节点的平衡因子
     *
     * @param node
     * @return
     */
    private int getBalance(AVLNode<T> node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }


    public void insert(T element) {
        if (element == null)
            return;
        insert(root, element);
    }

    private AVLNode<T> insert(AVLNode<T> node, T element) {
        if (node == null) {
            return new AVLNode<>(element, null, null);
        }

        int cmp = element.compareTo(node.element);
        if (cmp < 0) {
            node.left = insert(node.left, element);
        } else if (cmp > 0) {
            node.right = insert(node.right, element);
        } else {
            // do nothing
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);
        if (balance > 1) {
            int result = element.compareTo(node.left.element);
            if (result < 1) {
                // 左左, 右旋
                return rightRotate(node);
            } else {
                // 左右, 先左旋后右旋
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        } else if (balance < 1) {
            int result = element.compareTo(node.right.element);
            if (result < 1) {
                // 右左
                node.right = rightRotate(node.right);
                return leftRotate(node);
            } else {
                // 右右
                return leftRotate(node);
            }
        }
        return node;

    }

    private class AVLNode<T> {
        private T element;
        private AVLNode<T> left;
        private AVLNode<T> right;
        private int height;

        public AVLNode(T element, AVLNode<T> left, AVLNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }
}
