import java.util.Arrays;

public class KthLargestInUnsortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,2,1,5,6,4};
		int k = 2;
		System.out.println(findK(nums, k));
	}
	
	public static int findK(int[] nums, int k){
		Arrays.sort(nums);
		return nums[nums.length-k];
	}
}
