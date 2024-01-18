package com.biswa.dsa.code.binary_tree.part1;

import com.biswa.dsa.util.model.obj.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class TreeViews {
    public static ArrayList<Integer> getLeftView(TreeNode root)
    {
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) return ans;

        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int l = q.size();
            TreeNode leftMost = null;
            for (int i = 0; i < l; i++) {
                TreeNode cur = q.poll();
                if (cur != null) {
                    if (i == 0) leftMost = cur;
                    if (cur.left != null) q.offer(cur.left);
                    if (cur.right != null) q.offer(cur.right);
                }
            }
            if (leftMost != null) {
                ans.add(leftMost.val);
            }
        }

        return ans;
    }
}
