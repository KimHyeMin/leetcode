package problem;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
public class BinarySearchTree {

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;

        for (int i = 0 ; i< preorder.length ; i++) {
            int val = preorder[i];
            if (root == null) {
                root = new TreeNode(val);
                continue;
            }
            travelNode(root, root.val > val ? root.left : root.right, val, root.val > val ? -1 : 1);
        }
        return root;
    }

    //value가 들어갈 노드를 찾자
    private void travelNode(TreeNode parentNode, TreeNode node, int value, int type) {

        if (node == null) {
            if (type == -1) {
                parentNode.left = new TreeNode(value);
            } else {
                parentNode.right = new TreeNode(value);
            }
            return;
        }

        if (node.val > value) {
            travelNode(node, node.left, value, -1);

        } else {
            travelNode(node, node.right, value, 1);
        }
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
}
