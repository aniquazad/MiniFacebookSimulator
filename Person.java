package pa3;

/*
 * This class holds the name and the friends list of the Person. It also has methods which get the name and friend list.
 * It also has methods which adds friends, deletes friends, and searches for the name of a friend.
 */
public class Person 
{
	private String name; //the name of the Person
	private FBLinkedList friendsList; //the friend list of the person
	
	public Person(String name)
	{
		this.name = name;
		friendsList = new FBLinkedList();
	}
	
	/*
	 * Returns the name of the Person
	 * @return String the name of the Person
	 */
	public String getName()
	{
		return name;
	}
	
	/*
	 * Returns the friend list of the Person
	 * @return FBLinkedList the friend list of the Person
	 */
	public FBLinkedList getFriendsList()
	{
		return friendsList;
	}
	
	/*
	 * Adds a friend to the Person's friend list
	 * @param p the friend to add
	 */
	public void addToList(Person p)
	{
		friendsList.insert(p);
	}
	
	/*
	 * Deletes a friend to the Person's friend list
	 * @param p the friend to delete
	 */
	public void deleteFromList(Person p)
	{
		friendsList.delete(p);
	}
	
	/*
	 * Searches for a name in the Person's friend list
	 * @param p the name to search for
	 * @return boolean whether or not the name was found
	 */
	public boolean searchList(String p)
	{
		Person found = friendsList.search(p);
		if(found == null)
			return false;
		else
			return true;
			
	}
	
}
