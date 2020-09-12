package backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @LeetCode https://leetcode-cn.com/problems/permutations/
 *
 * @author vision
 * @since 2020/09/09
 */
public class Permute {

    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> solution(int[] nums){
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track){

        // 触发结束条件
        if (track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            // 题目要求不可重复，去除不合题意的选择
            if (track.contains(nums[i])){
                continue;
            }
            // 做出决策
            track.add(nums[i]);
            backtrack(nums, track);
            // 撤销决策
            track.removeLast();
        }
    }
}
