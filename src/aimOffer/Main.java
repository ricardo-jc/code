package aimOffer;

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

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(head);
    }
}