package aimOffer;

import aimOffer.structures.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.replaceSpace(new StringBuffer("We Are Happy")));

//        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
//        System.out.println(solution.Find(12, array));

//        int[] pre = {1,2,3,4,5,6,7};int[] in = {3,2,4,1,6,5,7};
//        System.out.println(solution.reConstructBinaryTree(pre, in));

//        int[] array = {6,1,2,3,4,5};
//        System.out.println(solution.minNumberInRotateArray(array));

//        char[] matrix = {'a', 'b', 'c', 'e', 's', 'f' ,'c', 's', 'a', 'd', 'e', 'e'};
//        char[] matrix = {'A','B','C','E','H','J','I','G','S','F','C','S','L','O','P','Q','A','D','E','E','M','N','O','E','A','D','I','D','E','J','F','M','V','C','E','I','F','G','G','S'};
//        char[] str = {'a','b','c','b'};
//        char[] str = {'S','L','H','E','C','C','E','I','D','E','J','F','G','G','F','I','E'};
//        char[] str = {'S','G','G','F','I','E','C','V','A','A','S','A','B','C','E','H','J','I','G','Q','E','M'};
//        for(int i= 0;i<5; i++) {
//            for (int j = 0; j < 8; j++) {
//                System.out.print(matrix[i * 8 + j] + "\t");
//            }
//            System.out.println();
//        }
//        System.out.println(solution.hasPath(matrix,5,8, str));

//        System.out.println(solution.movingCount(10, 1, 100));

//        System.out.println(solution.integerBreak(10));

//        System.out.println(solution.Power2(2.0, 10));

//        solution.print1ToMaxOfNDigits(2);

//        System.out.println(solution.deleteDuplication());
//        char[] str = {'a','b'};
//        char[] pattern = {'a','b','.','*'};
//        System.out.println(solution.match(str, pattern));

//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        System.out.println(solution.ReverseList_iteration(head));
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);list.add(2);list.add(3);list.add(4);
//        System.out.println(list.subList(1,3));

//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(3);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(2);
//        root.right = new TreeNode(7);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(9);
//        System.out.println(root);
//        System.out.println(solution.Last_iteration(root));
//        System.out.println(solution.Inorder_iteration(root));
//        System.out.println(solution.Serialize(root));
//        System.out.println(solution.Serialize(solution.Deserialize(solution.Serialize(root))));
//        System.out.println(solution.Deserialize("5,#,4,#,3,#,2,"));

//        int[] a = new int[]{1,2,3,2,2,2,5,4,2};
//        System.out.println(solution.MoreThanHalfNum_Solution(a));

//        int[] a = new int[]{1,5,7,2,9,3,1,8,6};
//        for(Integer i:a) System.out.print(i + " ");
//        System.out.println();
//        System.out.println(solution.GetLeastNumbers_Solution2(a, 5));

//        String str = "googgle";
//        System.out.println(solution.FirstNotRepeatingChar(str));

//        int[] array = new int[]{-1, -2, -5, -4};
//        System.out.println(solution.FindGreatestSumOfSubArray(array));
//        int[] array = new int[]{-1, 2, 1, -4};
//        System.out.println(solution.twoSumClosest(array, 4));

        String input = "aaabbaabb";
        System.out.println(solution.KSubstring(input, 2));
    }

}
