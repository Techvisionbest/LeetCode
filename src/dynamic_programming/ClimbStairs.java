package dynamic_programming;

public class ClimbStairs {

    public int solution(int n){
        if (n == 0) return 1;
        if (n == 1) return 1;
        return solution(n - 1) + solution(n-2);
    }
}
