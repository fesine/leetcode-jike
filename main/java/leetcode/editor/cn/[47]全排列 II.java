package leetcode.editor.cn;
//给定一个可包含重复数字的序列，返回所有不重复的全排列。
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法 
// 👍 374 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (len == 0) {
            return result;
        }
        //排序是去重的前提
        Arrays.sort(nums);
        //创建stack
        Deque path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, path, used, result);
        return result;

    }

    private void dfs(int[] nums, int len, int depth, Deque path, boolean[] used, List<List<Integer>> result) {
        //退出条件
        if (depth == len) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }
            //选择
            path.addLast(nums[i]);
            used[i] = true;
            //回溯
            dfs(nums, len, depth + 1, path, used, result);
            //撤销选择
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1};
        List<List<Integer>> permute = new PermuteUnique().permuteUnique(nums);
        System.out.println();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
