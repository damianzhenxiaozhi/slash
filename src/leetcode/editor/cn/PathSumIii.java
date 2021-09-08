//给定一个二叉树，它的每个结点都存放着一个整数值。 
//
// 找出路径和等于给定数值的路径总数。 
//
// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。 
//
// 示例： 
//
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 908 👎 0


package leetcode.editor.cn;

import java.util.*;

public class PathSumIii {
    public static void main(String[] args) {
        Solution s = new PathSumIii().new Solution();
        MyBinaryTree tree = new MyBinaryTree(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1});
        int targetSum = 8;
        System.out.println(s.pathSum(tree.getRoot(), targetSum));
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        private int count;

        public int pathSum(TreeNode root, int targetSum) {
            count = 0;
            backtrace(root, targetSum);
            return count;
        }

        private Map<Integer, Integer> backtrace(TreeNode root, int targetSum) {
            if (root == null) {
                return Collections.emptyMap();
            }

            Map<Integer, Integer> rootSum = new HashMap<>();
            if (root.left != null) {
                Map<Integer, Integer> leftSum = backtrace(root.left, targetSum);
                for (Map.Entry<Integer, Integer> entry : leftSum.entrySet()) {
                    int val = entry.getKey() + root.val;
                    rootSum.put(val, rootSum.getOrDefault(val, 0) + entry.getValue());
                    if (val == targetSum) {
                        count += entry.getValue();
                    }
                }
            }

            if (root.right != null) {
                Map<Integer, Integer> rightSum = backtrace(root.right, targetSum);
                for (Map.Entry<Integer, Integer> entry : rightSum.entrySet()) {
                    int val = entry.getKey() + root.val;
                    rootSum.put(val, rootSum.getOrDefault(val, 0) + entry.getValue());
                    if (val == targetSum) {
                        count += entry.getValue();
                    }
                }
            }

            rootSum.put(root.val, rootSum.getOrDefault(root.val, 0) + 1);
            if (root.val == targetSum) {
                count += 1;
            }

            return rootSum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
