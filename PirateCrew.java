
/*

Description:

The Marine class is a child of the Character Class and facilitates the creation of the marine

Contributed by: Marianne Gaerlan

*/


import java.util.ArrayList;
import java.util.List;

public class PirateCrew {

    private final int crewID;
    private static int count;
    private String crewName;
    private String shipName;
    private Pirate captain;
    private List<Pirate> crewMembers = new ArrayList<>();
    private int totalBounty;

    PirateCrew(String crewName, String shipName)
    {
        this.crewID = ++count;
        this.crewName = crewName;
        this.shipName = shipName;
        this.totalBounty = 0;
    }
    // setters


    public void setCrewName(String crewName)
    {
        this.crewName= crewName;
    }

    public void setShipName(String shipName)
    {
        this.shipName = shipName;
    }

    public void setCaptain(Pirate captain)
    {
        this.captain = captain;
    }
    
    // getters

    public int getCrewID()
    {
        return this.crewID;
    }

    public String getCrewName()
    {
        return this.crewName;
    }

    public String getShipName()
    {
        return this.shipName;
    }

    public Pirate getCaptain()
    {
        return this.captain;
    }


    public int getTotalBounty()
    {
        this.totalBounty=0;

        for(Pirate crew : crewMembers){
            this.totalBounty += crew.getBounty();
        }

        return this.totalBounty;
    }

    public List<Pirate> getPirates()
    {
        return this.crewMembers;
    }

    public void viewList()
    {
        for(Pirate p : crewMembers)
        {
            System.out.println("Database ID: " + p.getCharacterID() + " Name: " + p.getName());
        }
        System.out.println();
    }
    
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

    // add a public void viewMemberProfile() for individual members


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


    public void removeCrewMember(Pirate member)
    {
        crewMembers.remove(member);
        member.setPirateCrew(null);
        System.out.println(member.getName() + " is no longer in the crew.");
    }
    
}
