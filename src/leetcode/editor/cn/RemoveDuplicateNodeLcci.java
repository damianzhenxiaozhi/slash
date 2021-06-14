//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。 
//
// 示例1: 
//
// 
// 输入：[1, 2, 3, 3, 2, 1]
// 输出：[1, 2, 3]
// 
//
// 示例2: 
//
// 
// 输入：[1, 1, 1, 1, 2]
// 输出：[1, 2]
// 
//
// 提示： 
//
// 
// 链表长度在[0, 20000]范围内。 
// 链表元素在[0, 20000]范围内。 
// 
//
// 进阶： 
//
// 如果不得使用临时缓冲区，该怎么解决？ 
// Related Topics 链表 
// 👍 109 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateNodeLcci {
    public static void main(String[] args) {
        Solution s = new RemoveDuplicateNodeLcci().new Solution();
        MyList list = new MyList(new int[] {1, 2, 3, 3, 2, 1});
        ListNode r = s.removeDuplicateNodes(list.getHead());
        MyList.print(r);
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode removeDuplicateNodes(ListNode head) {
            ListNode dummyHead = new ListNode();
            ListNode tail = dummyHead;

            Set<Integer> ht = new HashSet<>();
            ListNode p = head;
            while (p != null) {
                if (!ht.contains(p.val)) {
                    tail.next = p;
                    tail = p;

                    ht.add(p.val);
                }

                p = p.next;
            }

            tail.next = null;

            return dummyHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}