package aimOffer;

import java.util.*;

public class Solution {

    public boolean Find(int target, int [][] array) {
        int row = array.length;
        int column = array[0].length;
        for(int i = 0, j = column - 1; i < row && j >= 0;) {
            if(array[i][j] == target)
                return true;
            else if(array[i][j] > target)
                j--;
            else
                i++;
        }
        return false;
    }

    public String replaceSpace(StringBuffer str) {
        int p1 = str.length() - 1;
        for(int i = 0; i <= p1; i++){
            char c = str.charAt(i);
            if(c == ' '){
                str.append("  ");
            }
        }
        int p2 = str.length() - 1;
        for(; p1 >= 0 && p1 < p2; p1--){
            if(str.charAt(p1) == ' '){
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            }else{
                str.setCharAt(p2--, str.charAt(p1));
            }
        }
        return str.toString();
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ints = new ArrayList<>();
        ListNode l = listNode;
        while(l != null) {
            ints.add(l.val);
            l = l.next;
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = ints.size() - 1; i >= 0; i--){
            result.add(ints.get(i));
        }
        return result;
    }

    ArrayList<Integer> result = new ArrayList<>();
    public ArrayList<Integer> print(ListNode listNode) {
        if(listNode != null) {
            print(listNode.next);
            result.add(listNode.val);
        }
        return result;
    }

    public void reConstructBinaryTree(List<Integer> pre, List<Integer> in, TreeNode root) {
        List<Integer> liftPre = new ArrayList<>();
        List<Integer> liftIn = new ArrayList<>();
        List<Integer> rightPre = new ArrayList<>();
        List<Integer> rightIn = new ArrayList<>();
        int rootInIn = in.indexOf(root.val);
        int i = 0;
        while(i < rootInIn) {
            liftIn.add(in.get(i++));
        }
        i++;
        while(i < in.size()) {
            rightIn.add(in.get(i++));
        }
        for(Integer p:pre) {
            if(liftIn.contains(p)) {
                liftPre.add(p);
            }
            else if(rightIn.contains(p)) {
                rightPre.add(p);
            }
        }
        if(liftPre.size() > 0) {
            root.left = new TreeNode(liftPre.get(0));
            reConstructBinaryTree(liftPre, liftIn, root.left);
        }
        if(rightPre.size() > 0) {
            root.right = new TreeNode(rightPre.get(0));
            reConstructBinaryTree(rightPre, rightIn, root.right);
        }
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = new TreeNode(pre[0]);
        List<Integer> preList = new ArrayList<>();
        List<Integer> inList = new ArrayList<>();
        for(int p:pre) {
            preList.add(p);
        }
        for(int i:in) {
            inList.add(i);
        }
        reConstructBinaryTree(preList, inList, root);
        return root;
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode.right != null) {
            TreeLinkNode right = pNode.right;
            while(right.left != null) {
                right = right.left;
            }
            return right;
        }
        else {
            TreeLinkNode temp = pNode;
            while(temp.next != null && temp != temp.next.left) {
                temp = temp.next;
            }
            return temp.next;
        }
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int node) {
        stack1.push(node);
    }
    public int pop() {
        if(!stack2.empty()) {
            return stack2.pop();
        }
        else {
            while(!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int Fibonacci(int n) {
        int i = 0, j = 1;
        while(n-- > 0) {
            j = i + j;
            i = j - i;
        }
        return i;
    }

    public int JumpFloor(int target) {
        int i = 1, j = 2;
        while(target-- > 1) {
            j = j + i;
            i = j - i;
        }
        return i;
    }

    public int RectCover(int target) {
        if(target == 0) return 0;
        int i = 1, j = 2;
        while (target-- > 1) {
            j += i;
            i = j - i;
        }
        return i;
    }

    public int JumpFloorII(int target) {
        if(target == 0) return 1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int value = 0;
        for(int i = 0; i < target; i++) {
            value += map.get(i);
            map.put(i + 1, value);
        }
        return value;
    }

    public int minNumberInRotateArray(int [] array) {
        int left = 0, right = array.length - 1;
        while(left < right && right - left > 1) {
            int mid = (right + left)/2;
            if(array[mid] > array[right]) {
                left = mid;
            }
            else if(array[mid] == array[right]) {
                right--;
            }
            else {
                right = mid;
            }
        }
        return array[right];
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        List<Integer> path = new ArrayList<>();
        boolean[] flag = new boolean[matrix.length];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                int n = 0;
                if(str[n] == matrix[i * cols + j] && !flag[i * cols + j]) {
                    flag[i * cols + j] = true;
                    n++;
                    while(n < str.length && n > 0) {
                        if(i + 1 < rows) {
                            if(str[n] == matrix[(i + 1)* cols + j] && !flag[(i + 1)* cols + j]) {
                                i = i + 1;
                                flag[i * cols + j] = true;
                                n++;
                                path.add(1);
                                continue;
                            }
                        }
                        if(i - 1 >= 0) {
                            if(str[n] == matrix[(i - 1)* cols + j] && !flag[(i - 1)* cols + j]) {
                                i = i - 1;
                                flag[i * cols + j] = true;
                                n++;
                                path.add(2);
                                continue;
                            }
                        }
                        if(j + 1 < cols) {
                            if(str[n] == matrix[i * cols + j + 1] && !flag[i * cols + j + 1]) {
                                j = j + 1;
                                flag[i * cols + j] = true;
                                n++;
                                path.add(3);
                                continue;
                            }
                        }
                        if(j - 1 >= 0) {
                            if(str[n] == matrix[i * cols + j - 1] && !flag[i * cols + j - 1]) {
                                j = j - 1;
                                flag[i * cols + j] = true;
                                n++;
                                path.add(4);
                                continue;
                            }
                        }
                        n--;
                        if(path.size() > 0) {
                            switch (path.get(path.size() - 1)) {
                                case 1:
                                    i--;break;
                                case 2:
                                    i++;break;
                                case 3:
                                    j--;break;
                                case 4:
                                    j++;break;
                            }
                            path.remove(path.size() - 1);
                        }
                    }
                    flag[i * cols + j] = false;
                    if(n == str.length)
                        return true;
                }
            }
        }
        return false;
    }

    private int move(int rows, int cols, int i, int j, boolean[][] coverd, int threshold) {
        if(i >= 0 && i < rows && j >= 0 && j < cols && !coverd[i][j]) {
            int n = 0, temp;
            temp = i;
            while(temp / 10 > 0){
                n += temp % 10;
                temp = temp / 10;
            }
            n += temp;
            temp = j;
            while(temp / 10 > 0){
                n += temp % 10;
                temp = temp / 10;
            }
            n += temp;
            if(n <= threshold) {
                coverd[i][j] = true;
                return 1 + move(rows, cols, i + 1, j, coverd, threshold) + move(rows, cols, i - 1, j, coverd, threshold)
                        + move(rows, cols, i, j + 1, coverd, threshold) + move(rows, cols, i, j - 1, coverd, threshold);
            }
        }
        return 0;
    }
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] coverd = new boolean[rows][cols];
        return move(rows, cols, 0, 0, coverd, threshold);
    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                dp[i]= Math.max(dp[i], Math.max((i - j) * j, dp[j] * (i - j)));
            }
        }
        return dp[n];
    }

}

