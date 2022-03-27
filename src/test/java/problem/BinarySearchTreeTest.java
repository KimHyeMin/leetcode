package problem;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    @Test
    public void test() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int[] preorder = {8, 5, 1,7,10,12};
        binarySearchTree.bstFromPreorder(preorder);
    }

}