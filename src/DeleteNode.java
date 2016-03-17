
public class DeleteNode {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = null;
				
		deleteNode(node3);
		ListNode node= node1;
		while(node!=null){
			System.out.println(node.val + "-->");
			node = node.next;
		}
		
	}
	
	public static void deleteNode(ListNode node){
		ListNode temp = node;
		node = temp.next;
		
	}
}


 class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
 }