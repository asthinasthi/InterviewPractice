import java.util.Arrays;

public class MedianOfTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[]{1,2};
		int[] B = new int[]{6,7,8,9,10};
		  int m = A.length, n = B.length;
	        int l = (m + n + 1) / 2;
	        int r = (m + n + 2) / 2;
	        System.out.println((findKth(A, 0, B, 0, l) + findKth(A, 0, B, 0, r)) / 2.0);
	}

	public static double findMedian(int[] nums1, int[] nums2){
		int i = 0;
		int j = 0;
		if(nums1 == null){
			nums1 = new int[0];
		}
		if(nums2 == null){
			nums2 = new int[0];
		}
		int[] nums = new int[nums1.length + nums2.length];
		while(i<nums1.length && j<nums2.length){
			if(nums1[i] < nums2[j]){
				nums[i+j] = nums1[i++];
				nums[i+j] = nums2[j];
			} else {
				nums[i+j] = nums2[j++];
				nums[i+j] = nums1[i];
			}
		}
		if(i == nums1.length){
			for(;j<nums2.length;j++){
				nums[i+j] = nums2[j];
			}
		} else {
			for(;i<nums1.length;i++){
				nums[i+j] = nums1[i];
			}
		}
		for(int num: nums){
			System.out.print(num+",");
		}
		System.out.println();
		if(nums.length%2 == 0){
			return (double)(nums[nums.length/2] + nums[nums.length/2 -1])/2;
		} else{
			return nums[nums.length/2];
		}
	}
	
	public static double findKth(int[] a, int aStart, int[] b, int bStart, int k){
		if(aStart > a.length -1 ){
			return b[bStart + k - 1];
		}
		
		if(bStart > b.length -1){
			return a[aStart + k - 1];
		}
		
		if(k == 1){
			return Math.min(a[aStart], b[bStart]);
		}
		
		int aKth = Integer.MAX_VALUE;
		int bKth = Integer.MAX_VALUE;
		if(aStart + k/2 - 1 < a.length){
			aKth = a[aStart+k/2-1];
		}
		if(bStart + k/2 - 1 < b.length){
			bKth = b[bStart+k/2-1];
		}
		
		if(aKth < bKth){
			return findKth(a, aStart + k/2, b, bStart, k-k/2);
		} else {
			return findKth(a, aStart, b, bStart+k/2, k-k/2);
		}
	}

	public static double getMedian(int nums[]){
		int n = nums.length;
		if(n%2 == 0){//even
			return (double)(nums[n/2] + nums[n/2 -1])/2;
		} else {//odd
			return nums[n/2];
		}
	}
}
