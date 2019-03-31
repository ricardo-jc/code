package aimOffer;

import aimOffer.structures.*;

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
    public void push_(int node) {
        stack1.push(node);
    }
    public int pop_() {
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

    public int NumberOf1(int n) {
        int count = 0;
        while(n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }

    public double Power1(double base, int exponent) {
        double a = 1;
        int n = Math.abs(exponent);
        while (n-- > 0) {
            a *= base;
        }
        if(exponent > 0) return a;
        else return 1/a;
    }
    public double Power2(double base, int exponent) {
        if(exponent < 0) {
            int n = Math.abs(exponent);
            if(n == 1) return base;
            if(n % 2 == 1) {
                return 1 / (base * Power2((base * base), n/2));
            }else {
                return 1 / Power2((base * base), n/2);
            }
        }
        else {
            if(exponent == 0) return 1;
            if(exponent == 1) return base;
            if(exponent % 2 == 1) {
                return base * Power2((base * base), exponent/2);
            }else {
                return Power2((base * base), exponent/2);
            }
        }
    }

    public void print1ToMaxOfNDigits(int n) {
        char[] num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] out = new char[n];
        printNDigits(0, out, num);
    }
    private void printNDigits(int j, char[] out, char[] num) {
        if(j < out.length) {
            for(int i = 0; i < num.length; i++) {
                out[j] = num[i];
                printNDigits(j + 1, out, num);
            }
            return;
        }
        for(int i = 0; i < out.length; i++){
            if(out[i] != '0') {
                for(int l = i; l < out.length; l++) {
                    System.out.print(out[l]);
                }
                System.out.println();
                break;
            }
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null || pHead.next == null) return pHead;
        ListNode temp = pHead;
        ListNode next = temp.next;
        if(temp.val != next.val) {
            while(next.next != null && temp.next.val != next.next.val) {
                temp = temp.next;
                next = next.next;
            }
            temp.next = deleteDuplication(next);
            return pHead;
        }
        else {
            while(next.next != null && temp.val == next.next.val) {
                next = next.next;
            }
            pHead = next.next;
            return deleteDuplication(pHead);
        }
    }
    public ListNode deleteDuplication(){
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(4);
        System.out.println(node);
        return deleteDuplication(node);
    }

    public boolean match(char[] str, char[] pattern)
    {
        return match_m(str, pattern, 0, 0);
    }
    private boolean match_e(char[] str, char[] pattern, int a,int b){
        if(a >= str.length) return false;
        return str[a] == pattern[b] || pattern[b] == '.';
    }
    private boolean match_m(char[] str, char[] pattern, int i, int j){
        if(j >= pattern.length) {
            return i == str.length && j == pattern.length;
        }
        if(j < pattern.length - 1 && pattern[j + 1] == '*') {
            return match_m(str, pattern, i, j + 2)
                    || (match_e(str, pattern, i, j) && match_m(str, pattern, i + 1, j + 2))
                    || (match_e(str, pattern, i, j) && match_m(str, pattern, i + 1, j));
        }
        else return match_e(str, pattern, i, j) && match_m(str, pattern, i + 1, j + 1) ;
    }

    public boolean match2(char[] str, char[] pattern) {

        int m = str.length, n = pattern.length;
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;
        for (int i = 1; i <= n; i++)
            if (pattern[i - 1] == '*')
                dp[0][i] = dp[0][i - 2];

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (pattern[j - 1] == '*')
                    if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.') {
                        dp[i][j] |= dp[i][j - 1]; // a* counts as single a
                        dp[i][j] |= dp[i - 1][j]; // a* counts as multiple a
                        dp[i][j] |= dp[i][j - 2]; // a* counts as empty
                    } else
                        dp[i][j] = dp[i][j - 2];   // a* only counts as empty

        return dp[m][n];
    }

    public boolean isNumeric(char[] str) {
        int i = 0;
        boolean hasDot = false;
        boolean hasE = false;
        if(str[0] == '+' || str[0] == '-') i++;
        for(; i < str.length; i++) {
            if(isNum(str[i])) continue;
            else if(str[i] == '.' && !hasDot) {
                hasDot = true;
            }
            else if((str[i] == 'E' || str[i] == 'e') && !hasE) {
                hasE = true;
                hasDot = true;
                if(i + 1 < str.length && (str[i + 1] == '+' || str[i + 1] == '-')) i++;
                if(!(i + 1 < str.length && isNum(str[i + 1]))) return false;
            }
            else return false;
        }
        return true;
    }
    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    public void reOrderArray(int[] nums) {
        int oddNum = 0;
        for(int num:nums) {
            if(num % 2 != 0) oddNum++;
        }
        int even = oddNum;
        int i = 0;
        int[] copy = nums.clone();
        for(int num:copy) {
            if(num % 2 == 0) nums[even++] = num;
            else nums[i++] = num;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null) return null;
        int n = 1;
        ListNode point = head;
        while(point.next != null) {
            n++;
            point = point.next;
        }
        point = head;
        if(n < k) return null;
        for(int i = 0; i < n - k; i++) {
            point = point.next;
        }
        return point;
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead == null || pHead.next == null) return null;
        ListNode fast = pHead, slow = pHead;
        do {
            fast = fast.next.next;
            slow = slow.next;
        }while(fast != slow);
        fast = pHead;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public ListNode ReverseList_recursion(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = null;
        ListNode temp = ReverseList_recursion(next);
        next.next = head;
        return temp;
    }
    public ListNode ReverseList_iteration(ListNode head) {
        ListNode temp = new ListNode(-1);
        while(head != null) {
            ListNode next = head.next;
            head.next = temp.next;
            temp.next = head;
            head = next;
        }
        return temp.next;
    }

    public ListNode Merge_recursion(ListNode list1,ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1.val <= list2.val) {
            list1.next = Merge_recursion(list1.next, list2);
            return list1;
        }
        else {
            list2.next = Merge_recursion(list1, list2.next);
            return list2;
        }
    }
    public ListNode Merge_iteration(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                p.next = list1;
                list1 = list1.next;
            }
            else{
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        if(list1 == null)
            p.next = list2;
        if(list2 == null)
            p.next = list1;
        return head.next;
    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null) return false;
        return Subtree(root1, root2) || Subtree(root1.left, root2) || Subtree(root1.right, root2);
    }
    private boolean Subtree(TreeNode root1, TreeNode root2) {
        if(root2 == null) return true;
        if(root1 == null) return false;
        if(root1.val != root2.val) return false;
        return Subtree(root1.left, root2.left) && Subtree(root1.right, root2.right);
    }

    public void Mirror(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }

    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        return isSymmetrical(pRoot.left, pRoot.right);
    }
    private boolean isSymmetrical(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        if(t1.val == t2.val)
            return isSymmetrical(t1.left, t2.right) && isSymmetrical(t1.right, t2.left);
        else return false;
    }

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int r = 0, row = matrix.length;
        int c = 0, col = matrix[0].length;
        ArrayList<Integer> result = new ArrayList<>();
        while(r < row && c < col) {
            for(int j = c; j < col; j++) {
                result.add(matrix[r][j]);
            }
            for(int i = r + 1; i < row; i++) {
                result.add(matrix[i][col - 1]);
            }
            if(r != row - 1) {
                for(int j = col - 2; j >= c; j--) {
                    result.add(matrix[row - 1][j]);
                }
            }
            if(c != col - 1) {
                for(int i = row - 2; i > r; i--) {
                    result.add(matrix[i][c]);
                }
            }
            r++;c++;row--;col--;
        }
        return result;
    }

    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> min = new Stack<>();
    public void push(int node) {
        data.push(node);
        min.push(min.isEmpty() ? node : Math.min(node, min.peek()));
    }
    public void pop() {
        data.pop();
        min.pop();
    }
    public int top() {
        return data.peek();
    }
    public int min() {
        return min.peek();
    }

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        for(int a : popA) {
            for(;!stack.contains(a) && pushIndex < pushA.length; pushIndex++) {
                    stack.push(pushA[pushIndex]);
            }
            if(stack.pop() != a) return false;
        }
        return stack.isEmpty();
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arg = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int cnt = queue.size();
            while(cnt-- > 0) {
                TreeNode t = queue.poll();
                if(t == null) continue;
                arg.add(t.val);
                queue.add(t.left);
                queue.add(t.right);
            }
        }
        return arg;
    }

    ArrayList<ArrayList<Integer> > Print_(TreeNode pRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        queue.add(pRoot);
        while(!queue.isEmpty()) {
            int cnt = queue.size();
            ArrayList<Integer> res = new ArrayList<>();
            while(cnt-- > 0){
                TreeNode t = queue.poll();
                if(t == null) continue;
                res.add(t.val);
                queue.add(t.left);
                queue.add(t.right);
            }
            if(res.size() > 0) result.add(res);
        }
        return result;
    }

    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean reverse = false;
        while(!queue.isEmpty()) {
            int cnt = queue.size();
            ArrayList<Integer> res = new ArrayList<>();
            while (cnt-- > 0) {
                TreeNode t = queue.poll();
                if (t == null) continue;
                res.add(t.val);
                queue.add(t.left);
                queue.add(t.right);
            }
            if (res.size() > 0) {
                if (reverse) Collections.reverse(res);
                result.add(res);
            }
            reverse = !reverse;
        }
        return result;
    }

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0) return false;
        return verify(sequence, 0, sequence.length - 1);
    }
    private boolean verify(int [] sequence, int first, int last) {
        if(last - first <= 1) return true;
        int root = sequence[last];
        int cutIndex = 0;
        while(cutIndex < last && sequence[cutIndex] < root) cutIndex++;
        for(int i = cutIndex; i < last; i++) {
            if(sequence[i] < root) return false;
        }
        return verify(sequence, first, cutIndex - 1) && verify(sequence, cutIndex, last - 1);
    }

    private ArrayList<ArrayList<Integer>> result_ = new ArrayList<>();
    ArrayList<Integer> array = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) return result_;
        array.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null) {
            result_.add(new ArrayList<>(array));
        }
        FindPath(root.left, target);
        FindPath(root.right,target);
        array.remove(array.size() - 1);
        return result_;
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null) return null;
        RandomListNode p = pHead;
        RandomListNode result = new RandomListNode(p.label);
        RandomListNode q = result;
        while(p.next != null) {
            q.next = new RandomListNode(p.next.label);
            if(p.random != null) q.random = new RandomListNode(p.random.label);
            p = p.next;
            q = q.next;
        }
        return result;
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        Convert(pRootOfTree.left);
        Convert(pRootOfTree.right);
        TreeNode max = MaxNode(pRootOfTree.left);
        if(max != null) {
            max.right = pRootOfTree;
            pRootOfTree.left = max;
        }
        TreeNode min = MinNode(pRootOfTree.right);
        if(min != null) {
            min.left = pRootOfTree;
            pRootOfTree.right = min;
        }
        return MinNode(pRootOfTree);
    }
    private TreeNode MinNode(TreeNode root) {
        if(root == null) return null;
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
    private TreeNode MaxNode(TreeNode root) {
        if(root == null) return null;
        while(root.right != null) {
            root = root.right;
        }
        return root;
    }

    public String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null) sb.append("#,");
        else {
            sb.append(root.val).append(",");
            sb.append(Serialize(root.left));
            sb.append(Serialize(root.right));
        }
        return sb.toString();
    }
    public TreeNode Deserialize(String str) {
        List<String> vals = Arrays.asList(str.split(","));
        return Deserialize(vals);
    }
    private int index = -1;
    private TreeNode Deserialize(List<String> vals) {
        if(index >= vals.size() - 1 || "#".equals(vals.get(++index))) return null;
        TreeNode root = new TreeNode(Integer.parseInt(vals.get(index)));
        root.left = Deserialize(vals);
        root.right = Deserialize(vals);
        return root;
    }

    //字符串的排列
    private ArrayList<String> permutation_res = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        if(str == null || str.length() == 0) return permutation_res;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backtracking(chars, new boolean[str.length()], new StringBuilder());
        return permutation_res;
    }
    private void backtracking(char[] chars, boolean[] choiced, StringBuilder sb){
        if(chars.length == sb.length()) {
            permutation_res.add(sb.toString());
            return;
        }
        for(int i = 0; i < chars.length - 1; i++) {
            if(choiced[i]) continue;
            if(i > 0 && chars[i] == chars[i - 1] && !choiced[i - 1]) continue;
            sb.append(chars[i]);
            choiced[i] = true;
            backtracking(chars, choiced, sb);
            sb.deleteCharAt(sb.length() - 1);
            choiced[i] = false;
        }
    }

    //数组中出现次数超过一半的数字
    public int MoreThanHalfNum_Solution(int [] array) {
        int n = array.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(Integer a : array) {
            if(!map.containsKey(a.hashCode()))
                map.put(a.hashCode(), 1);
            else map.put(a.hashCode(), map.get(a.hashCode()) + 1);
            if(map.get(a.hashCode()) > n) return a;
        }
        return 0;
    }

    //最小的k个数
    public ArrayList<Integer> GetLeastNumbers_Solution1(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>(k);
        if(k > input.length || k <= 0) return list;
        findKthSamllest(input, k);
        for(int i = 0; i < k; i++) {
                list.add(input[i]);
        }
        return list;
    }
    private void findKthSamllest(int[] input, int k) {
        int start = 0;
        int end = input.length - 1;
        while(true) {
            int n = partition(input, start, end);
            if(n == k - 1) break;
            if(n < k - 1) start = n + 1;
            else end = n - 1;
        }
    }
    private int partition(int[] input, int start, int end) {
        int i = start;
        int j = end + 1;
        while(true) {
            while(i < end && input[++i] < input[start]);
            while(j > start && input[--j] > input[start]);
            if(j <= i) break;
            swap(input, i, j);
        }
        swap(input, start, j);
        return j;
    }
    private void swap(int[] input, int i ,int j) {
        if(input == null || input.length < 2 || i == j) return;
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
        for(Integer a:input) System.out.print(a + " ");
        System.out.println();
    }
    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        if(k > input.length || k <= 0) return new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>
                ((a, b) -> b - a);
