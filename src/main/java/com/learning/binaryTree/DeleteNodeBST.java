package com.learning.binaryTree;

import com.learning.TreeNode;

public class DeleteNodeBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        DeleteNodeBST deleteNodeBST = new DeleteNodeBST();
        TreeNode result = deleteNodeBST.deleteNode(root, 6);
        System.out.println(result);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            return deleteAndReplace(root, key);
        }

        TreeNode holder = root;
        while (root != null) {
            if (root.left != null && root.left.val == key) {
                root.left = deleteAndReplace(root.left, key);
                break;
            } else {

                if (root.right != null && root.right.val == key) {

                    root.right = deleteAndReplace(root.right, key);
                    break;
                } else {
                    if (root.val > key) {
                        root = root.left;
                    } else {
                        root = root.right;
                    }
                }
            }
        }

        return holder;
    }

    public TreeNode deleteAndReplace(TreeNode node, int key) {
        if (node.left == null) {
            return node.right;
        }
        if (node.right == null) {
            return node.left;
        }

        TreeNode theLastRight = findTheLastRight(node.left);
        theLastRight.right = node.right;
        return node.left;
    }

    public TreeNode findTheLastRight(TreeNode node) {
        if (node.right == null) {
            return node;
        }
        return findTheLastRight(node.right);
    }


}
