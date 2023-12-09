package pt.sergioigreja.test;

public class Problem606 {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.toString();
    }

    public void helper(TreeNode current, StringBuilder sb) {
        if (current == null)
            return;
        sb.append(current.val);
        if (current.left == null && current.right == null)
            return;
        sb.append('(');
        helper(current.left, sb);
        sb.append(')');
        if (current.right != null) {
            sb.append('(');
            helper(current.right, sb);
            sb.append(')');
        }
    }
}
