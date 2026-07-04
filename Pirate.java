
public class Pirate extends Character{

    private int Bounty;
    private String PirateRole;
    private boolean isCaptain;
    private PirateCrew pirateCrew;

    public Pirate( String Name, String Alias, String Origin, String Status, int Wallet, int Bounty, boolean isCaptain, String PirateRole )
    {
        super(Name, Alias, Origin, Status, Wallet, "Pirate");
        this.Bounty = Bounty;
        this.isCaptain = isCaptain;
        this.PirateRole = PirateRole;
        

    }

    // setters

    public void setBounty(int Bounty)
    {
        if (Bounty >= 0)
        {
            this.Bounty= Bounty;
        }
        else
        {
            throw new IllegalArgumentException("Bounty can't be negative");
        }

    }

    public void setPirateRole(String PirateRole)
    {
        this.PirateRole= PirateRole;
    }

    public void setisCaptain(boolean isCaptain)
    {
        this.isCaptain= isCaptain;
    }

    public void setPirateCrew(PirateCrew pirateCrew)
    {
        this.pirateCrew= pirateCrew;
    }

    // getters

    public int getBounty()
    {
        return this.Bounty;
    }

    public String getPirateRole()
    {
        return this.PirateRole;
    }

    public boolean getisCaptain()
    {
        return this.isCaptain;
    }

    public PirateCrew getPirateCrew()
    {
        return this.pirateCrew;
    }

//methods


    public void ModifyBounty(int amount)
    {
        if (amount >=0)
        {
        this.Bounty += amount;
        }
        else
        {
            throw new IllegalArgumentException("Amount can't be negative");
        }

    }

    public void AssignToCrew(PirateCrew newCrew)
    {
        this.pirateCrew = newCrew;
    }


@Override
    public void DisplayProfile()
    {
       super.DisplayProfile();
       System.out.println("Bounty: " + getBounty());
       System.out.println("Pirate Role: " + getPirateRole());
      System.out.println( "Pirate Crew: " + getPirateCrew().getCrewName());
      System.out.println("Captain: " + (getisCaptain() ? "Yes" : "No"));
    
    }
}
