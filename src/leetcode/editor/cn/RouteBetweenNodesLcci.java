//节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。 
//
// 示例1: 
//
//  输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
// 输出：true
// 
//
// 示例2: 
//
//  输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [
//1, 3], [2, 3], [3, 4]], start = 0, target = 4
// 输出 true
// 
//
// 提示： 
//
// 
// 节点数量n在[0, 1e5]范围内。 
// 节点编号大于等于 0 小于 n。 
// 图中可能存在自环和平行边。 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 
// 👍 35 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;

public class RouteBetweenNodesLcci {
    public static void main(String[] args) {
        Solution s = new RouteBetweenNodesLcci().new Solution();
        int n = 3;
        int[][] graph = {{0, 1}, {0, 2}, {1, 2}, {1, 2}};
        int start = 0;
        int target = 2;
        System.out.println(s.findWhetherExistsPath(n, graph, start, target));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private boolean found;
        private boolean[] visited;

        public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
            LinkedList<Integer>[] adj = new LinkedList[n];
            visited = new boolean[n];
            for (int i = 0; i < graph.length; i++) {
                int s = graph[i][0];
                int t = graph[i][1];
                if (adj[s] == null) {
                    adj[s] = new LinkedList<>();
                }
                adj[s].add(t);
            }

            found = false;
            dfsSearch(adj, start, target);
            return found;
        }

        private void dfsSearch(LinkedList<Integer>[] adj, int start, int target) {
            if (found) {
                return;
            }

            visited[start] = true;

            if (adj[start] == null) {
                return;
            }

            for (int i = 0; i < adj[start].size(); i++) {
                int j = adj[start].get(i);
                if (!visited[j]) {
                    if (j == target) {
                        found = true;
                        return;
                    }
                    dfsSearch(adj, j, target);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
