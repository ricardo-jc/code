package aimOffer;

import aimOffer.structures.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeTraverse {
    //二叉树的遍历
    private ArrayList<Integer> vals = new ArrayList<>();
    //前序遍历
    //递归
    public ArrayList<Integer> Preorder_recursion(TreeNode root) {
        if(root == null) return null;
        vals.add(root.val);
        Preorder_recursion(root.left);
        Preorder_recursion(root.right);
        return vals;
    }
    //迭代
    public ArrayList<Integer> Preorder_iteration(TreeNode root) {
        if(root == null) return null;
        TreeNode p = root;
        Stack<TreeNode> pre = new Stack<>();
        while(!pre.isEmpty() || p != null) {
            while(p != null) {
                pre.add(p);
                vals.add(p.val);
                p = p.left;
            }
            p = pre.pop().right;
        }
        return vals;
    }
    //中序遍历
    //递归
    public ArrayList<Integer> Inorder_recursion(TreeNode root) {
        if(root == null) return null;
        Inorder_recursion(root.left);
        vals.add(root.val);
        Inorder_recursion(root.right);
        return vals;
    }
    //迭代
    public ArrayList<Integer> Inorder_iteration(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> pre = new Stack<>();
        TreeNode p = root;
        while(p != null || !pre.isEmpty()) {
            while(p != null) {
                pre.add(p);
                p = p.left;
            }
            p = pre.pop();
            vals.add(p.val);
            p = p.right;
        }
        return vals;
    }
    //后续遍历
    //递归
    public ArrayList<Integer> Postorder_recursion(TreeNode root) {
        if(root == null) return null;
        Postorder_recursion(root.left);
        Postorder_recursion(root.right);
        vals.add(root.val);
        return vals;
    }
    //迭代
    public ArrayList<Integer> Postorder_iteration_1(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> pre = new Stack<>();
        TreeNode p = root;
        while(p != null || !pre.isEmpty()) {
            while(p != null) {
                pre.add(p);
                stack.add(p);
                p = p.right;
            }
            p = pre.pop().left;
        }
        while(!stack.isEmpty())
            vals.add(stack.pop().val);
        return vals;
    }
    public ArrayList<Integer> Postorder_iteration_2(TreeNode root) {
        if(root == null) return null;
        TreeNode pre = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode p = stack.peek();
            if((p.left == null && p.right == null) || pre == p.left || pre == p.right) {
                vals.add(p.val);
                pre = stack.pop();
                continue;
            }
            if(p.right != null){
                stack.add(p.right);
            }
            if(p.left != null) {
                stack.add(p.left);
            }
        }
        return vals;
    }
}
