package dynamic_programming;

/**
 * 背包问题
 * 题目：
 *
 * 给你⼀个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性。
 * 其中第 i 个物品的重量为 wt[i] ，价值为 val[i] ，现在让你⽤这个背包装物品，
 * 最多能装的价值是多少？
 *
 * 示例：
 *
 * N = 3, W = 4
 * wt = [2, 1, 3]
 * val = [4, 2, 3]
 *
 * 输出：6
 *
 * 解释：选择前两件物品装进背包，总重量3小于w，可以获得最大价值6。
 *
 */
public class Package {

    private int[] weights;
    private int[] values;

    public int solution(int w, int n, int[] weights, int[] values){
        this.weights = weights;
        this.values = values;
        return dp(w, n);
    }

    /**
     * 动态转移方程
     *
     * @param W 背包剩余容量
     * @param n 可选择的物品
     * @return 当背包容量为w，可选择的前n件物品时背包能装的最大价值
     */
    private int dp(int W, int n){
        // base case
        if (W <= 0 || n == 0) return 0;
        for (int i = 1; i <= n; i++){
            for (int w = 1; w <= W; w++){
                // 背包容量不够，只能选择不装
                if (w < weights[i - 1]){
                    return dp(w, i - 1);
                }else{
                    // 做出选择：装 or 不装
                    int valueSelected = dp(w - weights[i-1], i-1) + values[i-1];
                    int valueUnSelected = dp(w, i-1);
                    return Math.max(valueSelected, valueUnSelected);
                }
            }
        }
        return 0;
    }
}
