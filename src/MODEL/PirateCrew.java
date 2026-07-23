package MODEL;

/**
 * The PirateCrew is a class that facilitates the behavior of the pirate crew
 * Contributed by: Marianne Gaerlan
 */


import java.util.ArrayList;
import java.util.List;

public class PirateCrew {

    private final int crewID; // ID of the crew
    private static int count; // count that increments the crew ID
    private String crewName; // name of the crew
    private String shipName; // name of the ship
    private Pirate captain; // captain of the crew
    private List<Pirate> crewMembers = new ArrayList<>(); // list of members of the crew
    private int totalBounty; // total bounty of the crew

    // This is the pirate crew constructor

    public PirateCrew(String crewName, String shipName)
    {
        this.crewID = ++count;
        this.crewName = crewName;
        this.shipName = shipName;
        this.totalBounty = 0;
    }

/** setCrewName lets the user mutate crew name
*
*@param crewName
*@return void

*/   

    public void setCrewName(String crewName)
    {
        this.crewName= crewName;
    }
/** setShipName lets the user mutate ship name
*
*@param shipName
*@return void

*/   
    public void setShipName(String shipName)
    {
        this.shipName = shipName;
    }
/** setCaptain lets the user mutate captain
*
*@param captain
*@return void

*/   
    public void setCaptain(Pirate captain)
    {
        this.captain = captain;
    }
    



/** getCrewID lets the user access the ID of the crew
*
*@param none
*@return this.crewID

*/  
    public int getCrewID()
    {
        return this.crewID;
    }
/** getCrewName lets the user access the name of the crew
*
*@param none
*@return this.crewName

*/   
    public String getCrewName()
    {
        return this.crewName;
    }
/** getShipName lets the user access the ship name  of the crew
*
*@param none
*@return this.shipName

*/   
    public String getShipName()
    {
        return this.shipName;
    }
/** getCaptain lets the user access the captain of the crew
*
*@param none
*@return this.captain

*/   
    public Pirate getCaptain()
    {
        return this.captain;
    }

/** getTotalBounty lets the user access the total bounty of the crew
*
*@param none
*@return this.totalBounty

*/   
    public int getTotalBounty()
    {
        int total=0;

        for(Pirate crew : crewMembers){

            this.totalBounty += crew.getBounty();

        }

        return total;
    }

/** getPirates lets the user access the list of members of the crew
*
*@param none
*@return this.crewMembers

*/   
    public List<Pirate> getPirates()
    {
        return this.crewMembers;
    }
    
/** modifyCrewBounty lets the user modify the crews total bounty
*
*@param pirate
*@return void

*/   

    public void modifyCrewBounty(Pirate pirate)
    {
        this.totalBounty -= pirate.getBounty();
        
    }

/** The method views the members of the Pirate Crew
*
*@param none
*@return void

*/
    public void viewList()
    {
        for(Pirate p : crewMembers)
        {
            System.out.println("Database ID: " + p.getCharacterID() + " Name: " + p.getName());
        }
        System.out.println();
    }
    

/** The method views the attributes of the Pirate Group
*
*@param none
*@return void

*/
    public void viewPirateGroup()
    {
        System.out.println("Pirate Crew: " + this.crewName);
        System.out.println("Ship Name: " + this.shipName);
        int i = 1;
        
        if (getCaptain() != null)
        {
        System.out.println("Captain: " + this.captain.getName());

        }
        else
        {
        System.out.println("Captain: None");
        }

        System.out.println("Total Bounty: " + getTotalBounty());
            System.out.println("Crew Members:");
            if (crewMembers.isEmpty())
                {
                    System.out.println("No Members Added");
                }

            for (Pirate crew: crewMembers)
            {
                System.out.println("("+ i+") " + crew.getName());
                i++;
            }
          

    }

/** The method recruit a member to the Crew
*
*@param newMember that you want to add
*@return void
*@throw Illegal Argument Exception if the member already exists and Null Pointer Exception if the member already belongs to the other crew

*/

    public void recruitCrewMember(Pirate newMember)
    {
        if(newMember.getPirateCrew() != null)
        {
            throw new NullPointerException("Member already belongs to another crew.");
        }

        if (crewMembers.contains(newMember))
        {
            throw new IllegalArgumentException("Member already Exists!");
        }

        crewMembers.add(newMember);
        newMember.setPirateCrew(this);
        if(newMember.getPirateRole().contains("Captain")){
            setCaptain(newMember);
            newMember.setisCaptain(true);
        }
        
        if (newMember.getStatus().equals("Free"))
        {
             totalBounty += newMember.getBounty();
        }

        System.out.println("Welcome to the Crew, " + newMember.getName() + "!");
    }

/** The method removes a member from the Crew
*
*@param member that you want to remove
*@return void

*/
    public void removeCrewMember(Pirate member)
    {
        crewMembers.remove(member);
        member.setPirateCrew(null);
        System.out.println(member.getName() + " is no longer in the crew.");
    }

     public String FileFormat()
     {

        ArrayList<String> memberNames = new ArrayList<>();

      for (Pirate p: crewMembers)
        {
            memberNames.add(p.getName());
        }
        String members = String.join(",", memberNames);
        return "AFFILIATION: PIRATE CREW | ID: " + getCrewID() + 
        "| CREW NAME: " + getCrewName() + 
        "| SHIP NAME: " + getShipName() +
         "| TOTAL BOUNTY: " + getTotalBounty() +
          "| CAPTAIN: " + (getCaptain() == null ? "NONE": getCaptain().getName()) +
           "| MEMBERS: " + (getPirates() == null ||getPirates().isEmpty() ? "NONE": members);
  
     }
}



