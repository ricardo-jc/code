package leetCode;

public class MyPow_50 {
    class Solution {
        public double myPow_recursion(double x, int n) {
            if(n < 0) return 1/(myPow_recursion(x, -n - 1)*x);
            if(n == 0) return 1;
            if(n == 1 || x == 1) return x;
            double y = myPow_recursion(x, n/2);
            if(n % 2 == 0) return y*y;
            else return y*y*x;
        }
        public double myPow(double x, int n) {
            if(n < 0) return 1/(myPow(x, -n-1) * x);
            if(n == 0) return 1;
            if(n == 1 || x == 1) return x;
            double pow = 1;
            int t = n;
            while(t > 0) {
                if((t & 1) == 1) pow *= x;
                x *= x;
                t >>= 1;
            }
            return pow;
        }
    }
    public static void main(String[] args){
        System.out.println(new MyPow_50().new Solution().myPow(2, -2));
    }
}
