package dynamic_programming;

/**
 * 最长公共子序列：
 * @link https://leetcode-cn.com/problems/longest-common-subsequence
 *
 * @author vision
 * @since 20/08/28
 */
public class LongestCommonSubseq {

    public int solution(String text1, String text2){
        char[] array1 = text1.toCharArray();
        char[] array2 = text2.toCharArray();
        int length1 = array1.length + 1;
        int length2 = array2.length + 1;
        int[][] dp = new int[length1][length2];
        for (int i = 0; i < length1; i++){
            dp[i][0] = 0;
        }
        for (int j = 0; j < length2; j++){
            dp[0][j] = 0;
        }
        for (int i = 1; i < length1; i++){
            for (int j = 1; j < length2; j++){
                if (array1[i - 1] == array2[j - 1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[length1 - 1][length2 - 1];
    }
}
