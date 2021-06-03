package daily;

import java.util.HashMap;

public class FindMaxLength {
    public int findMaxLength(int[] nums){
        int size = nums.length, maxLength = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (nums[i] == 1){
                counter++;
            }else{
                counter--;
            }
            if (map.containsKey(counter)) {
                int prevIndex = map.get(counter);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                map.put(counter, i);
            }
        }
        return maxLength;

    }
}
