package backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author vision
 * @since 2020/09/16
 */
public class CombinationSum {

    private List<List<Integer>> res = new LinkedList<>();
    private int[] candidates;

    public List<List<Integer>> solution(int[] candidates, int target){
        this.candidates = candidates;
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(track, target,0);
        return res;
    }

    private void backtrack(LinkedList<Integer> track, int target, int index){

        if (index == candidates.length){
            return;
        }

        if (target < 0){
            return;
        }

        if (target == 0){
            res.add(new LinkedList<>(track));
            return;
        }
        backtrack(track, target, index + 1);
        if (target - candidates[index] >= 0){
            track.add(candidates[index]);
            backtrack(track, target - candidates[index], index);
            track.removeLast();
        }

    }

}
