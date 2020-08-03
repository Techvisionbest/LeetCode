import java.util.HashMap;

/**
 * 斐波那契数列
 */
public class Fibonacci {

    // 「 备忘录，避免重叠字问题的计算 」
    HashMap<Integer, Integer> memo = new HashMap();

    public int fib(int N) {

        if (N < 0) {
            throw new IllegalArgumentException("N can not less than zero");
        }

        if (memo.containsKey(N)){
            return memo.get(N);
        }

        // base case
        if (N == 0) return 0;
        if (N == 1) return 1;

        memo.put(N, fib(N - 2) + fib(N - 1));

        return fib(N - 2) + fib(N - 1);

    }
}
