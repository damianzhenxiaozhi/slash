//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 608 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution s = new BinaryTreePostorderTraversal().new Solution();
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
        private List<Integer> values;

        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }

            values = new ArrayList<>();
            postorderTraversal_r(root);

            return values;
        }

        private void postorderTraversal_r(TreeNode root) {
            if (root == null) {
                return;
            }

            postorderTraversal_r(root.left);
            postorderTraversal_r(root.right);
            values.add(root.val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}