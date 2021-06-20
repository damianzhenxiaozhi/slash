//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 1101 👎 0


package leetcode.editor.cn;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution s = new ValidateBinarySearchTree().new Solution();
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
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }

            long[] result = isValidBstRec(root);
            return result != null;
        }

        private long[] isValidBstRec(TreeNode root) {
            if (root == null) {
                return new long[] {Long.MIN_VALUE, Long.MAX_VALUE};
            }

            long[] leftValues = isValidBstRec(root.left);
            if (leftValues == null) {
                return null;
            }

            long[] rightValues = isValidBstRec(root.right);
            if (rightValues == null) {
                return null;
            }

            if (leftValues[0] == Long.MIN_VALUE) {
                leftValues[0] = root.val;
            }

            if (rightValues[1] == Long.MAX_VALUE) {
                rightValues[1] = root.val;
            }

            if (leftValues[1] != Long.MAX_VALUE && root.val <= leftValues[1]) {
                return null;
            }

            if (rightValues[0] != Long.MIN_VALUE && root.val >= rightValues[0]) {
                return null;
            }

            return new long[]{leftValues[0], rightValues[1]};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}