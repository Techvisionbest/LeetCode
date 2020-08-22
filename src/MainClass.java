import dynamic_programming.MinEditDistance;
import dynamic_programming.OnlyFourKeyKeyboard;
import dynamic_programming.Package;

public class MainClass {

    public static void main(String[] args){
        int[] weights = {2,1,3};
        int[] values = {4,2,3};
        System.out.println(new Package().solution(4, 3, weights, values));
    }
}
