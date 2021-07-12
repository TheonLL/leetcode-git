package doublePointer;

public class RotateArr {
	
	public static void main(String[] args) {
		int[] arr=new int[] {4,5,6,7,0,1,2};
		Solution solution=new Solution();
		
		System.out.println(solution.rotareArrSearch(arr, 0));
}
}


class Solution{
	public int rotareArrSearch(int[] rotateArr,int target) {
		//initial left right pointer
		int left=0;int right=rotateArr.length-1;

		//iterate 
		while (left<=right) {
			//create mid
			int mid=(left+right)>>1;
			if(rotateArr[mid]==target) return mid;
			if (rotateArr[left]<=rotateArr[mid]) {
				if (rotateArr[left]<=target&&target<=rotateArr[mid]) {
					right=mid-1;
				//虽然不是顺序升 但是是阶梯升
				}else {
				left=mid+1;	
				}
				
			}else {
				if (rotateArr[mid]<=target&&target<=rotateArr[right]) {
					left=mid+1;
					
				}else {
					right=mid-1;
				}
			}
			
		}
		
		return-1;
	}
	
}
