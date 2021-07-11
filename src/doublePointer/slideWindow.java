package doublePointer;

import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.imageio.event.IIOReadWarningListener;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

/*
 * 双指针问题之滑动窗口类型题目解法
 */
public class slideWindow {

	
	/*
	 * 1 最小子覆盖问题 
	 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
	 * 输入：s = "ADOBECODEBANC", t = "ABC"
		输出："BANC"
	 */
	
	public static String minSubCoverage(String s,String t) {
		//创建两个hashMap来分别来存储，所需char和窗口中已经存在char的数量
		Map<Character, Integer> needMap=new HashMap<>();
		Map<Character, Integer> windowMap=new HashMap<>();
		
		// 初始化 needMap
		for (int i=0;i<t.length();++i) {needMap.put(t.charAt(i), 0);}
		for (int i=0;i<t.length();++i) {needMap.put(t.charAt(i), needMap.get(t.charAt(i)+1));}
		for (int i=0;i<t.length();++i) {windowMap.put(t.charAt(i), 0);}

		//初始化左右指针索引 初始窗口的左右
		int left=0;
		int right=0;
		//创建一个值了存储记录，解是否符合条件
		int valid=0;
		//记录最小覆盖子串的起始索引和长度
		int startIndex=0;
		int subStrLen=Integer.MAX_VALUE;
		while (right<s.length()) {
			//将初始窗口的右边扩大边界，并将字符存入windowMap中 j
			char c=s.charAt(right);
			// 窗口右边范围扩大
			right++;
			// 在窗口内部对数据进行一系列的更新
			//对c进行判断，是否为need的字符
			if (needMap.containsKey(c)) {
				windowMap.put(c, windowMap.get(c)+1);
				if (needMap.get(c)==windowMap.get(c)) {
					valid++;					
				}
			}
			//判断左侧窗口是否要收缩
			while (valid==needMap.size()) {
				//通过移动窗口左边指针来缩小窗口，优化可行解
				if (right-left<subStrLen) {
					//临时存储left的值。left更新后进行下一步探索，如果不合符，则返回startIndex做为解窗口的左索引
					startIndex=left;
					subStrLen=right-left;
				}
				// 通过将left索引上的字符弹出窗口 来缩小窗口
				char d=s.charAt(left);
				// 更新 窗口左边索引 缩小窗口
				left++;
				// 对窗口内部数据进行一系列的更新
				if (needMap.containsKey(d)) {					
					if (windowMap.get(d)==needMap.get(d)) {
						valid--;
					}
					windowMap.put(d, windowMap.get(d)-1);
				}
			}			
		}		
		// 返回最小字符串
		return subStrLen==Integer.MAX_VALUE?"":s.substring(startIndex, startIndex+subStrLen);		
	}
	
