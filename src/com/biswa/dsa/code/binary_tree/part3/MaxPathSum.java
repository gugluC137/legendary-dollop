package com.biswa.dsa.code.binary_tree.part3;

import com.biswa.dsa.util.model.obj.TreeNode;

public class MaxPathSum {

    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return ans;
    }

    public int maxPathSumHelper(TreeNode node) {
        //base condition
        if (node == null) {
            return 0;
        }

        //process
        int maxSumRight = Math.max(maxPathSumHelper(node.right), 0);
        int maxSumLeft = Math.max(maxPathSumHelper(node.left), 0);

        ans = Math.max(ans, node.val + maxSumLeft + maxSumRight);

        return Math.max(node.val, node.val + Math.max(maxSumLeft, maxSumRight));
    }
}
