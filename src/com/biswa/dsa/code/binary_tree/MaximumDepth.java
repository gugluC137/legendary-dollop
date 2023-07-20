package com.biswa.dsa.code.binary_tree;

import com.biswa.dsa.util.model.obj.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class MaximumDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return 1 + Math.max(l, r);
    }

    //using level order traversal
    public int maxDepthIterative(TreeNode root) {
        List<List<Integer>> finalList = new ArrayList<>();
        new TreeTraversals().levelOrder(root, finalList);
        return finalList.size();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
          3,
          new TreeNode(9),
          new TreeNode(
            20,
            new TreeNode(15),
            new TreeNode(7))
        );

        System.out.println(new MaximumDepth().maxDepthIterative(root));
    }
}
