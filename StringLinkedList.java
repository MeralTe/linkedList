package verketteteliste;

/**@subject algorithms and data 
 * @author Meral Temür
 * @date 2022

 */
public class StringLinkedList implements StringList {

	class ListNode {  
		/**
		 * Entry value - single Element
		 */
		private String value; //the actual value of the actual node
		private ListNode next; //reference to the next node in the list
		private ListNode prev; //reference to previous node in the list
		/**
		 * constructor create a node-object with the given value
		 * @param value
		 */
		ListNode(String value) { //"Beispiel: A,B,C"
			this.value = value;
		}
	}
	/**
	 * Attribute
	 */
	private ListNode head;
	private ListNode tail;

	public StringLinkedList() {}
	/**
	 * This method check if the double linked list is empty
	 * @return true if it's the case and false if not
	 */
	public boolean isEmpty() {
		if( head == null && tail == null )
			return true;
		else
			return false;
	}
	/**
	 * This method adds new element in list
	 */
	@Override
	public void add(String value) {
		//first create a node with the given value
		ListNode valueNode = new ListNode(value);
		//if the list is empty
		if(this.isEmpty()) {
			//put the created node in the list
			head = valueNode;
			tail = valueNode;
		} else { //if not put the created node in the list
			tail.next = valueNode; //1
			valueNode.prev = tail; //2
			tail = valueNode; //3
		}
	}
	/**
	 * This method puts Element in given index
	 * @param int index, String value
	 */
	@Override
	public void add(int index, String value) throws IndexOutOfBoundsException {
		if( index < 0 || index > this.size()) {
			throw new IndexOutOfBoundsException("index = " + index + ", and size = " + size());
		} else if (index == size()) {
			//then put the node at the end of the list
			this.add(value);
		} else if (index == 0) { //start
			ListNode valueNode = new ListNode(value);
			ListNode tempNode = this.head;
			tempNode.prev = valueNode; //1
			valueNode.next = tempNode; //2
			head = tempNode.prev;
		} else {
			ListNode valueNode = new ListNode(value);
			ListNode tempNode = this.head;//get the first node of list
			int count = 0;
			//go to the previous position to index(means if index = 2, then previous position is 1)
			while(count != index-1) {
				tempNode = tempNode.next;
				count++;
			}
			//Now we are at that previous position
			//put the created node between the previous position to index and the position index(means between 1and2)
			valueNode.next = tempNode.next; //1
			tempNode.next.prev = valueNode; //2
			valueNode.prev = tempNode; //3
			tempNode.next = valueNode; //4
		}
	}
	/**
	 * This method shows if the value is in list
	 * @param String value we are searching for
	 * @return specified value or false if not
	 */
	@Override
	public boolean contains(String value) {
		//get the first node of list
		ListNode tempNode = this.head;
		while(tempNode != null) {
			if( tempNode.value.equals(value)) { //compare 2 String with equals
				return true;
			}
			tempNode = tempNode.next;
		}
		return false;
	}
	/**
	 * This method shows where the value in list is
	 * @param value we are searching for
	 * @return the index where the value is in list / -1 if not in list
	 */
	@Override
	public int indexOf(String value) {
		ListNode tempNode = this.head; //start first node
		int index = 0;
		while(tempNode != null) {
			if(tempNode.value.equals(value)) {
				return index;
			}
			index++; //get the position of the actual node
			tempNode = tempNode.next;
		}
		return -1;
	}
	/**
	 * This method remove a specified value from list
	 * @param specified value we want to remove
	 * @return true / false
	 */
	@Override
	public boolean remove(String value) {
		//first check, if the list contains this specified value
		if(contains(value)) {
			//go to thorugh the list and the the node with the specified value
			ListNode tempNode = this.head;
			while( tempNode != null ) { //as long as the end of the list is not reached
				if( tempNode.value.equals(value) ) {
					//then remove this node from the list
					tempNode.prev.next = tempNode.next; //1
					tempNode.next.prev = tempNode.prev; //2
					tempNode.prev = null; //3
					tempNode.next = null; //4
					return true;
				}
				tempNode = tempNode.next; //got to  the next node;
			}
		}
		return false;
	}
	/**
	 * This method removes value in the specified index
	 * @param index we want to remove
	 * @return 
	 */
	@Override
	public String remove(int index) throws IndexOutOfBoundsException {
		if( index < 0 || index > this.size() ) {
			throw new IndexOutOfBoundsException("index = " + index + ", and size = " + size());
		}
		ListNode tempNode = this.head;
		int indexremove = 0;
		while(tempNode != null) {
			if (indexremove == index) {
				//then remove this node from the list
				tempNode.prev.next = tempNode.next; //1
				tempNode.next.prev = tempNode.prev; //2
				tempNode.prev = null; //3
				tempNode.next = null; //4
				return tempNode.value;
			}
			indexremove++;
			tempNode = tempNode.next;
		}
		return null;
	}
	/**
	 *@param index 
	 *@return value of specified index we want to know
	 */
	@Override
	public String get(int index) throws IndexOutOfBoundsException{ 
		if( index < 0 || index > this.size()) {
			throw new IndexOutOfBoundsException("index = " + index + ", and size = " + size());
		} else {
			//get the first node of list
			ListNode tempNode = this.head;
			int position = 0;
			while( tempNode != null ) {
				if( position == index ) {
					return tempNode.value;
				}
				position++;
				tempNode = tempNode.next;
			}
		}
		return null;
	}
	/**
	 * This method shows the size of our list
	 * @return number of size
	 */
	@Override
	public int size() {
		//get the first node of list
		ListNode tempNode = this.head;
		//to count the list elements
		int countNodes = 0;
		//as long as the end of the list is not reached
		while(tempNode != null) {
			countNodes++;
			tempNode = tempNode.next; // go to the next node;
		}
		return countNodes;
	}
}


