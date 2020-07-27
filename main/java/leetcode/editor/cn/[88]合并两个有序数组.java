package leetcode.editor.cn;
//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针 
// 👍 573 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = nums1.length - 1; i > 0; i--) {
            if(n == 0 || m == 0){
                break;
            }
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[i] = nums1[m - 1];
                m--;
            } else {
                nums1[i] = nums2[n - 1];
                n--;
            }

        }
        //将nums2剩余部分填充给nums1
        for (int j = 0; j < n; j++) {
            nums1[j] = nums2[j];
        }
    }

    public static void main(String[] args) {
        //int[] nums1 = { 4, 5,6, 0, 0, 0};
        //int[] nums2 = {1, 2, 3};
        //new MergeSortedArray().merge(nums1, 3, nums2, 3);
        int[] nums = {3,3};
        int[] ints = new MergeSortedArray().twoSum(nums, 6);
        System.out.println();
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int a = target-nums[i];
            if (map.containsKey(a)) {
                return new int[]{map.get(a),i};
            }
            map.put(nums[i],i);
        }
        return null;
        //int[] result = new int[2];
        //for (int i = 0; i < nums.length-1; i++) {
        //    int a = target - nums[i];
        //    for (int j = i+1; j < nums.length; j++) {
        //        if(a == nums[j]){
        //            result[0] = i;
        //            result[1] = j;
        //            break;
        //        }
        //    }
        //
        //}
        //return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
