/**
 * This class holds the behavior of the affiliation database and facilitates the registering of a new pirate crew or marine corp
 * Contributed by: Marco Macasaet
*/
package MODEL;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AffiliationDatabase {

    
    private final Map<Integer,PirateCrew> crewMap; // the hashmap for the pirate crew
    private final Map<Integer,MarineCorps> corpMap; // the hashmap for the marine corp

// Affiliation Database constructor
    public AffiliationDatabase()
    {
        this.crewMap = new HashMap<>();
        this.corpMap = new HashMap<>();
        loadCrewFile();
        loadCorpFile();
    }


/** addPirateCrew lets the user add a new pirate crew to the system
*
* @param crew
* @return void
* @throws Illegalargument exception if the user tries to add an already existing crew

*/   
    public void addPirateCrew(PirateCrew crew)
    {

        if (crewMap.containsKey(crew.getCrewID()))
        {
            throw new IllegalArgumentException("Pirate Crew ID already exists");
        }

        crewMap.put(crew.getCrewID(), crew);
        savePirateCrewtoFile(crew);

    }

/**  getCrew lets the user access a crew using its ID
*
*@param crewID
*@return pirateCrew

*/ 

    public PirateCrew getCrew(int crewID)
    {
        PirateCrew pirateCrew = crewMap.get(crewID);

        return pirateCrew;
    }

/** removeCrew lets the user remove a  pirate crew from the system
*
*@param crewID
*@return void

*/   
    public void removeCrew (int crewID)
    {
        PirateCrew removedPirateCrew = crewMap.remove(crewID);
        System.out.println(removedPirateCrew.getCrewName() + " has been removed.");

        rewriteCrewFile();
    }


/** displayCrews display the list of crews existing in the system
*
*@param none
*@return none

*/   
    public void displayCrews()
    {

        System.out.println("\n====== PIRATE CREW DATABASE ======");
        if (getCrewMap().isEmpty())
        {
            System.out.println("No Members");
        }
        for (PirateCrew p: crewMap.values())
        {
           System.out.println("ID: " + p.getCrewID() + " | Name: " +  p.getCrewName());
            System.out.println("----------------------------");
        }
    }
/**  getCrewMap lets the user access the crew hashmap
*
*@param none
*@return crewMap

*/   


    public Map<Integer, PirateCrew> getCrewMap(){
        return crewMap;
    }

/** addMarineCorp lets the user add a new marine corp to the system
*
*@param corps
*@return void
*@throw Illegal argument exception if the user tries to add an already existing corp

*/   

    public void addMarineCorp(MarineCorps corps)
    {

        if (corpMap.containsKey(corps.getCorpsID()))
        {
            throw new IllegalArgumentException("Marine Corp ID already exists");
        }

        corpMap.put(corps.getCorpsID(), corps);
        saveCorptoFile(corps);

    }

/** getCorps lets the user access a corp using its ID
*
*@param corpsID
*@return marineCorps

*/ 

    public MarineCorps getCorps(int corpsID)
    {
        MarineCorps marineCorps = corpMap.get(corpsID);

        return marineCorps;
    }


/** getCrewMap lets the user access the corp hashmap
*
*@param none
*@return corpMap

*/ 
    public Map<Integer, MarineCorps> getCorpsMap(){
        return corpMap;
    }

/**  removeCorps lets the user remove a marine corp from the system
*
*@param corpsID
*@return void

*/   

    public void removeCorps (int corpsID)
    {
        MarineCorps removedMarineCorps = corpMap.remove(corpsID);
        System.out.println(removedMarineCorps.getcorpsName() + " has been removed.");
        rewriteCrewFile();
    }

/**  displayCorps display the list of corps existing in the system
*
*@param none
*@return void

*/ 

    public void displayCorps()
    {


        System.out.println("\n====== MARINE CORPS DATABASE ======");
        if (getCorpsMap().isEmpty())
        {
            System.out.println("No Members");
        }
        for (MarineCorps m: corpMap.values())
        {
           System.out.println("ID: " + m.getCorpsID() + " | Name: " +  m.getcorpsName());
            System.out.println("----------------------------");
        }
    }


/** savePirateCrewtoFile utilizes file writer to save the logged pirate crew into a text file
    * 
    *@param crew
    *@return void

*/  


    public static void savePirateCrewtoFile(PirateCrew crew)
    {
        if (crew == null)
        {
            return;
        }

        try (FileWriter writer = new FileWriter ("PirateCrews.txt", true))
        {
            PrintWriter pWriter = new PrintWriter(writer);

            pWriter.println(crew.FileFormat());
            
        }
        catch (IOException e)
        {
            System.out.println("Erorr: " + e.getMessage());

        }
    }


/** saveCorptoFile utilizes file writer to save the logged marine corp into a text file
    * 
    *@param corp
    *@return void

*/  


    public static void saveCorptoFile(MarineCorps corp)
    {
        if (corp == null)
        {
            return;
        }

        try (FileWriter writer = new FileWriter ("MarineCorps.txt", true))
        {
            PrintWriter pWriter = new PrintWriter(writer);

            pWriter.println(corp.FileFormat());
            
        }
        catch (IOException e)
        {
            System.out.println("Erorr: " + e.getMessage());

        }
    }



/** rewriteCrewFile utilizes file writer to overwrite the current crew text file
    * 
    *@param none
    *@return void

*/  


    public void rewriteCrewFile()
    {
        try (FileWriter writer = new FileWriter ("PirateCrews.txt", false))
        {
            PrintWriter pWriter = new PrintWriter(writer);
        
            for (PirateCrew p: crewMap.values())
            {
                pWriter.println(p.FileFormat());
            }
        }
        catch (IOException e)
        {
            System.out.println("Erorr: " + e.getMessage());

        }
        
    }


/** rewriteCorpFile utilizes file writer to overwrite the current corp text file
    * 
    *@param none
    *@return void

*/  


    public void rewriteCorpFile()
    {
        try (FileWriter writer = new FileWriter ("MarineCorps.txt", false))
        {
            PrintWriter pWriter = new PrintWriter(writer);
        
            for (MarineCorps m: corpMap.values())
            {
                pWriter.println(m.FileFormat());
            }
        }
        catch (IOException e)
        {
            System.out.println("Erorr: " + e.getMessage());

        }
        
    }


/** loadCrewFile utilizes file to load the pirate crew text file
    * 
    *@param none
    *@return void

*/  

        public void loadCrewFile()
    {
        File file = new File("PirateCrews.txt");

        if (!file.exists())
        {
            System.out.println("Pirate Crew file doesn't contain anything");
            return;
        }

        try (Scanner scanner = new Scanner(file))
        {
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] segments = line.split("\\s*\\|\\s*");

                    String name = segments[2].split(":")[1].trim();
                    String ship = segments[3].split(":")[1].trim();
                    // int bounty = Integer.parseInt(segments[4].split(":")[1].trim());
                    // String captain = segments[5].split(":")[1].trim();
                    // String members = segments[6].split(":")[1].trim();

                    PirateCrew p = null;
                       p = new PirateCrew(name, ship);
                       crewMap.put(p.getCrewID(),p);
            }
        }

        catch (Exception e)
        {
            System.out.println("Error loading Crew file: " + e.getMessage());
        }
    }
        public void loadCorpFile()
    {
        File file = new File("MarineCorps.txt");

        if (!file.exists())
        {
            System.out.println("Marine Corp file doesn't contain anything");
            return;
        }

        try (Scanner scanner = new Scanner(file))
        {
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] segments = line.split("\\s*\\|\\s*");

                    String name = segments[2].split(":")[1].trim();
                    String location = segments[4].split(":")[1].trim();

                       MarineCorps m = new MarineCorps(name, location);
                       corpMap.put(m.getCorpsID(),m);
            }
        }

        catch (Exception e)
        {
            System.out.println("Error loading Corp file: " + e.getMessage());
        }
    }
}

