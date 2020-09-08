import java.util.HashMap;
import java.util.Map;

/**
 * @LeetCode https://leetcode-cn.com/problems/two-sum/
 *
 * @since 2020/09/08
 * @author vision
 */
public class TwoSum {

    public int[] solution(int[] nums, int target){

        Map<Integer, Integer> map = new HashMap(nums.length);

        for (int i = 0; i < nums.length; i++){
            int res = target - nums[i];
            if (map.containsKey(res)){
                return new int[]{i, map.get(res)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
