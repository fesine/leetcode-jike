package leetcode.editor.cn;
//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 817 👎 0


import java.util.Arrays;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int n =heights.length;
        if (n == 0) {
            return 0;
        }
        if(n == 1){
            return heights[0];
        }
        int area = 0;
        //1、暴力求解法
        //for (int i = 0; i <  n; i++) {
        //    if (heights[i] == 0) {
        //        continue;
        //    }
        //    int b = heights[i];
        //    for (int j = i; j < n; j++) {
        //        b = Math.min(b, heights[j]);
        //        area = Math.max(area, (j - i + 1) * b);
        //    }
        //}
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right,n);
        //用于存放下标值
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            //peek，取元素，但不弹出，数量不减少
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.peek()] = i;
                //pop,弹出元素，数量减少
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1:stack.peek();
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            area = Math.max(area, (right[i] - left[i] - 1) * heights[i]);
        }
        return area;

    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 6, 2, 3};
        System.out.println(new LargestRectangleArea().largestRectangleArea(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
