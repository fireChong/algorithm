package com.personal.algorithm.tree;

/**
 * AVL 树
 * <p>
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
 * @param <T>
 */
public class AVLTree<T> {
    private int height(AVLNode<T> node) {
        return node == null ? 0 : node.height;
    }


    private AVLNode<T> leftRoate(AVLNode<T> node)
    {
        if (node == null) return null;
        AVLNode<T> right = node.right;
        node.right = right.left;
        right.left = node;

        // TODO 更新height
        return right;

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
            this.height = 1;
        }
    }
}
