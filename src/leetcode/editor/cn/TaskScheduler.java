//给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个
//单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。 
//
// 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。 
//
// 你需要计算完成所有任务所需要的 最短时间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：tasks = ["A","A","A","B","B","B"], n = 2
//输出：8
//解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
//     在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。 
//
// 示例 2： 
//
// 
//输入：tasks = ["A","A","A","B","B","B"], n = 0
//输出：6
//解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
//["A","A","A","B","B","B"]
//["A","B","A","B","A","B"]
//["B","B","B","A","A","A"]
//...
//诸如此类
// 
//
// 示例 3： 
//
// 
//输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
//输出：16
//解释：一种可能的解决方案是：
//     A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待
//命) -> (待命) -> A
// 
//
// 
//
// 提示： 
//
// 
// 1 <= task.length <= 104 
// tasks[i] 是大写英文字母 
// n 的取值范围为 [0, 100] 
// 
// Related Topics 贪心 数组 哈希表 计数 排序 堆（优先队列） 
// 👍 695 👎 0


package leetcode.editor.cn;

import java.util.*;

public class TaskScheduler {
    public static void main(String[] args) {
        Solution s = new TaskScheduler().new Solution();
        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int n = 2;
        System.out.println(s.leastInterval(tasks, n));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            if (n == 0) {
                return tasks.length;
            }

            Queue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

            int[] taskCounts = new int[26];
            for (char task : tasks) {
                taskCounts[task - 'A']++;
            }
            for (int i = 0; i < 26; i++) {
                if (taskCounts[i] != 0) {
                    heap.offer(taskCounts[i]);
                }
            }

            int result = 0;
            int left = heap.size();
            while (left != 0) {
                List<Integer> out = new ArrayList<>();
                // 循环n+1次从堆中取数据，如果堆中有的话取出并count-1,没有的话跳过
                for (int i = 0; i <= n; i++) {
                    if (!heap.isEmpty()) {
                        int c = heap.poll();
                        c--;
                        out.add(c);
                    }
                    result++;
                }

                // 将取出的重新放回堆中
                int curNumCount = out.size();
                for (int c : out) {
                    if (c != 0) {
                        heap.add(c);
                    }
                }

                left = heap.size();
                if (left == 0) {
                    result -= (n + 1 - curNumCount);
                }
            }

            return result;
        }

        public int leastIntervalBySort(char[] tasks, int n) {
            if (n == 0) {
                return tasks.length;
            }

            Integer[] taskCount = new Integer[26];
            for (int i = 0; i < taskCount.length; i++) {
                taskCount[i] = 0;
            }

            for (char t : tasks) {
                taskCount[t - 'A']++;
            }

            Arrays.sort(taskCount, Collections.reverseOrder());
            int leftPos = getLeftPos(taskCount);
            int result = 0;
            while (leftPos != 0) {
                if (leftPos >= n + 1) {
                    for (int i = 0; i <= n; i++) {
                        taskCount[i]--;
                    }
                    result += (n + 1);

                    Arrays.sort(taskCount, Collections.reverseOrder());
                    leftPos = getLeftPos(taskCount);
                } else {
                    int curLeftPos = leftPos;
                    for (int i = 0; i < curLeftPos; i++) {
                        taskCount[i]--;
                    }

                    leftPos = getLeftPos(taskCount);
                    if (leftPos == 0) {
                        result += curLeftPos;
                    } else {
                        result += (n + 1);
                        Arrays.sort(taskCount, Collections.reverseOrder());
                    }
                }
            }

            return result;
        }

        private int getLeftPos(Integer[] taskCount) {
            int p = 0;
            for (int i = 0; i < taskCount.length; i++) {
                if (taskCount[i] == 0) {
                    return p;
                }
                p++;
            }

            return p;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}