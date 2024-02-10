package com.biswa.dsa.code.binary_tree.part2;

import com.biswa.dsa.util.model.obj.TreeNode;

//Conditions:
// - all TreeNode.val are unique
// - both p and q exist in the tree
public class LCABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }

        //process
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);

        if (left != null && right != null) {
            return root;
        }

        if (left == null) {
            return right;
        }

        return left;
    }
}
