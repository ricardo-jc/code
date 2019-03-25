package aimOffer;

import aimOffer.structures.TreeNode;

import java.util.*;

public class BinaryTreeTraverse {
    //二叉树的遍历
    private ArrayList<Integer> vals = new ArrayList<>();
    //前序遍历
    //递归
    public ArrayList<Integer> preorder_recursion(TreeNode root) {
        if(root == null) return null;
        vals.add(root.val);
        preorder_recursion(root.left);
        preorder_recursion(root.right);
        return vals;
    }
    //迭代
    public ArrayList<Integer> preorder_iteration(TreeNode root) {
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
    public ArrayList<Integer> inorder_recursion(TreeNode root) {
        if(root == null) return null;
        inorder_recursion(root.left);
        vals.add(root.val);
        inorder_recursion(root.right);
        return vals;
    }
    //迭代
    public ArrayList<Integer> inorder_iteration(TreeNode root) {
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
    public ArrayList<Integer> postorder_recursion(TreeNode root) {
        if(root == null) return null;
        postorder_recursion(root.left);
        postorder_recursion(root.right);
        vals.add(root.val);
        return vals;
    }
    //迭代
    public ArrayList<Integer> postorder_iteration_1(TreeNode root) {
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
    public ArrayList<Integer> postorder_iteration_2(TreeNode root) {
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

    //层序遍历
    //迭代
    public ArrayList<Integer> levelorder_iteration(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode p = queue.poll();
            vals.add(p.val);
            if(p.left != null){
                queue.add(p.left);
            }
            if(p.right != null) {
                queue.add(p.right);
            }
        }
        return vals;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        BinaryTreeTraverse traverse = new BinaryTreeTraverse();
        System.out.println(traverse.levelorder_iteration(root));
    }
}
