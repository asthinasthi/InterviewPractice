import java.util.HashMap;

public class RemoveDup {

	public static void main(String[] args){
		int[] nums = {1,1,1,2,2,3};
//		int[] nums = {1,2,2};
//		int[] nums = {2,2,2,2};
//		int[] nums = {1,1};
//		int[] nums = {1,1,1,2,2,2,3,3};
 		System.out.println(removeDup(nums));
	}
	
	public static int removeDup(int[] nums){
		if(nums.length == 0){
			return 0;
		}
		int count = 1;
		int prev = nums[0];
		int begin = 1;
		for(int i=1; i<nums.length; i++){
			if(prev == nums[i]){
				count++;
			} else {
				count = 1;
			}
			if(count <=2){
				if(begin < i){
					nums[begin] = nums[i];
				}
				begin++;
			}
			prev = nums[i];
		}
		return begin;
	}
}
