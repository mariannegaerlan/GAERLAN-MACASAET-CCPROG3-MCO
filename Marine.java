
public class Marine extends Character{

    private String Rank;
    private MarineCorps marineCorps;
    

    public Marine(String Name, String Alias, String Origin, String Status, int Wallet, String Rank)
    {
        super(Name, Alias, Origin, Status, Wallet, "Marine");
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
       if (getMarineCorps()!=null)
        {
        System.out.println("Marine Corps: " +getMarineCorps().getcorpsName());
       System.out.println("Rank: " + getRank());

        }
        else
        {
            System.out.println("Marine Corps: None");
        }
    }

}
