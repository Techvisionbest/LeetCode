import dynamic_programming.*;
import dynamic_programming.Package;

public class MainClass {

    public static void main(String[] args){
        int[] days = {1,2,3,4,5,6,7,8,9,10,30,31};
        int[] costs = {2, 7, 15};
        System.out.println(new MinCostTickets().solution(days, costs));
    }
}
