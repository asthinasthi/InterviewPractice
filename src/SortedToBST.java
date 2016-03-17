import java.awt.print.Printable;

import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.PBEKeySpec;

public class SortedToBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] inputArray = {1,2,3,4,5,6};
		SortedToBST object = new SortedToBST();
		TreeNode root = object.sort(inputArray, 0, inputArray.length-1);
		printBST(root);
	}

	static void printBST(TreeNode root){
		if(root == null){
			return;
		}
		printBST(root.left);
		printBST(root.right);
		
		System.out.println(root.val);
		

	}
	
	public TreeNode sort(int[] nums, int begin, int end){
		
		if(begin>end){
			return null;
		}
		
		TreeNode root = new TreeNode(nums[begin+(end-begin)/2]);
		
		root.left = sort(nums, begin, begin+(end-begin)/2-1);
		root.right = sort(nums, begin+(end-begin)/2+1, end);
		
		return root;
	}
	
	public class TreeNode{
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
}
