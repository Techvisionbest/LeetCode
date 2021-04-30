package daily;

import java.util.HashMap;
import java.util.Map;

/**
 * 链接：https://leetcode-cn.com/problems/single-number-ii/
 */
public class SingleNumber {

    public int solution(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int ans = 0;
        for (Map.Entry entry : map.entrySet()){
            int num = (int) entry.getKey(), count = (int) entry.getValue();
            if (count == 1){
                ans = num;
                break;
            }
        }
        return ans;
    }

    public int solution2(int[] nums){
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }
}