//                (Comparator.comparingInt(x -> -x));
//                (Comparator.comparing(o -> -o));
        for(Integer i:input) {
            maxHeap.add(i);
            if(maxHeap.size() > k)
                maxHeap.poll();
        }
        return new ArrayList<>(maxHeap);
    }

    //求数据流的中位数
    private PriorityQueue<Integer> left = new PriorityQueue<>();
    private PriorityQueue<Integer> right = new PriorityQueue<>(Comparator.comparing(x -> -x));
    public void Insert(Integer num) {
        if(right.size() == 0) right.offer(num);
        else if(num < right.peek()) left.offer(num);
        else right.offer(num);
        if(right.size() >= left.size() + 2) left.offer(right.poll());
        if(right.size() <= left.size() - 1) right.offer(left.poll());
    }
    public Double GetMedian() {
        if(right.size() == left.size()) return (double)(right.peek() + left.peek()) / 2;
        else return (double) right.peek();
    }

    //第一个只出现一次的字符
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> count = new HashMap<>();
        char[] chars = str.toCharArray();
        HashMap<Character, Integer> index = new LinkedHashMap<>();
        for(int i = 0; i < chars.length; i++) {
            if(!count.containsKey(chars[i])) {
                count.put(chars[i], 1);
                index.put(chars[i], i);
            }
            else {
                count.put(chars[i], -1);
                index.remove(chars[i]);
            }
        }
        return index.size() > 0 ? index.entrySet().iterator().next().getValue() : -1;
    }

    //字节流中第一个不重复的字符
    int[] input = new int[256];
    ArrayList<Character> chars = new ArrayList<>();
    public void Insert(char ch)
    {
        input[ch]++;
        chars.add(ch);
    }
    public char FirstAppearingOnce()
    {
        for(Character c : chars) {
            if(input[c] == 1) return c;
        }
        return '#';
    }

    //最大子序列和
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(Integer i : array) {
            if(sum <= 0) {
                sum = i;
            }else sum += i;
            max = Math.max(sum, max);
        }
        return max;
    }


    public int maxSubList(int[] arr) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        boolean lower = true;
        int pre = arr[index];
        for (int i = index + 1; i < arr.length; i++) {
            if (lower && pre > arr[i] || !lower && pre < arr[i]) {
                if (sum <= 0) sum = arr[i];
                else sum += arr[i];
                max = Math.max(sum, max);
                lower = !lower;
            }
        }
        return max;
    }



//    public int numberOf1(int n) {
//        int sum = 0;
//        while(n != 0){
//            sum++;
//            n = n & (n - 1);
//        }
//        return sum;
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {
//            int a = in.nextInt();
//            Solution m = new Solution();
//            System.out.println(m.numberOf1(a));
//        }
//    }
}

