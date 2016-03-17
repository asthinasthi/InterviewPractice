
public class RotateArrayInPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6,7};
				
		int k = 3;
		getRotatedArray(nums, k);
//		getRotatedArrayFast(nums, k);
	}
	
	public static void getRotatedArrayFast(int[] nums, int k){
		if(k>nums.length){
			return;
		}
		while(k>0){
			int temp = nums[nums.length-1];
			for(int i=nums.length-1; i>0 ;i--){
				nums[i] = nums[i-1];
			}
			nums[0] = temp;
			k--;
		}
//		for(int num: nums){
//		System.out.print(num + ",");
//		}
		
	}
	public static void getRotatedArray(int[] nums, int k){
		if(nums.length == 1 || nums.length == 0 || k>=nums.length || k == 0){
			
		} else {
			int size = nums.length;
			int j = size-k;
			int i = j-1;
			int temp = 0;
			
			while(Math.abs(i) < Math.abs(j) ){
				for(int idx = Math.abs(i); idx<Math.abs(j);idx = idx+2){
//					temp = nums[idx];
//					nums[idx] = nums[idx+1];
//					nums[idx+1] = temp;
					nums[idx] = nums[idx]^nums[idx+1];
					nums[idx+1] = nums[idx]^nums[idx+1];
					nums[idx] = nums[idx]^nums[idx+1];
				}
	
				if(j==size-1){
					j = -(size-1);
				}
				i--;
				j++;
			}
//			for(int num: nums){
//				System.out.print(num + ",");
//			}
		}
	}
}
