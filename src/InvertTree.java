/**
 * @LeetCode https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * 题目：
 * 反转一棵二叉树。
 * 示例：
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 */
public class InvertTree {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  public TreeNode solution(TreeNode root){
        if (root == null){
            return null;
        }
        TreeNode left = solution(root.left);
        TreeNode right = solution(root.right);
        root.left = right;
        root.right = left;
        return root;
  }
}
