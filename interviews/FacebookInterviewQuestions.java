import java.util.HashSet;

class FacebookNode {

	public FacebookNode() {
	}

	FacebookNode next;
	int data;
	FacebookNode child;
}

public class FacebookInterviewQuestions {

	/**
	 * Given a node with next, data, and child, return a linked list containing
	 * all these nodes flattened. If child is null, it will have data.
	 */
	public FacebookNode flatten(FacebookNode node) {
		if (node == null) {
			return null;
		}

		FacebookNode n = new FacebookNode();
		FacebookNode head = n;

		if (node.child == null) {
			n.data = node.data;
		} else {
			n.next = flatten(node.child);
			head = n;
			while (n.next != null) {
				n = n.next;
			}
		}
		return head;
	}

	/**
	 * Given revision numbers and an isBadRevision function, find the first
	 * revision number that broke.
	 */
	public int firstBadRevision(int good, int bad) {
		if (good > bad || (bad - good) == 1) {
			return bad;
		}
		int mid = (good + bad) / 2;
		if (isBadRevision(mid)) {
			return firstBadRevision(good, mid);
		}
		return firstBadRevision(mid, bad);
	}

	private boolean isBadRevision(int revision) {
		return true;
	}

	/**
	 * Given an array of consecutive numbers in any order with exactly one
	 * missing, find the missing number. E.g input: 2, 4, 3, 7, 6 output: 5
	 */
	public int findMissingNumber(int[] array) {
		HashSet<Integer> set = new HashSet<Integer>();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			set.add(array[i]);
			if (min > array[i]) {
				min = array[i];
			}
			if (max < array[i]) {
				max = array[i];
			}
		}

		for (int i = min; i < max; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}
		return -1;
	}
}