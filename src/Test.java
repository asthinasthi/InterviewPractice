
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1,2,3,4};
		exchange(nums, 2, 3);
		
		for(int num: nums){
			System.out.print(num);
			System.out.print(", ");
		}
	}
	
	public static void exchange(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
