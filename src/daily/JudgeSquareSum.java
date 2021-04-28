package daily;

/**
 * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers/
 */
public class JudgeSquareSum {

    /**
     * 穷举
     * @param c
     * @return
     */
    private boolean solution(int c){
        for (long a = 0; a * a <= c; a++){
            double b = Math.sqrt(c - a * a);
            if (b == (int) b){
                return true;
            }
        }
        return false;
    }

    /**
     * 双指针
     * @param c
     * @return
     */
    private boolean solution2(int c){
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left <= right) {
            int sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }


}
