

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class LibraryMemberTest.
 *
 * @author   Ailidh 
 * @version 1.0
 */
public class LibraryMemberTest
{
    private LibraryMember libraryM1;

    /**
     * Default constructor for test class LibraryMemberTest
     */
    public LibraryMemberTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        libraryM1 = new LibraryMember("Ailidh Kinney");
        
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    /**
     * Check the name of the library member is set to correct value.
     */
    @Test
    public void testSetName()
    {
        libraryM1.setName("Ailidh");
        assertEquals("Ailidh", libraryM1.getName());
    }
    
    /**
     * Check the libray member's name is returned.
     */
    @Test
    public void testGetName()
    {
        libraryM1.setName("Ailidh");
        assertEquals("Ailidh", libraryM1.getName());
    }

    /**
     * Check that messages are recorded.
     */
    @Test
    public void testSetMessages()
    {
        libraryM1.setMessage("Reading is fun!");
        assertEquals("Reading is fun!", libraryM1.getMessages());
    }
    
    /**
     * Check that stored messages are returned.
     */
     @Test
    public void testGetMessages()
    {
        libraryM1.setMessage("Reading is fun!");
        assertEquals("Reading is fun!", libraryM1.getMessages());
    }

    /**
     * Check that method returns total number of resources that member is holding.
     */
    @Test
    public void testTotalNoOfResources()
    {
        Book book1 = new Book("Roald Dahl", "Matilda", "broken spine");
        libraryM1.addResource(book1);
        Book book2 = new Book("Sally Rooney", "Normal People", "Ripped cover");
        libraryM1.addResource(book2);
        assertEquals(2, libraryM1.totalNumberOfResources());
    }

    /**
     * Check that method returns the details of the resources currently held by member.
     */
    @Test
    public void testGetCurrentResources()
    {
        Book book1 = new Book("Sally Rooney", "Normal People", "Cracked spine.");
        java.util.ArrayList<Resource> arrayLis2 = new java.util.ArrayList<Resource>();
        assertEquals(true, arrayLis2.add(book1));
        libraryM1.addResource(book1);
        assertEquals(arrayLis2, libraryM1.getCurrentResources());
    }

    /**
     * Check that a new resource is added to the resources the member holds.
     */
    @Test
    public void testAddNewResource()
    {
        Book book1 = new Book("Sally Rooney", "Matilda", "Broken spine");
        java.util.ArrayList<Resource> arrayLis1 = new java.util.ArrayList<Resource>();
        assertEquals(true, arrayLis1.add(book1));
        libraryM1.addResource(book1);
        assertEquals(arrayLis1, libraryM1.getCurrentResources());
    }

    /**
     * Check that the correct details of resources held are returned. 
     */
    @Test
    public void testGetDetails()
    {
        Book book1 = new Book("Sally Rooney", "Normal People", "Cracked spine.");
        libraryM1.addResource(book1);
        assertEquals("Ailidh Kinney is currently an active member.They are currently borrowng 1 book.They have no messages.", libraryM1.getMemberDetails());
    }

    /** 
     * Check that the details of the member are returned.
     */
    @Test
    public void testPrintMemberDetails()
    {
        Book book1 = new Book("Sally Rooney", "Normal People", "Cracked spine.");
        libraryM1.addResource(book1);
        libraryM1.printMemberDetails();
        assertEquals("Ailidh Kinney is currently an active member.They are currently borrowng 1 book.They have no messages.", libraryM1.getMemberDetails());
    }

    @Test
    public void testRemoveResource()
    {
        Book book1 = new Book("Test", "J Smith", "none");
        libraryM1.addResource(book1);
        assertEquals(1, libraryM1.totalNumberOfResources());
        libraryM1.removeResource(book1);
        assertEquals(0, libraryM1.totalNumberOfResources());
    }

    @Test
    public void printDetails()
    {
        Book book1 = new Book("Sally Rooney", "Normal People", "Cracked spine");
        libraryM1.addResource(book1);
        libraryM1.printMemberDetails();
    }
}













