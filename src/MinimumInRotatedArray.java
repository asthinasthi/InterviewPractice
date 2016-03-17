
public class MinimumInRotatedArray {

	public static void main(String[] args){
		int[] nums = {3,4,5,1,2};
//		int[] nums = {3,1,2};
//		int[] nums = {2,1};
//		int[] nums = {2,3,4,5,1};
//		int[] nums = {5,1,2,3,4};
		int res = getMin(nums);
		System.out.println(res);
	}
	
	public static int getMinInArray(int[] nums){
		if(nums.length == 0){
			return 0;
		}
//		if(nums.length == 1){
//			return nums[0];
//		}
		int i = 0;
		int j = nums.length - 1;
		while(nums[i] > nums[j]){
				i++;
				j--;
		}
		if(i==0){
			return nums[0];
		}
		if(nums[i-1]>nums[i]){
			return nums[i];
		} else {
			return nums[i+1];
		}
	}
	
	public static int getMin(int[] nums){
		if(nums.length == 1){
			return nums[0];
		}
		int i =0;
		for(i=0;i<nums.length-1;i++){
			if(nums[i] > nums[i+1]){
				
			} else {
				break;
			}
		}
		if(i==0){
			return nums[nums.length-1];
		}
		if(i == (nums.length-1)){
			return nums[i+1];
		}
		return nums[i];
	}
}
