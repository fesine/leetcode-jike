package leetcode.editor.cn;//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 776 👎 0

/**
 *
 * 我们先定义一个数组 dpMax，用 dpMax[i] 表示以第 i 个元素的结尾的子数组，乘积最大的值，也就是这个数组必须包含第 i 个元素。
 *
 * 那么 dpMax[i] 的话有几种取值。
 *
 * 当 nums[i] >= 0 并且dpMax[i-1] > 0，dpMax[i] = dpMax[i-1] * nums[i]
 * 当 nums[i] >= 0 并且dpMax[i-1] < 0，此时如果和前边的数累乘的话，会变成负数，所以dpMax[i] = nums[i]
 * 当 nums[i] < 0，此时如果前边累乘结果是一个很大的负数，和当前负数累乘的话就会变成一个更大的数。所以我们还需要一个数组 dpMin 来记录以第 i 个元素的结尾的子数组，乘积最小的值。
 * 当dpMin[i-1] < 0，dpMax[i] = dpMin[i-1] * nums[i]
 * 当dpMin[i-1] >= 0，dpMax[i] = nums[i]
 * 当然，上边引入了 dpMin 数组，怎么求 dpMin 其实和上边求 dpMax 的过程其实是一样的。
 *
 * 按上边的分析，我们就需要加很多的 if else来判断不同的情况，这里可以用个技巧。
 *
 * 我们注意到上边dpMax[i] 的取值无非就是三种，dpMax[i-1] * nums[i]、dpMin[i-1] * nums[i] 以及 nums[i]。
 *
 * 所以我们更新的时候，无需去区分当前是哪种情况，只需要从三个取值中选一个最大的即可。
 *
 *
 * dpMax[i] = max(dpMax[i-1] * nums[i], dpMin[i-1] * nums[i], nums[i]);
 * 求 dpMin[i] 同理。
 *
 *
 * dpMin[i] = min(dpMax[i-1] * nums[i], dpMin[i-1] * nums[i], nums[i]);
 * 更新过程中，我们可以用一个变量 max 去保存当前得到的最大值。
 *
 */

//leetcode submit region begin(Prohibit modification and deletion)
class MaxProduct {
    /**
     * 遍历数组时，不断更新最大值
     * 令imax为当前最大值，则imax=相乘后的结果与当前值比较后的最大值
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        //创建dpMax[]
        int[] dpMax = new int[n];
        dpMax[0] = nums[0];
        //创建dpMin[]
        int[] dpMin = new int[n];
        dpMin[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            //思路非常棒
            dpMax[i] = Math.max(dpMax[i-1]*nums[i],Math.max(dpMin[i - 1] * nums[i], nums[i]));
            dpMin[i] = Math.min(dpMax[i - 1] * nums[i], Math.min(dpMin[i - 1] * nums[i], nums[i]));
            max = Math.max(max,dpMax[i]);
        }
        return max;

    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(new MaxProduct().maxProduct(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
