package leetcode.editor.cn;//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i
// 的两个端点分别为 (i,
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例： 
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
// Related Topics 数组 双指针 
// 👍 1663 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class MaxArea {
    /**
     * 方法一，使用暴力破解法，遍历所有的面积，获取面积最大的
     * 方法二，从两边向中间进行收缩，然后进行高度对比。
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int area = 0;
        //for (int i = 0; i < height.length - 1; i++) {
        //    for (int j = 1; j < height.length; j++) {
        //        int h = Math.min(height[i], height[j]);
        //        area = Math.max(area, (j - i) * h);
        //    }
        //}
        int i = 0, j = height.length - 1;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            area = Math.max(area, (j - i) * h);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
            //area = height[i] < height[j] ? Math.max(area, (j - i) * height[i++]) : Math.max(area,
            //        (j - i) * height[j--]);
        }
        return area;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new MaxArea().maxArea(height));
    }
}


//leetcode submit region end(Prohibit modification and deletion)
