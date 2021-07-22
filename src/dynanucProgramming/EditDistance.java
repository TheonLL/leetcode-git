package dynanucProgramming;

public class EditDistance {
	public static void main(String[] args) {
		String s1="horse";
		String s2="ros";
		SolutionEditDistance solutionEditDistance=new SolutionEditDistance();
		System.out.println(solutionEditDistance.minDistance(s1, s2));
	}
}

class SolutionEditDistance{
	public int minDistance(String s1,String s2) {
		if (s1.length()*s2.length()==0){return Math.max(s1.length(), s2.length());}
		else {
			if (s1.equals(s2)) {
				return 0;
			}
			int rlength=s1.length()+1;
			int clength=s2.length()+1;
			// initial dp array
			int[][] dp=new int[rlength][clength];
			dp[0][0]=0;
			for (int i = 1; i <rlength; i++) {
				for (int j = 1; j < clength; j++) {
					// 替换字符或者不操作
					if (s1.charAt(i-1)==s2.charAt(j-1)) {
						dp[i][j]=dp[i-1][j-1];
					// 如果是插入
					}else {
						dp[i][j]=Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]))+1;
					}
				}
			}
			
			return dp[rlength-1][clength-1];
		}
		
	}
}