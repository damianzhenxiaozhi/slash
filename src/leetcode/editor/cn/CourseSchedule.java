//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。 
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 105 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 
// 👍 863 👎 0


package leetcode.editor.cn;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        Solution s = new CourseSchedule().new Solution();
        long begin = System.currentTimeMillis();
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, 0}, {0, 1}};
        System.out.println(s.canFinish(numCourses, prerequisites));
        System.out.println(System.currentTimeMillis() - begin);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private boolean canFinish = false;
        private LinkedList<Integer>[] adj;
        private boolean hasLoop = false;
        private Set<Integer> passedCourses = new HashSet<>();

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (prerequisites.length == 0 || numCourses == 0) {
                return true;
            }

            adj = new LinkedList[numCourses];
            for (int i = 0; i < numCourses; i++) {
                adj[i] = new LinkedList<>();
            }

            // kahn
//            int[] inDegree = new int[numCourses];
//            for (int i = 0; i < prerequisites.length; i++) {
//                adj[prerequisites[i][1]].add(prerequisites[i][0]);
//                inDegree[prerequisites[i][0]]++;
//            }

            // kahn dfs
//            dfsKahn(inDegree, new boolean[numCourses], 0);
//            return canFinish;

            // kahn collection
//            List<Integer> zeroDegree = new ArrayList<>();
//            for (int i = 0; i < inDegree.length; i++) {
//                if (inDegree[i] == 0) {
//                    zeroDegree.add(i);
//                }
//            }
//
//            int count = 0;
//            while (!zeroDegree.isEmpty()) {
//                int index = zeroDegree.remove(0);
//                count++;
//                for (int i = 0; i < adj[index].size(); i++) {
//                    inDegree[adj[index].get(i)]--;
//                    if (inDegree[adj[index].get(i)] == 0) {
//                        zeroDegree.add(adj[index].get(i));
//                    }
//                }
//            }
//
//            return count == numCourses;

            // dfs
            for (int i = 0; i < prerequisites.length; i++) {
                adj[prerequisites[i][1]].add(prerequisites[i][0]);
            }

            for (int i = 0; i < numCourses; i++) {
                if (!passedCourses.contains(i)) {
                    dfsCheck(i, new HashSet<>());
                }
            }

            return !hasLoop;
        }

        private void dfsKahn(int[] inDegree, boolean[] visited, int count) {
            if (count == inDegree.length) {
                canFinish = true;
                return;
            }

            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] != 0 || visited[i]) {
                    continue;
                }

                visited[i] = true;
                for (int j = 0; j < adj[i].size(); j++) {
                    inDegree[adj[i].get(j)]--;
                }

                dfsKahn(inDegree, visited, count + 1);

                // 不能回溯，路径太多会超时
            }
        }

        private void dfsCheck(int start, Set<Integer> path) {
            if (path.contains(start)) {
                hasLoop = true;
                return;
            }

            if (hasLoop) {
                return;
            }

            if (passedCourses.contains(start)) {
                return;
            }

            passedCourses.add(start);
            path.add(start);
            for (int j = 0; j < adj[start].size(); j++) {
                dfsCheck(adj[start].get(j), path);
            }
            path.remove(start);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}