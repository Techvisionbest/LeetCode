package dynamic_programming;

/**
 * 题目：
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 *
 * 示例 1:
 * 输入:
 *
 * "bbbab"
 * 输出:
 *
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 *
 * 示例 2:
 * 输入:
 *
 * "cbbd"
 * 输出:
 *
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 只包含小写英文字母
 */
public class LongestPalindromeSubseq {

    private String s;

    public int solution(String s){
        this.s = s;
        return dp(0, s.length() - 1);
    }

    private int dp(int i, int j){

        if (i == j) return 1;
        if (i < j) return 0;
        if (getString(i).contains(getString(j))){
            return dp(i + 1, j-1) + 2;
        }else{
            return Math.max(dp(i + 1, j), dp(i, j - 1));
        }
    }

    /**
     * 获取字符串指定位置的字符
     *
     * @param index
     * @return
     */
    private String getString(int index) {
        return s.substring(index, index + 1);
    }
}
