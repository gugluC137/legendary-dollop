package com.biswa.dsa.code.binary_tree;

import com.biswa.dsa.util.model.obj.Node;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
public class PopulateNextRightPointer {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur != null) {
                cur.next = q.peek();
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            } else {
                if (!q.isEmpty()) q.offer(null);
            }
        }

        return root;
    }

    public Node connectI(Node root) {
        Node levelStartNode = root;
        while (levelStartNode != null) {
            Node cur = levelStartNode;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }

                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }

                cur = cur.next;
            }

            levelStartNode = levelStartNode.left;
        }

        return root;
    }
}
