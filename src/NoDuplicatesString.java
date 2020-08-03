import java.util.HashMap;
import java.util.HashSet;

/**
 * 题目：
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例：
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class NoDuplicatesString {

    /**
     * MySolution
     *
     * @param s
     * @return
     */
    public static final int lengthOfLongestSubstring(String s) {
        if (s.length() == 0){
            return 0;
        }

        int length = s.length();
        int result = 0;
        int start = 0;
        int end = 0;
        HashSet<Character> subStringSet = new HashSet<>(s.length());
        subStringSet.add(s.charAt(0));
        while (start < length){
            while(end + 1 < length && !subStringSet.contains(s.charAt(end + 1))){
                subStringSet.add(s.charAt(end + 1));
                end ++;
            }
            result = Math.max(result, end - start + 1);
            if (end + 1 == length){
                break;
            }
            subStringSet.remove(s.charAt(start));
            start ++;
        }
        return result;
    }
}
