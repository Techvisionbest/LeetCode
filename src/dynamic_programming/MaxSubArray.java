package dynamic_programming;

/**
 * 题目：
 *
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 *
 * 示例：
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaxSubArray {

    // 状态定义：
    // 设动态规划列表dp，dp[i] 代表以元素nums[i]为结尾的连续子数组最大和
    // 状态转移方程：
    // dp[i] = if (dp[i-1] > 0) dp[i-1] + nums[i] else nums[i]
    // 初始状态(base case)：
    // dp[0] = nums[0]


    public int solution(int[] nums) {
        // 动态压缩
        int max = nums[0];
        int prev = 0;
        int cur = nums[0];
        for (int i = 0; i < nums.length; i++){
            cur = nums[i];
            if (prev > 0) cur += prev;
            max = Math.max(cur, max);
            prev = cur;
        }
        return max;
    }


}
