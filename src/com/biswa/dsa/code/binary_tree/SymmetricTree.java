package com.biswa.dsa.code.binary_tree;

import com.biswa.dsa.util.model.obj.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }

        if (leftNode == null || rightNode == null) {
            return false;
        }

        if (leftNode.val != rightNode.val) {
            return false;
        }

        return isSymmetric(leftNode.left, rightNode.right) && isSymmetric(leftNode.right, rightNode.left);
    }
}
