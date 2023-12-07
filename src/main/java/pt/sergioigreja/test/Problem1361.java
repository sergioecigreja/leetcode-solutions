package pt.sergioigreja.test;

import java.util.HashSet;

import java.util.Set;
import java.util.Stack;

public class Problem1361 {
    public static void main(String[] args) {

    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int root = findRoot(n, leftChild, rightChild);
        if (root == -1)
            return false;
        Stack<Integer> stack = new Stack<>();
        Set<Integer> seen = new HashSet<>();
        stack.add(root);
        seen.add(root);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            int[] children = { leftChild[node], rightChild[node] };

            for (int child : children) {
                if (child != -1) {
                    if (seen.contains(child)) {
                        return false;
                    }

                    stack.push(child);
                    seen.add(child);
                }
            }
        }

        return seen.size() == n;
    }

    public int findRoot(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> children = new HashSet<>();
        for (int node : leftChild) {
            children.add(node);
        }

        for (int node : rightChild) {
            children.add(node);
        }

        for (var i = 0; i < n; i++) {
            if (!children.contains(i)) {
                return i;
            }
        }

        return -1;
    }
}
