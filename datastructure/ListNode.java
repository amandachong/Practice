/**
 * Definition for singly-linked list.
 */
public class ListNode {

	int val;
	int min;
	ListNode next;
	String s;

	ListNode(int x) {
		val = x;
		next = null;
	}

	ListNode(String s) {
		this.s = s;
		next = null;
	}

	public ListNode add(ListNode node) {
		next = node;
		return next;
	}
}
