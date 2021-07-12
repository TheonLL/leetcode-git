
package doublePointer;

public class Model {
	
	/*
	 * 二分搜索情况分类和模板
	 */
	public int binarySearch(int[] nums,int target) {
		//initial right and left pointer
		int left=0; int right=nums.length-1;
		while (left<=right) {
			int mid=(left+right)/2;
			if (nums[mid]<target) {
				left=mid+1;				
			}else if (nums[mid]>target) {
				right=mid-1;
			}else if (nums[mid]==target) {
				//直接返回
				return mid;
			}			
		}
		// if haven't
		return -1;	
	}
	public int leftBoundSearch_spacial(int[] nums,int target) {
		//initial right and left pointer
		int left=0; int right=nums.length;
		while (left<right) {
			int mid=(left+right)/2;
			if (nums[mid]<target) {
				left=mid+1;				
			}else if (nums[mid]>target) {
				right=mid;
			}else if (nums[mid]==target) {
				// 先别返回，锁定左侧边界
				right=mid;
			}			
		}

		return left;	
	}
	
	public int leftBoundSearch(int[] nums,int target) {
		//initial right and left pointer
		int left=0; int right=nums.length-1;
		while (left<=right) {
			int mid=(left+right)/2;
			if (nums[mid]<target) {
				left=mid+1;				
			}else if (nums[mid]>target) {
				right=mid-1;
			}else if (nums[mid]==target) {
				// 先别返回，锁定左侧边界
				left=mid-1;
			}			
		}
		// 最后检查left的越界情况
		if (left>=nums.length||nums[left]!=target) {
			return -1;
		}
		return left;	
	}
	
	public int rightBoundSearch_spacial(int[] nums,int target) {
		//initial right and left pointer
		int left=0; int right=nums.length;
		while (left<right) {
			int mid=(left+right)/2;
			if (nums[mid]<target) {
				left=mid+1;				
			}else if (nums[mid]>target) {
				right=mid;
			}else if (nums[mid]==target) {
				// 先别返回，锁定左侧边界
				left=mid+1;
			}			
		}

		return left-1;	
	}
	
	public int rightBoundSearch(int[] nums,int target) {
		//initial right and left pointer
		int left=0; int right=nums.length-1;
		while (left<=right) {
			int mid=(left+right)/2;
			if (nums[mid]<target) {
				left=mid+1;				
			}else if (nums[mid]>target) {
				right=mid-1;
			}else if (nums[mid]==target) {
				// 先别返回，锁定左侧边界
				left=mid+1;
			}			
		}
		// 最后检查left的越界情况
		if (right<0||nums[left]!=target) {
			return -1;
		}
		return right;	
	}

}
