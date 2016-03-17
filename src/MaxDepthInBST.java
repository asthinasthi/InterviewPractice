import javax.annotation.Generated;

public class MaxDepthInBST {
	/*    10
	 * 6     11
	 4   7     12
	2 3 
	 * */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(6);
		root.right = new TreeNode(11);
		root.left.left = new TreeNode(4);
		root.left.right  = new TreeNode(7);
		root.left.left.left = new TreeNode(2);
		root.left.left.right = new TreeNode(3);
		root.right.right = new TreeNode(12);
		
		System.out.println(getDepth(root));
	}
	
	static int getDepth(TreeNode root){
		int leftDepth = 0;
		int rightDepth = 0;
		if(root == null){
			return 0;
		}
		leftDepth = getDepth(root.left);
		rightDepth = getDepth(root.right);
		
		if(leftDepth > rightDepth){
			return leftDepth+1;
		} else {
			return rightDepth+1;
		}
	}
}
 class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
