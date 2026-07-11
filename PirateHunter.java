
/*

Description:

The Pirate Hunter class is a child of the Character Class and facilitates the creation of the Pirate Hunter

Contributed by: Marianne Gaerlan

*/



public class PirateHunter extends Character{

    private String CombatStyle; // This is the combat style of the hunter
    private int ConfirmedCaptures; // this is the number of captures by the hunter
    

    // This is the pirate hunter constructor
    public PirateHunter(String Name, String Alias, String Origin, String Status, int Wallet, String CombatStyle, int ConfirmedCaptures)
    {
        super(Name, Alias, Origin, Status, Wallet, "Pirate Hunter");
        this.CombatStyle = CombatStyle;
        this.ConfirmedCaptures = ConfirmedCaptures;

    }


// Below are the Setters
    public void setCombatStyle( String CombatStyle)
    {
        this.CombatStyle = CombatStyle;
    }

    public void setConfirmedCaptures(int ConfirmedCaptures)
    {
        this.ConfirmedCaptures = ConfirmedCaptures;
    }

// Below are the Getters

    public String getCombatStyle()
    {
        return this.CombatStyle;
    }

    public int getConfirmedCaptures()
    {
        return this.ConfirmedCaptures;
    }

// This displays the attributes of the Pirate Hunter

@Override
    public void DisplayProfile()
    {
       super.DisplayProfile();
       System.out.println("Combat Style: " + getCombatStyle());
       System.out.println("Confirmed Captures: " + getConfirmedCaptures());
    
    }
}
