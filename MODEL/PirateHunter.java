
/**
 * The Pirate Hunter class is a child of the Character Class and facilitates the creation of the Pirate Hunter
 * Contributed by: Marianne Gaerlan
 *
*/



public class PirateHunter extends Character implements Captor{

    private String CombatStyle; // This is the combat style of the hunter
    private int ConfirmedCaptures; // this is the number of captures by the hunter
    

    // This is the pirate hunter constructor
    public PirateHunter(String Name, String Alias, String Origin, String Status, int Wallet, String CombatStyle)
    {
        super(Name, Alias, Origin, Status, Wallet, "Pirate Hunter");
        this.CombatStyle = CombatStyle;

    }


/** setCombatStyle lets the user mutate CombatStyle
*
*@param CombatStyle
*@return void

*/   

    public void setCombatStyle( String CombatStyle)
    {
        this.CombatStyle = CombatStyle;
    }
/** incrementConfirmedCaptures increments the number of captures
*
*@param ConfirmedCaptures
*@return void

*/   
    public void incrementConfirmedCaptures()
    {
        this.ConfirmedCaptures++;
    }

/** getCombatStyle lets the user access the Combat Style
*
*@param none
*@return this.CombatStyle

*/   

    public String getCombatStyle()
    {
        return this.CombatStyle;
    }

/** getConfirmedCaptures lets the user access the Confirmed Captures
*
*@param none
*@return this.ConfirmedCaptures

*/   

    public int getConfirmedCaptures()
    {
        return this.ConfirmedCaptures;
    }

/** The method displays the attributes of the Pirate Hunter
*
*@param None
*@return void

*/
@Override
    public void DisplayProfile()
    {
    // call the Character class display profile method
       super.DisplayProfile();
       System.out.println("Combat Style: " + getCombatStyle());
       if (this.getConfirmedCaptures()!= 0)
    {
       System.out.println("Confirmed Captures: " + getConfirmedCaptures());

    }
    else
    {
       System.out.println("Confirmed Captures: None");

    }
    
    }

/** The method lets the Pirate Hunter capture the Pirate
*
*@param bounty
*@return void

*/
@Override
 public void claimBounty(int bounty)
 {
    this.incrementConfirmedCaptures();
    this.setWallet(this.getWallet()+ bounty);
 }
 

    @Override
     public String FileFormat()
     {

        return "ROLE: PIRATE | NAME: " + getName() + "| ALIAS: " + getAlias() + "| ORIGIN: " + getOrigin()
        + "| STATUS: " + getStatus() + "| WALLET: " + getWallet() + "| COMBAT STLYE: " + getCombatStyle() + "| CONFIRMED CAPTURES: " + getConfirmedCaptures();

     }
}
