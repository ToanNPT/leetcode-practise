package com.learning.binaryTree;

import com.learning.TreeNode;

public class MaximumDepthBinaryTree {


    public static int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        var left = maxDepth(node.left);
        var right = maxDepth(node.right);
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        System.out.println(maxDepth(root));
    }
}
