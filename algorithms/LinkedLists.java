import java.util.HashSet;
import java.util.Hashtable;

public class LinkedLists {

	public ListNode beginningOfLoop(ListNode n) {
		Hashtable<Integer, ListNode> table = new Hashtable<Integer, ListNode>();
		while (n != null) {
			if (table.contains(n)) {
				return n;
			}
			table.put(n.value, n);
			n = n.next;
		}
		return null;
	}

	/**
	 * Reverse a linked list
	 * 
	 * Input: head -> 2 -> 3 -> 1
	 * 
	 * Output: 1 -> 3 -> 2 -> head
	 */
	public static Node reverseLinkedList(Node head, Node node) {
		if (head == null) {
			return null;
		}
		if (node == null) {
			return head;
		}
		Node n1 = head;
		Node n2 = node;
		Node temp = n2.next;
		n2.next = n1;
		n1.next = temp;
		return reverseLinkedList(n2, n1.next);
	}

	public Node findMiddle(Node node) {
		Node middle = node;
		Node last = node;
		while (last != null) {
			last = last.next.next;
			middle = middle.next;
		}
		return middle;
	}

	public static int nthLast(Node n, int nthLast) {
		if (n == null)
			return nthLast--;
		int i = nthLast(n.next, nthLast);
		if (i == 0)
			return n.value;
		else
			return i--;
	}

	public static int nthElement(Node n, int nth) {
		if (nth == 0)
			return n.value;
		while (nth != 0) {
			n = n.next;
			nth--;
		}
		return n.value;
	}

	public ListNode addTwoNumbers(ListNode a, ListNode b) {
		ListNode head = new ListNode(0);

		ListNode first = a;
		ListNode second = b;
		ListNode third = head;

		int carry = 0;

		while (first != null || second != null) {
			if (first != null) {
				carry += first.val;
				first = first.next;
			}

			if (second != null) {
				carry += second.val;
				second = second.next;
			}

			third.next = new ListNode(carry % 10);
			carry = carry / 10;
			third = third.next;
		}

		if (carry > 0) {
			third.next = new ListNode(carry);
		}

		return head.next;
	}

