package leetcode.editor.cn;
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
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


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int j = 0 ;
        // 遍历数组
        //for (int i = 0; i < nums.length; i++) {
        //    // 如果当前值不等于0
        //    if (nums[i] != 0) {
        //        // 交换i和j的值，i和j有可能相等
        //        nums[j] = nums[i];
        //        // i不等于j，将i下标的值置为0，说明j的位置是0
        //        if(i != j){
        //            nums[i] = 0;
        //        }
        //        // j++
        //        j++;
        //    }
        //}
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
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
        int [] nums= {100, 1, 0, 3, 0, 12};
        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
