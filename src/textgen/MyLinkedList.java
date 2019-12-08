package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<E> (null);
		tail = new LLNode<E> (null);
		size = 0;
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element == null)
			throw new NullPointerException("Element cannot be null");
		LLNode<E> temp = new LLNode<E>(element);
		if(size==0){
			head.next = temp;
			temp.next = tail;
			temp.prev = head;
			tail.prev = temp;
		}
		else{
		LLNode<E> curr = head.next;
		while(curr.next!=null && curr.next.data!=null)
		{
			curr = curr.next;
		}
		
		curr.next = temp;
		temp.next = tail;
		temp.prev = curr;
 		tail.prev = temp;
		}
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index<0 || index>size-1 ||size==0)
			throw new IndexOutOfBoundsException("Index out of bounds");
		LLNode<E> curr = head.next;
		for(int i = 0; i < index; i++)
		{
			if(curr.next == null)
				return null;
			
			curr = curr.next;
		}
		return curr.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(index<0 || index>size)
			throw new IndexOutOfBoundsException("Index out of bounds");
		if(element == null)
			throw new NullPointerException("element cannot be null");
		LLNode<E> curr = head;
		for(int i=0;i<index;i++){
			curr=curr.next;
		}
		LLNode<E> temp = new LLNode<E>(element);
		temp.next = curr.next;		
		curr.next.prev = temp;
		curr.next = temp;
		temp.prev = curr;
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(index<0 || index>size || size==0)
			throw new IndexOutOfBoundsException("Index out of Bounds");
		if(size==1){
			LLNode<E> temp= head.next;
			head.next=tail;
			tail.prev=head;
			size--;
			return temp.data;
		}
		else{
			LLNode<E> curr = head;
		int in=0;
		while(in<index )
		{
			curr=curr.next;
			in++;
		}
		LLNode<E> temp = curr.next;
		curr.next=curr.next.next;
		curr.next.next.prev=curr;
		size--;
		
		return temp.data;
		}
		
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(index<0 || index>size)
			throw new IndexOutOfBoundsException("Index out of bounds");
		if(element==null)
			throw new NullPointerException("Element cannot be null");
		LLNode<E> curr = head.next;
		int in = 0;
		while(curr.next!=null && in<index)
		{
			curr = curr.next;
			in++;
		}
		E temp = curr.data;
		curr.data = element;
		return temp;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
