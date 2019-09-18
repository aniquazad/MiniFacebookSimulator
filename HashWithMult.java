package pa3;

import java.util.*;

/*
 * This class is a micro-version of the popular web based media application, Facebook.
 * It implements a HashTable to store people. This particular class
 * uses the multiplication method in hashing to store each person in the hash table;
 * if there are any collisions, they are fixed with chaining. Users can choose
 * to create an "account", add a friend, unfriend, check a person's friend list,
 * and see if two people are friends. 
 */
public class HashWithMult 
{
	FBLinkedList[] hashTableMult; //the hash table which stores people
	private static final int LENGTH_OF_TABLE = 10;//the number of slots in the hash table
	private static final double A = 0.6180339887;//the value of A used in the multiplication method
	private static Scanner in; //the Scanner to read user inputs
	private ArrayList<String> names; //contains names of the people already in Facebook
	private ArrayList<Person> first50; //the ArrayList containing the 50 people
	
	/*
	 * Initializes/instantiates the global vars in this class
	 */
	public HashWithMult()
	{
		hashTableMult = new FBLinkedList[LENGTH_OF_TABLE]; //makes hash table of a certain number of slot
		for(int i = 0; i < LENGTH_OF_TABLE; i++)
		{
			hashTableMult[i] = new FBLinkedList();//initializes the hash table
		}
		in = new Scanner(System.in); //initializes the Scanner
		names = new ArrayList<String>(); //initializes the names ArrayList
		first50 = new ArrayList<>(50);
	}
	
	/*
	 * This method is the multiplcation method used to determine which slot
	 * in the hash table the Person will be added. It adds up the ASCII
	 * value of each letter of the person's name. Then it uses the equation
	 * m((key x A)%1) to get the index of the key.
	 * @param p the Person to be added to a certain slot in the hash table
	 * @return htIndex the index of the hash table where Person p will be added to
	 */
	public int multHashFxn(Person p)
	{
		String name = p.getName();
		int totalAscii = 0;
		for(int i = 0; i < name.length(); i++)
		{
			totalAscii = (int)name.charAt(i);
		}
		
		int htIndex = (int)(Math.floor(LENGTH_OF_TABLE*((totalAscii * A) % 1)));
		return htIndex;
	}
	
	/*
	 * This method creates and adds the 50 people to the hashTable
	 */
	public void add50People()
	{
		first50.add(new Person("Liam"));
		first50.add(new Person("Emma"));
		first50.add(new Person("Noah"));
		first50.add(new Person("Olivia"));
		first50.add(new Person("William"));
		first50.add(new Person("Ava"));
		first50.add(new Person("James"));
		first50.add(new Person("Isabella"));
		first50.add(new Person("Logan"));
		first50.add(new Person("Sophia"));
		first50.add(new Person("Benjamin"));
		first50.add(new Person("Mia"));
		first50.add(new Person("Mason"));
		first50.add(new Person("Charlotte"));
		first50.add(new Person("Elijah"));
		first50.add(new Person("Amelia"));
		first50.add(new Person("Oliver"));
		first50.add(new Person("Evelyn"));
		first50.add(new Person("Jacob"));
		first50.add(new Person("Abigail"));
		first50.add(new Person("Lucas"));
		first50.add(new Person("Harper"));
		first50.add(new Person("Michael"));
		first50.add(new Person("Emily"));
		first50.add(new Person("Alexander"));
		first50.add(new Person("Elizabeth"));
		first50.add(new Person("Ethan"));
		first50.add(new Person("Avery"));
		first50.add(new Person("Daniel"));
		first50.add(new Person("Sofia"));
		first50.add(new Person("Matthew"));
		first50.add(new Person("Ella"));
		first50.add(new Person("Aiden"));
		first50.add(new Person("Madison"));
		first50.add(new Person("Henry"));
		first50.add(new Person("Scarlett"));
		first50.add(new Person("Joseph"));
		first50.add(new Person("Victoria"));
		first50.add(new Person("Jackson"));
		first50.add(new Person("Aria"));
		first50.add(new Person("Samuel"));
		first50.add(new Person("Grace"));
		first50.add(new Person("Sebastian"));
		first50.add(new Person("Chloe"));
		first50.add(new Person("David"));
		first50.add(new Person("Camilia"));
		first50.add(new Person("Carter"));
		first50.add(new Person("Penelope"));
		first50.add(new Person("Wyatt"));
		first50.add(new Person("Riley"));
		
		for(Person p: first50)
		{
			names.add(p.getName());
			chainedHashInsert(hashTableMult, p);
		}
	}
	
