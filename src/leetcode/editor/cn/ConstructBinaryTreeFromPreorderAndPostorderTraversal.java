//返回与给定的前序和后序遍历匹配的任何二叉树。 
//
// pre 和 post 遍历中的值是不同的正整数。 
//
// 
//
// 示例： 
//
// 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
//输出：[1,2,3,4,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= pre.length == post.length <= 30 
// pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列 
// 每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。 
// 
// Related Topics 树 
// 👍 177 👎 0


package leetcode.editor.cn;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution s = new ConstructBinaryTreeFromPreorderAndPostorderTraversal().new Solution();
        int[] pre = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] post = new int[]{4, 5, 2, 6, 7, 3, 1};
        TreeNode root = s.constructFromPrePost(pre, post);
        MyBinaryTree.print(root);
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
        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            return constructFromPrePost(pre, 0, pre.length - 1, post, 0, post.length - 1);
        }

        private TreeNode constructFromPrePost(int[] pre, int i, int j, int[] post, int p, int q) {
            if (i > j || p > q) {
                return null;
            }

            if (i == j || p == q) {
                return new TreeNode(pre[i]);
            }

            TreeNode root = new TreeNode(pre[i]);

            int r = p;
            while (r <= q && post[r] != pre[i + 1]) {
                r++;
            }

            TreeNode left = constructFromPrePost(pre, i + 1, i + 1 + r - p, post, p, r);
            TreeNode right = constructFromPrePost(pre, i + 1 + r - p + 1, j, post, r + 1, q - 1);

            root.left = left;
            root.right = right;

            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
