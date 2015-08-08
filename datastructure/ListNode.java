/**
 * Definition for singly-linked list.
 */
public class ListNode extends Node {

	public int val;
	public ListNode next;
	public int min;
	public String s;

	public ListNode(int x) {
		val = x;
		next = null;
	}

	public ListNode(String s) {
		this.s = s;
		next = null;
	}

	public ListNode add(ListNode node) {
		next = node;
		return next;
	}
}
