package com.leetcode.daily;

/**
 * 题目描述： 
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。 
 * 说明：
 * 为什么返回数值是整数，但输出的答案是数组呢? 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 你可以想象内部操作如下: 
 * 示例1: 输入：nums = [3,2,2,3], val = 3 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而
 * nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。 
 * 示例2: 
 * 输入：nums =[0,1,2,2,3,0,4,2], val = 2 输出：5, nums = [0,1,4,0,3] 解释：函数应该返回新的长度 5, 并且 nums
 * 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。 
 * 提示： 
 * 0 <=nums.length <= 100 0 <= nums[i] <= 50 0 <= val <= 100
 * 
 * 题目链接：https://leetcode-cn.com/problems/remove-element/
 */
public class RemoveElement {

    public int solution(int[] nums, int val) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            // 如果 nums[i] 与 val 相等，说明该元素应当被移除
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        printNums(nums, left);
        return left;
    }

    public int solution2(int[] nums, int val) {
        int left = 0, right = nums.length;
        while(left < right){
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        printNums(nums, left);
        return left;
    }

    private void printNums(int[] nums, int size){
        if (size != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            for (int i = 0; i < size; i++) {
                sb.append(String.valueOf(nums[i]));
                if(i != size -1){
                    sb.append(",");
                }
            }
            sb.append("}");
            System.out.println(sb);
        }
    }
}