package leetCode;

import aimOffer.structures.TreeNode;

public class LowestCommonAncestor_235 {
    class Solution {
        public TreeNode lowestCommonAncestor_recursion(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null || root == p || root == q) return root;
            if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
            if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
            return root;
        }
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
            while(root != null) {
                if(root.val > p.val && root.val > q.val) root = root.left;
                else if(root.val < p.val && root.val < q.val) root = root.right;
                else return root;
            }
            return null;
        }
    }
}
