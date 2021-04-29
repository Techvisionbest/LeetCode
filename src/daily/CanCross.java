package daily;

/**
 * https://leetcode-cn.com/problems/frog-jump/
 */
public class CanCross {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        // 定义状态,dp[i][j]表示：青蛙能否到达 编号为i的石子，且上次跳跃距离为j
        boolean [][] dp = new boolean[n][n];
        // base case:表示青蛙能够到达编号为0的石子，且上次跳跃距离为0(即初始状态)
        dp[0][0] = true;
        // 优化1
        for (int i = 1; i < n; ++i) {
            if (stones[i] - stones[i-1] > i){
                return false;
            }
        }
        for (int i = 1; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j){
                int k = stones[i] - stones[j];
                if (k > j + 1){
                    break;
                }
                // 状态转移方程
                dp[i][k] = dp[j][k-1] || dp[j][k] || dp[j][k+1];
                if (i == n-1 && dp[i][k]){
                    return true;
                }
            }
        }
        return false;

    }
}
