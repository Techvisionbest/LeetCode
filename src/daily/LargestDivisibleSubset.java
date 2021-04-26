package com.leetcode.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    

    public List<Integer> solution(int[] nums){
        int length = nums.length;
        int[] arr = Arrays.copyOf(nums, nums.length);

        for (int i = 1; i < arr.length; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;

            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }

        // 对于数组dp，我们这么定义，dp[n]表示对于数组nums表示前n个元素最大整除子集元素数量
        int[] dp = new int[length + 1];
        List<Integer> results = new ArrayList<>();
        dp[0] = 0;
        dp[1] = 0;
        
        for(int i = 2; i <= length; i++){
            int add;
            if(arr[i - 1] % arr[i - 2] == 0) {
                add = dp[i - 1] + 1;
            }else{
                add = dp[i - 1];
            }
            int giveUp = dp[i - 1];
            if(add > giveUp){
                if(results.isEmpty()){
                    results.add(arr[i - 2]);
                }
                results.add(arr[i - 1]);
            }
            dp[i] = Math.max(add, giveUp);
        }
        if(results.isEmpty() ){
            results.add(arr[0]);
        }

        System.out.println(dp[length]);
        return results;

    }
}
