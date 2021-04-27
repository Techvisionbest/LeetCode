package daily;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 链接：https://leetcode-cn.com/problems/range-sum-of-bst/
 */
public class RangeSumBST {
    /**
     * 深度优先搜索
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int solution(TreeNode root, int low, int high){
        if (root == null)
            return 0;
        if (root.val > high){
            return solution(root.left, low, high);
        }
        if (root.val < low){
            return solution(root.right, low, high);
        }
        return root.val + solution(root.left, low, high) + solution(root.right, low, high);
    }

    /**
     * 广度优先搜索
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int solution2(TreeNode root, int low, int high){
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode current = q.poll();
            if (current == null){
                continue;
            }
            if (current.val > high){
                q.offer(current.left);
            }else if (current.val < low){
                q.offer(current.right);
            }else{
                sum += current.val;
                q.offer(current.left);
                q.offer(current.right);
            }
        }
        return sum;
    }

}
