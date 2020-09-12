import backtracking.CombinationSum2;
import dynamic_programming.*;
import dynamic_programming.Package;

public class MainClass {

    public static void main(String[] args){
        int[] nums = {1,3,2};
        int target = 3;
        System.out.println(new CombinationSum2().solution(nums, target));
    }
}
