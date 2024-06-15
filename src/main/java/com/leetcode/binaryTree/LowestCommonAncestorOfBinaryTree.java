package com.leetcode.binaryTree;

import com.models.TreeNode;

public class LowestCommonAncestorOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findLCA(root, p, q);

    }

    public TreeNode findLCA(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return null;
        }
        if (node == p || node == q) {
            return node;
        }
        var left = findLCA(node.left, p, q);
        var right = findLCA(node.right, p, q);
        if (left != null && right != null) {
            return node;
        }
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        System.out.println(new LowestCommonAncestorOfBinaryTree().lowestCommonAncestor(root, root.left, root.right).val);
    }
}
