//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], p = 1, q = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 105] 内。 
// -109 <= Node.val <= 109 
// 所有 Node.val 互不相同 。 
// p != q 
// p 和 q 均存在于给定的二叉树中。 
// 
// Related Topics 树 
// 👍 1158 👎 0


package leetcode.editor.cn;

public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Solution s = new LowestCommonAncestorOfABinaryTree().new Solution();
        Integer[] arr = new Integer[]{3,5,1,6,2,0,8,null,null,7,4};
        MyBinaryTree tree = new MyBinaryTree(arr);
        TreeNode p = tree.getByVal(5);
        TreeNode q = tree.getByVal(4);
        TreeNode lca = s.lowestCommonAncestor(tree.getRoot(), p, q);
        System.out.println(lca.val);
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
        private TreeNode lca;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            getPorQCount(root, p, q);
            return lca;
        }

        private int getPorQCount(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return 0;
            }

            int leftCount = 0;
            if (root.left != null) {
                leftCount = getPorQCount(root.left, p, q);
                if (lca != null) {
                    return 2;
                }
            }

            int rightCount = 0;
            if (root.right != null) {
                rightCount = getPorQCount(root.right, p, q);
                if (lca != null) {
                    return 2;
                }
            }

            int rootCount = 0;
            if (root == p) {
                rootCount = 1;
            } else if (root == q) {
                rootCount = 1;
            }

            if (leftCount == 1 && rightCount == 1) {
                lca = root;
                return 2;
            }

            if (rootCount == 1 && (leftCount == 1 || rightCount == 1)) {
                lca = root;
                return 2;
            }

            return leftCount + rightCount + rootCount;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
