import java.util.ArrayList;
import java.util.List;

public class MarineCorps
{

    private final int corpsID;
    private static int count;
    private String baseLocation;
    private Marine corpsCommander;
    private String corpsName;
    private List<Marine> marineMembers = new ArrayList<>();
    private int operationalFunds;

    MarineCorps(String baseLocation, String corpsName, int operationalFunds)
    {
        this.corpsID = ++count;
        this.baseLocation = baseLocation;
        this.corpsName = corpsName;
        this.operationalFunds = operationalFunds;
    }

    // setters


    public void setBaseLocation(String baseLocation)
    {
        this.baseLocation = baseLocation;
    }

    public void setCorpsCommander(Marine corpsCommander)
    {
        this.corpsCommander = corpsCommander;
    }


    public void setcorpsName(String corpsName)
    {
        this.corpsName = corpsName;
    }


    public void setOperationalFunds (int operationalFunds)
    {
        if (operationalFunds>=0)
            this.operationalFunds = operationalFunds;
    }

    // getters

    public int getCorpsID()
    {
        return this.corpsID;
    }

   public String getBaseLocation()
    {
        return this.baseLocation;
    }

    public Marine getcorpsCommander()
    {
        return this.corpsCommander;
    }

    public String getcorpsName()
    {
        return this.corpsName;
    }


    public int getOperationalFunds()
    {

        return this.operationalFunds;
    }

    public List<Marine> getMarines()
    {
        return this.marineMembers;
    }

    public void viewList()
    {
        for(Marine m : marineMembers){
            System.out.println("Database ID: " + m.getCharacterID() + " Name: " + m.getName());
        }
        System.out.println();
    }

    public void viewMarineGroup()
    {
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
            System.out.println("("+ getCorpsID()+") " + member.getName());
        }
    }

    // add a public void viewMemberProfile() for individual members


   public void recruitMarineMember(Marine newMember)
    {
        if(newMember.getMarineCorps() != null)
        {
            throw new NullPointerException("Member already belongs to another crew.");
        }

        if (marineMembers.contains(newMember))
        {
            throw new IllegalArgumentException("Member already Exists!");
        }

        marineMembers.add(newMember);
        newMember.setmarineCorps(this);
        if(newMember.getRank() == "Commander") setCorpsCommander(newMember);

        System.out.println("Welcome to the Corps, " + newMember.getName() + "!");
    }


    public void removeMarineMember(Marine member)
    {
        marineMembers.remove(member);
        System.out.println(member.getName() + " is no longer a Marine.");
    }

}
