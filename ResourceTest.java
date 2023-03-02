

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ResourceTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ResourceTest
{
    private Resource resource1;

    /**
     * Default constructor for test class ResourceTest
     */
    public ResourceTest()
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
        resource1 = new Resource("Sally Rooney", "Normal People", true);
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
     * Check the correct author value is returned.
     */
    @Test
    public void testGetAuthor()
    {
        assertEquals("Sally Rooney", resource1.getAuthor());
    }

    /**
     * Check the value for author is set correctly.
     */
    @Test
    public void testSetAuthor()
    {
        assertEquals("Sally Rooney", resource1.getAuthor());
        resource1.setAuthor("Ms. S Rooney");
        assertEquals("Ms. S Rooney", resource1.getAuthor());
    }

    /**
     * Check the correct title value is returned.
     */
    @Test
    public void testGetTitle()
    {
        assertEquals("Normal People", resource1.getTitle());
    }

    /**
     * Check the value for title is set correctly.
     */
    @Test
    public void testSetTitle()
    {
        assertEquals("Normal People", resource1.getTitle());
        resource1.setTitle("Conversations With Friends");
        assertEquals("Conversations With Friends", resource1.getTitle());
    }

    /**
     * Check the value of the ISBN is returned.
     */
    @Test
    public void testGetIsbn()
    {
        assertEquals("", resource1.getIsbn());
    }

    /**
     * Check the value for the ISBN is set correctly.
     */
    @Test
    public void testSetIsbn()
    {
        assertEquals("", resource1.getIsbn());
        resource1.setIsbn("13500089271");
        assertEquals("13500089271", resource1.getIsbn());
    }

    /**
     * Check that the correct LibraryMember is returned as current holder.
     */
    @Test
    public void testGetCurrentHolder()
    {
        LibraryMember libraryM1 = new LibraryMember("Ailidh");
        resource1.setCurrentHolder(libraryM1);
        assertEquals(libraryM1, resource1.getCurrentHolder());
    }
    
    /**
     * Check that that the method sets the current holder correctly with LibraryMember object.
     */
    @Test
    public void testSetCurrentHolder()
    {
        LibraryMember libraryM1 = new LibraryMember("Ailidh");
        resource1.setCurrentHolder(libraryM1);
        assertEquals(libraryM1, resource1.getCurrentHolder());
        LibraryMember libraryM2 = new LibraryMember("Kevin");
        resource1.setCurrentHolder(libraryM2);
        assertEquals(libraryM2, resource1.getCurrentHolder());
    }

    /**
     * Check that the damages to a resource are returned. 
     */
    @Test
    public void testGetDamages()
    {
        assertEquals("", resource1.getDamages());
        resource1.setDamage("broken spine");
        assertEquals("broken spine", resource1.getDamages());
    }

    /**
     * Check that the method adds a damage to a Resource object.
     */
    @Test
    public void testAddDamage()
    {
        assertEquals("", resource1.getDamages());
        resource1.setDamage("broken spine");
        assertEquals("broken spine", resource1.getDamages());
        resource1.addDamage("ripped front cover");
        assertEquals("Previous damage: broken spine. New damage: ripped front cover", resource1.getDamages());
    }
    
    /**
     * Check a method sets the inital damage for a Resource object. 
     */
    @Test
    public void testSetDamage()
    {
        resource1.setDamage("cracked spine");
        assertEquals("cracked spine", resource1.getDamages());
    }
    
    /**
     * Check that true is returned if the resource is available and false otherwise.
     */
    @Test
    public void testIsAvailableNow()
    {
        assertEquals(true, resource1.isAvailableNow());
        LibraryMember libraryM1 = new LibraryMember("ailidh");
        resource1.setCurrentHolder(libraryM1);
        assertEquals(false, resource1.isAvailableNow());
    }

    /**
     * Check that the details of a resource are returned correctly.
     */
    @Test
    public void testGetDetails()
    {
        resource1.setAuthor("Sally Rooney");
        resource1.setTitle("Normal People");
        resource1.setIsbn("1234");
        assertEquals("'Normal People', by Sally Rooney (ISBN: 1234.", resource1.getDetails());
    }

    /**
     * Check that the details of a resource are printed corectly. 
     */
    @Test
    public void testPrintDetails()
    {
        Resource resource2 = new Resource("Sally Rooney", "Normal People", true);
        resource2.printDetails();
    }
}

















