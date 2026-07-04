import java.util.HashMap;
import java.util.Map;


public class DevilFruitDatabase {
   private final Map<Integer,DevilFruit> dfMap;

    public DevilFruitDatabase()
    {
        this.dfMap = new HashMap<>();
    }

    public Map<Integer, DevilFruit> getDFMap()
    {
        return dfMap;
    }

    public void createDevilFruit(DevilFruit devilFruit)
    {

        if (dfMap.containsKey(devilFruit.getFruitId()))
        {
            throw new IllegalArgumentException("Devil Fruit ID already exists");
        }

        dfMap.put(devilFruit.getFruitId(), devilFruit);

    }

    public DevilFruit getDevilFruit(int fruitID)
    {
        DevilFruit devilFruit = dfMap.get(fruitID);

        return devilFruit;
    }

    public void assignFruitToUser(int fruitID, Character character)
    {
        DevilFruit devilFruit = getDevilFruit(fruitID);
    
        devilFruit.triggerReincarnation(); 
        devilFruit.assignUser(character); 

    }

    public void viewDevilFruit(int fruitID)
    {
        DevilFruit devilFruit = dfMap.get(fruitID);
        System.out.println("Fruit ID: " + devilFruit.getFruitId());
        System.out.println("Fruit Name: " + devilFruit.getFruitName());
        System.out.println("Category: " + devilFruit.getCategory());
        System.out.println("Ability: " + devilFruit.getPrimaryAbility());

        if (devilFruit.getcurrentOwner() != null)
        {
            System.out.println("Current Owner: " + devilFruit.getcurrentOwner().getName());
        }
        else
        {
            System.out.println("Current Owner: none");
        }

        if(devilFruit.getHistoricalOwners()!= null)
        {
            System.out.println("---Historical Owners---");
            for (Character c: devilFruit.getHistoricalOwners())
            {
                System.out.println("("+ c.getCharacterID()+ ")" + c.getName());
            }
        }


    }

    public void displayFruits()
    {

        System.out.println("\n====== DEVIL FRUIT DATABASE ======");
        for (DevilFruit d: dfMap.values())
        {
            System.out.println("(" + d.getFruitId() +") " + d.getFruitName());
            System.out.println("----------------------------");
        }
    }
}
