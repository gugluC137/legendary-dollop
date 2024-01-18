package com.biswa.dsa.code.binary_tree.part1;

import com.biswa.dsa.util.model.obj.TreeNode;

public class DiameterOfTree {
    int diameter;

    //TC: O(n)
    //SC: O(n)
    public int solWithRecursion(TreeNode node) {
        if (node == null) return 0;

        int left = solWithRecursion(node.left);
        int right = solWithRecursion(node.right);

        diameter = Math.max(diameter, left+right);
        return 1 + Math.max(left, right);
    }
}
