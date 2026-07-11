/**
 * This class holds the behavior of the affiliation database and facilitates the registering of a new pirate crew or marine corp
 * Contributed by: Marco Macasaet
*/

import java.util.HashMap;
import java.util.Map;

public class AffiliationDatabase {

    
    private final Map<Integer,PirateCrew> crewMap; // the hashmap for the pirate crew
    private final Map<Integer,MarineCorps> corpMap; // the hashmap for the marine corp

// Affiliation Database constructor
    public AffiliationDatabase()
    {
        this.crewMap = new HashMap<>();
        this.corpMap = new HashMap<>();
    }


/* addPirateCrew lets the user add a new pirate crew to the system

@param crew
@return void
@throw Illegal argument exception if the user tries to add an already existing crew

*/   
    public void addPirateCrew(PirateCrew crew)
    {

        if (crewMap.containsKey(crew.getCrewID()))
        {
            throw new IllegalArgumentException("Pirate Crew ID already exists");
        }

        crewMap.put(crew.getCrewID(), crew);

    }

/* getCrew lets the user access a crew using its ID

@param crewID
@return pirateCrew

*/ 

    public PirateCrew getCrew(int crewID)
    {
        PirateCrew pirateCrew = crewMap.get(crewID);

        return pirateCrew;
    }

/* removeCrew lets the user remove a  pirate crew from the system

@param crewID
@return void

*/   
    public void removeCrew (int crewID)
    {
        PirateCrew removedPirateCrew = crewMap.remove(crewID);
        System.out.println(removedPirateCrew.getCrewName() + " has been removed.");
    }


/* displayCrews display the list of crews existing in the system

@param none
@return none

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
/* getCrewMap lets the user access the crew hashmap

@param none
@return crewMap

*/   


    public Map<Integer, PirateCrew> getCrewMap(){
        return crewMap;
    }

/* addMarineCorp lets the user add a new marine corp to the system

@param corps
@return void
@throw Illegal argument exception if the user tries to add an already existing corp

*/   

    public void addMarineCorp(MarineCorps corps)
    {

        if (corpMap.containsKey(corps.getCorpsID()))
        {
            throw new IllegalArgumentException("Marine Corp ID already exists");
        }

        corpMap.put(corps.getCorpsID(), corps);

    }

/* getCorps lets the user access a corp using its ID

@param corpsID
@return marineCorps

*/ 

    public MarineCorps getCorps(int corpsID)
    {
        MarineCorps marineCorps = corpMap.get(corpsID);

        return marineCorps;
    }


/* getCrewMap lets the user access the corp hashmap

@param none
@return corpMap

*/ 
    public Map<Integer, MarineCorps> getCorpsMap(){
        return corpMap;
    }

/* removeCorps lets the user remove a marine corp from the system

@param corpsID
@return void

*/   

    public void removeCorps (int corpsID)
    {
        MarineCorps removedMarineCorps = corpMap.remove(corpsID);
        System.out.println(removedMarineCorps.getcorpsName() + " has been removed.");
    }

/* displayCorps display the list of corps existing in the system

@param none
@return void

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

}

