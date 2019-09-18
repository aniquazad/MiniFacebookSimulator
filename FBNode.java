package pa3;

/*
 * This is the node class used by FBLinkedList. It has methods which get and set the next nodes, and get data of the Person.
 */
public class FBNode 
{
	private FBNode next; //the next node
	private Person data; //the data of the Person
	
	//Creates an instance of Person data
	FBNode(Person data)
	{
		this.data = data;
	}
	
	/* Gets the next node
	 * @return next the next node
	 */
	public FBNode getNext()
	{
		return next;
	}
	
	/*
	 * Sets the next node
	 * @param next the node to be set to next
	 */
	void setNext(FBNode next)
	{
		this.next = next;
	}

	/*
	 * Gets the data of the Person for the node
	 * @return data the data of the Person
	 */
	public Person getData()
	{
		return data;
	}
}