	public ListNode findBeginning(ListNode head) {
		ListNode n1 = head;
		ListNode n2 = head;
		while (n2.next != null) {
			n1 = n1.next;
			n2 = n2.next.next;
			if (n1 == n2)
				break;
		}
		if (n2.next == null)
			return null;
		n1 = head;
		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}
		return n2;
	}

	public ListNode nthToLast(ListNode node, int n) {
		if (node == null || n < 1) {
			return null;
		}

		ListNode n1 = node;
		ListNode n2 = node;

		for (int i = 0; i < n; i++) {
			if (n2 == null)
				return null;
			n2 = n2.next;
		}

		while (n2.next != null) {
			n2 = n2.next;
			n1 = n1.next;
		}
		return n1;
	}

	public ListNode mthToLast(ListNode node, int m) {
		if (node == null || m < 1) {
			return null;
		}
		ListNode ret = node;
		ListNode last = node;
		while (m > 0) {
			if (last == null) {
				return null;
			}
			last = last.next;
			m--;
		}
		while (last != null) {
			ret = ret.next;
			last = last.next;
		}

		return ret;
	}

	/**
	 * Returns the head.
	 */
	public ListNode deleteNode(ListNode head, int data) {
		ListNode node = head;
		if (node.value == data) {
			return node.next;
		}
		while (node.next != null) {
			if (node.next.value == data) {
				node.next = node.next.next;
				return head;
			}
			node = node.next;
		}
		return head;
	}

	/**
	 * You are given a linked list with at least one node that is either
	 * null-terminated (acyclic) or ends in a cycle (cyclic).
	 * 
	 * Write a function that takes a pointer to the head of a list and
	 * determines whether the list is cyclic or acyclic. Your function should
	 * return false if the list is acyclic and true if it is cyclic. You may not
	 * modify the list in any way.
	 */
	public boolean determineTermination(ListNode head) {
		HashSet<ListNode> hashSet = new HashSet<ListNode>();
		ListNode node = head;
		while (node != null) {
			if (hashSet.contains(node)) {
				return false;
			}
			hashSet.add(node);
			node = node.next;
		}
		return true;
	}

	/**
	 * LeetCode - Reverse Linked List: Reverse a singly linked list.
	 */
	private ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode previous = null;
		ListNode current = head;
		while (current != null) {
			ListNode next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head = previous;
		return head;
	}

	public boolean isPowerOfTwo(int n) {
		return ((n & (n - 1)) == 0 && n > 0);
	}

	/**
	 * LeetCode - Merge two sorted linked lists and return it as a new list. The
	 * new list should be made by splicing together the nodes of the first two
	 * lists.
	 */
	public ListNode mergeTwoLists(ListNode a, ListNode b) {
		ListNode merged = new ListNode(0);

		ListNode first = a;
		ListNode second = b;
		ListNode third = merged;

		while (first != null && second != null) {
			if (first.val <= second.val) {
				third.next = first;
				first = first.next;
			} else {
				third.next = second;
				second = second.next;
			}
			third = third.next;
		}

		if (first != null) {
			third.next = first;
		}
		if (second != null) {
			third.next = second;
		}

		return merged.next;
	}

	public ListNode mergeLists(ListNode a, ListNode b) {
		ListNode result = new ListNode(0);
		ListNode node = result;
		if (a == null) {
			return b;
		} else if (b == null) {
			return a;
		}
		while (a != null && b != null) {
			if (a.val <= b.val) {
				node.next = a;
				a = a.next;
			} else {
				node.next = b;
				b = b.next;
			}
			node = node.next;
		}
		if (a != null) {
			node.next = a;
		} else {
			node.next = b;
		}
		return result.next;
	}

	/**
	 * LeetCode - Palindrome Linked List: Given a singly linked list, determine
	 * if it is a palindrome.
	 */
	public boolean isPalindrome(ListNode head) {
		ListNode reverse = reverseList(head);
		while (head != null) {
			if (head.val != reverse.val) {
				return false;
			}
			head = head.next;
			reverse = reverse.next;
		}
		return true;
	}

	/**
	 * LeetCode - Intersection of Two LinkedLists: Write a program to find the
	 * node at which the intersection of two singly linked lists begins.
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		HashSet<ListNode> hashSet = new HashSet<ListNode>();
		ListNode head = headA;
		while (head != null) {
			hashSet.add(head);
			head = head.next;
		}
		head = headB;
		while (head != null) {
			if (hashSet.contains(head)) {
				return head;
			}
			hashSet.add(head);
			head = head.next;
		}
		return null;
	}

	/**
	 * LeetCode - Delete Node in a Linked List: Write a function to delete a
	 * node (except the tail) in a singly linked list, given only access to that
	 * node.
	 */
	public void deleteNode(ListNode node) {
		if (node == null) {
			return;
		}
		node.val = node.next.val;
		node = node.next;
	}

	/**
	 * LeetCode - Remove Linked List Elements: Remove all elements from a linked
	 * list of integers that have value val.
	 */
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}
		if (head.val == val) {
			return removeElements(head.next, val);
		}
		head.next = removeElements(head.next, val);
		return head;
	}

	/**
	 * Convert a binary tree into a In Order traversal circular list
	 * re-purposing the node's pointers Left & Right as Previous and Next
	 * respectively.
	 * 
	 * Hint: A single node Left & Right points to itself.
	 * 
	 * Note: This is not a binary search tree.
	 */
	public static Node treeToCircle(TreeNode tree) {
		if (tree == null) {
			return null;
		}
		Node circle = new Node();
		circle.previous = treeToCircle(tree.left);
		circle.value = tree.value;
		circle.next = treeToCircle(tree.right);
		return circle;
	}

	/**
	 * LeetCode - Remove Duplicates from Sorted List: Given a sorted linked
	 * list, delete all duplicates such that each element appear only once.
	 */
	public ListNode deleteDuplicates(ListNode head) {
		ListNode node = head;
		while (node != null) {
			ListNode next = node.next;
			if (next != null && node.val == next.val) {
				node.next = next.next;
			} else {
				node = next;
			}
		}
		return head;
	}

	/**
	 * Swap Nodes in Pairs: Given a linked list, swap every two adjacent nodes
	 * and return its head.
	 * 
	 * For example, given 1->2->3->4, you should return the list as 2->1->4->3.
	 */
	public static ListNode swapPairs(ListNode node) {
		if (node == null || node.next == null) {
			return node;
		}
		ListNode first = node;
		ListNode second = node.next;
		ListNode third = node.next.next;
		ListNode ret = second;
		ret.next = first;
		ret.next.next = swapPairs(third);
		return ret;
	}

	public static void testSwapPairs() {
		ListNode a = new ListNode("A");
		a.add(new ListNode("B")).add(new ListNode("C")).add(new ListNode("D"))
				.add(new ListNode("E"));
		printNodes(swapPairs(a));
	}

	public Node reverse(Node node) {
		Node root = node;
		Node next = node.next;
		Node nextNext = node.next.next;
		while (next != null) {
			next.next = root;
			root.next = nextNext;
			root = next;
			next = next.next;
			nextNext = nextNext.next;
		}
		return root;
	}

	public static void printNodes(ListNode node) {
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}

	/**
	 * LeetCode - Given a linked list, determine if it has a cycle in it.
	 */
	public boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				return true;
			}
		}
		return true;
	}
}