
public class Marine {

    private String Rank;
    private String MarineCorps;
    

// setters
    public void setRank( String Rank)
    {
        this.Rank = Rank;
    }

    public void setMarineCorps(String MarineCorps)
    {
        this.MarineCorps = MarineCorps;
    }

// getters

    public String getRank()
    {
        return this.Rank;
    }

    public String getMarineCorps()
    {
        return this.MarineCorps;
    }


    public void PromoteRank(String NewRank)
    {
        this.Rank = NewRank;
    }

    public void AssignToCorps(String NewCorps)
    {
        this.MarineCorps = NewCorps;
    }
    
}
