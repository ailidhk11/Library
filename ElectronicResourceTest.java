

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ElectronicResourceTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElectronicResourceTest
{
    /**
     * Default constructor for test class ElectronicResourceTest
     */
    public ElectronicResourceTest()
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
     * Check the devices used to access the relevant resource are returned.
     */
    @Test
    public void testGetDevices()
    {
        ElectronicResource electron1 = new ElectronicResource("J Walters", "Computing Science");
        Device device1 = new Device("iPad", "Cafe");
        java.util.ArrayList<Device> arrayLis1 = new java.util.ArrayList<Device>();
        electron1.addDevice(device1);
        assertEquals(true, arrayLis1.add(device1));
        assertEquals(arrayLis1, electron1.getDevices());
    }

    /**
     * Check that a new device is correctly added to the ArrayList devices. 
     */
    @Test
    public void testAddDevice()
    {
        ElectronicResource electron1 = new ElectronicResource("J Walters", "Computing Science");
        Device device1 = new Device("iPad", "Cafe");
        Device device2 = new Device("Kindle", "Reading nook");
        java.util.ArrayList<Device> arrayLis1 = new java.util.ArrayList<Device>();
        assertEquals(true, arrayLis1.add(device1));
        assertEquals(true, arrayLis1.add(device2));
        electron1.addDevice(device1);
        electron1.addDevice(device2);
        assertEquals(arrayLis1, electron1.getDevices());
    }
    
    /**
     * Check that device information is printed.
     */
    @Test
    public void testPrintDeviceDetails()
    {
        ElectronicResource electron1 = new ElectronicResource("L Willow", "Tesco");
        Device device1 = new Device("iPad", "cafe");
        electron1.addDevice(device1);
        electron1.printDeviceDetails();
    }
}




