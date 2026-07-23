/**
 * The MarineCorps is a class that facilitates the behavior of the marine corp
 * Contributed by: Marianne Gaerlan
*/
package MODEL;


import java.util.ArrayList;
import java.util.List;

public class MarineCorps
{

    private final int corpsID; // ID of the marine corp
    private static int count; // increments the ID
    private String baseLocation; // the base location of the corp
    private Marine corpsCommander; // the commander of the corp
    private String corpsName; // the name of the corps
    private List<Marine> marineMembers = new ArrayList<>(); // the list of members of the corp
    private int operationalFunds; // the operational funds of the corp

    // This is the Marine Corp constructor

    public MarineCorps(String baseLocation, String corpsName)
    {
        this.corpsID = ++count;
        this.baseLocation = baseLocation;
        this.corpsName = corpsName;
    }

/** setBaseLocation lets the user mutate the base location
*
*@param baseLocation
*@return void

*/   

    public void setBaseLocation(String baseLocation)
    {
        this.baseLocation = baseLocation;
    }

/** setCorpsCommander lets the user mutate the corps commander
*
*@param corpsCommander
*@return void

*/   

    public void setCorpsCommander(Marine corpsCommander)
    {
        this.corpsCommander = corpsCommander;
    }


/** setcorpsName lets the user mutate the name of the corps
*
*@param corpsName
*@return void

*/   

    public void setcorpsName(String corpsName)
    {
        this.corpsName = corpsName;
    }


/** setOperationalFunds lets the user mutate the amount of operational funds
*
*@param operationalFunds
*@return void

*/   
    public void setOperationalFunds (int operationalFunds)
    {
        if (operationalFunds>=0)
            this.operationalFunds = operationalFunds;
    }

/** getCorpsID lets the user access the ID of the corp
*
*@param none
*@return this.corpsID

*/   

    public int getCorpsID()
    {
        return this.corpsID;
    }


/** getBaseLocation lets the user access the location of the corp
*
*@param none
*@return this.baseLocation

*/   

   public String getBaseLocation()
    {
        return this.baseLocation;
    }

/** getcorpsCommander lets the user access the commander of the corp
*
*@param none
*@return this.corpsCommander

*/   

    public Marine getcorpsCommander()
    {
        return this.corpsCommander;
    }

/** getcorpsName lets the user access the name of the corp
*
*@param none
*@return this.corpsName

*/   


    public String getcorpsName()
    {
        return this.corpsName;
    }


/** getcorpsName lets the user access the funds of the corp
*
*@param none
*@return this.operationalFunds

*/   


    public int getOperationalFunds()
    {

        return this.operationalFunds;
    }

/** getMarines lets the user access the members of the corp
*
*@param none
*@return this.marineMembers

*/   


    public List<Marine> getMarines()
    {
        return this.marineMembers;
    }


/** The method views the members of the Marine Corp
*
*@param none
*@return void

*/
    public void viewList()
    {
        for(Marine m : marineMembers){
            System.out.println("Database ID: " + m.getCharacterID() + " Name: " + m.getName());
        }
        System.out.println();
    }


/** The method views the attributes of the Marine Group
*
*@param none
*@return void

*/
    public void viewMarineGroup()
    {
        int i = 1;

        System.out.println("Marine Corps: " + this.corpsName);
        System.out.println("Base Location: " + this.baseLocation);
        if (getcorpsCommander() != null)
        {
        System.out.println("Corps Commander: " + corpsCommander.getName());

        }
        else
        {
        System.out.println("Corps Commander: None" );
        }
        System.out.println("Operational Funds: " + this.operationalFunds);
        System.out.println("Marine Members:");
        
        if (marineMembers.isEmpty())
        {
            System.out.println("No members added");
        }
        for (Marine member: marineMembers)
        {
            System.out.println("("+ i+") " + member.getName());
            i++;
        }
    }

/** The method recruit a member to the Corp
*
*@param newMember that you want to add
*@return void
*@throw Illegal Argument Exception if the member already exists and Null Pointer Exception if the member already belongs to the other corp

*/

   public void recruitMarineMember(Marine newMember)
    {
        if(newMember.getMarineCorps() != null)
        {
            throw new NullPointerException("Member already belongs to another corps.");
        }

        if (marineMembers.contains(newMember))
        {
            throw new IllegalArgumentException("Member already Exists!");
        }

        marineMembers.add(newMember);
        newMember.setmarineCorps(this);
        if(newMember.getRank().contains("Commander")) setCorpsCommander(newMember);

        System.out.println("Welcome to the Corps, " + newMember.getName() + "!");
    }

/** The method removes a member from the Corp
*
*@param member that you want to remove
*@return void

*/
    public void removeMarineMember(Marine member)
    {
        marineMembers.remove(member);
        member.setmarineCorps(null);
        System.out.println(member.getName() + " is no longer in the corps.");
    }


     public String FileFormat()
     {

        ArrayList<String> memberNames = new ArrayList<>();
        for (Marine m: marineMembers)
        {
            memberNames.add(m.getName());
        }
        String members = String.join(",", memberNames);
   
        return "AFFILIATION: MARINE CORP | ID: " + getCorpsID() + 
        "| CORP NAME: " + getcorpsName() + 
        "| OPERATIONAL FUNDS: " + getOperationalFunds() +
         "| BASE LOCATION: " + getBaseLocation() +
          "| COMMANDER: " + (getcorpsCommander() == null ? "NONE": getcorpsCommander().getName()) +
           "| MEMBERS: " + (getMarines() == null ||getMarines().isEmpty() ? "NONE": members);
     }
}