	/*
	 * This method adds friends to a small number of people from the
	 * list of 50 people
	 */
	public void addTempFriends() 
	{
		//Creates temp instances of a few people
		Person p1 = chainedHashSearch(hashTableMult, "Emily");
		Person p2 = chainedHashSearch(hashTableMult, "Noah");
		Person p3 = chainedHashSearch(hashTableMult, "Daniel");
		Person p4 = chainedHashSearch(hashTableMult, "Madison");
		Person p5 = chainedHashSearch(hashTableMult, "Scarlett");
		Person p6 = chainedHashSearch(hashTableMult, "Grace");

		//add random friends for each person
		for(int i = 0; i < 10; i++)
			p1.addToList(first50.get(i));
		for(int i = 11; i < 18; i++)
			p2.addToList(first50.get(i));
		for(int i = 35; i < 50; i++)
			p3.addToList(first50.get(i));
		for(int i = 0; i < 6; i++)
			p4.addToList(first50.get(i));
		for(int i = 9; i < 40; i++)
			p5.addToList(first50.get(i));
		for(int i = 5; i < 24; i++)
			p6.addToList(first50.get(i));
	}
	/*
	 * This method gets the Person then calls the hash function to get
	 * the index. Then, the person is added to the hash table at the 
	 * calculated index
	 * @param hashTable the hash table where the Person p is inserted
	 * @p the person to be inserted into the hash table
	 */
	public void chainedHashInsert(FBLinkedList[] hashTableMult, Person p)
	{
		int htIndex = multHashFxn(p); //gets the index
		hashTableMult[htIndex].insert(p);//inserts p at the index
	}
	
	/*
	 * This method gets the Person then calls the hash function to get
	 * the index. Then, the person is deleted from the hash table at the 
	 * calculated index
	 * @param hashTable the hash table where the Person p is deleted from
	 * @p the person to be deleted from the hash table
	 */
	public void chainedHashDelete(FBLinkedList[] hashTableMult, Person p)
	{
		int htKey = multHashFxn(p); //gets the index
		hashTableMult[htKey].delete(p); //deletes p from the index
	}
	
	/*
	 * This method uses the name given by the user and creates a temp Person.
	 * Then, it finds the index of the hash table where that name would be located.
	 * Then, it searches through the hash table at that index to find the name.
	 * Once the name is found, the corresponding Person is returned.
	 * @param hashTable the hash table where the name is searched
	 * @param name the name of the person to be searched in the hash table
	 */
	public Person chainedHashSearch(FBLinkedList[] hashTableMult, String name)
	{
		Person temp = new Person(name); //creates a temp Person of name
		int htKey = multHashFxn(temp); //gets the index
		Person found = hashTableMult[htKey].search(name); //searches instance of name at the index
		return found; //returns the Person
	}
	
	/*
	 * This method checks if two people are friends. If they are friends, 
	 * the method returns "Yes"; if not, the method returns "No"
	 * @param p1 the first person to check
	 * @param p2 the second person to check
	 * @return String the value "Yes" or "No" which determines if 2 ppl are friends
	 */
	public String checkIfFriends(Person p1, Person p2) //Person p1, Person p2
	{
		//searches the list of p1 to see if it finds p2
		 boolean friends = p1.searchList(p2.getName());
		 if(friends == true) //if p2 is found in p1's list
			 return "Yes";
		 else
			 return "No"; 
	}
	
	/*
	 * This method allows the user to create a Person by entering a name.
	 * They are prompted to enter a name, which is then fixed to make the 
	 * first char capitalized. Then, it adds the name to the names list.
	 * Finally, it adds the Person to the hash table by calling chainedHashInsert.
	 */
	public void option1()//create person
	{
		System.out.println("Create a person");
		System.out.print("Please enter the person's name:\t");//prompts user to enter name
		String name = in.next();
		//fixes the name to make sure that the first letter is capital
		String firstLetter = name.substring(0,1);
		name = firstLetter.toUpperCase() + name.substring(1);
		names.add(name);//adds name to the names list
		Person p = new Person(name); //creates a new Person with a name
		chainedHashInsert(hashTableMult, p); //adds the Person to the hash table
		System.out.println();
		return;
	}
	
