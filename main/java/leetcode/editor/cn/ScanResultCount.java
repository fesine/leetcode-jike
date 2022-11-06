package leetcode.editor.cn;

import java.util.Scanner;

/**
 *
 * 2.第一行输入一串由逗号隔开的数字，第二行输入一个整数。若该整数可以由第一行的连续数字的和表示，
 * 输出连续数字的最大数量；若不能表示，输出-1
 * 如输入：
 * 2,1,3,4,2,3,1,5,7
 * 12
 * 输出：5
 * 解释：第一行的连续数字中：2+1+3+4+2=12，个数为5；3+4+2+3=12，个数为4；5+7=12，个数为2。
 * 其中5最大，输出5。
 * 输入：
 * 1,2,3,4
 * 20
 * 输出：-1
 * 解释：20不能由第一行连续数字的和表示，输出-1
 * @description: 类描述
 * @author: fesine
 * @createTime:2021/4/28
 * @update:修改内容
 * @author: fesine
 * @updateTime:2021/4/28
 */
public class ScanResultCount {

    private int solution(Integer[] nums,int target){
        int max=-1;
        for (int i = 0; i < nums.length-1; i++) {
            int sum = nums[i];
            int count = 1;
            for (int j = i; j < nums.length; j++) {
                sum +=nums[j];
                if (sum > target) {
                    break;
                }
                count++;
                if(sum == target){
                    max = Math.max(max,count);
                    break;
                }

            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(",");
        //{2, 1, 3, 4, 2, 3, 1, 5, 7}
        Integer[] nums = new Integer[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i]=Integer.valueOf(split[i].trim());
        }
        int solution = new ScanResultCount().solution(nums, scanner.nextInt());
        System.out.println(solution);
    }
}
