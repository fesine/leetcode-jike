package leetcode.editor.cn;
//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法 
// 👍 711 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0,nums,result,new ArrayList<>());
        return result;

    }

    private void backtrack(int i, int[] nums, List<List<Integer>> result, ArrayList<Integer> subList) {
        result.add(new ArrayList<>(subList));
        for (int j = i; j < nums.length; j++) {
            //做选择
            subList.add(nums[j]);
            //回溯
            backtrack(j+1,nums,result,subList);
            //撤销选择
            subList.remove(subList.size()-1);

        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> subsets = new Subsets().subsets(nums);
        System.out.println(subsets);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
