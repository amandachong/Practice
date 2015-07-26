import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

public class LinkedLists {

	public Node beginningOfLoop(Node n) {

		Hashtable table = new Hashtable();

		while (n != null) {
			if (table.contains(n)) {
				return n;
			}
			table.put(n.data, n);
			n = n.next;
		}

		return null;
	}

	public Node add(Node first, Node second, int carry) {

		if (first == null && second == null) {
			return null;
		}
		first.data = first.data + second.data + carry;
		carry = first.data % 10;
		first.data = first.data - carry;

		add(first.next, second.next, carry);

		return first;
	}

	public Node add(Node n1, Node n2) {
		Node result = null;
		int carry = 0;
		int value = 0;
		Node n = result;
		while (true) {
			if (n1 == null && n2 == null)
				break;
			value = carry;
			if (n1 != null)
				value += n1.data;
			if (n2 != null)
				value += n2.data;
			if (value > 10) {
				carry = 1;
			}
			n = new Node(value % 10);
			n1 = n1.next;
			n2 = n2.next;
			n = n.next;
		}
		return result;
	}

	public Node findBeginning(Node head) {
		Node n1 = head;
		Node n2 = head;
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

	public boolean deleteNode(Node n) {
		if (n == null || n.next == null) {
			return false;
		}
		n = n.next;
		return true;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void deleteDuplicates(Node n) {
		Hashtable table = new Hashtable();
		table.put(n.data, true);
		while (n.next != null) {
			if (table.containsKey(n.next.data))
				n.next = n.next.next;
			else {
				table.put(n.next.data, true);
				n = n.next;
			}
			n.next = n.next.next;
		}
	}

	public Node nthToLast(Node node, int n) {
		if (node == null || n < 1) {
			return null;
		}

		Node n1 = node;
		Node n2 = node;

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

	// Return head
	public Node deleteNode(Node head, int data) {

		Node node = head;
		if (node.data == data) {
			return node.next;
		}
		while (node.next != null) {
			if (node.next.data == data) {
				node.next = node.next.next;
				return head;
			}
			node = node.next;
		}
		return head;
	}

}