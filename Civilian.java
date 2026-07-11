
/*

Description:

The Civilian class is a child of the Character Class and facilitates the creation of the Civilian
Contributed by: Marianne Gaerlan

*/

public class Civilian extends Character{

    private String Profession; // This is the profession of the Civilian
    private String Residence; // This is the Residence of the Civilian

    // This is the Civilian Constructor

    public Civilian(String Name, String Alias, String Origin, String Status, int Wallet, String Profession, String Residence)
    {
        super(Name, Alias, Origin, Status, Wallet, "Civillian");
        this.Profession = Profession;
        this.Residence = Residence;

    }
    

// Below are the setters
    public void setProfession( String Profession)
    {
        this.Profession = Profession;
    }

    public void setResidence(String Residence)
    {
        this.Residence = Residence;
    }

// Below are the getters

    public String getProfession()
    {
        return this.Profession;
    }

    public String getResidence()
    {
        return this.Residence;
    }

// This method displays the attributes of the Civilian

@Override
    public void DisplayProfile()
    {
       super.DisplayProfile();
       System.out.println("Profession: " + getProfession());
       System.out.println("Residence: " +getResidence());
    }
}
