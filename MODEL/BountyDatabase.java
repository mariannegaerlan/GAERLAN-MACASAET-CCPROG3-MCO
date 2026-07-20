/**
 * This class holds the behavior of the devil fruit database and facilitates the registering of a new devil fruit
 * Contributed by: Marianne Gaerlan
 */


import java.util.HashMap;
import java.util.Map;


public class BountyDatabase {

    private final Map<Integer,PirateBounty> bountyMap;
    
    public BountyDatabase()
    {
        this.bountyMap = new HashMap<>();
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
    
}
