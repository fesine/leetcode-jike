package leetcode.editor.cn;
//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 845 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Permute {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums){
        LinkedList<Integer> path = new LinkedList<>();
        backtrack(nums,path);

        return result;
    }

    private void backtrack(int[] nums, LinkedList<Integer> path) {
        if (path.size() == nums.length) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(path.contains(nums[i])){
                continue;
            }
            //选择
            path.add(nums[i]);
            //下转
            backtrack(nums,path);
            //取消选择
            path.removeLast();
        }
    }
    //public List<List<Integer>> permute(int[] nums) {
    //    int len = nums.length;
    //    List<List<Integer>> result = new ArrayList<>();
    //    if(len == 0){
    //        return result;
    //    }
    //    //创建stack
    //    Deque path = new ArrayDeque<>();
    //    boolean[] used = new boolean[len];
    //    dfs(nums,len,0,path,used,result);
    //
    //    return result;
    //
    //}
    //
    //private void dfs(int[] nums, int len, int depth, Deque path, boolean[] used, List<List<Integer>> result) {
    //    //退出条件
    //    if(depth == len){
    //        result.add(new ArrayList<>(path));
    //        return;
    //    }
    //    for (int i = 0; i < len; i++) {
    //        if(used[i]){
    //            continue;
    //        }
    //        //选择
    //        path.addLast(nums[i]);
    //        used[i] = true;
    //        //回溯
    //        dfs(nums,len,depth+1,path,used,result);
    //        //撤销选择
    //        path.removeLast();
    //        used[i] = false;
    //    }
    //}


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> permute = new Permute().permute(nums);
        System.out.println();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
