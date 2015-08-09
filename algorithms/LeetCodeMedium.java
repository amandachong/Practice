public class LeetCodeMedium {

	/**
	 * Swap Nodes in Pairs: Given a linked list, swap every two adjacent nodes
	 * and return its head.
	 * 
	 * For example, given 1->2->3->4, you should return the list as 2->1->4->3.
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
}
