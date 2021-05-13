package daily;

/**
 * 链接：https://leetcode-cn.com/problems/xor-queries-of-a-subarray/
 */
public class XORQueries {
    public int[] solution(int[] arr, int[][] queries) {
        int n = arr.length;
        int pre[] = new int[n + 1];
        // 计算前缀和
        for (int i = 1; i < n + 1; i++) {
            pre[i] = pre[i - 1] ^ arr[i - 1];
        }
        int[] ans = new int[queries.length];
        int i = 0;
        for (int[] query : queries){
            ans[i++] = pre[query[0]] ^ pre[query[1] + 1];
        }
        return ans;
    }
}
