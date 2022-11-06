package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 一个 0-1000 的整数，拆解为一个（本身）或多个连续自然数的和，
 * 按照自然数的个数从少到多输出各个方案 input = solution，
 * 方案内的自然数按照从小到大排列
 *
 * @description: 类描述
 * @author: fesine
 * @createTime:2021/4/27
 * @update:修改内容
 * @author: fesine
 * @updateTime:2021/4/27
 */
public class MaxAddResult {

    List<List<Integer>> solution(Integer n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(n);
        result.add(list);
        if(n == 0 || n == 1 || n==2){
            return result;
        }
        for (int i = n / 2 + 1; i >= 2; i--) {
            int sum = i;
            for (int j = i-1; j >= 1; j--) {
                sum += j;
                if (sum == n) {
                    list = new ArrayList<>();
                    for (int k = j; k <= i; k++) {
                        list.add(k);
                    }
                    result.add(list);
                    break;
                } else if (sum > n) {
                    break;
                }
            }
        }

        return result;
}

    public static void main(String[] args) {
        List<List<Integer>> solution = new MaxAddResult().solution(3);
        System.out.println();
    }
}
