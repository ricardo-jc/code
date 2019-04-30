package leetCode;

import java.util.*;

public class ThreeSum_15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            for(int i = 0; i < nums.length - 1; i++) {
                int a = nums[i];
                if(i > 0 && nums[i] == nums[i - 1]) continue;
                int l = i + 1, r = nums.length - 1;
                while(l < r) {
                    int sum = a + nums[l] + nums[r];
                    if(sum < 0) l += 1;
                    else if(sum > 0) r -= 1;
                    else {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(a);
                        ans.add(nums[l]);
                        ans.add(nums[r]);
                        res.add(ans);
                        while(l < r && nums[l + 1] == nums[l]) l++;
                        while(l < r && nums[r - 1] == nums[r]) r--;
                        l++;r--;
                    }
                }
            }
            return res;
        }
    }
    public static void main(String[] args) {
        ThreeSum_15 t = new ThreeSum_15();
        Solution s = t.new Solution();
        System.out.println(s.threeSum(new int[]{-2, 0, 1, 1, 2}));
    }
}
