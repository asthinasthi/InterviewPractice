
public class MinSizeSubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3, 4, 5, 8};
		int s = 7;
//		int[] nums = {2,3,1,2,4,3};
//		int s = 7;
		System.out.println(minSubArrayLen(s, nums));
	}

public static int minSubArrayLen(int s, int[] nums) {
		if(s==0){
			return 0;
		}
		int start = 0;
		int end = 0;
		int sum = 0;
		int minLength = nums.length+1;
		while(end < nums.length){
			sum+=nums[end++];
			while(sum>=s){
				minLength = Math.min(minLength, end-start);
				sum-=nums[start++];
			}
		}
		return minLength==nums.length+1 ? 0 : minLength;
	}
}
