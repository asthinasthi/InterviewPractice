
public class QuickSort {

	public static void main(String[] args){
		int[] nums = {5,4,3,2,1,7,8};
		
		for(int num: nums){
			System.out.print(num + ", ");
		}
		System.out.println();
		sort(nums, 0, nums.length-1);
		for(int num: nums){
			System.out.print(num + ", ");
		}
	}
	
	public static void sort(int[] nums, int low, int high){
		int pivot = low + (high-low)/2;
		
		int i = low;
		int j = high;
		
		while(i<=j){
			while(nums[i] <  nums[pivot]){
				i++;
			}
			while(nums[j] > nums[pivot]){
				j--;
			}
			
			if(i<=j){
				exchange(nums, i, j);
				i++;
				j--;
			}
		}
		if(low <= pivot-1)
			sort(nums, low, pivot-1);
		if(pivot+1 <= high)
			sort(nums, pivot+1, high);
	}
	
	public static void exchange(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
