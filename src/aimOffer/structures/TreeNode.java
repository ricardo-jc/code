package aimOffer.structures;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {
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
