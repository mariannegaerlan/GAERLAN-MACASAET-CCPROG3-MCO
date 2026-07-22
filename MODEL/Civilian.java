
/**
 * The Civilian class is a child of the Character Class and facilitates the creation of the Civilian
 * Contributed by: Marianne Gaerlan
*/

public class Civilian extends Character implements Captor{

    private String Profession; // This is the profession of the Civilian
    private String Residence; // This is the Residence of the Civilian

    // This is the Civilian Constructor

    public Civilian(String Name, String Alias, String Origin, String Status, int Wallet, String Profession, String Residence)
    {
        super(Name, Alias, Origin, Status, Wallet, "Civillian");
        this.Profession = Profession;
        this.Residence = Residence;

    }
    

/** setProfession lets the user mutate the Profession
*
*@param Profession
*@return void

*/   
public void setProfession( String Profession)
    {
        this.Profession = Profession;
    }

/** setResidence lets the user mutate the Residence
*
*@param Residence
*@return void

*/   

    public void setResidence(String Residence)
    {
        this.Residence = Residence;
    }

/** getProfession lets the user access the Profession
*
*@param none
*@return this.Profession

*/   
    public String getProfession()
    {
        return this.Profession;
    }


/** getProfession lets the user access the Residence
*
*@param none
*@return this.Residence

*/   

    public String getResidence()
    {
        return this.Residence;
    }


/** The method displays the attributes of the Civilian
*
*@param None
*@return void

*/
@Override
    public void DisplayProfile()
    {
    // call the Character class display profile method
       super.DisplayProfile();
       System.out.println("Profession: " + getProfession());
       System.out.println("Residence: " +getResidence());
    }


/** The method lets the Civilian capture the Pirate
*
*@param bounty
*@return void

*/
@Override
 public void claimBounty(int bounty)
 {
          this.setWallet(this.getWallet()+ bounty);
 }


    @Override
     public String FileFormat()
     {

        return "ROLE: CIVILIAN | ID: " +getCharacterID() + " | NAME: " + getName() + "| ALIAS: " + getAlias() + "| ORIGIN: " + getOrigin()
        + "| STATUS: " + getStatus() + "| WALLET: " + getWallet()  + "| PROFESSION: " + getProfession() + "| RESIDENCE: " + getResidence() +"| DEVIL FRUIT: " + (getDFPower() == null ? "NONE" : getDFPower().getFruitName());
     }
}
