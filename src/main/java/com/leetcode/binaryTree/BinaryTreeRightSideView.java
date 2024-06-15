package com.leetcode.binaryTree;

import com.models.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        lookUp(root, 0, values);
        return values;
    }

    public void lookUp(TreeNode node, int level, List<Integer> values) {
        if (node == null) {
            return;
        }

        if (level == values.size()) {
            values.add(node.val);
        }

        lookUp(node.right, level + 1, values);
        lookUp(node.left, level + 1, values);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(new BinaryTreeRightSideView().rightSideView(root));
    }
}
