package dynamic_programming;

import java.util.HashSet;

/**
 * 最低票价
 *
 * @author vision
 * @link https://leetcode-cn.com/problems/minimum-cost-for-tickets/
 * @since 2020/09/02
 */
public class MinCostTickets {

    public int solution(int[] days, int[] cost) {
        int dayCount = days[days.length - 1];
        HashSet<Integer> daySet = new HashSet<>();
        for (int day : days) {
            daySet.add(day);
        }
        int[] dp = new int[dayCount + 1];
        if (dayCount == 0) return 0;
        if (dayCount == 1) {
            return Math.min(cost[0], Math.min(cost[1], cost[2]));
        }

        dp[0] = 0;
        dp[1] = Math.min(cost[0], Math.min(cost[1], cost[2]));

        for (int i = 2; i < dayCount + 1; i++) {
            if (daySet.contains(i)) {
                int oneCost, sevenCost, thirtyCost;
                oneCost = dp[i - 1] + cost[0];

                if (i <= 7) {
                    sevenCost = 0 + cost[1];
                } else {
                    sevenCost = dp[i - 7] + cost[1];
                }

                if (i <= 30) {
                    thirtyCost = 0 + cost[2];
                } else {
                    thirtyCost = dp[i - 30] + cost[2];
                }
                dp[i] = Math.min(oneCost, Math.min(sevenCost, thirtyCost));
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dayCount];
    }
}
