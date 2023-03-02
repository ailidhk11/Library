
/**
 * A class representing a physical book that can be borrowed by a member of the library.
 *
 * @author Ailidh
 * @version 1.0
 */
public class Book extends Resource
{
    // Damages to a book to be recorded.
    private String damagesToBook;

    /**
     * Constructor for objects of class Book.
     * @param author The book's author.
     * @param title The book's title.
     *
     */
    public Book(String author, String title, String damagesToRecord)
    {
        // initialise instance variables
        super(author, title, true);
        damagesToBook = damagesToRecord;
    }
    
}
