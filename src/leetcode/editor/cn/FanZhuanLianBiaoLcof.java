//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 链表 
// 👍 242 👎 0


package leetcode.editor.cn;

public class FanZhuanLianBiaoLcof {
    public static void main(String[] args) {
        Solution s = new FanZhuanLianBiaoLcof().new Solution();
        MyList list = new MyList(new int[]{1,2,3,4,5});
        ListNode rList = s.reverseList(list.getHead());
        MyList.print(rList);
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
        public ListNode reverseList(ListNode head) {
            ListNode newHead = null;
            ListNode p = head;
            while (p != null) {
                ListNode tmp = p.next;

                p.next = newHead;
                newHead = p;

                p = tmp;
            }

            return newHead;
        }
    }

    class Solution1 {
        public ListNode reverseList(ListNode head) {
            ListNode newHead = null;
            ListNode p = head;
            while (p != null) {
                ListNode tmp = p.next;

                p.next = newHead;
                newHead = p;

                p = tmp;
            }

            return newHead;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
