import java.util.HashSet;

public class LeetCodeEasy {

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
	 * LeetCode – Path Sum: Given a binary tree and a sum, determine if the tree
	 * has a root-to-leaf path such that adding up all the values along the path
	 * equals the given sum.
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.value == sum && root.left == null && root.right == null) {
			return true;
		}
		return hasPathSum(root.left, sum - root.value)
				|| hasPathSum(root.right, sum - root.value);
	}

	/**
	 * LeetCode - Lowest Common Ancestor of a Binary Search Tree: Given a binary
	 * search tree (BST), find the lowest common ancestor (LCA) of two given
	 * nodes in the BST.
	 */
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,
			TreeNode q) {
		if (root == null || p == null || q == null) {
			return null;
		}
		if (p.value < root.value && q.value < root.value) {
			return lowestCommonAncestor(root.left, p, q);
		}
		if (p.value > root.value && q.value > root.value) {
			return lowestCommonAncestor(root.right, p, q);
		}
		return root;
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

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result;
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}
		if (l1.val <= l2.val) {
			result = l1;
			l1.next = mergeTwoLists(l1.next, l2);
		} else {
			result = l2;
			result.next = mergeTwoLists(l1, l2.next);
		}
		return result;
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
	 * LeetCode - Contains Duplicate: Given an array of integers, find if the
	 * array contains any duplicates. Your function should return true if any
	 * value appears at least twice in the array, and it should return false if
	 * every element is distinct.
	 */
	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> hashSet = new HashSet<Integer>();
		for (int num : nums) {
			if (hashSet.contains(num)) {
				return true;
			}
			hashSet.add(num);
		}
		return false;
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
		node.next = node.next.next;
	}

	/**
	 * LeetCode - Remove Element: Given an array and a value, remove all
	 * instances of that value in place and return the new length.
	 */
	public int removeElement(int[] nums, int val) {
		int newLength = nums.length;
		for (int i = 0; i < newLength; i++) {
			if (nums[i] == val) {
				int temp = nums[newLength - 1];
				nums[newLength - 1] = nums[i];
				nums[i] = temp;
				newLength--;
				i--;
			}
		}
		return newLength;
	}

	/**
	 * LeetCode - String to Integer (atoi): Implement atoi to convert a string
	 * to an integer.
	 */
	public int myAtoi(String str) {
		if (str == null || str.length() < 1)
			return 0;
		str = str.trim();
		char flag = '+';
		int i = 0;
		if (str.charAt(0) == '-') {
			flag = '-';
			i++;
		} else if (str.charAt(0) == '+') {
			i++;
		}
		double result = 0;
		while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}
		if (flag == '-')
			result = -result;
		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		return (int) result;
	}

	/**
	 * LeetCode - Maximum Depth of Binary Tree: Given a binary tree, find its
	 * maximum depth.
	 */
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	/**
	 * LeetCode - Symmetric Tree: Given a binary tree, check whether it is a
	 * mirror of itself (ie, symmetric around its center).
	 */
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSymmetric(root.left, root.right);
	}

	private boolean isSymmetric(TreeNode l, TreeNode r) {
		if (l == null && r == null) {
			return true;
		} else if (l == null || r == null) {
			return false;
		}
		if (l.value != r.value) {
			return false;
		}
		return isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
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
	 * LeetCode - Minimum Depth of Binary Tree: Given a binary tree, find its
	 * minimum depth.
	 */
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null) {
			return 1 + minDepth(root.right);
		}
		if (root.right == null) {
			return 1 + minDepth(root.left);
		}
		return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	}

	/**
	 * LeetCode - Length of Last Word: Given a string s consists of
	 * upper/lower-case alphabets and empty space characters ' ', return the
	 * length of last word in the string.
	 */
	public int lengthOfLastWord(String s) {
		if (s == null) {
			return 0;
		}
		s = s.trim();
		if (s.length() == 0) {
			return 0;
		}
		int index = s.lastIndexOf(' ');
		if (index == -1) {
			return s.length();
		}
		String lastWord = s.substring(index + 1, s.length());
		return lastWord.length();
	}

	/**
	 * LeetCode - Remove Duplicates from Sorted Array: Given a sorted array,
	 * remove the duplicates in place such that each element appear only once
	 * and return the new length.
	 */
	public int removeDuplicates(int[] nums) {
		if (nums == null) {
			return 0;
		}
		if (nums.length <= 1) {
			return nums.length;
		}
		int i = 0;
		for (int j = 0; j < nums.length; j++)
			if (nums[i] != nums[j])
				nums[++i] = nums[j];
		return i + 1;
	}

	/**
	 * LeetCode – Maximum Subarray
	 * 
	 * Find the contiguous subarray within an array (containing at least one
	 * number) which has the largest sum.
	 * 
	 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous
	 * subarray [4,−1,2,1] has the largest sum = 6.
	 */
	public static int maxSumSubArray(int[] array) {
		int max = array[0];
		int newSum = array[0];
		for (int i = 1; i < array.length; i++) {
			newSum = Math.max(newSum + array[i], array[i]);
			max = Math.max(max, newSum);
		}
		return max;
	}
}
