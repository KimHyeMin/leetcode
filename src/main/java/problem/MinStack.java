package problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/min-stack/
public class MinStack {

    private Node topNode = null;

    public MinStack() {

    }

    public void push(int val) {
        if (topNode == null) {
            topNode = new Node();
            topNode.val=val;
            topNode.min = val;
            return;
        }
       Node nextNode = new Node();
       nextNode.val = val;
       nextNode.min = Math.min(topNode.min, val);
       nextNode.preNode = topNode;
       topNode = nextNode;
    }

    public void pop() {
       topNode = topNode.preNode;
    }

    public int top() {
       return topNode.val;
    }

    public int getMin() {
       return topNode.min;
    }

    static class Node {
        int val;
        int min;
        Node preNode;
    }
}

