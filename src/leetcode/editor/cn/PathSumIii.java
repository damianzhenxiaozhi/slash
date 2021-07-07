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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PathSumIii {
    public static void main(String[] args) {
        Solution s = new PathSumIii().new Solution();
        MyBinaryTree tree = new MyBinaryTree(new Integer[]{1,null,2, null, null, null,3, null, null, null, null, null, null, null,4,null,5});
        int targetSum = 3;
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
        private Set<TreeNode> startNode;

        public int pathSum(TreeNode root, int targetSum) {
            count = 0;
            startNode = new HashSet<>();
            backtrace(root, new ArrayList<>(), targetSum);
            return count;
        }

        private void backtrace(TreeNode root, List<Integer> path, int targetSum) {
            if (root == null) {
                return;
            }

            if (path.isEmpty()) {
                if (startNode.contains(root)) {
                    return;
                }
                startNode.add(root);
            }

            path.add(root.val);
            if (pathSum(path) == targetSum) {
                count++;
            }

            backtrace(root.left, path, targetSum);
            path.remove(path.size() - 1);
            path.add(root.val);
            backtrace(root.right, path, targetSum);
            path.remove(path.size() - 1);

            backtrace(root.left, new ArrayList<>(), targetSum);
            backtrace(root.right, new ArrayList<>(), targetSum);
        }

        private int pathSum(List<Integer> path) {
            return path.stream().mapToInt(n -> n).sum();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
