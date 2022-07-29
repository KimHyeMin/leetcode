package problem;

import java.util.ArrayDeque;
import java.util.Queue;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        Queue<TreeNodeWrapper> queue = new ArrayDeque<>();
        queue.add(new TreeNodeWrapper(root, root.val));

        while(!queue.isEmpty()) {
            TreeNodeWrapper head = queue.poll();

            if (head.treeNode.left == null && head.treeNode.right == null && head.sum == targetSum) {
                return true;
            }

            if (head.treeNode.left != null) {

                    queue.add(new TreeNodeWrapper(head.treeNode.left, head.sum + head.treeNode.left.val));
            }

            if (head.treeNode.right != null) {

                    queue.add(new TreeNodeWrapper(head.treeNode.right, head.sum + head.treeNode.right.val));

            }
        }

        return false;
    }

    public class TreeNodeWrapper {
        TreeNode treeNode;
        int sum;

        public TreeNodeWrapper(TreeNode root, int val) {
            this.treeNode = root;
            this.sum = val;
        }
    }
}
