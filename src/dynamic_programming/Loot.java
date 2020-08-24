package dynamic_programming;

/**
 * 打家劫舍：
 * 题目：
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 示例1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 示例2:
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 */
public class Loot {

    private int nums[];

    public int solution(int[] nums){
        this.nums = nums;
        return dp(nums.length);
    }

    // TODO 重叠子问题、状态压缩
    private int dp(int n){
        // base case
        if (n <= 0){
            return 0;
        }
        // 对于第 n 个房屋，小偷可以选择偷 or 不偷，取金额最大
        int ifSteal = dp(n - 2) + nums[n-1];
        int unSteal = dp(n-1);
        return Math.max(ifSteal, unSteal);
    }
}
