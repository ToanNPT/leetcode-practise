package com.leetcode.binaryTree;

import com.models.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class PathSumTree {
    public int pathSum(TreeNode root, int targetSum) {
        AtomicInteger count = new AtomicInteger(0);
        Long currPrefix = 0L;
        Map<Long, Integer> prefixMaps = new HashMap<>();
        countPaths(root, currPrefix, targetSum, prefixMaps, count);

        return count.get();
    }

    public static void countPaths(TreeNode node, Long currPrefix, int target, Map<Long, Integer> prefixMap,
                                  AtomicInteger count) {
        if (node == null) {
            return;
        }
        currPrefix = currPrefix + node.val;

        if (currPrefix == target) {
            count.getAndIncrement();
        }

        count.set(count.get() + prefixMap.getOrDefault(currPrefix - target, 0));

        prefixMap.put(currPrefix, prefixMap.getOrDefault(currPrefix, 0) + 1);

        countPaths(node.left, currPrefix, target, prefixMap, count);
        countPaths(node.right, currPrefix, target, prefixMap, count);

        prefixMap.put(currPrefix, prefixMap.get(currPrefix) - 1);
    }

}
