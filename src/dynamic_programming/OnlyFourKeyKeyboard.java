package dynamic_programming;

import java.util.HashMap;

/**
 * 题目：
 * <p>
 * 假设你有一个特殊的键盘包含下面的按键：
 * Key 1：在屏幕上打印一个'A'。
 * Key 2：(Ctrl - A)：选中整个屏幕。
 * Key 3：(Ctrl - C)：复制选中区域到缓冲区。
 * Key 4：(Ctrl - V)：将缓冲区内容输出到上次输入的结束位置，并显示在屏幕上。
 * 现在，你只可以按键N次（使用上述四种按键），请问屏幕上最多可以显示几个'A'呢？
 * <p>
 * 示例：
 * <p>
 * 输入：N = 7
 * 输出：9
 * 解释：
 * 我们最多可以在屏幕上显示九个'A'，通过以下顺序按键：
 * A，A，A，Ctrl A，Ctrl C，Ctrl V，Ctrl V
 */
public class OnlyFourKeyKeyboard {

    private static HashMap<Integer, Integer> memo = new HashMap<>();

    public static int solution(int N) {
        // 初始状态：剩余N次按键机会， 此时屏幕上有 0 个 'A'，缓冲区有 0 个 'A'
        return dp(N, 0, 0);
    }

    /**
     * 定义状态：
     * <p>
     * 对于(n, nums, copy)这个状态，屏幕上最多能有dp(n, nums, copy)个 'A'
     * <p>
     * 由于题目要求'A'的个数最多
     * 我们可以认为 Ctrl A 和 Ctrl C 是一定会一起按的，所以，每次按键都有三种可能：
     * 1、A： 此时剩余按键次数为N-1， 缓冲区A个数不变，屏幕上A的个数加1
     * 2、Ctrl A + Ctrl C：此时剩余按键次数为 N - 2，缓冲区A个数为 nums + copy， 屏幕上A的个数不变
     * 3、Ctrl V：此时剩余按键次数为 N - 1，缓冲区个数不变， 屏幕上A的个数变为 nums + copy
     *
     * @param N    剩余按键次数
     * @param nums 屏幕上'A'的个数
     * @param copy 缓冲区中'A'的个数
     * @return
     */
    private static int dp(int N, int nums, int copy) {
        // base case
        if (N <= 0) {
            return nums;
        }
        if (memo.containsKey(N)) {
            return memo.get(N);
        }
        int pressA = dp(N - 1, nums + 1, copy);
        int pressAAndC = dp(N - 2, nums, copy + nums);
        int pressV = dp(N - 1, nums + copy, copy);
        int max = Math.max(pressA, pressAAndC);
        max = Math.max(max, pressV);
        memo.put(N, max);
        return max;
    }
}
