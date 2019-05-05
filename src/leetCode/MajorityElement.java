package leetCode;

import java.util.HashMap;

public class MajorityElement {
    class Solution {
        public int majorityElement(int[] nums) {
            if(nums.length == 1) return nums[0];
            HashMap<Integer, Integer> map = new HashMap<>();
            for(Integer num:nums) {
                Integer count = map.get(num);
                if(count == null) map.put(num, 1);
                else {
                    if(count + 1 > nums.length / 2) return num;
                    map.put(num, count + 1);
                }
            }
            return -1;
        }
    }
}
