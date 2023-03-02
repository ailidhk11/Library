import java.util.ArrayList;

/**
 * A class detailing physical and electronic resources
 * available in a library.
 *
 * @author Ailidh
 * @version 1.0
 */
public class Resource
{
    // The author.
    private String author;
    // The resource's title.
    private String title;
    // The ISBN of the resource.
    private String isbn;
    // If it currently checked out.
    private LibraryMember currentHolder;
    // If book has any damages.
    private String damagesToBook;
    // Type of resource
    private boolean isAvailableNow;
    

    /**
     * Constructor for objects of class Resource
     * @param resourceAuthor The resource's author.
     * @param resourceTitle The resource's title.
     * @param isAvailable If the resource is currently available. 
     */
    public Resource(String resourceAuthor, String resourceTitle, boolean isAvailable)
    {
        author = resourceAuthor;
        title = resourceTitle;
        currentHolder = null;
        damagesToBook = "";
        isAvailableNow = isAvailable;
        if(this instanceof ElectronicResource) {
            isbn = "Electronic resources do not require ISBNs.";
        }
        else {
            isbn = "";
        }
    }
    
    /**
     * Set the author of the resource.
     * @param updateAuthor The resource's author.
     */
    public void setAuthor(String updateAuthor)    
    {
        author = updateAuthor;
    }

    /**
     * Get the author of the resource. 
     * @return The resource's author.
     */
    public String getAuthor()
    {
        return author;
    }
    
    /**
     * Set the title of a resource. 
     * @param setTitle The resource's title.
     */
    public void setTitle(String setTitle)
    {
        title = setTitle;
    }
    
     /**
     * Get the title of the resource.
     * @return The resource's title. 
     */
    public String getTitle()
    {
        return title;
    }
    
    /** 
     * Set the ISBN of a resource.
     * @param updateIsbn The resource's ISBN.
     */
    public void setIsbn(String updateIsbn)
    {
        isbn = updateIsbn;
    }
    
    /**
     * Get the ISBN of a resource.
     * @return The resource's ISBN.
     */
    public String getIsbn()
    {
        return isbn;
    }
    
    /**
     * Set the library member who is now holding the resource if it is available.
     * @param newHolder The library member now holding the resource.
     */
    public void setCurrentHolder(LibraryMember newHolder)
    {
        if (newHolder == null) {
            System.out.println("Null value rejected. Please enter a new value.");
        }
        else {
            currentHolder = newHolder;
        }
    }
    
    /**
     * Get the current holder of a resource.
     * @return The current holder of the resource.
     */
    public LibraryMember getCurrentHolder()
    {
        return currentHolder;
    }
    
    /** 
     * Set the damage of a resource. 
     * @param setDamage The damage to record.
     */
    public void setDamage(String setDamage)
    {
        if (this instanceof ElectronicResource) {
            System.out.println("This is a digital resource. You cannot record any damages.");
        }
        else {
            damagesToBook = setDamage;
        }
    }
    
    /**
     * Add new damage to the resource.
     * @param newDamage The new damage to record. 
     */
    public void addDamage(String newDamage)
    {
        if(this instanceof ElectronicResource) {
            System.out.println("This is a digital resource. You cannot record any damages.");
        }
        else {
            damagesToBook = "Previous damage: " + damagesToBook +". New damage: " + newDamage;
        }
    }  
    
    /**
     * Get the damages of the resource.
     * @return Damages of the resource.
     */
    public String getDamages()
    {
        if(this instanceof ElectronicResource) {
            return "This is a digital resource and has no damages.";
        }
        else { 
            return damagesToBook;
        }
    }

    /**
     * Get the details of the resource.
     */
    public String getDetails()
    {
        String details = "";
        if(this instanceof ElectronicResource) {
            details = "'" + getTitle() +"'" + ", by " + getAuthor() + " (ISBN: " + getIsbn() + ". This is an electronic resource.";
        }
        else if (this instanceof Book) {
            details = "'" + getTitle() +"'" + ", by " + getAuthor() + " (ISBN: " + getIsbn() + ", with" + damagesToBook;
        }
        else if (this instanceof Resource) {
            details = "'" + getTitle()+ "'" + ", by " + getAuthor() + " (ISBN: " + getIsbn() + ".";
        }
        return details;
    }
    
    /** 
     * Print the details of a resource. 
     */
    public void printDetails()
    {
        System.out.println("'" + title +"'" + ", by " + author + " "); 
        System.out.println("(ISBN: " + isbn + ").");
        if(this instanceof ElectronicResource) {
            System.out.println(". This is an electronic resource.");
        }
        else if(this instanceof Book) {
            if (damagesToBook == "") {
                System.out.print("This book has no damages.");
            }
            else {
                System.out.print(", with " + damagesToBook + ".");
            }
        }
        if(getCurrentHolder() == null && this instanceof ElectronicResource){
            System.out.print("Access this resource today.");
        }
        else if (getCurrentHolder() == null) {
            System.out.print("This book is currently available.");
        }
        else if (getCurrentHolder() != null) {
            System.out.print("This book is currently unavailable.");
        }
    }
    
    /**
     * A method to check if a resource is available. 
     * @return True if available, otherwise false.
     */
    public boolean isAvailableNow()
    {
        boolean valid;
        if(this instanceof ElectronicResource) {
            String error = ("This is an electronic resource and we have unlimited copies available.");
            System.out.println(error);
            valid = true;
        }
        else if(this instanceof Book && getCurrentHolder() != null) {
            valid = false;
            String error = ("This resource is not currently available.");
            System.out.println(error);
            
        }
        else if(this instanceof Resource && getCurrentHolder() != null) {
            valid = false;
            String error = ("This resource is not currently available.");
            System.out.println(error);
        }
        else
            valid = true;
        return valid;
    }
}
