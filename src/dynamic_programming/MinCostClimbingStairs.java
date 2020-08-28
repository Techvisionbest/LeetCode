package dynamic_programming;

public class MinCostClimbingStairs {

    public int solution(int[] cost){

        int stairsCount = cost.length;
        int[] dp = new int[stairsCount + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= stairsCount - 1; i++){
            int costSingle = dp[i - 1] + cost[i];
            int costDouble = dp[i - 2] + cost[i];
            dp[i] = Math.min(costSingle, costDouble);
        }
        return dp[cost.length - 1];
    }

//    private int dp(int n){
//
//        if (n == 0) return 0;
//        if (n == 1) return 0;
//        return Math.min(dp(n - 2) + )
//    }
}
