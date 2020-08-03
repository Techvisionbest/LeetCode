import java.util.HashMap;

/**
 * 题目：
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例：
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 */
public class CoinChange {

    HashMap<Integer, Integer> memo = new HashMap<>();

    public int coinChange(int[] coins, int amount) {

        if (memo.containsKey(amount)){
            return memo.get(amount);
        }

        if (amount < 0){
            return -1;
        }

        if (amount == 0){
            return 0;
        }

        int res = Integer.MAX_VALUE;

        for (int coin : coins){

            int subproblem = coinChange(coins, amount - coin);
            if (subproblem == -1) continue;
            res = Math.min(res, 1 + subproblem);
        }

        if (res != Integer.MAX_VALUE){
            memo.put(amount, res);
            return res;
        }else{
            memo.put(amount, -1);
            return -1;
        }

    }
}
