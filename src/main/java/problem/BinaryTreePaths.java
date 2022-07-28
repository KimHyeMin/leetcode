package problem;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    private List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        getDeepPath(root, sb);
        return res;
    }

    private void getDeepPath(TreeNode node, StringBuilder sb) {
        int len = sb.length();
        sb.append(node.val);
        if (node.left == null && node.right == null) {
            res.add(sb.toString());
            sb.setLength(len);
            return;
        }

        sb.append("->");

        if (node.left != null) {
            getDeepPath(node.left, sb);
        }
        if (node.right != null) {
            getDeepPath(node.right, sb);
        }
        sb.setLength(len);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
