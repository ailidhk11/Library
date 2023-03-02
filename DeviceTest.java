

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class DeviceTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DeviceTest
{
    private Device device1;

    /**
     * Default constructor for test class DeviceTest
     */
    public DeviceTest()
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
        
        
        device1 = new Device("iPad", "Cafe");
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
     * Check the type of electronic device is returned.
     */
    @Test
    public void testGetType()
    {
        assertEquals("iPad", device1.getType());
    }
    
    /**
     * Check the type of electronic device is correctly recorded.
     */
     @Test
    public void testSetDeviceType()
    {
        device1.setType("Kindle");
        assertEquals("Kindle", device1.getType());
    }

    /**
     * Check the correct location is returned.
     */
    @Test
    public void testGetLocation()
    {
        assertEquals("Cafe", device1.getLocation());
    }

    /** 
     * Check the location of electronic device is correctly updated.
     */
    @Test
    public void testSetLocation()
    {
        device1.setLocation("Reading nook");
        assertEquals("Reading nook", device1.getLocation());
    }

    /**
     * Check that the result is true if the device is not currently in use, otherwise false.
     */
    @Test
    public void testIsAvailable()
    {
        assertEquals(true, device1.isCurrentlyAvailable());
    }

    /**
     * Check that the details of the device print correctly.
     */
    @Test
    public void testPrintDetails()
    {
        device1.printDeviceDetails();
    }
}









