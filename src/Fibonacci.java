import java.util.HashMap;

/**
 * 斐波那契数列
 */
public class Fibonacci {

    public int fib(int N) {

        if (N < 0) {
            throw new IllegalArgumentException("N can not less than zero");
        }


        // base case
        if (N < 2) return N;

        int prev = 1, curr = 1;

        // 状态压缩，使空间复杂度从 O(n) -> O(1)
        for (int i = 3; i <= N; i ++){
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;

    }
}
