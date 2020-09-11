package leetcode.editor.cn;
//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
//
// 
//
// 示例： 
//
// 输入：
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出：3
//解释：
//长度最长的公共子数组是 [3, 2, 1] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= len(A), len(B) <= 1000 
// 0 <= A[i], B[i] < 100 
// 
// Related Topics 数组 哈希表 二分查找 动态规划 
// 👍 314 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class FindLength {
    public int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(A[i-1] == B[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = new int[]{
                1, 2, 3, 2, 1};
        int[] b = new int[]{
                3, 2, 1, 4, 7
        };
        System.out.println(new FindLength().findLength(a,b));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
