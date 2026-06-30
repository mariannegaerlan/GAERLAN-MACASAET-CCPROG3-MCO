
public class Civilian extends Character{

    private String Profession;
    private String Residence;

    public Civilian(String Name, String Alias, String Origin, String Status, int Wallet, String Profession, String Residence)
    {
        super(Name, Alias, Origin, Status, Wallet);
        this.Profession = Profession;
        this.Residence = Residence;

    }
    

// setters
    public void setProfession( String Profession)
    {
        this.Profession = Profession;
    }

    public void setResidence(String Residence)
    {
        this.Residence = Residence;
    }

// getters

    public String getProfession()
    {
        return this.Profession;
    }

    public String getResidence()
    {
        return this.Residence;
    }

// methods

@Override
    public void DisplayProfile()
    {
       super.DisplayProfile();
       System.out.println("Profession: " + getProfession());
       System.out.println("Residence: " +getResidence());
    }
}
