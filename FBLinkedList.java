package pa3;

/*
 * This class is the LinkedList class created specifically for this project. It has methods which 
 * insert a Person into a LinkedList, deletes a Person from a LinkedList, and searches for a Person
 * with a given name. It also has a toString() method which gets the name from each node and adds it 
 * to a String and then is returned.
 */
public class FBLinkedList 
{
	private FBNode head; //the head node
	private FBNode tail; //the tail node
	
	/*
	 * This method adds a Friend at the head to the LinkedList.
	 * @param p The person who will be added as a friend
	 */
	public void insert(Person p)
	{
		
		FBNode newNode = new FBNode(p); //creates a new node of Person p
		newNode.setNext(head); //newNode points to the head node, making it the head node
		head = newNode;
		if(tail == null)//if it is an empty LinkedList
		{
			tail = newNode; //make the new node the head and tail
		}
	}
	
	/*
	 * This method deletes Person p from the linked list. It goes through various checks
	 * to see if the linked list has any edge cases and does deletion based on the cases.
	 * @param p the Person to delete
	 */
	public void delete(Person p)
	{
		//Edge case 1: if LinkedList is empty
		if(head == null)
		{
			return;
		}
		
		//Edge case 2: If there is only one node and Person p is that node
		else if(head == tail && head.getData().equals(p))
		{
			//set both head and tail to null
			head = null;
			tail = null;
		}
		//edge case 3: if the head contains Person p
		else if(head.getData().equals(p))
		{
			//set head to be the node after the old head
			head = head.getNext();
		}
		//no edge cases apply
		else
		{
			FBNode beforeDeletedNode = head; //set the node before the one to delete to head
			while(beforeDeletedNode.getNext().getData() != p)//while the node next to beforeDeletedNode doesn't equal p
				beforeDeletedNode = beforeDeletedNode.getNext(); //get the next node
			beforeDeletedNode.setNext(beforeDeletedNode.getNext().getNext());//set beforeDeletedNode's next node to 2 after it
			if(beforeDeletedNode.getNext() == null)
			{
				tail = beforeDeletedNode;
			}
		}
	}
	
	/*
	 * This method searches for the String p(name) in each node. Once it finds it, it returns the node's data which 
	 * contains name.
	 * @param p the String name of the Person to look for
	 */
	public Person search(String p)
	{
		//if LinkedList is empty
		if(head == null)
		{
			return null;
		}
		FBNode currNode = head;
		while(currNode != null )//while current node doesn't reach null
		{
			if(currNode.getData().getName().equals(p))//if currNode's name equals p
			{
				return currNode.getData(); //return the data of that node
			}
			currNode = currNode.getNext();//else go to the next node
		}
		return null;//else return null
	}
	
	/*
	 * This method gets the name from each node and returns it
	 * @return String the list of names
	 */
	public String toString()
	{
		String res = "";
		if(head == null)
		{
			return null;
		}
			
        FBNode currNode = head;
        while(currNode != null){
            res += currNode.getData().getName() + ", ";
            currNode = currNode.getNext();
        }
        return res;
		
	}

}
