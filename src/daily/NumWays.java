package daily;

/**
 * 链接:https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/
 *
 * TODO 状态压缩
 */
public class NumWays {

    public int solution(int steps, int arrLen) {
        final int MODULO = 1000000007;
        // 指针下标一定不会超过 Math.min(arrLen -1, steps)
        int maxColumn = Math.min(arrLen -1, steps / 2);
        // dp[i][j]:表示在i步操作之后，指针位于下标j的方案数
        int[][] dp = new int[steps + 1][maxColumn + 1];
        // base case:dp[0][0] = 1,表示没有任何操作时，指针一定位于下标0处
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= maxColumn; j++) {
                dp[i][j] = dp[i-1][j];
                if (j - 1 >= 0){
                    dp[i][j] = (dp[i][j] + dp[i-1][j-1]) % MODULO;
                }
                if (j + 1 <= maxColumn){
                    dp[i][j] = (dp[i][j] + dp[i-1][j+1]) % MODULO;
                }
            }
        }
        return dp[steps][0];
    }
}
