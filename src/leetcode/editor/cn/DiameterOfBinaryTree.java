//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 深度优先搜索 Binary Tree 
// 👍 723 👎 0


package leetcode.editor.cn;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution s = new DiameterOfBinaryTree().new Solution();
        MyBinaryTree tree = new MyBinaryTree(new Integer[]{1, 2, 3, 4, 5, null, null});
        System.out.println(s.diameterOfBinaryTree(tree.getRoot()));
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
        public int diameterOfBinaryTree(TreeNode root) {
            int[] result = countOfRootOrNonRoot(root);
            return Math.max(result[0] , result[1]) - 1;
        }

        private int[] countOfRootOrNonRoot(TreeNode root) {
            if (root == null) {
                return new int[]{0, 0};
            }

            int[] left = countOfRootOrNonRoot(root.left);
            int[] right = countOfRootOrNonRoot(root.right);

            int diameterOfRoot = Math.max(left[0] + 1, right[0] + 1);
            int diameterOfNonRoot = Math.max(Math.max(left[0] + right[0] + 1, left[1]), right[1]);

            return new int[]{diameterOfRoot, diameterOfNonRoot};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
