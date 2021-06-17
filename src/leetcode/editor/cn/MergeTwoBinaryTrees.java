//给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。 
//
// 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
//。 
//
// 示例 1: 
//
// 
//输入: 
//	Tree 1                     Tree 2                  
//          1                         2                             
//         / \                       / \                            
//        3   2                     1   3                        
//       /                           \   \                      
//      5                             4   7                  
//输出: 
//合并后的树:
//	     3
//	    / \
//	   4   5
//	  / \   \ 
//	 5   4   7
// 
//
// 注意: 合并必须从两个树的根节点开始。 
// Related Topics 树 
// 👍 707 👎 0


package leetcode.editor.cn;

public class MergeTwoBinaryTrees {
  public static void main(String[] args) {
    Solution s = new MergeTwoBinaryTrees().new Solution();
  }
 
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode dummyNode = new TreeNode();

        mergeTrees_r(dummyNode, 0, root1, root2);

        return dummyNode.left;
    }

    private void mergeTrees_r(TreeNode preNode, int i, TreeNode root1, TreeNode root2) {
        TreeNode node = getNode(root1, root2);
        if (i == 0) {
            preNode.left = node;
        } else {
            preNode.right = node;
        }

        mergeTrees_r(node, 0, root1.left, root2.left);
        mergeTrees_r(node, 1, root1.right, root2.right);
    }

    private TreeNode getNode(TreeNode root1, TreeNode root2) {
        if (root1 != null && root2 != null) {
            root1.val = root1.val + root2.val;
            return root1;
        } else {
            return root1 != null ? root1 : root2;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
