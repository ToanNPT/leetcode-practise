package com.learning.binaryTree;

import com.learning.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class LongestZigZagTree {

    public int longestZigZag(TreeNode root) {
        AtomicInteger max = new AtomicInteger(0);
        findZigZag(root, true, 0, max);
        findZigZag(root, false, 0, max);
        return max.get();
    }

    public void findZigZag(TreeNode node, boolean isLeft, int length, AtomicInteger max) {
        if (node == null) {
            return;
        }

        if (length >= max.get()) {
            max.set(length);
        }

        if(isLeft){
            findZigZag(node.left, true, 1, max);
            findZigZag(node.right, false, length + 1, max);
        }else{
            findZigZag(node.left, true, length + 1, max);
            findZigZag(node.right, false, 1, max);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.left.right = new TreeNode(1);
        root.right.left.right.left = new TreeNode(1);
        root.right.left.right.left.right = new TreeNode(1);
        System.out.println(new LongestZigZagTree().longestZigZag(root));
    }

}
