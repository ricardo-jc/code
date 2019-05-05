package leetCode;

import aimOffer.structures.TreeNode;

import java.util.Stack;

public class IsValidBST_98 {
    class Solution {
        public boolean isValidBST_Traverse(TreeNode root) {
            if(root == null) return true;
            else {
                long pre = Long.MIN_VALUE;
                Stack<TreeNode> stack = new Stack<>();
                TreeNode p = root;
                while(p != null || !stack.empty()) {
                    while(p != null) {
                        stack.push(p);
                        p = p.left;
                    }
                    p = stack.pop();
                    if(pre >= p.val) return false;
                    pre = p.val;
                    p = p.right;
                }
                return true;
            }
        }
        public boolean isValidBST(TreeNode root) {
            return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }
        private boolean isValid(TreeNode root, Long min, Long max) {
            if (root == null) return true;
            if (min != null && min >= root.val) return false;
            if (max != null && max <= root.val) return false;
            return isValid(root.left, min, (long)root.val) && isValid(root.right, (long)root.val, max);
        }
        private long min(TreeNode root) {
            long min = Long.MAX_VALUE;
            if(root == null) return min;
            return Math.min(Math.min(min, root.val), Math.min(min(root.left), min(root.right)));
        }
        private long max(TreeNode root) {
            long max = Long.MIN_VALUE;
            if(root == null) return max;
            return Math.max(Math.max(max, root.val), Math.max(max(root.left), max(root.right)));
        }
    }
    public static void main(String[] args) {
        IsValidBST_98 i = new IsValidBST_98();
        Solution s = i.new Solution();
        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(3);
        root.right = new TreeNode(30);
        root.right.left = new TreeNode(10);
        root.right.left.right = new TreeNode(15);
        root.right.left.right.right = new TreeNode(45);
        System.out.println(s.isValidBST(root));
    }
}
