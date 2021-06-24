//给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。 
//
// 
//
// 示例： 
//
// 输入：[1,2,3,4,5,null,7,8]
//
//        1
//       /  \ 
//      2    3
//     / \    \ 
//    4   5    7
//   /
//  8
//
//输出：[[1],[2,3],[4,5,7],[8]]
// 
// Related Topics 树 广度优先搜索 
// 👍 53 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListOfDepthLcci {
    public static void main(String[] args) {
        Solution s = new ListOfDepthLcci().new Solution();
        MyBinaryTree tree = new MyBinaryTree(new Integer[] {1,2,3,4,5,null,7,8});
        ListNode[] r = s.listOfDepth(tree.getRoot());
        for (ListNode head : r) {
            while (head != null) {
                System.out.print(head.val + ", ");
                head = head.next;
            }
            System.out.println();
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode[] listOfDepth(TreeNode tree) {
            if (tree == null) {
                return null;
            }

            List<ListNode> result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(tree);
            while (!queue.isEmpty()) {
                int count = queue.size();

                ListNode dummyHead = new ListNode();
                ListNode tail = dummyHead;
                while (count-- > 0) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }

                    if (node.right != null) {
                        queue.offer(node.right);
                    }

                    tail.next = new ListNode(node.val);
                    tail = tail.next;
                }

                result.add(dummyHead.next);
            }

            ListNode[] res = new ListNode[result.size()];
            for (int i = 0; i < result.size(); i++) {
                res[i] = result.get(i);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
