package dynanucProgramming;

public class MaxSubArray {
	public static void main(String[] args) {
		int[] A =new int[] {1,2,3,2,1};
		int[] B =new int[] {3,2,4,1,7};
		solutionMaxSubArr maxSubArr=new solutionMaxSubArr();
		System.out.println(maxSubArr.findLength(A, B));
	}

}


class solutionMaxSubArr{
	
	public int findLength(int[] A, int[] B) {
	    return A.length < B.length ? findMax(A, B) : findMax(B, A);
	}

	int findMax(int[] A, int[] B) {
	    int max = 0;
	    int an = A.length, bn = B.length;
	    for(int len=1; len <= an; len++) {
	        max = Math.max(max, maxLen(A, 0, B, bn - len, len));
	    }
	    for(int j=bn-an; j >= 0;j--) {
	        max = Math.max(max, maxLen(A, 0, B, j, an));
	    }
	    for(int i=1;i<an;i++) {
	        max = Math.max(max, maxLen(A, i, B, 0, an - i));
	    }
	    return max;
	}

	int maxLen(int[] a, int i, int[] b, int j, int len) {
	    int count = 0, max = 0;
	    for(int k = 0; k < len; k++) {
	        if(a[i+k] == b[j+k]) {
	            count++;
	        } else if(count > 0) {
	            max = Math.max(max, count);
	            count = 0;
	        }
	    }
	    return count > 0 ? Math.max(max, count) : max;
	}

	
	
}