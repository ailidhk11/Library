import java.util.ArrayList;
/**
 * A class to represent electronic resources available in a library.
 *
 * @author Ailidh
 * @version 1.0
 */
public class ElectronicResource extends Resource
{
    // An ArrayList showing what resources can be used to access the device.
    private ArrayList<Device> devices;
    
    /**
     * Constructor for objects of class ElectronicResource
     * @param author The resource's author. 
     * @param title The resource's title.
     * 
     */
    public ElectronicResource(String author, String title)
    {
        super(author, title, true);
        devices = new ArrayList<>();
    }
    
    /**
     * Add a new device that you can access this resource on.
     * @param newDevice The device to add to ArrayList devices.
     */
    public void addDevice(Device newDevice)
    {
        if (newDevice == null) {
            System.out.println("Please enter a valid value.");
        }
        else {
            devices.add(newDevice);
        }
    }
    
    /**
     * Get the curent devices available to use to access this resource.
     * @return The devices ArrayList showing devices available to access this resource.
     */
    public ArrayList getDevices()
    {
        return devices;
    }
    
    public void printDeviceDetails()
    {
        for(Device device : devices) {
            device.printDeviceDetails();
        }
    }
        

    
}
