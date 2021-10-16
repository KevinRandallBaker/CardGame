public class LinkedList<E> 
{
	//				Node class						//
	// -~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~ //
	class Node<F> 
	{
		public F data;
		public Node<F> next;

		public Node(F data) {
			this(data, null);
		}

	     public Node(F data, Node<F> next) {
			this.data = data;
			this.next = next;
		}
	}
	// -~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~ //
	
	private Node<E> head;
	protected int size;

	public LinkedList() {
		this.head = new Node<E>(null);
		this.size = 0;
	}

	public void add(int index, E item) {
		if (index < 0 || index > size) {
			System.out.println("Index is invalid.");
			return;
		} else if (index == 0) {
			addFirst(item);
		} else {
			Node<E> node = getNode(index - 1); // Need node reference
			addAfter(node, item);
		}

	}

	private Node<E> getNode(int index) {
		Node<E> node = head;

		// Iterates to the index
		for (int i = 0; i < index && node != null; i++)
			node = node.next;

		return node;
	}

	private void addFirst(E item) {
		// Create new node and point head to it
		head.next = new Node<E>(item, head.next);
		size++;
	}

	private void addAfter(Node<E> node, E item) {
		// Create new node and point node to it
		node.next = new Node<E>(item, node.next);
		size++;
	}

	public E remove(int index) // This element deletes elements from the linked List
	{ // based on the index, removeFirst() || removeAfter()
		if (index < 0 || index >= size) // Checking if index is valid
		{
			System.out.println("Invalid index.");
			return null;
		} else if (index == 0) // If index == 0 call removeFirst()
		{
			return removeFirst();
		} else // Else return removeAfter(index)
		{
			Node<E> node = getNode(index - 1);
			return removeAfter(node);
		}

	}

	private E removeFirst() // Change the head node (if applicable)
	{ // return the dleeted data
		Node<E> temp = head.next;

		// if(head.next == null) // Pretty sure all this stuff is not needed because
		// { // we made sure the index was valid for this reason.
		// System.out.println("Cannot remove first list is empty.");
		// return null;
		// }

		head.next = head.next.next;
		size--;
		return temp.data;
		// return null;
	}

	private E removeAfter(Node<E> node) {
		Node<E> temp = node.next;

		// if(temp.next == null) // Pretty sure all this stuff is not needed because
		// { // we made sure the index was valid for this reason.
		// System.out.println("Cannot remove after list is empty.");
		// return null;
		// }

		temp.next = temp.next.next; // Sets the node after to point to the one after that
		size--; // Thus deleting it and decrementing size
		return head.next.data; // Returns the deleted info

	}

	public E get(int index) // Returns the data at the given index
	{
		if (index < 0 || index > size) // Checks for valid index
		{
			System.out.println("Invalid index thing my guy.");
			return null;
		}

		if (index == 0) // Returns right way without loop if first elem
			return head.next.data;

		Node<E> temp = head.next;

		for (int i = 0; i < index - 1; i++) // Loops to iterate node to correct index
		{
			temp = temp.next;
		}

		return temp.next.data; // Returns data
	}

	public void set(int index, E data) // Sets data at given index with data
	{
		if (index < 0 || index > size) // Checks for valid index
		{
			System.out.println("Invalid index thing my guy.");
			return;
		}

		if (index == 0) // If index is 0 no need for loop
			this.head.next.data = data;

		Node<E> temp = head.next;

		for (int i = 0; i < index - 1; i++) // Iterates to correct index
		{
			temp = temp.next;
		}

		temp.data = data; // Changes the data
	}

	public int size() {
		return this.size;
	}

	public String toString() 
	{
		String s = "";
		Node<E> temp = head.next;

		for (int i = 0; i < size - 1; i++) 
		{
			s += temp.data + ", ";
			temp = temp.next;
			
			if(i % 2 == 0 && i != 0)
				s += "\n";
		}

		s += temp.data;

		return s;
	}

	public Node<E> getHead()
	{
		return head;
	}


}
