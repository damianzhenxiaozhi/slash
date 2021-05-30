//三合一。描述如何只用一个数组来实现三个栈。 
//
// 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。s
//tackNum表示栈下标，value表示压入的值。 
//
// 构造函数会传入一个stackSize参数，代表每个栈的大小。 
//
// 示例1: 
//
//  输入：
//["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
//[[1], [0, 1], [0, 2], [0], [0], [0], [0]]
// 输出：
//[null, null, null, 1, -1, -1, true]
//说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
// 
//
// 示例2: 
//
//  输入：
//["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
//[[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
// 输出：
//[null, null, null, null, 2, 1, -1, -1]
// 
// Related Topics 设计 
// 👍 34 👎 0


package leetcode.editor.cn;

public class ThreeInOneLcci {
    public static void main(String[] args) {
        TripleInOne s = new ThreeInOneLcci().new TripleInOne(2);
        s.push(0, 1);
        s.push(0, 2);
        System.out.println(s.peek(0));
        s.pop(0);
        System.out.println(s.peek(0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class TripleInOne {
        private int[] stack;
        private int[] top = new int[3];
        private int stackSize;

        public TripleInOne(int stackSize) {
            stack = new int[3 * stackSize];
            this.stackSize = stackSize;
            top[0] = 0;
            top[1] = stackSize;
            top[2] = 2 * stackSize;
        }

        public void push(int stackNum, int value) {
            if (isFull(stackNum)) {
                return;
            }

            stack[top[stackNum]++] = value;
        }

        private boolean isFull(int stackNum) {
            return top[stackNum] == (stackNum + 1) * stackSize;
        }

        public int pop(int stackNum) {
            if (isEmpty(stackNum)) {
                return -1;
            }

            return stack[--top[stackNum]];
        }

        public int peek(int stackNum) {
            if (isEmpty(stackNum)) {
                return -1;
            }

            int peekPos = top[stackNum] - 1;
            return stack[peekPos];
        }

        public boolean isEmpty(int stackNum) {
            return top[stackNum] == stackNum * stackSize;

        }
    }

/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne obj = new TripleInOne(stackSize);
 * obj.push(stackNum,value);
 * int param_2 = obj.pop(stackNum);
 * int param_3 = obj.peek(stackNum);
 * boolean param_4 = obj.isEmpty(stackNum);
 */
//leetcode submit region end(Prohibit modification and deletion)

}