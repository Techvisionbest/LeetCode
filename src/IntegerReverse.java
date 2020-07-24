/*
 * 题目：
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例
 *
 * 输入: 123
 * 输出: 321
 *
 * 输入: 120
 * 输出: 21
 *
 */
public class IntegerReverse {

    public int reverse(int x) {
        int rev = 0;
        while (x != 0){
            int pop = x % 10;
            x /= 10;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
