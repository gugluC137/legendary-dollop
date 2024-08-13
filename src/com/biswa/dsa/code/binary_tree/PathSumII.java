package com.biswa.dsa.code.binary_tree;

import com.biswa.dsa.util.model.obj.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        LinkedList<Integer> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        helper(root, targetSum, q, result);

        return result;
    }

    public void helper(TreeNode node, int targetSum, LinkedList<Integer> curPath, List<List<Integer>> result) {
        //base case
        if (node.left == null && node.right == null) {
            if (targetSum-node.val == 0) {
                curPath.addLast(node.val);
                result.add(new ArrayList<>(curPath));
                curPath.removeLast();
            }
            return;
        }

        //process
        curPath.addLast(node.val);
        if (node.left != null) {
            helper(node.left, targetSum-node.val, curPath, result);
        }
        if (node.right != null) {
            helper(node.right, targetSum-node.val, curPath, result);
        }
        curPath.removeLast();
    }
}
