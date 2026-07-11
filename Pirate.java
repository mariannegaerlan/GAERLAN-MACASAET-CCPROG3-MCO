
/*

Description:

The Pirate class is a child of the Character Class and facilitates the creation of the pirate

Contributed by: Marianne Gaerlan

*/


public class Pirate extends Character{

    private int Bounty; // This is the Bounty of the Pirate
    private String PirateRole; // This is the Role of the Pirate
    private boolean isCaptain; // this is the boolean indicating if the Pirate is a Captain
    private PirateCrew pirateCrew; // This is the crew that the pirate belongs to


    // This is the constructor of the Pirate
    public Pirate( String Name, String Alias, String Origin, String Status, int Wallet, int Bounty, boolean isCaptain, String PirateRole )
    {
        super(Name, Alias, Origin, Status, Wallet, "Pirate");
        this.Bounty = Bounty;
        this.isCaptain = isCaptain;
        this.PirateRole = PirateRole;
        

    }

    // Below are the setters

    public void setBounty(int Bounty)
    {
        if (Bounty >= 0) // if the Bounty is less than 0, a throw will halt its input.
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

    // Below are the getters

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
        if (amount >=0) // if the amount is less than 0, a throw will halt its input.
        {
        this.Bounty += amount;
        }
        else
        {
            throw new IllegalArgumentException("Amount can't be negative");
        }

    }


// This method displays the attributes of the Pirate

@Override
    public void DisplayProfile()
    {
       super.DisplayProfile();
       System.out.println("Bounty: " + getBounty());
       System.out.println("Pirate Role: " + getPirateRole());

       

       if (getPirateCrew() != null)
       {
        System.out.println( "Pirate Crew: " + getPirateCrew().getCrewName());
       }
       else
       {
        System.out.println("Pirate Crew: None");

       }
      
    
    }
}
