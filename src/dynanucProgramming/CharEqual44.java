package dynanucProgramming;

public class CharEqual44 {

}

class SolutionCharEquals{
	public boolean solution(String[] strings,String[] strings2) {
		int len1=strings.length;
		int len2=strings2.length;
		if (len1*len2==0) {
			if (len1==0&&len2==0) {
				return true;
			}
			return false;			
		}else {
			//create dparr
			boolean[][] dp=new boolean[len1+1][len2+1];
			//initial dparr
			dp[0][0]=true;
			// iterate state
			for (int i = 0; i <= len1; ++i) {
				for (int j = 0; j <=len2; ++j) {
					boolean nowChar=true;
					if (nowChar) {
						
					}
					dp[i][j]=dp[i-1][j-1]||nowChar;
				}
			}
			return true;
		}
		
	}
}