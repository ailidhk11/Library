import java.util.ArrayList;
/**
 * A class to represent a library and all the available resources.
 *
 * @author Ailidh
 * @version 1.0
 */
public class Library
{
    // An ArrayList for storing library resources
    private ArrayList<Resource> resources;
    // The name of the library.
    private String libraryName;
  
    
    /**
     * Constructor for objects of class Library.
     * @param libraryName The name of the library.
     */
    public Library(String name)
    {
        resources = new ArrayList<>();
        libraryName = name;
    }
    
    /**
     * Set the name of the library.
     * @param newName The name of the library.
     */
    public void setLibraryName(String newName)
    {
        libraryName = newName;
    }
    
    /**
     * 
     * Get the name of the library.
     * @return The library name.
     */
    public String getLibraryname()
    {
        return libraryName;
    }
    
    public ArrayList getResources() {
        return resources;
    }

    /**
     * Print the details of the library.
     */
    public void printDetails()
    {
        if(resources.size() > 0) {
            System.out.println("Welcome to the " + libraryName + " Library.");
            System.out.println("It has the following resources: ");
            for(Resource resource : resources) {
            resource.printDetails();
            }
        }
        else {
            System.out.println("Welcome to the " + libraryName + ". We need resources!");
        }
    }

    /**
     * Check if the library contains a resource.
     * @param resourceToCheck The resouce to search for in the library.
     */
    public boolean resourceAvailableInLibrary(Resource resourceToCheck)
    {
        boolean available = true;
        if(resources.isEmpty()) {
            System.out.println("This collection is empty!");
        }
        else if(resourceToCheck == null) {
            System.out.println("Please enter a valid value.");
        }
        
        else if(resources.contains(resourceToCheck)) {
            available = true;
        }
        else {
            available = false;
        }
        return available;
    }
    
    /**
     * Edit the title of a resource in the library.
     * @param oldTitle The existing title of the resource.
     * @param newTitle The new title of the resource.
     */
    public void editTitle(String oldTitle, String newTitle) {
        int counter = 0;
        for(Resource resource : resources) {
            if (oldTitle == null || newTitle == null) {
                System.out.println("Please enter a valid value.");
            }
            else if(resource.getTitle() == oldTitle) {
                resource.setTitle(newTitle);
                System.out.println("Resource updated to " + newTitle);
            }
            else {
                counter++;
            }
            if (counter == resources.size()) {
                System.out.println("There are no resources with this existing title.");
            }
        }
    }
    
    /**
     * Find a resource within the library.
     * @param resourceToFind The resource to find.
     */
    public Resource findResource(Resource resourceToFind)
    {
        if(resources.contains(resourceToFind))
            return resourceToFind;
        else 
            return null;
    }
    
    /**
     * Search the library for resources matching the given ISBN.
     * @param isbnToFind The ISBN to search for.
     */
    public void findIsbn(String isbnToFind)
    {
        int total = 0;
        for(Resource resource: resources) {
            if(resource instanceof Book && resource.getIsbn() == isbnToFind) {
                System.out.println(resource.getDetails());
                total++;
            }
        System.out.println("Total resources with matching ISBN: " + total + ".");
        System.out.println("Please note ISBN searches will not search our digital resources.");
            }
    }
    /**
     * Search the library for resources matching the given author.
     * @param authorToFind The author to search for.
     */
    public void findAuthor(String authorToFind)
    {
        if(resources.isEmpty()) {
            System.out.println("This collection is empty!");
        }
        int total = 0;
        int notFound = 0;
        for(Resource resource : resources) {
            if(resource.getAuthor() == authorToFind) {
                System.out.println(resource.getDetails());
                total++;
            }
            else {
                notFound++;
                if(notFound == resources.size()){
                    System.out.println("No matches found.");
            }
        }
        System.out.println("Total resources with matching author: " + total + ".");
        }
    }
    
    /**
     * Remove a resource from the library.
     * @param resourceToRemove The resource to remove from the library.
     */
    public void removeResource(Resource resourceToRemove)
    {
        int counter = 0;
        if(resourceToRemove == null) {
            System.out.println("Please enter a valid value.");
        }
        else if(resources.contains(resourceToRemove))
            resources.remove(resourceToRemove);
        else {
            counter++;
            if(counter == resources.size()) {
                System.out.println("That resource does not exist in the catalogue to be removed.");
            }
        }
    }
    
