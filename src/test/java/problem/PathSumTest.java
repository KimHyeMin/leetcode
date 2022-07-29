package problem;

import org.junit.Test;

import static org.junit.Assert.*;

public class PathSumTest {

    private static final PathSum dut = new PathSum();

    @Test
    public void test() {
        //root = [5,4,8,11,null,13,4,7,2,null,null,null,1],
        TreeNode left_3_1 = new TreeNode(7, null, null);
        TreeNode left_3_2 = new TreeNode(2, null,null);
        TreeNode left_2_1 = new TreeNode(11, left_3_1, left_3_2);
        TreeNode left_1 = new TreeNode(4, left_2_1, null);
        TreeNode root = new TreeNode(5, left_1, null);
        int targetSum = 22;

        assertTrue(dut.hasPathSum(root, targetSum));
    }

    @Test
    public void test2() {
        //root = [],
        TreeNode root = null;
        int targetSum = 0;

        assertFalse(dut.hasPathSum(root, targetSum));
    }


    @Test
    public void test3() {
        //root = [1,2,3], targetSum = 5
        TreeNode right_1 = new TreeNode(3, null, null);
        TreeNode left_1 = new TreeNode(2, null, null);
        TreeNode root = new TreeNode(1, left_1, right_1);
        int targetSum = 5;

        assertFalse(dut.hasPathSum(root, targetSum));
    }

    @Test
    public void test4() {
        //root = [1,2], targetSum = 1
        TreeNode left_1 = new TreeNode(2, null, null);
        TreeNode root = new TreeNode(1, left_1, null);
        int targetSum = 1;

        assertFalse(dut.hasPathSum(root, targetSum));
    }

    @Test
    public void test5() {
        //root = [1], targetSum = 1
        TreeNode root = new TreeNode(1, null, null);
        int targetSum = 1;

        assertTrue(dut.hasPathSum(root, targetSum));
    }

    @Test
    public void test6() {
        //root = [1,2,null,3,null,4,null,5]
        //6
        TreeNode left_4_1 = new TreeNode(5, null, null);
        TreeNode left_3_1 = new TreeNode(4, left_4_1,null);
        TreeNode left_2_1 = new TreeNode(3, left_3_1, null);
        TreeNode left_1 = new TreeNode(2, left_2_1, null);
        TreeNode root = new TreeNode(1, left_1, null);
        int targetSum = 6;

        assertFalse(dut.hasPathSum(root, targetSum));
    }
    @Test
    public void test7() {
        //root = [1,-2,-3,1,3,-2,null,-1]
        //-1
        TreeNode left_3_1 = new TreeNode(-1, null, null);
        TreeNode left_2_2 = new TreeNode(-2, null,null);
        TreeNode left_2_1 = new TreeNode(1, left_3_1, null);
        TreeNode right_2_1 = new TreeNode(3, null, null);
        TreeNode left_1 = new TreeNode(-2, left_2_1, right_2_1);
        TreeNode right_1 = new TreeNode(-3, left_2_2, null);
        TreeNode root = new TreeNode(1, left_1, right_1);
        int targetSum = -1;

        assertTrue(dut.hasPathSum(root, targetSum));
    }
}