//给定一个二叉树，在树的最后一行找到最左边的值。 
//
// 示例 1: 
//
// 
//输入:
//
//    2
//   / \
//  1   3
//
//输出:
//1
// 
//
// 
//
// 示例 2: 
//
// 
//输入:
//
//        1
//       / \
//      2   3
//     /   / \
//    4   5   6
//       /
//      7
//
//输出:
//7
// 
//
// 
//
// 注意: 您可以假设树（即给定的根节点）不为 NULL。 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 184 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    public static void main(String[] args) {
        Solution s = new FindBottomLeftTreeValue().new Solution();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(s.findBottomLeftValue(root));
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
        public int findBottomLeftValue(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            int count = 1;
            int left = root.val;
            while (!queue.isEmpty()) {
                left = queue.peek().val;
                while (count-- > 0) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }

                count = queue.size();
            }

            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
