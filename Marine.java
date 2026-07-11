
/**
 * The Marine class is a child of the Character Class and facilitates the creation of the marine
 * Contributed by: Marianne Gaerlan
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


/* setRank enables the Rank attribute to be mutated

@param Rank is the new mutated Rank
@return void

*/
    public void setRank( String Rank)
    {
        this.Rank = Rank;
    }



/* setmarineCorps enables the Marine Corp attribute to be mutated

@param Rank is the new mutated Rank
@return void

*/

    public void setmarineCorps(MarineCorps marineCorps)
    {
        this.marineCorps = marineCorps;
    }


/* getRank lets the user have read access to the Rank attribute

@param None
@return this.rank

*/


    public String getRank()
    {
        return this.Rank;
    }

/* getMarineCorps lets the user have read access to the Marine Corps attribute

@param None
@return MarineCorps

*/



    public MarineCorps getMarineCorps()
    {
        return this.marineCorps;
    }



/* The method displays the attributes of the Marine

@param None
@return void

*/


@Override
    public void DisplayProfile()
    {
    // call the Character class display profile method
       super.DisplayProfile();
       // if the Marine belongs to a Marine Corps, display the Corps Name, else, set it as None
       if (getMarineCorps()!=null)
        {
        System.out.println("Marine Corps: " +getMarineCorps().getcorpsName());
        }
        else
        {
            System.out.println("Marine Corps: None");
        }
        System.out.println("Rank: " + getRank());

    }

}
