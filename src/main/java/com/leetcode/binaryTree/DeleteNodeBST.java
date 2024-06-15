package com.leetcode.binaryTree;

import com.models.TreeNode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class DeleteNodeBST {
    public static void main(String[] args) {
        pass();
    }

    public static class Model {
        public Integer value;
    }

    public static void pass(){
        var  x = Arrays.asList(1,2,3);
        var b = x.stream().collect(Collectors.toList());
        x.add(4);
        x.forEach(i -> System.out.println(i));
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
