package codeSpaghetti;

public class LinkedList {
	 
		private static int counter;
		private Node head;
	 
		// Default constructor
		public LinkedList() {
	 
		}
	 
		// appends the specified element to the end of this list.
		public void add(Object data) {
	 
			// Initialize Node only incase of 1st element
			if (head == null) {
				head = new Node(data);
			}
	 
			Node codeSpTemp = new Node(data);
			Node codeSpCurrent = head;
	 
			// Let's check for NPE before iterate over codeSpCurrent
			if (codeSpCurrent != null) {
	 
				// starting at the head node, crawl to the end of the list and then add element after last node
				while (codeSpCurrent.getNext() != null) {
					codeSpCurrent = codeSpCurrent.getNext();
				}
	 
				// the last node's "next" reference set to our new node
				codeSpCurrent.setNext(codeSpTemp);
			}
	 
			// increment the number of elements variable
			incrementCounter();
		}
	 
		private static int getCounter() {
			return counter;
		}
	 
		private static void incrementCounter() {
			counter++;
		}
	 
		private void decrementCounter() {
			counter--;
		}
	 
		// inserts the specified element at the specified position in this list
		public void add(Object data, int index) {
			Node codeSpTemp = new Node(data);
			Node codeSpCurrent = head;
	 
			// Let's check for NPE before iterate over codeSpCurrent
			if (codeSpCurrent != null) {
				// crawl to the requested index or the last element in the list, whichever comes first
				for (int i = 0; i < index && codeSpCurrent.getNext() != null; i++) {
					codeSpCurrent = codeSpCurrent.getNext();
				}
			}
	 
			// set the new node's next-node reference to this node's next-node reference
			codeSpTemp.setNext(codeSpCurrent.getNext());
	 
			// now set this node's next-node reference to the new node
			codeSpCurrent.setNext(codeSpTemp);
	 
			// increment the number of elements variable
			incrementCounter();
		}
	 
		public Object get(int index)
		// returns the element at the specified position in this list.
		{
			// index must be 1 or higher
			if (index < 0)
				return null;
			Node codeSpCurrent = null;
			if (head != null) {
				codeSpCurrent = head.getNext();
				for (int i = 0; i < index; i++) {
					if (codeSpCurrent.getNext() == null)
						return null;
	 
					codeSpCurrent = codeSpCurrent.getNext();
				}
				return codeSpCurrent.getData();
			}
			return codeSpCurrent;
	 
		}
	 
		// removes the element at the specified position in this list.
		public boolean remove(int index) {
	 
			// if the index is out of range, exit
			if (index < 1 || index > size())
				return false;
	 
			Node codeSpCurrent = head;
			if (head != null) {
				for (int i = 0; i < index; i++) {
					if (codeSpCurrent.getNext() == null)
						return false;
	 
					codeSpCurrent = codeSpCurrent.getNext();
				}
				codeSpCurrent.setNext(codeSpCurrent.getNext().getNext());
	 
				// decrement the number of elements variable
				decrementCounter();
				return true;
	 
			}
			return false;
		}
	 
		// returns the number of elements in this list.
		public int size() {
			return getCounter();
		}
	 
		public String toString() {
			String output = "";
	 
			if (head != null) {
				Node codeSpCurrent = head.getNext();
				while (codeSpCurrent != null) {
					output += "[" + codeSpCurrent.getData().toString() + "]";
					codeSpCurrent = codeSpCurrent.getNext();
				}
	 
			}
			return output;
		}
	 
		private class Node {
			// reference to the next node in the chain, or null if there isn't one.
			Node next;
	 
			// data carried by this node. could be of any type you need.
			Object data;
	 
			// Node constructor
			public Node(Object dataValue) {
				next = null;
				data = dataValue;
			}
	 
			// another Node constructor if we want to specify the node to point to.
			@SuppressWarnings("unused")
			public Node(Object dataValue, Node nextValue) {
				next = nextValue;
				data = dataValue;
			}
	 
			// these methods should be self-explanatory
			public Object getData() {
				return data;
			}
	 
			@SuppressWarnings("unused")
			public void setData(Object dataValue) {
				data = dataValue;
			}
	 
			public Node getNext() {
				return next;
			}
	 
			public void setNext(Node nextValue) {
				next = nextValue;
			}
	 
		}
	}