	/*
	 * This method allows users to make two people friends. They enter the 1st 
	 * person's name, and the method uses chainedHashSearch to find the corresponding
	 * Person of that name. Then the user does the same for the 2nd person. Then, the method
	 * makes sure that the two people aren't already friends. If they're not, then each person
	 * is added to the others friend list. If they are friends, the user is notified.
	 */
	public void option2()//make a friend
	{
		System.out.println("Make a friend");
		System.out.print("Enter the name of person 1:\t");//prompts user to enter the 1st name
		String p1 = in.next();
		//fixes the name to make sure that the first letter is capital
		String firstLetter = p1.substring(0,1);
		p1 = firstLetter.toUpperCase() + p1.substring(1);
		
		boolean inNames = nameExists(p1);//makes sure that the name exists
		if(inNames == false)
		{
			System.out.println("ERROR: Person does not exist on Facebook!");
			return;
		}
		Person person1 = chainedHashSearch(hashTableMult, p1);//searches for Person of the name p1
		
		System.out.print("Enter the name of person 2:\t");//prompts user to enter the 2nd name
		String p2 = in.next();
		//fixes the name to make sure that the first letter is capital
		String firstL2 = p2.substring(0,1);
		p2 = firstL2.toUpperCase() + p2.substring(1);
		
		boolean inNames2 = nameExists(p2); //makes sure the name exists
		if(inNames2 == false)
		{
			System.out.println("ERROR: Person does not exist on Facebook!");
			return;
		}
		
		Person person2 = chainedHashSearch(hashTableMult, p2);//searches for Person of the name p2
		String friends = checkIfFriends(person1, person2);//checks if person1 and person2 are already friends
		if(friends.equals("No"))//if they're not friends
		{
			person1.addToList(person2);//adds person2 to person1's friend list
			person2.addToList(person1);//adds person1 to person2's friend list
			System.out.println("Successfully Friended!");
			System.out.println();
		}
		else//if they are friends
		{
			System.out.println(p1 + " and " + p2 +" are already friends!");
		}
	}
	
	/*
	 * This method allows users to unfriend two people. They enter the 1st 
	 * person's name, and the method uses chainedHashSearch to find the corresponding
	 * Person of that name. Then the user does the same for the 2nd person. Then, the method
	 * makes sure that the two people are already friends. If they are, then each person
	 * is deleted from the others friend list. If they're not friends, the user is notified.
	 */
	public void option3()//unfriend
	{
		System.out.println("Unfriend someone");
		System.out.print("Enter the name of person 1:\t");//prompts user to enter the 1st name
		String p1 = in.next();
		//fixes the name to make sure that the first letter is capital
		String firstLetter = p1.substring(0,1);
		p1 = firstLetter.toUpperCase() + p1.substring(1);
		
		boolean inNames = nameExists(p1);//makes sure the name exists
		if(inNames == false)
		{
			System.out.println("ERROR: Person does not exist on Facebook!");
			return;
		}
		Person person1 = chainedHashSearch(hashTableMult, p1);//searches for Person of the name p1
		
		System.out.print("Enter the name of person 2:\t");//prompts user to enter the 2nd name
		String p2 = in.next();
		//fixes the name to make sure that the first letter is capital
		String firstL2 = p2.substring(0,1);
		p2 = firstL2.toUpperCase() + p2.substring(1);
		
		boolean inNames2 = nameExists(p2);//makes sure the name exists
		if(inNames2 == false)
		{
			System.out.println("ERROR: Person does not exist on Facebook!");
			return;
		}
		
		Person person2 = chainedHashSearch(hashTableMult, p2);//searches for Person of the name p2
		String friends = checkIfFriends(person1, person2);//checks if person1 and person2 are already friends
		if(friends.equals("Yes"))//if they are friends
		{
			person1.deleteFromList(person2);//deletes person2 from person1's friend list
			person2.deleteFromList(person1);//deletes person1 from person2's friend list
			System.out.println("Successfully Unfriended!");
			System.out.println();
		}
		else//if they're not friends
		{
			System.out.println(p1 + " and " + p2 +" are not friends!");
		}
	}
	
