package leetcodeTest;

import java.util.HashMap;
import java.util.Map;

public class FindSubs1 {
	public static void main(String[] args) {
		String p="abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
		SolutionfindSubstringInWraproundString1 solutionfindSubstringInWraproundString=new SolutionfindSubstringInWraproundString1();
		
		System.out.println(solutionfindSubstringInWraproundString.findSubstringInWraproundString(p));
	}

}




class SolutionfindSubstringInWraproundString1 {
	public int findSubstringInWraproundString(String p) {
        // 记录 p 中以每个字符结尾的最长连续子串的长度
        int[] dp = new int[26];
        char[] array = p.toCharArray();
        // 记录当前连续子串的长度
        int count = 0;
        // 遍历 p 中的所有字符
        for (int i = 0; i < array.length; i++) {
            // 判断字符是否连续
            if (i > 0 && (array[i] - array[i - 1] - 1) % 26 == 0) {
                // 连续则自加
                count++;
            } else {
                // 不连续则刷新
                count = 1;
            }
            // 只存储最长的连续长度
            dp[array[i] - 'a'] = Math.max(dp[array[i] - 'a'], count);
        }
        int result = 0;
        // 统计所有以每个字符结尾的最长连续子串的长度，就是唯一相等子串的个数
        for (int i : dp) {
            result += i;
        }
        return result;
    }
  
}