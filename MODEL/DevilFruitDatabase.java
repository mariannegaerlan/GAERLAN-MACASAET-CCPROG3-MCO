/**
 * This class holds the behavior of the devil fruit database and facilitates the registering of a new devil fruit
 * Contributed by: Marco Macasaet
 */


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class DevilFruitDatabase {
   private final Map<Integer,DevilFruit> dfMap; // hashmap of the devil fruit

// Constructor of the DevilFruitDatabase
    public DevilFruitDatabase()
    {
        this.dfMap = new HashMap<>();
        loadFruitFile();
    }
/** getDFMap lets the user access the devil fruit hashmap
*
*@param none
*@return dfMap

*/ 

    public Map<Integer, DevilFruit> getDFMap()
    {
        return dfMap;
    }


/** createDevilFruit lets the user create a new devil fruit
*
*@param devilFruit
*@return void
*@throws IllegalArgumentException if the user inputs an already existing devil fruit

*/ 

    public void createDevilFruit(DevilFruit devilFruit)
    {

        if (dfMap.containsKey(devilFruit.getFruitId()))
        {
            throw new IllegalArgumentException("Devil Fruit ID already exists");
        }

        dfMap.put(devilFruit.getFruitId(), devilFruit);
        saveFruittoFile(devilFruit);

    }
/** getDevilFruit lets the user access the devil fruit
*
*@param fruitID
*@return devilFruit

*/ 
    public DevilFruit getDevilFruit(int fruitID)
    {
        DevilFruit devilFruit = dfMap.get(fruitID);

        return devilFruit;
    }

/** assignFruitToUSer display calls the devil fruit (based on its ID)'s behavior to assign it to an existing character
*
*@param fruitID, character
*@return void

*/ 
    public void assignFruitToUser(int fruitID, Character character)
    {
        DevilFruit devilFruit = getDevilFruit(fruitID);
    
        devilFruit.triggerReincarnation(); 
        devilFruit.assignUser(character); 

    }
/** viewDevilFruit displays the specific information about the fruit
*
*@param fruitID
*@return void

*/ 

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

        if(devilFruit.getHistoricalOwners().isEmpty())
        {
            System.out.println("Historical Owners: None");

        }
        else
        {
            System.out.println("---Historical Owners---");
            for (Character c: devilFruit.getHistoricalOwners())
            {
                System.out.println("("+ c.getCharacterID()+ ") " + c.getName());
            }
        }


    }
    
/** displayFruits display the list of fruits existing in the system
*
*@param none
*@return void

*/ 

    public void displayFruits()
    {

        System.out.println("\n====== DEVIL FRUIT DATABASE ======");
        for (DevilFruit d: dfMap.values())
        {
            System.out.println("(" + d.getFruitId() +") " + d.getFruitName());
            System.out.println("----------------------------");
        }
    }



/** saveFruittoFile utilizes file writer to save the logged devil fruit into a text file
    * 
    *@param corp
    *@return void

*/  


    public static void saveFruittoFile(DevilFruit fruit)
    {
        if (fruit == null)
        {
            return;
        }

        try (FileWriter writer = new FileWriter ("DevilFruits.txt", true))
        {
            PrintWriter pWriter = new PrintWriter(writer);

            pWriter.println(fruit.FileFormat());
            
        }
        catch (IOException e)
        {
            System.out.println("Erorr: " + e.getMessage());

        }
    }

/** rewriteFruitFile utilizes file writer to overwrite the current devil fruit text file
    * 
    *@param none
    *@return void

*/  


    public void rewriteFruitFile()
    {
        try (FileWriter writer = new FileWriter ("DevilFruits.txt", false))
        {
            PrintWriter pWriter = new PrintWriter(writer);
        
            for (DevilFruit d: dfMap.values())
            {
                pWriter.println(d.FileFormat());
            }
        }
        catch (IOException e)
        {
            System.out.println("Erorr: " + e.getMessage());

        }
        
    }


/** loadFruitFile utilizes file to load the devil fruit text file
    * 
    *@param none
    *@return void

*/  

        public void loadFruitFile()
    {
        File file = new File("DevilFruits.txt");

        if (!file.exists())
        {
            System.out.println("Devil fruit file doesn't contain anything");
            return;
        }

        try (Scanner scanner = new Scanner(file))
        {
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] segments = line.split("\\s*\\|\\s*");

                    String category = segments[0].split(":")[1].trim();
                    String name = segments[2].split(":")[1].trim();
                    String ability = segments[3].split(":")[1].trim();

                       DevilFruit d = new DevilFruit(name, category, ability);
                       dfMap.put(d.getFruitId(),d);
            }
        }

        catch (Exception e)
        {
            System.out.println("Error loading Devil Fruit file: " + e.getMessage());
        }
    }
        


}
