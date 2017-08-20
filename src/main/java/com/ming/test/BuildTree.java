package com.ming.test;

/**
 * Created by charminglee on 17-7-24.
 *
 */
public class BuildTree {

    public static class TreeNode {
        public TreeNode(Integer data){
            this.data = data;
        }
        public Integer data;
        public TreeNode leftNode;
        public TreeNode rightNode;
    }


    public void printTree(TreeNode node){
        System.out.println(node.data);
        if (node.leftNode != null)
            printTree(node.leftNode);
        if (node.rightNode != null)
            printTree(node.rightNode);
    }

    public boolean contains(Integer x, TreeNode node){
        if (node == null)
            return false;

        if (node.data < x){
            return contains(x, node.rightNode);
        } else if (node.data > x){
            return contains(x, node.leftNode);
        }

        return true;
    }

    public TreeNode findMin(TreeNode node){
        if (node == null)
            return null;
        if (node.leftNode != null)
            return findMin(node.leftNode);

        return node;
    }

    public TreeNode findMax(TreeNode node){
        if (node == null)
            return null;

        while (node.rightNode != null)
            node = node.rightNode;

        return node;
    }

    public TreeNode insert(Integer x, TreeNode node){
        if (node == null){
            return new TreeNode(x);
        }

        if (node.data > x){
            node.leftNode = insert(x, node.leftNode);
        } else if(node.data < x) {
            node.rightNode = insert(x, node.rightNode);
        }

        return node;
    }

    public TreeNode remove(Integer x, TreeNode node){
        if (node == null)
            return null;

        if (node.data > x){
            node.leftNode = remove(x, node.leftNode);
        } else if (node.data < x){
            node.rightNode = remove(x, node.rightNode);
        } else if(node.leftNode != null && node.rightNode != null) {
            node.data = findMin(node.rightNode).data;
            node.rightNode = remove(node.data, node.rightNode);
        } else {
            node = node.leftNode != null ? node.leftNode : node.rightNode;
        }

        return node;
    }

    public static void main(String[] arg){
        TreeNode tree = createTree();

        BuildTree bt = new BuildTree();

        bt.remove(4, tree);

        bt.printTree(tree);

    }

    public static TreeNode createTree(){
        TreeNode root = new TreeNode(6);
        root.leftNode = new TreeNode(2);
        root.leftNode.leftNode = new TreeNode(1);
        root.leftNode.rightNode = new TreeNode(4);
        root.leftNode.rightNode.leftNode = new TreeNode(3);

        root.rightNode = new TreeNode(8);

        return root;
    }

}
