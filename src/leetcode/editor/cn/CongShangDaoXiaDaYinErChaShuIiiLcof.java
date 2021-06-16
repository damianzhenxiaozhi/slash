//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 
// 👍 103 👎 0


package leetcode.editor.cn;

import java.util.*;

public class CongShangDaoXiaDaYinErChaShuIiiLcof {
    public static void main(String[] args) {
        Solution s = new CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }

            List<List<Integer>> values = new ArrayList<>();
            levelOrder_r(root, values);

            return values;
        }

        private void levelOrder_r(TreeNode root, List<List<Integer>> values) {
            Deque<TreeNode> deque = new LinkedList<>();
            deque.offerLast(root);

            boolean leftBegin = true;
            int count = 1;
            while (!deque.isEmpty()) {
                List<Integer> layerValues = new ArrayList<>();
                while (count-- > 0) {
                    if (leftBegin) {
                        TreeNode node = deque.pollFirst();
                        layerValues.add(node.val);

                        if (node.left != null) {
                            deque.addLast(node.left);
                        }

                        if (node.right != null) {
                            deque.addLast(node.right);
                        }
                    } else {
                        TreeNode node = deque.pollLast();
                        layerValues.add(node.val);

                        if (node.right != null) {
                            deque.addFirst(node.right);
                        }

                        if (node.left != null) {
                            deque.addFirst(node.left);
                        }
                    }
                }

                leftBegin = !leftBegin;
                values.add(layerValues);
                count = deque.size();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
