package daily;

/**
 * https://leetcode-cn.com/problems/total-hamming-distance/
 */
public class TotalHammingDistance {
    public int solution(int[] nums) {
        int length = nums.length, ans = 0;
        // 元素的范围： 0到 10^9
        for (int i = 0; i < 30; i++) {
          int bit = 0;
          for (int val: nums){
              bit += (val >> i) & i;
          }
          ans += bit * (length - bit);
        }
        return ans;
    }
}
