//基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。 
//
// 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。 
//
// 
// 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。 
// 
//
// 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。（变化后的基因必须位于基因库 bank 中） 
//
// 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成
//此基因变化，返回 -1 。 
//
// 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。 
//
// 
//
// 示例 1：
//
// 
//输入：start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGG
//TA"]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC","AACCCC
//CC"]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// start.length == 8 
// end.length == 8 
// 0 <= bank.length <= 10 
// bank[i].length == 8 
// start、end 和 bank[i] 仅由字符 ['A', 'C', 'G', 'T'] 组成 
// 
// Related Topics 广度优先搜索 哈希表 字符串 
// 👍 231 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * Java：最小基因变化
 */
public class T433_MinimumGeneticMutation {
    public static void main(String[] args) {
        Solution solution = new T433_MinimumGeneticMutation().new Solution();
        // TO TEST
        String[] bank = new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        solution.minMutation("AAAAACCC", "AACCCCCC", bank);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMutation(String startGene, String endGene, String[] bank) {
            // 数组转成set，方便查找
            Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
            // 如果不包含结果数据，直接返回-1
            if (!bankSet.contains(endGene)) {
                return -1;
            }
            // 记录已经使用过的数据
            Set<String> usedSet = new HashSet<>();
            // 记录当前符合条件比对的数据
            Queue<String> queue = new LinkedList<>();
            queue.offer(startGene);
            usedSet.add(startGene);
            int count = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String cur = queue.poll();
                    if (endGene.equals(cur)) {
                        return count;
                    }
                    // 遍历bank set
                    for (String gene : bankSet) {
                        // 只找变化为1的基因，添加到set和队列中
                        if (!usedSet.contains(gene) && isChangeOne(cur, gene)) {
                            // 标记为使用过
                            usedSet.add(gene);
                            // 添加到队列中
                            queue.offer(gene);
                        }
                    }
                }
                count++;
            }
            return -1;
        }

        private boolean isChangeOne(String cur, String gene) {
            int change = 0;
            for (int i = 0; i < 8; i++) {
                if (cur.charAt(i) != gene.charAt(i)) {
                    change++;
                }
                if (change > 1) {
                    return false;
                }
            }
            return change == 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
