/**
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 */
class MinStack {

	ListNode top;

	public void push(int x) {
		ListNode node = new ListNode(x);
		if (top == null) {
			top = node;
			top.min = x;
		} else {
			node.min = Math.min(x, top.min);
			ListNode tmp = top;
			top = node;
			top.next = tmp;
		}
	}

	public void pop() {
		if (top == null) {
			return;
		}
		top = top.next;
	}

	public int top() {
		if (top == null) {
			return Integer.MAX_VALUE;
		}
		return top.val;
	}

	public int getMin() {
		if (top == null) {
			return Integer.MAX_VALUE;
		}
		return top.min;
	}
}