package huawei;

import sun.text.resources.cldr.bn.FormatData_bn_IN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author: 11983
 * @date: 21/09/02 14:46
 * @description:
 */

public class BuyList {
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s1 = bf.readLine();
        String[] sarr = s1.split(" ");
        int allm = Integer.parseInt(sarr[0]) / 10;
        int numc = Integer.parseInt(sarr[1]);
        List<int[]> carr = new ArrayList<>();
        for (int i = numc; i > 0; --i) {
            int[] arr = new int[3];
            String[] s = bf.readLine().split(" ");
            arr[0] = Integer.parseInt(s[0]) / 10;
            arr[1] = Integer.parseInt(s[1]);
            arr[2] = Integer.parseInt(s[2]);
            carr.add(arr);
        }
        // 前面是输入
        // create dp array
        int[][] dp = new int[numc+1][allm+1];
        // create a set store the number of master object
        Set<Integer> set = new HashSet<>();
        // initial dp array
        for (int i = 0; i < allm+1; i++) {
            dp[0][i] = 0;
        }
        // initial money
        for (int j = 1; j < numc+1; j++) {
            int[] a = carr.get(j-1);
            int p=a[0];
            int v=a[1];
            int q=a[2];
            int add=v*p;
            for (int i = 0; i < allm+1; i++) {
                if (p>i){
                    dp[j][i] = dp[j - 1][i];
                }else {
                    int buy=dp[j-1][i - p] + add;
                    int dontBuy=dp[j - 1][i];
                    if (q == 0) {
                        if (buy>dontBuy){
                            dp[j][i] =buy;
                            set.add(j);
                        }else {
                            dp[j][i] =dontBuy;
                        }
                    } else {
                        if (set.contains(q)) {
                            if (buy>dontBuy){
                                dp[j][i] =buy;
                                set.add(j);
                            }else {
                                dp[j][i] =dontBuy;
                            }
                        } else {
                            dp[j][i] = dontBuy;

                        }
                    }
                }
            }
        }
        System.out.println(dp[numc ][allm ] * 10);
    }}
