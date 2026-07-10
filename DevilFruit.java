import java.util.ArrayList;
import java.util.List;

public class DevilFruit 
{
    private final int fruitID;
    private static int count;
    private String fruitName;
    private String category;
    private String primaryAbility;
    private Character currentOwner;
    private List<Character> historicalOwners;

    DevilFruit(String fruitName, String category, String primaryAbility)
    {
        this.fruitID = ++count;
        this.fruitName = fruitName;
        this.category = category;
        this.primaryAbility = primaryAbility;
        this.historicalOwners = new ArrayList<>();
    }

    // setters


    public void setCategory(String category)
    {
        this.category = category;
    }

    public void setPrimaryAbility(String primaryAbility)
    {
        this.primaryAbility = primaryAbility;
    }

    public void setcurrentOwner(Character currentOwner)
    {
        this.currentOwner = currentOwner;
    }



    // getters

    public int getFruitId()
    {
        return fruitID;
    }

    public String getFruitName()
    {
        return fruitName;
    }

    public String getCategory()
    {
        return category;
    }

    public String getPrimaryAbility()
    {
        return primaryAbility;
    }

    public Character getcurrentOwner()
    {
        return currentOwner;
    }

    public List<Character> getHistoricalOwners()
    {
        return historicalOwners;
    }


    
    


    public boolean assignUser(Character newOwner)
    {
        if (this.currentOwner == null && newOwner.getDFPower() == null)
        {
            this.currentOwner = newOwner;
            newOwner.setDFPower(this);

            System.out.println(this.fruitName + "'s power has been transferred to " +this.currentOwner.getName());

            return true;
        }
        else if (newOwner.getDFPower() != null)
        {
            System.out.println(newOwner.getName() + " already has a Devil Fruit");
            return false;
        }
        else
        {
            System.out.println(this.currentOwner.getName() + " Owns this Devil Fruit!");
            return false;
        }

    }

    public void triggerReincarnation()
    {
        if (this.currentOwner != null && this.currentOwner.getStatus().equalsIgnoreCase( "Dead"))
        {
            historicalOwners.add(this.currentOwner);
            this.currentOwner.setDFPower(null);
            System.out.println(this.currentOwner.getName() + " had a Devil Fruit and is now Dead. " + this.fruitName +" has reincarnated.");
            this.currentOwner = null;

        }
    }




}