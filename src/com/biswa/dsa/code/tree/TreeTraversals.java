package com.biswa.dsa.code.tree;

import com.biswa.dsa.util.model.obj.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TreeTraversals {

    public void preorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }
    public void preorderIterative(TreeNode root, List<Integer> list) {
        if (root == null) return;
        Deque<TreeNode> st = new ArrayDeque<>();
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode cur = st.pop();
            list.add(cur.val);
            if (cur.right != null) st.push(cur.right);
            if (cur.left != null) st.push(cur.left);
        }
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    public void inorderIterative(TreeNode root, List<Integer> list) {
        if (root == null) return;
        Deque<TreeNode> st = new ArrayDeque<>();

        TreeNode node = root;
        while (true) {
            if (node != null) {
                st.push(node);
                node = node.left;
            } else {
                if (st.isEmpty()) break;
                node = st.pop();
                list.add(node.val);
                node = node.right;
            }
        }
    }

    public void postorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }
    public void postorderIterativeII(TreeNode root, List<Integer> list) {
        if (root == null) return;
        Deque<TreeNode> st1 = new ArrayDeque<>();
        Deque<TreeNode> st2 = new ArrayDeque<>();

        st1.push(root);
        while (!st1.isEmpty()) {
            TreeNode cur = st1.pop();
            st2.push(cur);
            if (cur.left != null) st1.push(cur.left);
            if (cur.right != null) st1.push(cur.right);
        }

        while (!st2.isEmpty()) {
            list.add(st2.pop().val);
        }
    }

    public void levelOrder(TreeNode root, List<List<Integer>> list) {
        if (root == null) return;
        Deque<TreeNode> q = new ArrayDeque<>();
        List<Integer> levelList = new ArrayList<>();
        TreeNode cur;
        q.offer(root);

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                cur = q.poll();
                if (cur != null) {
                    levelList.add(cur.val);
                    if (cur.left != null) q.offer(cur.left);
                    if (cur.right != null) q.offer(cur.right);
                }
            }
            list.add(levelList);
            levelList = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        //test for level order
        TreeNode root = new TreeNode(
          3,
          new TreeNode(9),
          new TreeNode(
            20,
            new TreeNode(15),
            new TreeNode(7))
        );

        List<List<Integer>> ans = new ArrayList<>();
        new TreeTraversals().levelOrder(root, ans);
        System.out.println(ans);
    }

}
