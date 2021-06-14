package daily;

/**
 * link:https://leetcode-cn.com/problems/guess-number-higher-or-lower/
 */
public class GuessGame {

    private final int correctGuess = 6;

    public int guessNumber(int n) {
        int pick = n / 2;
        int scope = Math.max(n / 2, 1);
        while(guess(pick) != 0){
            scope = Math.max(scope / 2, 1);
            if(guess(pick) == -1){
                pick -= scope;
            }
            if(guess(pick) == 1){
                pick += scope;
            }
            if(guess(pick) == 0){
                break;
            }

        }
        return pick;
    }

    private int guess(int guess){
        if (guess < correctGuess){
            return 1;
        }
        if (guess > correctGuess){
            return -1;
        }
        return 0;
    }
}
