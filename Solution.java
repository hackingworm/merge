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
		 * If one of the list is null, just return the other
		 */
		if (null == list1) {
			return list2;
		}

		if (null == list2) {
			return list1;
		}

		ListNode workList, checkList, mergedList;
		/**
		 * Initialize mergedList, and set up workList and checkList respectively
		 */
		if (list1.val > list2.val) {
			workList = list2;
			checkList = list1;
			mergedList = new ListNode(list2.val);
		} else {
			workList = list1;
			checkList = list2;
			mergedList = new ListNode(list1.val);
		}
	
		workList = workList.next;
		while (null != workList) {
			/**
			 * Append the elements in workList to mergedList, while it hasn't reached the end and their value
			 * isn't larger then the current element of the checkList if the checkList isn't null
			 */
			while (null != workList && (null == checkList || workList.val <= checkList.val))  {
				mergedList.append(workList.val);
				workList = workList.next;
			}

			/**
			 * Then swap the workList and checkList
			 */
			ListNode tempList = workList;
			workList = checkList;
			checkList = tempList;
		}

		return mergedList;
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
