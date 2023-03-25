/** 
* Project: Grade12Culminating
* Programmer: Taha Hashim 
* Date: January 21, 2022
* Program: User.java 
* Description: Taha Hashim's final culminating project
*/ 
package grade12culminating;

public class User 
{
    //creates the fields
    private int id;
    private int pin;
    
    //creates a no-arg constructor for the default values
    User()
    {
        id = 0;
        pin = 0;
    }
    
    //creates arg constructor that initializes data in fields of User object
    User(int i, int p)
    {
        id = i;
        pin = p;
    }
    
    /**
     * setId
     * Assigns ID to the User object
     * @param i - id
     */
    public void setId(int i)
    {
        id = i;
    }
    
    /**
     * setPin
     * Assigns pin to the User object
     * @param p - pin
     */
    public void setPin(int p)
    {
        pin = p;
    }
   
    /**
     * getId
     * Obtains the ID
     * @return id - the identification
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * getPin
     * Obtains the pin
     * @return pin - the pin
     */
    public int getPin()
    {
        return pin;
    }
    
}//end of class
