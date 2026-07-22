/**
 * This class holds the behavior of the devil fruit database and facilitates the registering of a new devil fruit
 * Contributed by: Marianne Gaerlan
 */


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class BountyDatabase {

    private final Map<Integer,PirateBounty> bountyMap;
    
    public BountyDatabase()
    {
        this.bountyMap = new HashMap<>();
        loadBountyFile();
    }


    public Map<Integer,PirateBounty> getBountyMap()
    {
        return this.bountyMap;
    }

    public void registerCapture(PirateBounty bounty)
    {
        if (bountyMap.containsKey(bounty.getCaptureID()))
        {
            throw new IllegalArgumentException("Capture ID already exists");
        }

        bountyMap.put(bounty.getCaptureID(), bounty);
        saveBountyttoFile(bounty);
    }

    public void viewHistoralCaptures()
    {
        System.out.println("=== HISTORICAL CAPTURE RECORDS ===");

        for (PirateBounty b: bountyMap.values())
            {
                for (String logs: b.getBountyHistory())
                {


                System.out.println("ID: "+ b.getCaptureID() + logs);
                }
            }
    }
    


/** saveBountyttoFile utilizes file writer to save the logged bounty into a text file
    * 
    *@param bounty
    *@return void

*/  


    public static void saveBountyttoFile(PirateBounty bounty)
    {
        if (bounty == null)
        {
            return;
        }

        try (FileWriter writer = new FileWriter ("Bounty.txt", true))
        {
            PrintWriter pWriter = new PrintWriter(writer);

            pWriter.println(bounty.FileFormat());
            
        }
        catch (IOException e)
        {
            System.out.println("Erorr: " + e.getMessage());

        }
    }

/** rewriteBountyFile utilizes file writer to overwrite the current bounty text file
    * 
    *@param none
    *@return void

*/  


    public void rewriteBountyFile()
    {
        try (FileWriter writer = new FileWriter ("Bounty.txt", false))
        {
            PrintWriter pWriter = new PrintWriter(writer);
        
            for (PirateBounty b: bountyMap.values())
            {
                pWriter.println(b.FileFormat());
            }
        }
        catch (IOException e)
        {
            System.out.println("Erorr: " + e.getMessage());

        }
        
    }


/** loadBountyFile utilizes file to load the bounty text file
    * 
    *@param none
    *@return void

*/  

    public void loadBountyFile()
    {
        File file = new File("Bounty.txt");

        if (!file.exists())
        {
            System.out.println("Bounty file doesn't contain anything");
            return;
        }

        try (Scanner scanner = new Scanner(file))
        {
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] segments = line.split("\\s*\\|\\s*");

                    String captorName = segments[1].split(":")[1].trim();
                    String capturedName = segments[2].split(":")[1].trim();

                    PirateBounty bounty = new PirateBounty();
                    bounty.getBountyHistory().add(line);
                       bountyMap.put(bounty.getCaptureID(),bounty);
                       
            }
        }

        catch (Exception e)
        {
            System.out.println("Error loading Devil Fruit file: " + e.getMessage());
        }
    }
        

}
