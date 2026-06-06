
public class Pirate extends CharacterType{

    private int Bounty;
    private String PirateRole;
    private Boolean isCaptain;
    private String PirateCrew;


    // setters

    public void setBounty(int Bounty)
    {
        this.Bounty= Bounty;
    }

    public void setPirateRole(String PirateRole)
    {
        this.PirateRole= PirateRole;
    }

    public void setisCaptain(boolean isCaptain)
    {
        this.isCaptain= isCaptain;
    }

    public void setPirateCrew(String PirateCrew)
    {
        this.PirateCrew= PirateCrew;
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

    public Boolean getisCaptain()
    {
        return this.isCaptain;
    }

    public String getPirateCrew()
    {
        return this.PirateCrew;
    }



    public void ModifyBounty(int amount)
    {
        this.Bounty += amount;
    }

    public void AssignToCrew(String newCrew)
    {
        this.PirateCrew = newCrew;
    }
    
}
