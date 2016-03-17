
public class MergeSortedArrays {
	public static void main(String[] args){
		int[] first = new int[9];
		first[0] = 4;
		first[1] = 8;
		first[2] = 12;
		first[3] = 13;
		first[4] = 16;
		int[] second = {3,7,9,10};
		
		
		
		merge(first, 9, second, 4);
		
	}
	
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
    	int k = m+n-1;
    	int i = m-1;
    	int j = n-1;

    	while(i>-1 && j>-1){
    		nums1[k--] = (nums1[i]>nums2[j])?nums1[i--]:nums2[j--];
    	}
    	while(j>-1){
    		nums1[k--] = nums2[j--];
    	}
    }
}
