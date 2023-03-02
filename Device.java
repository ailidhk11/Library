
/**
 * A class representing a device available in
 * the library to view electronic resources. 
 * 
 * 
 * @author Ailidh
 * @version 1.0
 */
public class Device
{
    // The type of device.
    private String deviceType;
    // Where the device is located in the library.
    private String deviceLocation;
    // If the device is currently available.
    private boolean isAvailable;
    /**
     * Constructor for objects of class Device
     * @param type The device type.
     * @param location The device location.
     */
    public Device(String type, String location)
    {
        deviceType = type;
        deviceLocation = location;
        isAvailable = true;
    }
    
     /**
     * Set the device type.
     * @param The type of the device.
     */
    public void setType(String newDeviceType)
    {
        deviceType = newDeviceType;
    }
    
    /**
     * Get the type of the device.
     * @return The device type.
     */
    public String getType()
    {
        return deviceType;
    }
    
    /**
     * Set the location of the device.
     * @param location The device's location.
     */
    public void setLocation(String location)
    {
        deviceLocation = location;
    }
    
    /**
     * Get the location of the device.
     * @return The device's location.
     */
    public String getLocation()
    {
        return deviceLocation;
    }
    
    /**
     * Check if the device is currently available.
     * @return True if available, otherwise false.
     */
    public boolean isCurrentlyAvailable()
    {
        if(isAvailable = true)
            return true;
        else
            return false;
    }
    
    /**
     * Print the details of the device. 
     */
    public void printDeviceDetails()
    {
        System.out.println("This device is a " + deviceType + ". It is located in the " + deviceLocation + ". ");
        if(isAvailable = true)
            System.out.println("This device is currently available.");
        else
            System.out.println("This device is currently being used by another member.");
    }
}
