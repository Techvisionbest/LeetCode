package dynamic_programming;

/**
 * 题目：
 * <p>
 * 给定两个字符串 s1 和 s2，计算出将 s1 转换成 s2 所使用的最少操作数。
 * 你可以对一个字符串进行如下三种操作：
 * <p>
 * 1、插入一个字符
 * 2、删除一个字符
 * 3、替换一个字符
 * <p>
 * 示例
 * <p>
 * 输入：s1 = “horse”，s2 = “ros”
 * 输出：3
 * 解释：
 * horse -> rorse （将 h 替换成 r）
 * rorse -> rose（删除r）
 * rose -> ros（删除e）
 */
public class MinEditDistance {

    public int solution(String s1, String s2) {
        int minCount = dp(s1.length() - 1, s1, s2.length() - 1, s2);
        System.out.println(minCount);
        return minCount;
    }


    /**
     * 状态转移方程
     * @param i
     * @param s1
     * @param j
     * @param s2
     * @return
     */
    private int dp(int i, String s1, int j, String s2) {
        if (i == -1) return j + 1;
        if (j == -1) return i + 1;
        if (getString(s1, i).contains(getString(s2, j))) {
            return dp(i - 1, s1, j - 1, s2);
        } else {
            int countInsert = dp(i, s1, j - 1, s2) + 1;
            int countDelete = dp(i-1, s1, j, s2) + 1;
            int countReplace = dp(i - 1, s1, j - 1, s2) + 1;
            int minCount = Math.min(countInsert, countDelete);
            minCount = Math.min(countReplace, minCount);
            return minCount;
        }
    }

    /**
     * 获取字符串指定位置的字符
     *
     * @param s
     * @param index
     * @return
     */
    private String getString(String s, int index) {
        return s.substring(index, index + 1);
    }

}
