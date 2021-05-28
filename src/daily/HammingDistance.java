package daily;

public class HammingDistance {
    public int solution(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
