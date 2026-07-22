/**
 * The DevilFruit is a class that facilitates the behavior of the Devil Fruit
 * Contributed by: Marianne Gaerlan
*/


import java.util.ArrayList;
import java.util.List;

public class DevilFruit 
{
    private final int fruitID; // ID of the fruit
    private static int count; // count increments the ID of the fruit
    private String fruitName; // name of the fruit
    private String category; // category of the fruit
    private String primaryAbility; // ability of the fruit
    private Character currentOwner; // current owner of the group
    private List<Character> historicalOwners; // list of past owners of the group


// Devil Fruit Constructor
    DevilFruit(String fruitName, String category, String primaryAbility)
    {
        this.fruitID = ++count;
        this.fruitName = fruitName;
        this.category = category;
        this.primaryAbility = primaryAbility;
        this.historicalOwners = new ArrayList<>();
    }

/** setCategory lets the user mutate the category
*
*@param category
*@return void

*/   


    public void setCategory(String category)
    {
        this.category = category;
    }
/** setPrimaryAbility lets the user mutate the primary Ability
*
*@param primaryAbility
*@return void

*/   
    public void setPrimaryAbility(String primaryAbility)
    {
        this.primaryAbility = primaryAbility;
    }
/** setcurrentOwner lets the user mutate the current owner
*
*@param currentOwner
*@return void

*/   
    public void setcurrentOwner(Character currentOwner)
    {
        this.currentOwner = currentOwner;
    }



/** getFruitId lets the user access the ID of the fruit
*
*@param none
*@return fruitID

*/   


    public int getFruitId()
    {
        return fruitID;
    }

/** getFruitName lets the user access the name of the fruit
*
*@param none
*@return fruitName

*/   


    public String getFruitName()
    {
        return fruitName;
    }
/** getCategory lets the user access the category of the fruit
*
*@param none
*@return category

*/   
    public String getCategory()
    {
        return category;
    }
/** getPrimaryAbility lets the user access the ability of the fruit
*
*@param none
*@return primaryAbility

*/  
    public String getPrimaryAbility()
    {
        return primaryAbility;
    }
/** getcurrentOwner lets the user access the owner of the fruit
*
*@param none
*@return currentOwner

*/  
    public Character getcurrentOwner()
    {
        return currentOwner;
    }
/** getHistoricalOwners lets the user access the past owners of the fruit
*
*@param none
*@return historicalOwners

*/  
    public List<Character> getHistoricalOwners()
    {
        return historicalOwners;
    }

/** this method checks if the fruit was successfully assigned to a user
*
*@param newOwner
*@return true or false

*/  
    
    

    public boolean assignUser(Character newOwner)
    {
        // if the fruit does not have a current owner and the new owner to be assigned does not have a fruit, assign the new owner to the fruit
        if (this.currentOwner == null && newOwner.getDFPower() == null)
        {
            this.currentOwner = newOwner;
            newOwner.setDFPower(this);

            System.out.println(this.fruitName + "'s power has been transferred to " +this.currentOwner.getName());

            return true;
        }
        else if (newOwner.getDFPower() != null) // if the new owner already has a devil fruit
        {
            System.out.println(newOwner.getName() + " already has a Devil Fruit");
            return false;
        }
        else // if the fruit is already owned by another owner
        {
            System.out.println(this.currentOwner.getName() + " Owns this Devil Fruit!");
            return false;
        }

    }

/** this method releases the fruit to the world for availability after the owner is dead
*
*@param none
*@return void

*/  
    
    public void triggerReincarnation()
    {
        // if the fruit has a owner and the owner's status is dead, add the owner to the historical owners list and remove its devil fruit power. Release the fruit by setting its current owner to null
        if (this.currentOwner != null && this.currentOwner.getStatus().equalsIgnoreCase( "Dead"))
        {
            historicalOwners.add(this.currentOwner);
            this.currentOwner.setDFPower(null);
            System.out.println(this.currentOwner.getName() + " had a Devil Fruit and is now Dead. " + this.fruitName +" has reincarnated.");
            this.currentOwner = null;

        }
    }


     public String FileFormat()
     {

        ArrayList<String> ownerNames = new ArrayList<>();
        for (Character o: historicalOwners)
        {
            ownerNames.add(o.getName());
        }
        String members = String.join(",", ownerNames);
        return "DEVIL FRUIT: " + getCategory() + "| ID: " + getFruitId() + "| FRUIT NAME: " + getFruitName() + "| ABILITY: " + getPrimaryAbility() + "| CURRENT OWNER: " + (getcurrentOwner() == null ? "NONE": getcurrentOwner().getName())  + "| HISTORICAL OWNERS: " + (getHistoricalOwners() == null ||getHistoricalOwners().isEmpty() ? "NONE": members);

     }


}