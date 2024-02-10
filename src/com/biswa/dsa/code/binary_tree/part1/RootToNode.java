package com.biswa.dsa.code.binary_tree.part1;

import com.biswa.dsa.util.model.obj.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RootToNode {
    public List<Integer> getRootToNodePath(TreeNode root, TreeNode endNode) {
        List<Integer> path = new ArrayList<>();

        getRootToNodePath(root, endNode, path);

        return path;
    }

    public boolean getRootToNodePath(TreeNode node, TreeNode endNode, List<Integer> path) {

        //base condition
        if (node == null) {
            return false;
        }

        //process
        path.add(node.val);

        if (node.val == endNode.val ||
            getRootToNodePath(node.left, endNode, path) ||
            getRootToNodePath(node.right, endNode, path)) {
            return true;
        }

        int lastIndex = path.size() - 1;
        path.remove(lastIndex);

        return false;
    }
}
