import java.util.HashMap;
import java.util.Map;

public class AffiliationDatabase {

    
    private final Map<Integer,PirateCrew> crewMap;
    private final Map<Integer,MarineCorps> corpMap;


    public AffiliationDatabase()
    {
        this.crewMap = new HashMap<>();
        this.corpMap = new HashMap<>();
    }

    public void addPirateCrew(PirateCrew crew)
    {

        if (crewMap.containsKey(crew.getCrewID()))
        {
            throw new IllegalArgumentException("Pirate Crew ID already exists");
        }

        crewMap.put(crew.getCrewID(), crew);

    }

    public PirateCrew getCrew(int crewID)
    {
        PirateCrew pirateCrew = crewMap.get(crewID);

        return pirateCrew;
    }

    public void removeCrew (int crewID)
    {
        PirateCrew removedPirateCrew = crewMap.remove(crewID);
        System.out.println(removedPirateCrew.getCrewName() + " has been removed.");
    }

    public void displayCrews()
    {
        if (crewMap.isEmpty())
        {
            System.out.println("The database is empty.");
            return;
        }
        System.out.println("\n====== PIRATE CREW DATABASE ======");
        for (PirateCrew p: crewMap.values())
        {
            p.viewPirateGroup();
            System.out.println("----------------------------");
        }
    }



    public void addMarineCorp(MarineCorps corps)
    {

        if (corpMap.containsKey(corps.getCorpsID()))
        {
            throw new IllegalArgumentException("Marine Corp ID already exists");
        }

        corpMap.put(corps.getCorpsID(), corps);

    }

    public MarineCorps getCorps(int corpsID)
    {
        MarineCorps marineCorps = corpMap.get(corpsID);

        return marineCorps;
    }

    public void removeCorps (int corpsID)
    {
        MarineCorps removedMarineCorps = corpMap.remove(corpsID);
        System.out.println(removedMarineCorps.getcorpsName() + " has been removed.");
    }

    public void displayCorps()
    {
        if (corpMap.isEmpty())
        {
            System.out.println("The database is empty.");
            return;
        }
        System.out.println("\n====== MARINE CORPS DATABASE ======");
        for (MarineCorps m: corpMap.values())
        {
            m.viewMarineGroup();
            System.out.println("----------------------------");
        }
    }
}

