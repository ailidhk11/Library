

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class LibraryTest.
 *
 * @author  Ailidh
 * @version 1.0
 */
public class LibraryTest
{
    private Library library1;
    private LibraryMember libraryM1;
    private Resource resource1;
    private Device device1;
    private ElectronicResource electron1;
    private Book book1;

    /**
     * Default constructor for test class LibraryTest
     */
    public LibraryTest()
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
        
        library1 = new Library("Willaim Patrick");
        libraryM1 = new LibraryMember("Ailidh");
        resource1 = new Resource("Roald Dahl", "Matilda", true);
        device1 = new Device("iPad", "Cafe");
        electron1 = new ElectronicResource("J Walters", "Computer Science");
        book1 = new Book("Sally Rooney", "Normal People", "none");
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
     * Check method returns the correct value.
     */
    @Test
    public void testGetLibraryName()
    {
        Library library1 = new Library("William Patrick");
        assertEquals("William Patrick", library1.getLibraryname());
    }
    /**
     * Check method sets or updates library name.
     */
    @Test
    public void testSetLibraryName()
    {
        Library library1 = new Library("William Patrick");
        library1.setLibraryName("Glasgow City");
        assertEquals("Glasgow City", library1.getLibraryname());
    }
    
    /**
     * Check true is returned when a resource is searched for and found in the catalogue.
     */
    @Test
    public void testResourceAvailableInLibrary()
    {
        library1.addNewResource(resource1);
        library1.addNewResource(book1);
        library1.addNewResource(electron1);
        assertEquals(true, library1.resourceAvailableInLibrary(resource1));
    }

    /**
     * Check method edits the title of relevant resource.
     */
    @Test
    public void testEditTitle()
    {
        library1.addNewResource(book1);
        library1.addNewResource(electron1);
        library1.addNewResource(resource1);
        library1.editTitle("Normal People", "Strangers");
        assertEquals("Strangers", book1.getTitle());
    }
    
    /**
     * Check the method finds the resource searched for.
     */
    @Test
    public void testFindResource()
    {
        library1.addNewResource(book1);
        library1.addNewResource(electron1);
        library1.addNewResource(resource1);
        assertEquals(book1, library1.findResource(book1));
    }
    
    /**
     * Check method finds resource(s) with matcing ISBN.
     */
    @Test
    public void testFindIsbn()
    {
        assertEquals("", book1.getIsbn());
        book1.setIsbn("12345678");
        library1.addNewResource(book1);
        library1.addNewResource(resource1);
        library1.findIsbn("12345678");
    }
    
    /**
     * Check method finds resource(s) with matching authors.
     */
    @Test
    public void testFindAuthor()
    {
        library1.addNewResource(book1);
        library1.addNewResource(electron1);
        library1.findAuthor("Sally Rooney");
    }

    /** 
     * Check method removes requested resource.
     */
    @Test
    public void testRemoveResource()
    {
        library1.addNewResource(book1);
        library1.addNewResource(electron1);
        java.util.ArrayList<Resource> arrayLis1 = new java.util.ArrayList<Resource>();
        assertEquals(true, arrayLis1.add(electron1));
        library1.removeResource(book1);
        assertEquals(1, library1.libraryCatalogueSize());
    }
    
    /**
     * Check method removes resource at given index. 
     */
    @Test
    public void testRemoveByIndex()
    {
        library1.addNewResource(book1);
        library1.addNewResource(electron1);
        library1.addNewResource(resource1);
        library1.removeResourceByIndex(0);
        assertEquals(2, library1.libraryCatalogueSize());
    }
    
    /**
     * Check method returns number of resources in catalogue.
     */
    @Test
    public void testLibraryCatalogueSize()
    {
        library1.addNewResource(book1);
        library1.addNewResource(electron1);
        library1.addNewResource(resource1);
        assertEquals(3, library1.libraryCatalogueSize());
    }

    /**
     * Check method simulates process of lending book by adding book to library member's list of books and marking book not available to other members.
     */
    @Test
    public void testLendingBook()
    {
        library1.addNewResource(book1);
        library1.lendingBook(book1, libraryM1);
        assertEquals(libraryM1, book1.getCurrentHolder());
        java.util.ArrayList<Resource> arrayLis1 = new java.util.ArrayList<Resource>();
        assertEquals(true, arrayLis1.add(book1));
        assertEquals(arrayLis1, libraryM1.getCurrentResources());
    }

    /**
     * Check method adds a new resource to the catalogue.
     */
    @Test
    public void testAddNewResource()
    {
        library1.addNewResource(book1);
        java.util.ArrayList<Resource> arrayLis1 = new java.util.ArrayList<Resource>();
        assertEquals(true, arrayLis1.add(book1));
        library1.addNewResource(electron1);
        assertEquals(true, arrayLis1.add(electron1));
        assertEquals(arrayLis1, library1.getResources());
    }

    /**
     * Check the method simulates the process of returning a book and making it available for others.
     * Damage recorded if required.
     */
    @Test
    public void testReturnBook()
    {
        library1.addNewResource(book1);
        library1.lendingBook(book1, libraryM1);
        library1.returningBook(book1, false, "");
        java.util.ArrayList<Resource> arrayLis1 = new java.util.ArrayList<Resource>();
        assertEquals(arrayLis1, libraryM1.getCurrentResources());
    }

    /**
     * Check message sent to members and stored to be accessed later.
     */
    @Test
    public void testMessageToMembers()
    {
        library1.addNewResource(book1);
        library1.lendingBook(book1, libraryM1);
        library1.messageToMembersHoldingBooks("Hello!");
        assertEquals("Hello!", libraryM1.getMessages());
    }

    /**
     * Check catalogue collection returned. 
     */
    @Test
    public void testGetResources()
    {
        library1.addNewResource(book1);
        library1.addNewResource(resource1);
        java.util.ArrayList<Resource> arrayLis1 = new java.util.ArrayList<Resource>();
        assertEquals(true, arrayLis1.add(book1));
        assertEquals(true, arrayLis1.add(resource1));
        assertEquals(arrayLis1, library1.getResources());
    }
    
    /**
     * Check the details of the catalogue are printed. 
     */
    @Test
    public void testPrintDetails()
    {
        library1.addNewResource(book1);
        library1.printDetails();
    }

    /**
     * Check resources not currently borrowed are listed.
     */
    @Test
    public void testListAvailableResources()
    {
        library1.addNewResource(book1);
        library1.addNewResource(resource1);
        Book book2 = new Book("Roald Dahl", "Matilda", "Ripped cover.");
        library1.addNewResource(book2);
        library1.availableBooks();
    }
        
    /**
     * Check only physical resources are listed.
     */
    @Test
    public void testListPhysicalResources()
    {
        library1.addNewResource(book1);
        Book book2 = new Book("Example", "J Smith", "none");
        library1.availableBooks();
        library1.addNewResource(book2);
        library1.addNewResource(electron1);
        library1.listPhysicalResources();
    }
    
    /**
     * Check only the details electronic resources are listed.
     */
    @Test
    public void testListElectronicResources()
    {
        library1.addNewResource(electron1);
        library1.addNewResource(book1);
        ElectronicResource electron2 = new ElectronicResource("K Mill", "Me and My Dog");
        library1.addNewResource(electron2);
        library1.listElectronicResources();
    }


    @Test
    public void testReturningElecResource()
    {
        library1.addNewResource(resource1);
        library1.lendingBook(resource1, libraryM1);
        library1.returningBook(resource1, false, "");
        assertEquals(resource1, library1.findResource(resource1));
    }
}























