package backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @LeetCode https://leetcode-cn.com/problems/combination-sum-ii/
 *
 * 题目：
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 示例：
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * @author vision
 * @since 2020/09/10
 */
public class CombinationSum2 {

    private List<List<Integer>> res = new LinkedList<>();
    private int[] candidates;
    private int target;

    public List<List<Integer>> solution(int[] candidates, int target){
        this.candidates = candidates;
        this.target = target;
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(track);
        return res;
    }

    void backtrack(LinkedList<Integer> track){

        // 结束条件
        int sum = 0;
        for (int num : track){
            sum += num;
        }
        if (sum == target){
            res.add(track);
            return;
        }
        if (sum > target){
            return;
        }

        for (int i = 0; i < candidates.length; i++){
            if (track.contains(candidates[i])){
                continue;
            }
            track.add(candidates[i]);
            backtrack(track);
            track.removeLast();
        }
    }
}