	/*
	 * 2 字符串排列 
	 * 
	 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
	 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
	 */
	public static boolean ifHasSubStr(String subStr,String str) {
		//创建map存储
		Map<Character, Integer> needMap=new HashMap<>();
		Map<Character, Integer> windowMap=new HashMap<>();
		//初始化map
		for (int i = 0; i < subStr.length(); i++) {needMap.put(subStr.charAt(i), 0);}
		//使得 subStr中如果有重复元素也可以实现
		for (int i = 0; i < subStr.length(); i++) {needMap.put(subStr.charAt(i), needMap.get(subStr.charAt(i))+1);}
		for (int i = 0; i < subStr.length(); i++) {windowMap.put(subStr.charAt(i), 0);}
		int left=0;
		int right=0;
		int valid=0;
		int startIndex=0;
		int strLen=Integer.MAX_VALUE;
		
		while (right<str.length()) {	
			char c=str.charAt(right);
			right++;
			//操作
			if (needMap.containsKey(c)) {
				windowMap.put(c, windowMap.get(c)+1);
				if (needMap.get(c)==windowMap.get(c)) {
					valid++;
				}												
			}
			//当窗口长度等于 valid char 个数 表示，窗口内只含needmap中的char
			//判断是否左收缩时，尽量用每次while循环都会改变的变量  subStr 连续用定窗口滑动
			while (right-left>=subStr.length()) {
				if(valid==needMap.size()) return true;
				char d=str.charAt(left);
				left++;
				//操作
				if (needMap.containsKey(d)) {
					if (needMap.get(d)==windowMap.get(d)) {
						valid--;
					}
					windowMap.put(d, windowMap.get(d)-1);
				}		
			}						
		}		
		return false;
	}
	
	
	
	
	/*
	 * 3 找到所有字母异位词
	 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
	 *字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
	 */
	public static ArrayList<Integer> findAllAnagramsString(String s,String p) {
		//创建needMap和windowMap来记录子字符
		Map<Character, Integer> needMap=new HashMap<>();
		Map<Character, Integer> windowMap=new HashMap<>();
		
		//初始化needMap and windowMap
		for (int i = 0; i < p.length(); i++) {needMap.put(p.charAt(i), 0);}
		for (int i = 0; i < p.length(); i++) {needMap.put(p.charAt(i), needMap.get(p.charAt(i))+1);}
		for (int i = 0; i < s.length(); i++) {windowMap.put(s.charAt(i), 0);}
		
		//初始化指针索引
		int left=0;
		int right=0;
		int valid=0;
		
		ArrayList<Integer> resultList=new ArrayList<Integer>();		
		//判断是否遍历晚字符串
		while (right<s.length()) {
			char c=s.charAt(right);
			right++;			
			//字符串内部操作
			if (needMap.containsKey(c)) {
				windowMap.put(c, windowMap.get(c)+1);
				if (needMap.get(c)==windowMap.get(c)) {
					valid++;
				}				
			}
			
		//判断是否 需要进行左收缩
			while (right-left>=p.length()) {
				if (valid==needMap.size()) {
					resultList.add(left);			
				}			
				char d =s.charAt(left);
				left++;
				if (needMap.containsKey(d)) {
					if (needMap.get(d)==windowMap.get(d)) {
						valid--;
					}					
					windowMap.put(d, windowMap.get(d)-1);					
				}
			}			
		}
		return resultList;
	}
	
	
	
	
	/*
	 * 4 最长无重复子串
	 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
	 */
	public static int longestSubstrWithoutRepeating(String s) {
		//创建needMap和windowMap存储字符串
		Map<Character, Integer> windowMap=new HashMap<>();
		
		//初始化
		for (int i = 0; i < s.length(); i++) {windowMap.put(s.charAt(i), 0);}
		
		//初始化索引
		int left=0;
		int right=0;
		int valid=0;
		
		//window向右边扩张
		while (right<s.length()) {
			char c=s.charAt(right);
			right++;			
			windowMap.put(c, windowMap.get(c)+1);

							
			// 判断是不是需要收缩左窗口
			while (windowMap.get(c)>1) {
				char d=s.charAt(left);
				left++;
				//对窗口进行数据操作
				windowMap.put(d, windowMap.get(d)-1);
			}
			valid=Math.max(valid, right-left);
					
		}
		return valid;
	}
	
	
	
	public static void main(String[] args) {
//		System.out.println("请输入字符串s:");
//		Scanner scanner=new Scanner(System.in);
//		String s=scanner.nextLine();
//		System.out.println("请输入子字符串t：");
//		String t=scanner.nextLine();
//		String s="ADOBECODEBANC";
//		String t="ABC";
//		String substr=minSubCoverage(s,t); 
//		String substr=minSubCoverage(s,t); 
		
		
//		String s="abb";
//		String t="eidbobbaoo";
//		boolean substr=ifHasSubStr(s,t);
//		System.out.println("结果为："+substr);
		
//		String s="cbaebabacd";
//		String t="abc";
//		System.out.println(findAllAnagramsString(s,t));
		
		
		
		String s="abcabcbb";

		System.out.println(longestSubstrWithoutRepeating(s));		
		
	}
	
}
