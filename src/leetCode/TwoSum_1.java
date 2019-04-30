package leetCode;

import java.util.*;

public class TwoSum_1 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++) {
                map.put(nums[i],i);
            }
            int[] res = new int[2];
            for(int i = 0; i < nums.length; i++) {
                if(map.containsKey(target - nums[i])) {
                    res[0] = i;
                    res[1] = map.get(target - nums[i]);
                    if(res[0] == res[1]) continue;
                    return res;
                }
            }
            return res;
        }
    }
    public static void main(String[] args) {
        TwoSum_1 t = new TwoSum_1();
        Solution s = t.new Solution();
        int[] nums = new int[]{3,2,4};
        for(Integer i:s.twoSum(nums, 6)) System.out.println(i);
    }
}
