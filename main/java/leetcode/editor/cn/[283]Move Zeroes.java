package leetcode.editor.cn;//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//  将数组遍历，如果数字不为0，则和前面为0数字进行交换
// 双指针实现
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 665 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0 ;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if(i != j){
                    nums[i] = 0;
                }
                j++;

            }
        }
        //int[] temp = new int[nums.length];
        //for (int i = 0; i < nums.length; i++) {
        //    if (nums[i] != 0) {
        //        temp[j] = nums[i];
        //        j++;
        //    }
        //}
        //for (int i = j; i < nums.length; i++) {
        //    temp[j] = 0;
        //}

        //for (int i = 0; i < temp.length; i++) {
        //    System.out.println(temp[i]);
        //}

    }

    public static void main(String[] args) {
        int [] nums= {100, 1, 0, 3, 12};
        new Solution().moveZeroes(nums);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
