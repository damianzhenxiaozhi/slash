//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 897 👎 0


package leetcode.editor.cn;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution s = new BinaryTreeLevelOrderTraversal().new Solution();
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
        private List<List<Integer>> values = new ArrayList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }

            levelOrder_r(root);

            return values;
        }

        private void levelOrder_r(TreeNode root) {
            values = new ArrayList<>();

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            int count = 1;
            while (!queue.isEmpty()) {
                List<Integer> layerValues = new ArrayList<>();
                while (count-- > 0) {
                    TreeNode node = queue.poll();
                    layerValues.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }

                values.add(layerValues);
                count = queue.size();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}