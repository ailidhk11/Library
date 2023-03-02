import java.util.ArrayList;
/**
 * Details of a person who is member of a library.
 * Gives information on what resources they are borrowing.
 *
 * @author Ailidh
 * @version 1.0
 */
public class LibraryMember
{
    // The name of the library member.
    private String name;
    // A collection of the resources they are currently borrowing.
    private ArrayList<Resource> currentResources;
    // Messages and notifcations received from the library.
    private String messages;
   
    /**
     * Constructor for objects of class LibraryMember.
     * @param nameOfMember The name of the library member.
     */
    public LibraryMember(String nameOfMember)
    {
        // initialise instance variables
        name = nameOfMember;
        currentResources = new ArrayList<>();
        messages = "";
    }
    
    /** Set the name of the library member.
     * @param newName The name of the library member.
     */
    public void setName(String newName)
    {
            name = newName;
    }
    
    /**
     * Get the name of the library member.
     * @return The name of the library member.
     */

    public String getName()
    {
        return name;
    }
    
      /**
     * Set a message for a libray member.
     * @param newMessage The message to set for the library member.
     */
    public void setMessage(String newMessage)
    {
        messages = messages + newMessage;
    }
    
    /**
     * Get the messages the library member has received.
     * @return messages The messages the library member has received.
     */
    public String getMessages()
    {
        return messages;
    }
    
    /**
     * Print the details of the messages the library member has received.
     */
    public void printMessages()
    {
        System.out.println(messages);
    }
    
    /** Print list of the books the user is currently borrwing.
     * 
     */
    public void  listBooks()
    {
        System.out.println("Currently borrwing: ");
        for(Resource resource : currentResources) {
            resource.printDetails();
        }
    }

    
    /**
     * Return a list of the resources the library member currently has.
     * @return The resources the library member is currently borrowing.
     */
    public ArrayList getCurrentResources()
    {
        return currentResources;
    }
    
    /**
     * Add a resource to the library member's current borrowing collection.
     * @param newResource The resource to add to the library member's collection.
     */
    public void addResource(Resource newResource)
    {
        if (newResource == null) {
            System.out.println("Please enter a valid value.");
        }
        else {
            currentResources.add(newResource);
        }
    }
    
    public void removeResource (Resource resourceToRemove)
    {
        if(resourceToRemove == null) {
            System.out.println("Please enter a valid value.");
        }
        else {
            currentResources.remove(resourceToRemove);
        }
    }
    
    /**
     * Get the total number of resources the library member is currently borrowing. 
     * @return The size of the collection of resources that the library member is currently borrowing.
     */
    public int totalNumberOfResources()
    {
        return currentResources.size();
    }
    
    /**
     * Print the details of the library member. 
     */
    public void printMemberDetails()
    {
        System.out.println(name + " is currently an active member.");
        if(currentResources.isEmpty())
            System.out.println("They are currently borrowing no books.");
        if(currentResources.size() == 1)
            System.out.println("They are currently borrowng 1 book.");
        if(currentResources.size() > 1)
            System.out.println("They are currently borrwing " + currentResources.size() + " books.");
        if(messages.isEmpty())
            System.out.println("They have no messages.");
        else
            System.out.println("They have the following messages stored:" + messages);
    }
    
    public String getMemberDetails()
    {
        String details = name + " is currently an active member.";
        if(currentResources.isEmpty()) {
            details = details + "They are currently borrowing no books.";
        }
        else if(currentResources.size() == 1) {
            details = details + "They are currently borrowng 1 book.";
        }
        else if(currentResources.size() > 1) {
            details = details + "They are currently borrwing " + currentResources.size() + " books.";
        }
        if(messages.isEmpty()) {
            details = details + "They have no messages.";
        }
        else {
            details = details + "They have the following messages stored:" + messages;
        }
        return details;
    }
    
   
}
