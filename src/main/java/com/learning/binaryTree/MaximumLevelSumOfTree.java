package com.learning.binaryTree;

import com.learning.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumLevelSumOfTree {

    public int maxLevelSum(TreeNode root) {
        Map<Integer, Long> sumByDepthMap = new HashMap<>();
        lookup(root, 0, sumByDepthMap);
        long max = sumByDepthMap.values().stream().mapToLong(Long::longValue).max().orElse(0);
        for (Map.Entry<Integer, Long> entry : sumByDepthMap.entrySet()) {
            if (entry.getValue().equals(max)) {
                return entry.getKey() + 1;
            }
        }
        return 0;
    }

    public void lookup(TreeNode node, int depth, Map<Integer, Long> sumByDepthMap ) {
        if (node == null) {
            return;
        }

        Long currSumByLevel = sumByDepthMap.getOrDefault(depth, 0L);
        sumByDepthMap.put(depth, currSumByLevel + node.val);

        lookup(node.left, depth + 1, sumByDepthMap);
        lookup(node.right, depth + 1, sumByDepthMap);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);
        System.out.println(new MaximumLevelSumOfTree().maxLevelSum(root));
    }


}
