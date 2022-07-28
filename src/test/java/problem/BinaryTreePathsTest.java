package problem;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreePathsTest {

    private static final BinaryTreePaths dut = new BinaryTreePaths();

    @Test
    public void test() {
        BinaryTreePaths.TreeNode root = new BinaryTreePaths.TreeNode(1);
        BinaryTreePaths.TreeNode sub1_1 = new BinaryTreePaths.TreeNode(2);
        BinaryTreePaths.TreeNode sub1_2 = new BinaryTreePaths.TreeNode(3);
        BinaryTreePaths.TreeNode sub2_1 = new BinaryTreePaths.TreeNode(5);
        sub1_1.right = sub2_1;
        root.left = sub1_1;
        root.right = sub1_2;

        dut.binaryTreePaths(root).stream().forEach(it -> {
            System.out.println(it);
        });

    }

    @Test
    public void test2() {
        BinaryTreePaths.TreeNode root = new BinaryTreePaths.TreeNode(1);
        dut.binaryTreePaths(root).stream().forEach(it -> {
            System.out.println(it);
        });

    }

    @Test
    public void test3() {
        BinaryTreePaths.TreeNode root = new BinaryTreePaths.TreeNode(1);
        BinaryTreePaths.TreeNode sub1_1 = new BinaryTreePaths.TreeNode(2);
        BinaryTreePaths.TreeNode sub1_2 = new BinaryTreePaths.TreeNode(3);

        root.left = sub1_1;
        root.right = sub1_2;

        dut.binaryTreePaths(root).stream().forEach(it -> {
            System.out.println(it);
        });

    }

    @Test
    public void test4() {
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        sb.append("b");
        sb.append("c");
        sb.append("d");
        sb.append("e");
        sb.setLength(2);
        System.out.println(sb.toString());
    }
}