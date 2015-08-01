public class LeetCodeMedium {

	/**
	 * Given a singly linked list, swap the list in pairs (reconnect the
	 * pointers, not simply swap the values).
	 * 
	 * For example: Before: A -> B -> C -> D After: B -> A -> D -> C
	 */
	public static ListNode swapPairs(ListNode node) {
		if (node == null) {
			return node;
		}
		if (node.next == null) {
			return node;
		}
		ListNode ret = node.next;
		ListNode nextNext = node.next.next;
		ret.next = node;
		node.next = swapPairs(nextNext);
		return ret;
	}

	public static void testSwapPairs() {
		ListNode a = new ListNode("A");
		a.add(new ListNode("B")).add(new ListNode("C")).add(new ListNode("D"))
				.add(new ListNode("E"));
		printNodes(swapPairs(a));
	}

	public static void printNodes(ListNode node) {
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}

	public double myPow(double x, int n) {
		if (n == 0) {
			return 1;
		} else if (n > 0) {
			return x * myPow(x, n - 1);
		} else {
			return 1 / (x * myPow(x, Math.abs(n + 1)));
		}
	}

	public static void main(String[] args) {

	}

}
