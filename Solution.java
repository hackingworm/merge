class ListNode {
	int val;
	ListNode next;

	ListNode() {}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	void append(int val) {
		ListNode current = this;
		while (null != current.next) {
			current = current.next;
		}
		current.next = new ListNode(val);
	}

	/**
	 * For test
	 */
	void print() {
		ListNode current = this;
		while (null != current) {
			System.out.print(current.val + " ");
			current = current.next;
		}
		System.out.println();
	}
}

class Solution {

	static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		/**
		 * Initialize the merged list. Please note that an addtional node (the
		 * first one) is introduced, which should be eliminated later
		 */
		ListNode merged = new ListNode(0);

		while (null != list1 && null != list2) {
			if (list1.val <= list2.val) {
				merged.append(list1.val);
				list1 = list1.next;
			} else {
				merged.append(list2.val);
				list2 = list2.next;
			}
		}

		ListNode remained;
		if (null != list1) {
			remained = list1;
		} else {
			remained = list2;
		}

		while (null != remained) {
			merged.append(remained.val);
			remained = remained.next;
		}

		/**
		 * Eliminate the firt node
		 */
		return merged.next;
	}

	/**
	 * For test
	 */
	public static void main(String[] args) {
		/**
		 * Construct a sorted linked list (1, 2 ,4)
		 */
		ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
		// ListNode list1 = new ListNode(2, new ListNode(3, new ListNode(6)));
		System.out.print("List one: ");
		list1.print();
		/**
		 * Construct another sorted linked list (1, 3, 4)
		 */
		ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
		// ListNode list2 = new ListNode(1, new ListNode(4, new ListNode(5, new ListNode(7))));
		System.out.print("List two: ");
		list2.print();
		ListNode mergedList = mergeTwoLists(list1, list2);
		System.out.print("List merged: ");
		mergedList.print();
	}
}
