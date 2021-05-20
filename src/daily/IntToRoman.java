package daily;

import java.util.HashMap;

/**
 * 链接：https://leetcode-cn.com/problems/integer-to-roman/
 * TODO 贪心算法
 */
public class IntToRoman {
    public String solution(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        int length = nums.length;
        int arr[] = new int[4];
        for (int i = 0; i < length; i++) {
            arr[4- length +i] = Character.getNumericValue(nums[i]);
        }
        StringBuilder sb = new StringBuilder();

        while (arr[0] > 0){
            sb.append(map.get(1000));
            arr[0]--;
        }
        while (arr[1] > 0){
            if (arr[1] >= 9){
                sb.append("CM");
                arr[1] = 0;
                continue;
            }
            if (arr[1] >= 5){
                sb.append("D");
                arr[1] = arr[1] - 5;
                continue;
            }
            if (arr[1] >= 4){
                sb.append("CD");
                arr[1] = 0;
                continue;
            }
            sb.append(map.get(100));
            arr[1]--;
        }
        while (arr[2] > 0){
            if (arr[2] >= 9){
                sb.append("XC");
                arr[2] = 0;
                continue;
            }
            if (arr[2] >= 5){
                sb.append("L");
                arr[2] = arr[2] - 5;
                continue;
            }
            if (arr[2] >= 4){
                sb.append("XL");
                arr[2] = 0;
                continue;
            }
            sb.append(map.get(10));
            arr[2]--;
        }
        while (arr[3] > 0){
            if (arr[3] >= 9){
                sb.append("IX");
                arr[3] = 0;
                continue;
            }
            if (arr[3] >= 5){
                sb.append("V");
                arr[3] = arr[3] - 5;
                continue;
            }
            if (arr[3] >= 4){
                sb.append("IV");
                arr[3] = arr[3] - 4;
                continue;
            }
            sb.append(map.get(1));
            arr[3]--;
        }
        return sb.toString();
    }
}
