
/*

Description:

The Marine class is a child of the Character Class and facilitates the creation of the marine

Contributed by: Marianne Gaerlan

*/



public class Marine extends Character{

    private String Rank; // This is the Rank of the Marine
    private MarineCorps marineCorps; // This is the corp where the Marine belongs to
    

    // This is the constructor of the Marine

    public Marine(String Name, String Alias, String Origin, String Status, int Wallet, String Rank)
    {
        super(Name, Alias, Origin, Status, Wallet, "Marine");
        this.Rank = Rank;

    }

// Below are the setters
    public void setRank( String Rank)
    {
        this.Rank = Rank;
    }

    public void setmarineCorps(MarineCorps marineCorps)
    {
        this.marineCorps = marineCorps;
    }

// Below are the getters

    public String getRank()
    {
        return this.Rank;
    }

    public MarineCorps getMarineCorps()
    {
        return this.marineCorps;
    }



// The method displays the attributes of the Marine

@Override
    public void DisplayProfile()
    {
       super.DisplayProfile();
       if (getMarineCorps()!=null)
        {
        System.out.println("Marine Corps: " +getMarineCorps().getcorpsName());
        }
        else
        {
            System.out.println("Marine Corps: None");
            System.out.println("Rank: " + getRank());

        }
    }

}
