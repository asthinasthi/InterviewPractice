
public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inputarray = {1,2,2,3,3,4,4,5,5,8,9,10,10,10,10};
		System.out.println(removeDuplicates(inputarray));
 
	}

	public static int removeDuplicates(int[] nums){
		if(nums.length == 0){
			return 0;
		}
		int i = 0;
		int j = 0;
		while(j<nums.length-1){
			if(nums[j] != nums[j+1]) {
					if(i<j){
						nums[i+1] = nums[j+1];
					}
					i++;
				}
			j++;
		}
		if(i<j){
			nums[i] = nums[j];
		}
//		for(int idx=0; idx<nums.length;idx++)
//			System.out.print(nums[idx]+",");
//		System.out.println();
		return i+1;
	}
}