	/*
	 * This method allows the user to search any Person's friend list in Facebook. The user
	 * enters the name of the person. and the method uses chainedHashSearch to find the corresponding
	 * Person of that name. Fianlly, the Person's friend list is printed to the console.
	 */
	public void option4()//search a person's friend list
	{
		System.out.println("Search a person's friend list");
		System.out.print("Enter the name:\t");//prompts user to enter the Person's name
		String p1 = in.next();
		//makes sure that the first letter is capital
		String firstLetter = p1.substring(0,1);
		p1 = firstLetter.toUpperCase() + p1.substring(1);
		
		boolean inNames = nameExists(p1);//checks to see if name exists
		if(inNames == false)
		{
			System.out.println("ERROR: Person does not exist on Facebook!");
			return;
		}
		Person found = chainedHashSearch(hashTableMult, p1);//searches for Person of the name p1
		System.out.print(found.getName() +"'s Friend List:\t");
		System.out.print(found.getFriendsList().toString());//prints the Person's friend list
		System.out.println();
	}
	
	/*
	 * This method checks to see if two people are friends. They enter the 1st 
	 * person's name, and the method uses chainedHashSearch to find the corresponding
	 * Person of that name. Then the user does the same for the 2nd person. Then, the method
	 * checks to see if the two people are friends. If they are, then "Yes" is printed. 
	 * If not, then "No" is printed.
	 */
	public void option5()//see if two people are friends
	{
		System.out.print("Enter the name of person 1:\t");//prompts user to enter the 1st name
		String p1 = in.next();
		//fixes the name to make sure that the first letter is capital
		String firstLetter = p1.substring(0,1);
		p1 = firstLetter.toUpperCase() + p1.substring(1);
		
		boolean inNames = nameExists(p1);//makes sure the name exists
		if(inNames == false)
		{
			System.out.println("ERROR: Person does not exist on Facebook!");
			return;
		}
		Person person1 = chainedHashSearch(hashTableMult, p1);//searches for Person of the name p1
		
		System.out.print("Enter the name of person 2:\t");//prompts user to enter the 2nd name
		String p2 = in.next();
		//fixes the name to make sure that the first letter is capital
		String firstL2 = p2.substring(0,1);
		p2 = firstL2.toUpperCase() + p2.substring(1);
		
		boolean inNames2 = nameExists(p2);//makes sure the name exists
		if(inNames2 == false)
		{
			System.out.println("ERROR: Person does not exist on Facebook!");
			return;
		}
		
		Person person2 = chainedHashSearch(hashTableMult, p2);//searches for Person of the name p2
		
		String friends = checkIfFriends(person1, person2);//sees if they are friends
		System.out.println(friends);//prints result
	}
	
	/*
	 * This method prints out the hash table
	 */
	public void option6()//print out hashtable
	{
		System.out.println("Hashtable");
		for(int i = 0; i < hashTableMult.length; i++)
		{
			System.out.println(i + ":\t" + hashTableMult[i].toString());
		}
	}
	
	/*
	 * This method checks to see if a name exists on Facebook before 
	 * any friending, unfriending, searching takes place.
	 */
	public boolean nameExists(String name)
	{
		if(names.contains(name))//if name is found in the names list
			return true;
		else
			return false;
	}
	
	/*
	 * This method lists the options for the user to choose from. If they enter 0, then 
	 * they have the choice of terminating the program or seeing the same program but using the \
	 * multiplication method.
	 */
	public void options()
	{
		//lists the options for the user
		System.out.println("What would you like to do?");
		System.out.println("1. Create a person");
		System.out.println("2. Make a friend");
		System.out.println("3. Unfriend");
		System.out.println("4. Search a person's friend list");
		System.out.println("5. See if two people are friends");
		System.out.println("6. Print out the hash table");
		System.out.println("0. Quit");
		int choice = in.nextInt();//reads user input
		//calls method based on choice
		if(choice == 1)
			option1();
		else if(choice == 2)
			option2();
		else if(choice == 3)
			option3();
		else if(choice == 4)
			option4();
		else if(choice == 5)
			option5();
		else if(choice == 6)
			option6();
		else//if user presses 0
		{
			System.out.println("Good-bye!");
			System.exit(0);	
		}
		options();
	}
	
	public void start()
	{
		System.out.println("****************************************");
		System.out.println("WELCOME TO THE MULT METHOD FB");
		System.out.println("****************************************");
		add50People();
		addTempFriends();
		options();
	}
}
