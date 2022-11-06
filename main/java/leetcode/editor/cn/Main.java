package leetcode.editor.cn;

import java.util.Scanner;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2021/4/28
 * @update:修改内容
 * @author: fesine
 * @updateTime:2021/4/28
 */
public class Main {
    private static char[] array = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p'
            , 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        for (int i = 0; i < m; i++) {
            String str = s.nextLine();
            int n = str.length();
            int[] x = new int[n];
            if (n == 1) {
                x[0] = 1;
            } else if (n == 2) {
                x[0] = 1;
                x[1] = 2;
            } else if (n == 3) {
                x[0] = 1;
                x[1] = 2;
                x[2] = 4;
            } else {
                x[0] = 1;
                x[1] = 2;
                x[2] = 4;
                for (int j = 3; j < n; j++) {
                    x[j] = x[j - 3] + x[j - 2] + x[j - 1];
                }
                for (int p = 0; p < n; p++) {
                    char c = str.charAt(p);
                    for (int j = 0; j < array.length; j++) {
                        if (c == array[j]) {
                            int k = x[p] + j;
                            k = k % 26;
                            System.out.print(array[k]);
                        }
                    }
                    System.out.println();
                }
            }


        }
    }

}
