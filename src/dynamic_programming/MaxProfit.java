package dynamic_programming;

/**
 * 题目：
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 *
 * 示例：
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 */
public class MaxProfit {


    /**
     * 暴力解法
     * 时间复杂度：O(n2)
     * 空间复杂度：O(1)
     *
     * @param prices
     * @return
     */
    private int violenceSolution(int[] prices){

        int max = 0;

        for (int i = 0; i < prices.length; i++){
            for (int j = i + 1; j < prices.length; j++){
                if (prices[i] > prices[j]){
                    continue;
                }
                max = Math.max(max, prices[j] - prices[i]);
            }
        }

        return max;
    }

//    private int solution(int[] prices){
//
//    }
}
