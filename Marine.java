
public class Marine extends Character{

    private String Rank;
    private MarineCorps marineCorps;
    

    public Marine(String Name, String Alias, String Origin, String Status, int Wallet, String Rank)
    {
        super(Name, Alias, Origin, Status, Wallet);
        this.Rank = Rank;

    }

// setters
    public void setRank( String Rank)
    {
        this.Rank = Rank;
    }

    public void setmarineCorps(MarineCorps marineCorps)
    {
        this.marineCorps = marineCorps;
    }

// getters

    public String getRank()
    {
        return this.Rank;
    }

    public MarineCorps getMarineCorps()
    {
        return this.marineCorps;
    }


    public void PromoteRank(String NewRank)
    {
        this.Rank = NewRank;
    }

    public void AssignToCorps(MarineCorps newCorps)
    {
        this.marineCorps = newCorps;
    }

//methods

@Override
    public void DisplayProfile()
    {
       super.DisplayProfile();
       System.out.println("Rank: " + getRank());
       System.out.println("MarineCorps: " +getMarineCorps().getcorpsName());
    }

}
