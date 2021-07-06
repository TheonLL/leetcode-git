package dynanucProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

import javax.imageio.event.IIOReadWarningListener;
import javax.sound.midi.Soundbank;

public class MinCoins {
	public static void main(String[] args) {

		System.out.println("请输入amount：");
		Scanner scanner=new Scanner(System.in);
		int amount=scanner.nextInt();
//		System.out.println(s);
		int[] coinsList=new int[] {1,5,10,20,50,100};
		CoinChange coinChange=new CoinChange(coinsList, amount);
		long time1=System.currentTimeMillis();
		System.out.println(coinChange.minCoinMemo(amount));
//		System.out.println(coinChange.minCoinsEnum(amount));
//		System.out.println(coinChange.minCoinDpAarr(coinsList,amount));
		long time2=System.currentTimeMillis();
		System.out.printf("算法花费了%d毫秒",(time2-time1));
		
		
		

		
	}
	

}

class CoinChange{
	
	int[] coinsList;
	int amount;
	Map<Integer, Integer> memohashMap=new HashMap<>();
	/*
	 * 1 暴力穷举法 求解动态规划  速度最慢
	 */
	//
	public int minCoinsEnum(int amount) {
		//每次寻优都先初始化
		double coinsNum=Double.POSITIVE_INFINITY;
		//base case
		if (amount<0) {
			return -1;
		}else if (amount==0) {
			return 0;
		//正常情况
		}else {
			for(int coins :coinsList) {
				int subProblem=minCoinsEnum(amount-coins);
				//迭代终止条件
				if (subProblem==-1) {
					continue;
				// 选择硬币最少的组合
				}else {
					coinsNum=Math.min(coinsNum, subProblem+1);	
				}
			}
			//对值进行判断 并返回
			if (coinsNum!=Double.POSITIVE_INFINITY) {
				return (int) coinsNum;
			}else {
				return -1;
			}			
		}
	}
	
	
	/*
	 * 2 带备忘录的 自顶向下 速度一般   6000以下可以超过之后就会报错
	 */
	public int minCoinMemo(int amount) {

		if (memohashMap.containsKey(amount)) {
			return memohashMap.get(amount);
		}else {
			int coinNum=amount+1;
			if (amount<0) {
				return -1;
			}else if (amount==0) {
				return 0;
			}else {				
				for(int coins:coinsList) {
					int subProblem=minCoinMemo(amount-coins);
					// 迭代终止条件
					if (subProblem==-1) {
						continue;
					}else {
						coinNum=Math.min(coinNum, subProblem+1);
					}					
				}				
			}
			memohashMap.put(amount, (coinNum!=amount+1)? coinNum:-1);
			if (coinNum!=amount+1) {
				return coinNum;
			}else {
				return -1;
			}
			
		}
		
	}
	
	
	
	
	/*
	 * 3 dp数组 自底向上  速度最快
	 */
	public int minCoinDpAarr(int[] coinsList,int amount ) {
		if(coinsList.length==0) return -1;
		if (amount<0) return -1;
		int[] dparr=new int[amount+1];
		dparr[0]=0;
		Arrays.fill(dparr, 1, dparr.length, Integer.MAX_VALUE);
		for (int i = 0; i < dparr.length; ++i) {
			for(int coin :coinsList) {
				if (i-coin<0) continue;
				dparr[i]=Math.min(dparr[i], dparr[i-coin]+1);
			}
			}
		return (dparr[amount]==Integer.MAX_VALUE)? -1:dparr[amount];
			
		
	}
	
	// 构造方法
	public  CoinChange(int[] coinsList,int amount) {
		this.amount=amount;
		this.coinsList=coinsList;

	}
}

