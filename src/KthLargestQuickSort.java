import javax.naming.PartialResultException;

public class KthLargestQuickSort {

	public static void main(String[] args) {
//		int[] nums = {4,2,1,3,5,7,6};
		int[] nums = {5,2,4,1,3,6,0};
		int k = 7;
		System.out.println(kthLargest(nums, 0, nums.length-1, k-1));
	}
	
	public static int kthLargest(int[] nums, int low, int high, int k){
		if(nums.length == 0){
			return 0;
		}
		int pos = partition(nums, low, high);
		
		if(pos == k){
			return nums[pos];
		} else if(pos > k ){
			pos = kthLargest(nums, low, pos-1, k);
		} else {
			pos = kthLargest(nums, pos+1, high, k);
		}
		
		return pos;
	}
	
	public static void exchange(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static int partition(int[] arr, int low, int high){
		int smallestSoFar = low;
		int pivot_val = arr[high];
		
		for(int j=low; j<=high-1; j++){
			if(arr[j] > pivot_val){
				exchange(arr, smallestSoFar, j);
				smallestSoFar++;
			}
		}
		exchange(arr, smallestSoFar, high);
		return smallestSoFar;
	}
}
