package com.learning.binaryTree;

import com.learning.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class CountGoodNodesInBinaryTree {

    public int goodNodes(TreeNode root) {
        Integer max = Integer.MIN_VALUE;
        AtomicInteger total = new AtomicInteger(0);
        count(root, max, total);
        return total.get();
    }

    public void count(TreeNode curr, Integer max, AtomicInteger total) {
        if (curr == null) {
            return;
        }

        total.set(max <= curr.val ? total.get() + 1 : total.get());
        max = curr.val > max ? curr.val : max;

        count(curr.left, max, total);
        count(curr.right, max, total);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(3);
//        root.right = new TreeNode(20);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(2);
        CountGoodNodesInBinaryTree a = new CountGoodNodesInBinaryTree();
        System.out.println(a.goodNodes(root));
    }
}
