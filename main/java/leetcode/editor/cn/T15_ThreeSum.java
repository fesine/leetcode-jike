//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k
// ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请 
//
// 你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 排序 
// 👍 5367 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Java：三数之和
 */
public class T15_ThreeSum {
    public static void main(String[] args) {
        Solution solution = new T15_ThreeSum().new Solution();
        List<List<Integer>> lists = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(Arrays.toString(lists.toArray()));
        // TO TEST
    }

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> lists = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                if (i == 0 || nums[i] != nums[i - 1]) {
                    int low = i + 1, high = nums.length - 1, sum = -nums[i];
                    // 双指针遍历
                    while (low < high) {
                        if (sum == nums[low] + nums[high]) {
                            lists.add(Arrays.asList(nums[i], nums[low], nums[high]));
                            // 跳过相同的值的位置
                            while (low < high && nums[low] == nums[low + 1]) {
                                low++;
                            }
                            while (low < high && nums[high] == nums[high - 1]) {
                                high--;
                            }
                            low++;
                            high--;
                        } else if (nums[low] + nums[high] < sum) {
                            // 两数相加小于sum，则左指针右移
                            low++;
                        } else {
                            // 两数相加大于sum，则右指针左移
                            high--;
                        }
                    }
                }
            }
            return lists;

        }
    }

}
