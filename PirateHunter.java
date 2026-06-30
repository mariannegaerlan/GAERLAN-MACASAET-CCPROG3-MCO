
public class PirateHunter extends Character{

    private String CombatStyle;
    private int ConfirmedCaptures;
    
    public PirateHunter(String Name, String Alias, String Origin, String Status, int Wallet, String CombatStyle, int ConfirmedCaptures)
    {
        super(Name, Alias, Origin, Status, Wallet);
        this.CombatStyle = CombatStyle;
        this.ConfirmedCaptures = ConfirmedCaptures;

    }


// setters
    public void setCombatStyle( String CombatStyle)
    {
        this.CombatStyle = CombatStyle;
    }

    public void setConfirmedCaptures(int ConfirmedCaptures)
    {
        this.ConfirmedCaptures = ConfirmedCaptures;
    }

// getters

    public String getCombatStyle()
    {
        return this.CombatStyle;
    }

    public int getConfirmedCaptures()
    {
        return this.ConfirmedCaptures;
    }

//methods

@Override
    public void DisplayProfile()
    {
       super.DisplayProfile();
       System.out.println("Combat Style: " + getCombatStyle());
       System.out.println("Confirmed Captures: " + getConfirmedCaptures());
    
    }
}
