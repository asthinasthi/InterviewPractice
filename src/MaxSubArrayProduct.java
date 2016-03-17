import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MaxSubArrayProduct {

	public static void main(String args[]){
//		int[] input = {2,3,-4,5,6,7,8,-10,11,12,-3,5};
		int[] input = {2,3,-4,5,6,0,100,-10,-1000};
		System.out.println(getMaxProd(input));
	}
	static int getMaxProd(int[] nums){
		List<Integer> inputList = new ArrayList<Integer>();
		ArrayList<Integer> zeroPos = new ArrayList<Integer>();
		for(int i=0;i<nums.length;i++){
			inputList.add(nums[i]);
			if(nums[i] == 0){
				zeroPos.add(i);
			}
		}
		int Max = 0;
		int start = 0;
		
		if(zeroPos.size() == 0){
			Max = getMaxProdForNonZero(inputList);
		} else {
			for(int i=0 ;i<zeroPos.size();i++){
				Max = Math.max(Max, getMaxProdForNonZero(inputList.subList(start, zeroPos.get(i))));
				start = zeroPos.get(i)+1; 
			}
			Max  = Math.max(Max, getMaxProdForNonZero(inputList.subList(start, inputList.size())) );
		}
		return Max;
	}
	static int getMaxProdForNonZero(List<Integer> numsList){
		if(numsList.size() == 1){
			return numsList.get(0);
		}
		if(numsList.size() == 0){
			return 0;
		}
		
	      int numOfNeg = 0;
			int firstNeg = 0;
			int lastNeg = 0;
			int prodTillLastNeg = 1;
			int prodFromFirstNegToLast = 1;
			int allProd = 1;
			for(int i=0;i<numsList.size();i++){
				if(numsList.get(i)<0){
					numOfNeg++;
					if(numOfNeg == 1){
						firstNeg = i;
					}
					lastNeg = i;
				}
				allProd*=numsList.get(i);
			}
			if(numOfNeg%2 == 0){//even
				return allProd;
			}else {
//				for(int i=0;i<lastNeg;i++){
//					firstProd*=numsList.get(i);
//				}
				prodTillLastNeg = allProd;
				for(int i=lastNeg; i< numsList.size();i++){
					prodTillLastNeg/=numsList.get(i);
				}
				prodFromFirstNegToLast = allProd;
//				for(int i=firstNeg+1; i<numsList.size();i++){
//					lastProd*=numsList.get(i);
//				}
				for(int i=0; i<firstNeg+1;i++){
					prodFromFirstNegToLast/=numsList.get(i);
				}
				return Math.max(prodTillLastNeg, prodFromFirstNegToLast);
			}
	}
	

}
