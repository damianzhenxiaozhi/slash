//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 数组 哈希表 分治算法 Binary Tree 
// 👍 523 👎 0


package leetcode.editor.cn;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution s = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        TreeNode root = s.buildTree(inorder, postorder);
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }

        private TreeNode buildTree(int[] inorder, int i, int j, int[] postorder, int p, int q) {
            if (i > j || p > q) {
                return null;
            }

            TreeNode root = new TreeNode(postorder[q]);

            int k = i;
            while (k <= j && inorder[k] != postorder[q]) {
                k++;
            }

            TreeNode left = buildTree(inorder, i, k - 1, postorder, p, p + (k - i) - 1);
            TreeNode right = buildTree(inorder, k + 1, j, postorder, p + (k - i), q - 1);

            root.left = left;
            root.right = right;

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
