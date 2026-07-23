
/**
 * The Pirate class is a child of the Character Class and facilitates the creation of the pirate
 * Contributed by: Marianne Gaerlan
*/
package MODEL;

public class Pirate extends Character{

    private int Bounty; // This is the Bounty of the Pirate
    private String PirateRole; // This is the Role of the Pirate
    private boolean isCaptain; // this is the boolean indicating if the Pirate is a Captain
    private PirateCrew pirateCrew; // This is the crew that the pirate belongs to


    // This is the constructor of the Pirate
    public Pirate( String Name, String Alias, String Origin, String Status, int Wallet, int Bounty, String PirateRole )
    {
        super(Name, Alias, Origin, Status, Wallet, "Pirate");
        this.Bounty = Bounty;
        this.PirateRole = PirateRole;
        

    }

/** setBounty lets the user mutate the Bounty 
*
*@param Bounty is the new mutated Bounty
*@return void
*@throw throws an Illegual Argument Exception if the user tries to input a negative value

*/
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

/** setPirateRole lets the user mutate the Pirate ROle 
*
*@param PirateRole is the new mutated PirateRole
*@return void

*/

    public void setPirateRole(String PirateRole)
    {
        this.PirateRole= PirateRole;
    }

/** setisCaptain lets the user mutate the Captain Boolean Value 
*
*@param isCaptain is the new mutated isCaptain
*@return void

*/


    public void setisCaptain(boolean isCaptain)
    {
        this.isCaptain= isCaptain;
    }

/** setPirateCrew lets the user mutate the Pirate Crew 
*
*@param pirateCrew is the new mutated Pirate Crew
*@return void

*/

    public void setPirateCrew(PirateCrew pirateCrew)
    {
        this.pirateCrew= pirateCrew;
    }

/** getBounty lets the user access the Bounty
*
*@param none
*@return this.bounty

*/
    public int getBounty()
    {
        return this.Bounty;
    }

/** getBounty lets the user access the Bounty
*
*@param none
*@return this.bounty

*/
    public String getPirateRole()
    {
        return this.PirateRole;
    }


/** getisCaptain lets the user access the boolean value of captain
*
*@param none
*@return this.isCaptain

*/
    public boolean getisCaptain()
    {
        return this.isCaptain;
    }
/** getPirateCrew lets the user access the pirate crew
*
*@param none
*@return this.pirateCrew

*/
    public PirateCrew getPirateCrew()
    {
        return this.pirateCrew;
    }


/** ModifyBounty lets the user modify the current Bounty
*
*@param amount
*@return void
*@throw Illegal argument exception if the user inputs a negative value

*/


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

/** The method displays the attributes of the Pirate
*
*@param None
*@return void

*/
@Override
    public void DisplayProfile()
    {
    // call the Character class display profile method
       super.DisplayProfile();
       System.out.println("Bounty: " + getBounty());
       System.out.println("Pirate Role: " + getPirateRole());

    // if the Pirate belongs to a Pirate Crew, display the Crew Name, else, set it as None


       if (getPirateCrew() != null)
       {
        System.out.println( "Pirate Crew: " + getPirateCrew().getCrewName());
       }
       else
       {
        System.out.println("Pirate Crew: None");

       }
      
    
    }

    @Override
     public String FileFormat()
     {
        return String.format(
            "ROLE: PIRATE | ID: %d | NAME: %s | ALIAS: %s | ORIGIN: %s | STATUS: %s | WALLET: %d | BOUNTY: %d | PIRATE ROLE: %s | CREW: %s | DEVIL FRUIT: %s",
            getCharacterID(),
            getName(),
            getAlias(),
            getOrigin(),
            getStatus(),
            getWallet(),
            getBounty(),
            this.getPirateRole(),
            getPirateCrew() == null ? "NONE" : getPirateCrew().getCrewName(),
            (getDFPower() == null ? "NONE" : getDFPower().getFruitName())
        );
     }

}
