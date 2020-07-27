package leetcode.editor.cn;
//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组 
// 👍 513 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class PlusOne {
    public int[] plusOne(int[] digits) {
        //int n = digits.length-1;
        //digits[n] =digits[n]+1;
        //while (digits[n] == 10 && n>0){
        //    digits[n] = 0;
        //    digits[n-1] = digits[n-1]+1;
        //    n--;
        //}
        //if(digits[0] == 10){
        //    //需要重新创建数组
        //    int[] arrays = new int[digits.length + 1];
        //    arrays[0] = 1;
        //    return arrays;
        //}
        //return digits;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0){
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;

    }

    public static void main(String[] args) {
        int[] nums = {9,9,9};
        new PlusOne().plusOne(nums);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
