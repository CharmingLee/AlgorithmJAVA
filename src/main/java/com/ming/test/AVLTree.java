package com.ming.test;

/**
 * Created by charminglee on 17-7-28.
 *
 */
public class AVLTree {

    public static class AVLNode{

        public AVLNode(Integer data){
            this.data = data;
        }

        public Integer data;
        public AVLNode leftNode;
        public AVLNode rightNode;
        public int height;
    }

    private int height(AVLNode t){
        return t == null ? -1 : t.height;
    }

    public AVLNode insert(int x, AVLNode t){
        if (t == null)
            return new AVLNode(x);
        if (t.data < x)
            t.rightNode = insert(x, t.rightNode);
        else if(t.data > x)
            t.leftNode = insert(x, t.leftNode);

        return balance(t);
    }

    public void printTree(AVLNode node){
        System.out.println(node.data);
        if (node.leftNode != null)
            printTree(node.leftNode);
        if (node.rightNode != null)
            printTree(node.rightNode);
    }

    private static final int ALLOWED_IMBALANCE = 1;

    private AVLNode balance(AVLNode t){
        if (t == null)
            return t;
        if (height(t.leftNode) - height(t.rightNode) > ALLOWED_IMBALANCE)
            if (height(t.leftNode.leftNode) >= height(t.leftNode.rightNode))
                t = rotateWithLeftChild(t);
            else
                t = doubleWithLeftChild(t);
        else if (height(t.rightNode) - height(t.leftNode) > ALLOWED_IMBALANCE)
                if (height(t.rightNode.rightNode) >= height(t.rightNode.leftNode))
                t = rotateWithRightChild(t);
                else
                t = doubleWithRightChild(t);

        t.height = Math.max(height(t.leftNode), height(t.rightNode)) + 1;

        return t;
    }

    private AVLNode rotateWithLeftChild(AVLNode k2){
        AVLNode k1 = k2.leftNode;
        k2.leftNode = k1.rightNode;
        k1.rightNode = k2;
        k2.height = Math.max(height(k2.leftNode), height(k2.rightNode)) + 1;
        k1.height = Math.max(height(k1.leftNode), k2.height) + 1;

        return k1;
    }

    private  AVLNode rotateWithRightChild(AVLNode k1 )
    {
        AVLNode k2 = k1.rightNode;
        k1.rightNode = k2.leftNode;
        k2.leftNode = k1;
        k1.height = Math.max( height( k1.leftNode ), height( k1.rightNode ) ) + 1;
        k2.height = Math.max( height( k2.rightNode ), k1.height ) + 1;
        return k2;
    }

    private AVLNode doubleWithRightChild(AVLNode k3){
        k3.leftNode = rotateWithLeftChild(k3.leftNode);
        return rotateWithLeftChild(k3);
    }

    private AVLNode doubleWithLeftChild( AVLNode k3 )
    {
        k3.leftNode = rotateWithRightChild( k3.leftNode );
        return rotateWithLeftChild( k3 );
    }

}
