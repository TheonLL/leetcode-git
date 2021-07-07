package doublePointer;

public class leftRightPointer {
	
	/*
	 * 1 二分查找 对于有序数组
	 */
	public static int binarySearch(int[] nums,int target) {
		// initial pointer
		int left=0;
		int right=nums.length-1;
		while (left<=right) {
			int mid=(right+left)/2;
			if (nums[mid]==target) {
				return mid;
			}else if (nums[mid]<target) {
				left=mid+1;
			}else if (nums[mid]>target) {
				right=mid-1;
			}
		}
		return -1;
		
	}
	
	/*
	 * 2、反转数组
	 */
	public static void reverse(int[] nums) {
		int left=0;
		int right=nums.length-1;
		while (left<right) {
			int temp=nums[left];
			nums[left]=nums[right];
			nums[right]=temp;
			left++;
			right--;			
		}
		
	}
	
	
	public static void main(String[] args) {
		
	}

}
