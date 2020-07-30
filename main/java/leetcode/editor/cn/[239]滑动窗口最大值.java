package leetcode.editor.cn;//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 473 👎 0


import java.util.ArrayDeque;

//leetcode submit region begin(Prohibit modification and deletion)
class MaxSlidingWindow {
    //2、官方解法，使用双端队列
    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int[] nums;

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if(n == 1){
            return nums;
        }
        int[] maxArray = new int[n - k+1];
        int m = 0;
        //1、暴力求解法
        //从第k-1个下标开始遍历，到最后
        //for (int i = k-1; i < n; i++) {
        //    //得到第一个下标的值
        //    int cur = nums[i];
        //    //从第一个下标到k范围内数字对比，返回最大值
        //    for (int j = i-k+1; j < i+1; j++) {
        //        cur = Math.max(cur, nums[j]);
        //    }
        //    //记录最大值到对应的数组下标中
        //    maxArray[m++] = cur;
        //}
        this.nums = nums;
        for (int i = 0; i < k; i++) {
            cleanDeque(i,k);
            deq.addLast(i);
            if(nums[i] > nums[m]){
                m = i;
            }
            maxArray[0] = nums[m];
        }

        for (int i = k; i < n; i++) {
            cleanDeque(i, k);
            deq.addLast(i);
            //最大的元素保留在头部
            maxArray[i - k + 1] = nums[deq.getFirst()];
        }

        //2、使用栈，将元素从小到大排序的下标放入栈中，和后续加入的元素进行比较，
        //Stack<Integer> stack = new Stack();
        //for (int i = 0; i < n; i++) {
        //
        //}


        return maxArray;

    }

    /**
     * 清理队列
     * @param i
     * @param k
     */
    private void cleanDeque(int i, int k) {
        //超出滑动块的元素，直接移除
        if (!deq.isEmpty() && deq.getFirst() ==i - k ) {
            deq.removeFirst();
        }
        //将当前元素和前面的元素进行比较，如果前面的小，则把前面的数据移除，
        // 因为在后面的滑块中，也肯定不是最大的
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) {
            deq.removeLast();
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, -2, 3, 6, 7};
        new MaxSlidingWindow().maxSlidingWindow(nums, 3);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
