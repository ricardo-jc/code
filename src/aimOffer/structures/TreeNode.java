package aimOffer.structures;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {
        val = x;
    }
    public TreeNode(int[] x) {
        arrayToTreeNode(x, 0);
    }
    private TreeNode arrayToTreeNode(int[] x, int index) {
        TreeNode root = new TreeNode(x[index]);
        if(2 * index + 1 < x.length) root.left = arrayToTreeNode(x, 2 * index + 1);
        if(2 * index + 2 < x.length) root.right = arrayToTreeNode(x, 2 * index + 2);
        return root;
    }
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder(val + ", ");
        if(left != null)
            string.append(left.toString());
        if(right != null)
            string.append(right.toString());
        return string.toString();
    }
}
