//栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：pu
//sh、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。 
//
// 示例1: 
//
//  输入：
//["SortedStack", "push", "push", "peek", "pop", "peek"]
//[[], [1], [2], [], [], []]
// 输出：
//[null,null,null,1,null,2]
// 
//
// 示例2: 
//
//  输入： 
//["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
//[[], [], [], [1], [], []]
// 输出：
//[null,null,null,null,null,true]
// 
//
// 说明: 
//
// 
// 栈中的元素数目在[0, 5000]范围内。 
// 
// Related Topics 设计 
// 👍 36 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Stack;

public class SortOfStacksLcci {
    public static void main(String[] args) {
        SortedStack s = new SortOfStacksLcci().new SortedStack();
        s.push(1);
        s.push(3);
        System.out.println(s.peek());
        s.push(2);
        System.out.println(s.peek());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class SortedStack {
        private Stack<Integer> s = new Stack<>();
        private Stack<Integer> tmp = new Stack<>();

        public SortedStack() {

        }

        public void push(int val) {
            while (!s.isEmpty() && s.peek() < val) {
                tmp.push(s.pop());
            }

            tmp.push(val);

            while (!tmp.isEmpty()) {
                s.push(tmp.pop());
            }
        }

        public void pop() {
            if (s.isEmpty()) {
                return;
            }

            s.pop();
        }

        public int peek() {
            if (s.isEmpty()) {
                return -1;
            }

            return s.peek();
        }

        public boolean isEmpty() {
            return s.isEmpty();
        }
    }

/**
 * Your SortedStack object will be instantiated and called as such:
 * SortedStack obj = new SortedStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.isEmpty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}