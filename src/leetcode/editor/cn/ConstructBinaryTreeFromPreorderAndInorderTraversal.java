//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 数组 哈希表 分治算法 Binary Tree 
// 👍 1089 👎 0


package leetcode.editor.cn;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution s = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = s.buildTree(preorder, inorder);
        MyBinaryTree.print(root);
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private TreeNode buildTree(int[] preorder, int i, int j, int[] inorder, int p, int q) {
            if (i > j || p > q) {
                return null;
            }

            TreeNode root = new TreeNode(preorder[i]);

            int r = p;
            while (r <= q && inorder[r] != preorder[i]) {
                r++;
            }
            int count = r - p;

            TreeNode left = buildTree(preorder, i + 1, i + count, inorder, p, p + count - 1);
            TreeNode right = buildTree(preorder, i + count + 1, j, inorder, p + count + 1, q);

            root.left = left;
            root.right = right;

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}