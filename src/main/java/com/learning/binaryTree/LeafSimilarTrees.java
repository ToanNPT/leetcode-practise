package com.learning.binaryTree;

import com.learning.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder sq1 = new StringBuilder();
        StringBuilder sq2 = new StringBuilder();

        leaf(root1, sq1);
        leaf(root2, sq2);

        return sq1.toString().equals(sq2.toString());
    }

    public void leaf(TreeNode root, StringBuilder sq) {
        if (root.left == null && root.right == null) {
            sq.append(root.val).append("@");
            return;
        }
        if (root.left != null) {
            leaf(root.left, sq);
        }

        if (root.right != null) {
            leaf(root.right, sq);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        LeafSimilarTrees a = new LeafSimilarTrees();
        a.leafSimilar(root, root);
    }
}
