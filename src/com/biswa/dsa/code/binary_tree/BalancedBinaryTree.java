package com.biswa.dsa.code.binary_tree;

import com.biswa.dsa.util.model.obj.TreeNode;

public class BalancedBinaryTree {

  //balanced BT: | if height(left) - height(right) | <= 1
  public boolean isBalanced(TreeNode root) {
    return helper(root) != -1;
  }

  private int helper(TreeNode node) {
    if (null == node) return 0;

    int hl = helper(node.left);
    if (hl == -1) return -1;

    int hr = helper(node.right);
    if (hr == -1) return -1;

    if (Math.abs(hl-hr) > 1) return -1;
    else return 1 + Math.max(hl, hr);
  }

}
