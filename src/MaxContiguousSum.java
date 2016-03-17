import javax.swing.text.html.CSS;

public class MaxContiguousSum {
	public static void main(String[] args){
		int[] inputArray = {-2,1,-3,4,-1,2,1,-50,6,12}; 
		System.out.println(maxSubArray(inputArray));
		
	}

	public static int maxSubArray(int[] nums) {
		if(nums.length>0){
	        int max = nums[0];
	        int currSum = nums[0];
	        
	        
	        for(int i=1; i<nums.length;i++){
	        	currSum += nums[i];
        		if(currSum < 0){
        			currSum = nums[i];
        		}
	        	if(nums[i] < 0){
	        		if(nums[i] > max){
	        			max = nums[i];
	        		}
	        	} else {
	        			if(currSum>=0 && currSum < nums[i]){
	        				currSum = nums[i];
	        			}
	        	}
	        	if(currSum > max){
	        		max = currSum;
	        	}
//	        	System.out.println("Max: " + max);
//	        	System.out.println("Current Sum: " + currSum);
	        }
	        return max;
		} else {
			return 0;
		}
    }
	
	public static int maxSubArrayWorking(int[] nums) {
		if(nums.length>0){
	        int max = nums[0];
	        int currSum = nums[0];
	        
	        for(int i=1; i<nums.length;i++){
	        	currSum += nums[i];
	        	if(nums[i] < 0){
	        		if(nums[i] > max){
	        			max = nums[i];
	        		}
	        		if(currSum < 0){
	        			currSum = nums[i];
	        		}
	        	} else {
	        		if(currSum<0){
	        			currSum = nums[i];
	        		} else{//Sum is positive
	        			if(currSum < nums[i]){
	        				currSum = nums[i];
	        			}
	        		}
	        	}
	        	if(currSum > max){
	        		max = currSum;
	        	}
//	        	System.out.println("Max: " + max);
//	        	System.out.println("Current Sum: " + currSum);
	        }
	        return max;
		} else {
			return 0;
		}
    }
}
