class MicrosoftInterview {

	/**
	 * Describe 3 ways in which you can get the kth element of a singly linked
	 * list and compare each of them then implement one of them.
	 * 
	 * 1. Keep 2 points - O(n) time, extra pointer 2. Keep a stack - O(n) extra
	 * memory, O(n) time 3. Go through the linked list once to get the length
	 * and go through it again by (length of list - k)
	 */
	public ListNode kthElement(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		ListNode fast = head;
		ListNode slow = head;
		for (int i = 0; i < k; i++) {
			fast = fast.next;
			if (fast == null) { // Check if k > actual linked list length.
				return null;
			}
		}
		while (fast.next != null) {
			fast = fast.next;
			if (fast == null) {
				return null;
			}
			slow = slow.next;
		}
		return slow;
	}

	/**
	 * Design something for a group of people who want to eat something.
	 * 
	 * See where everyone's geo location is and calculate the minimal distance
	 * that someone would like to walk to a restaurant. Have person with car
	 * pick everyone else and calculate optimal route for picking everyone up or
	 * deliveries. Find everyone's profile for eating and determine which
	 * restaurant suits a group of people. Use the app to divide the charges
	 * appropriately. Everyone can order from a menu on the app. Restaurants can
	 * deal with orders before customers arrive. Restaurants can delivery if
	 * there is no space to sit.
	 */

	/**
	 * Given preorder and postorder arrays, construct the binary tree.
	 */

	/**
	 * Given a string and a pattern with * and ?, determine if the string
	 * matches the pattern.
	 */
}
