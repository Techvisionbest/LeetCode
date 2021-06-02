package daily;

import java.util.HashMap;
import java.util.Map;

/**
 * link:https://leetcode-cn.com/problems/continuous-subarray-sum/
 */
public class CheckSubarraySum {
    /**
     * 暴力穷举(超时)
     * @param nums
     * @param k
     * @return
     */
    public boolean solution(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            int size = 1;
            for (int j = i+1; j < nums.length; j++) {
                sum += nums[j];
                size ++;
                if (sum % k == 0 && size >= 2){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 同余定理
     * @param nums
     * @param k
     * @return
     */
    public boolean solution1(int[] nums, int k){
        int m = nums.length;
        if (m < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < m; i++) {
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }
}
