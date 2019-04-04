package nowcoderOJ;

import java.util.*;
public class Main {
    private boolean judge(int[] input) {
        int pre = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        int next = 0;
        while(next < input.length || !stack.empty()) {
            while(next < input.length && input[next] != 0) {
                stack.add(next);
                next = 2 * next + 1;
            }
            next = stack.pop();
            if(pre < input[next]) {
                pre = input[next];
            }
            else return false;
            next = 2 * next + 2;
        }
        return true;
    }

    public static void main(String[] args) {
        int i = 0;
        Scanner in = new Scanner(System.in);
        String[] strings = in.next().split(",");
        int[] input = new int[strings.length];
        for(String val:strings) {
            if ("None".equals(val)) input[i++] = 0;
            else input[i++] = Integer.parseInt(val);
        }
        Main m = new Main();
        if(m.judge(input)) System.out.println("True");
        else System.out.println("False");
    }
}
