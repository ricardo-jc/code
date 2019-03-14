package aimOffer;

//import java.util.ArrayList;
//
//public class Main {
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
////        System.out.println(solution.replaceSpace(new StringBuffer("We Are Happy")));
//
////        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
////        System.out.println(solution.Find(12, array));
//
////        int[] pre = {1,2,3,4,5,6,7};int[] in = {3,2,4,1,6,5,7};
////        System.out.println(solution.reConstructBinaryTree(pre, in));
//
////        int[] array = {6,1,2,3,4,5};
////        System.out.println(solution.minNumberInRotateArray(array));
//
////        char[] matrix = {'a', 'b', 'c', 'e', 's', 'f' ,'c', 's', 'a', 'd', 'e', 'e'};
////        char[] matrix = {'A','B','C','E','H','J','I','G','S','F','C','S','L','O','P','Q','A','D','E','E','M','N','O','E','A','D','I','D','E','J','F','M','V','C','E','I','F','G','G','S'};
////        char[] str = {'a','b','c','b'};
////        char[] str = {'S','L','H','E','C','C','E','I','D','E','J','F','G','G','F','I','E'};
////        char[] str = {'S','G','G','F','I','E','C','V','A','A','S','A','B','C','E','H','J','I','G','Q','E','M'};
////        for(int i= 0;i<5; i++) {
////            for (int j = 0; j < 8; j++) {
////                System.out.print(matrix[i * 8 + j] + "\t");
////            }
////            System.out.println();
////        }
////        System.out.println(solution.hasPath(matrix,5,8, str));
//
////        System.out.println(solution.movingCount(10, 1, 100));
//
////        System.out.println(solution.integerBreak(10));
//
////        System.out.println(solution.Power2(2.0, 10));
//
////        solution.print1ToMaxOfNDigits(2);
//
////        System.out.println(solution.deleteDuplication());
////        char[] str = {'a','b'};
////        char[] pattern = {'a','b','.','*'};
////        System.out.println(solution.match(str, pattern));
//
////        ListNode head = new ListNode(1);
////        head.next = new ListNode(2);
////        head.next.next = new ListNode(3);
////        head.next.next.next = new ListNode(4);
////        System.out.println(solution.ReverseList_iteration(head));
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);list.add(2);list.add(3);list.add(4);
//        System.out.println(list);
//    }
//

import java.util.*;

//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] a = new int[n], b = new int[n];
//        int ans = 0;
//        for(int i = 0; i < 2 * n; i++){
//            if(i < n)
//                a[i] = sc.nextInt();
//            else
//                b[i - n] = sc.nextInt();
//        }
//        Arrays.sort(a);
//        Arrays.sort(b);
//        for(int i = 0; i < n; i++) {
//            ans += a[i] * b[n - i - 1];
//        }
//        System.out.println(ans);
//    }

//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String in = sc.next();
//        ArrayList<Character> chars = new ArrayList<>();
//        int[] dump = new int[26];
//        for (int i = 0; i < in.length(); i++) {
//            char c = in.charAt(i);
//            if (c < 97)
//                c = (char) ((int) c + 32);
//            chars.add(c);
//            dump[c - 97]++;
//        }
//        int min = chars.get(0);
//        for (int i = 0; i < chars.size(); i++) {
//            if(dump[chars.get(i) - 97] == 2) {
//                if (i < chars.size() - 1 && chars.get(i + 1) < min)
//                    min = chars.get(i + 1);
//            }
//            else {
//                if (i < chars.size() - 1 && chars.get(i + 1) < min)
//                    min = chars.get(i + 1);
//                break;
//            }
//        }
//        System.out.println((char) min);
//    }
//}

//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//            int d = sc.nextInt();
//            ArrayList<Bank> banks = new ArrayList<>();
//            for(int i = 0; i < n; i++){
//                Bank bank = new Bank();
//                String[] info = sc.nextLine().split(" ");
//                bank.addr = Integer.parseInt(info[0]);
//                bank.money = Double.parseDouble(info[1]);
//                banks.add(bank);
//        }
//        Collections.sort(banks, new Comparator<Object>() {
//            public int compare(Object o1, Object o2) {
//                Bank b1 = (Bank) o1;
//                Bank b2 = (Bank) o2;
//                if (b1.money > b2.money)
//                    return -1;
//                if (b1.money < b2.money)
//                    return 1;
//                else return 0;
//            }
//        });
//        double[] dp;
//        for(int i = 0; i < banks.size(); i++) {
//
//        }
//
//
//    }
//}
//class Bank {
//    int addr;
//    double money;
//}

public class Main {
    private HashMap<Character, Character> mappings;

    public Main() {
        this.mappings = new HashMap<>();
        this.mappings.put(')', '(');
    }
    public int isValid(String s) {
        boolean flag = false;
        Stack<Character> stack = new Stack<>();
        int res = 0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(this.mappings.containsKey(c)) {
                char topElement = stack.empty()?'#':stack.pop();
                res ++;
            }else {
                stack.push(c);
            }
        }
        return res;
    }
}