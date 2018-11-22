package aimOffer;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
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
