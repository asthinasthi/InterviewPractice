import java.util.Arrays;

import javax.sound.sampled.ReverbType;

public class RotateArray {
	
	public static void main(String[] args) {
		int[] array ={1,2,3,4,5,6,7}; // 5 6 7 1 2 3 4
		// 1 2 3 4 5 6 7
		// 4 3 2 1 5 6 7
		// 4 3 2 1 7 6 5
		// 5 6 7 1 2 3 4
		int k = 3;
		rotateArray(array, k);
	}
	
	public static void rotateArray(int[] array, int k){
		//Partition arr & rotate first part
		System.out.println(Arrays.toString(array));
		reverse(array, 0, array.length-k-1);
		System.out.println(Arrays.toString(array));
		reverse(array, array.length-k, array.length-1);
		System.out.println(Arrays.toString(array));
		reverse(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
	}
	
	public static void reverse(int[] arr, int startIdx, int endIdx){ // 1 2 3 4 5 6 --> 6 5 4 3 2 1
		if(arr.length == 0 || startIdx > endIdx){
			return;
		}
		while(startIdx < endIdx){
			//swap start and end
			int temp = arr[startIdx];
			arr[startIdx] = arr[endIdx];
			arr[endIdx] = temp;
			startIdx++;
			endIdx--;
		}

	}
}
