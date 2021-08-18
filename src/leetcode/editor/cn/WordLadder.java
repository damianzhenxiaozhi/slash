//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列： 
//
// 
// 序列中第一个单词是 beginWord 。 
// 序列中最后一个单词是 endWord 。 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典 wordList 中的单词。 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中
//的 单词数目 。如果不存在这样的转换序列，返回 0。 
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
// Related Topics 广度优先搜索 哈希表 字符串 
// 👍 821 👎 0


package leetcode.editor.cn;

import javafx.util.Pair;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        Solution s = new WordLadder().new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(s.ladderLength(beginWord, endWord, wordList));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private class WordPair {
            private String word;
            private Integer count;
            public WordPair(String word, Integer count) {
                this.word = word;
                this.count = count;
            }
        }

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Map<String, List<String>> adjMap = new HashMap<>();
            for (String word : wordList) {
                for (int i = 0; i < word.length(); i++) {
                    String mask = word.substring(0, i) + "*" + word.substring(i+1);
                    List<String> adj = adjMap.getOrDefault(mask, new ArrayList<>());
                    adj.add(word);
                    adjMap.put(mask, adj);
                }
            }

            Set<String> visited = new HashSet<>();
            Queue<WordPair> queue = new LinkedList<>();
            queue.offer(new WordPair(beginWord, 1));
            visited.add(beginWord);

            while (!queue.isEmpty()) {
                WordPair pair = queue.poll();
                String newWord = pair.word;
                if (newWord.equals(endWord)) {
                    return pair.count;
                }

                for (int i = 0; i < newWord.length(); i++) {
                    String mask = newWord.substring(0, i) + "*" + newWord.substring(i+1);
                    List<String> adj = adjMap.getOrDefault(mask, new ArrayList<>());
                    for (String s : adj) {
                        if (visited.contains(s)) {
                            continue;
                        }

                        visited.add(s);
                        queue.add(new WordPair(s, pair.count + 1));
                    }
                }
            }

            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}