    /**
     * Remove a resource from the library using its index position.
     * @param index The index position to remove from the library. 
     */
    public void removeResourceByIndex(int index)
    {
        if(indexValid(index))
            resources.remove(index);
        else
            System.out.print("There is no resource at this index.");
    }
    
    /**
     * Print a list of all available resources.
     */
    public void availableBooks()
    {
        for(Resource resource : resources) {
            if(resource.getCurrentHolder() == null || resource instanceof ElectronicResource)
                resource.printDetails();
            }
    }
    
    /**
     * Get the size of the library catalogue.
     * @return The size of the catalogue, being all resources currently contained within it.
     */
    public int libraryCatalogueSize()
    {
        return resources.size();
    }
    
    /**
     * Add a resource to the library catalogue.
     * @param resourceToAdd The resource to add to the catalogue.
     */
    public void addNewResource(Resource resourceToAdd)
    {
        if(resourceToAdd == null) {
            System.out.println("Please enter a valid value.");
        }
        else if(resources.contains(resourceToAdd))
            System.out.println("This resource already exists in the catalogue.");
        else
            resources.add(resourceToAdd);
    }
    
    /**
     * A method to simulate a library member borrowing a book.
     * @param bookToLend The resource the library member wants to borrow.
     * @param memberTakingBook The library member borrowing the resource.
     */
    public void lendingBook(Resource bookToLend, LibraryMember memberTakingBook)
    {
        if(bookToLend == null || memberTakingBook == null) {
            System.out.println("Please enter a valid value.");
        }
        if(bookToLend instanceof Book && memberTakingBook.getCurrentResources().contains(bookToLend)) {
            System.out.println("You already have this resource.");
        }
        else if(memberTakingBook.getCurrentResources().size() >= 5) {
            System.out.println("You have more than 5 books checked out.");
            System.out.println("Please return some before checking out this current book.");
        }
        else if (bookToLend instanceof ElectronicResource) {
            System.out.println("Enjoy this resouce!");
        }

        else if (bookToLend instanceof Book && memberTakingBook.getCurrentResources().size() <5 && bookToLend.getCurrentHolder() == null) {
            bookToLend.setCurrentHolder(memberTakingBook);
            memberTakingBook.addResource(bookToLend);
        }
        else if (bookToLend instanceof Resource && memberTakingBook.getCurrentResources().size() <5 && bookToLend.getCurrentHolder() == null) {
            bookToLend.setCurrentHolder(memberTakingBook);
            memberTakingBook.addResource(bookToLend);
        }
        else if (bookToLend.getCurrentHolder() != null) {
            System.out.print("Someone already had this book. Unfortunately you cannot check it out right now.");
        }
    }
    
    /**
     * A method to simulate a library member returning a resource.
     * @param bookToReturn The resource the library member wants to return.
     * @param newDamageToAdd True if the resource is physical and is damaged, otherwise false.
     * @param damageDescription The damage to record, if relevant.
     */
    public void returningBook(Resource bookToReturn, boolean newDamageToAdd, String damageDescription)
    {
        if(bookToReturn == null) {
            System.out.println("Please enter a valid value.");
        }
        else if(bookToReturn instanceof Book) {
            bookToReturn.getCurrentHolder().removeResource(bookToReturn);
            bookToReturn.addDamage(damageDescription);
        }
    }
    
    /** 
     * A method to simulate sending a message to all members who currently hold resources.
     * @param message The message to send to the relevant members.
     */
    public void messageToMembersHoldingBooks(String message)
    {
        for(Resource resource : resources) {
            if(resource instanceof Book && resource.getCurrentHolder()!= null)
                resource.getCurrentHolder().setMessage(message);
        }
    }
    
    /**
     * List the physical resources held in the library.
     */
    public void listPhysicalResources() 
    {
        for(Resource resource : resources) {
            if (resource instanceof Book) {
                resource.printDetails();
            }
        }
    }
    
    /**
     * List the electronic resources held in the library.
     */
    public void listElectronicResources()
    {
        for(Resource resource : resources) {
            if(resource instanceof ElectronicResource) {
                resource.printDetails();
            }
        }
    }
    
    /**
     * Check if a given index is valid in the collection.
     * @param index The index to check validity of.
     */
    private boolean indexValid(int index)
    {
        // The return value.
        // Set according to whether the index is valid or not.
        boolean valid;
        
        if(index < 0) {
            System.out.println("Index cannot be negative: " + index);
            valid = false;
        }
        else if(index >= resources.size()) {
            System.out.println("Index is too large: " + index);
            valid = false;
        }
        else {
            valid = true;
        }
        return valid;
    }
}