//对链表进行插入排序。 
//
// 
//插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。 
//每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。 
//
// 
//
// 插入排序算法： 
//
// 
// 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。 
// 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。 
// 重复直到所有输入数据插入完为止。 
// 
//
// 
//
// 示例 1： 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2： 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5
// 
// Related Topics 排序 链表 
// 👍 396 👎 0


package leetcode.editor.cn;

public class InsertionSortList {
    public static void main(String[] args) {
        Solution s = new InsertionSortList().new Solution();
        MyList list = new MyList(new int[]{-1,5,3,4,0});
        ListNode result = s.insertionSortList(list.getHead());
        MyList.print(result);
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode insertionSortList(ListNode head) {
            if (head == null) {
                return null;
            }

            ListNode dummyHead = new ListNode();
            dummyHead.next = head;

            ListNode p = head.next;
            head.next = null;
            while (p != null) {
                ListNode next = p.next;
                p.next = null;

                ListNode pre = dummyHead;
                ListNode q = dummyHead.next;
                while (q != null) {
                    if (q.val > p.val) {
                        pre.next = p;
                        p.next = q;
                        break;
                    } else {
                        pre = q;
                        q = q.next;
                    }
                }

                if (q == null) {
                    pre.next = p;
                }

                p = next;
            }

            return dummyHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
