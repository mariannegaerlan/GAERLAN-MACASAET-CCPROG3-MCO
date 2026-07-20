/**
 * This class is the Character class which is the blueprint for the Character objects
 * Contributed by: Marianne Gaerlan and Marco Macasaet
 */

public abstract class Character {



    private final int CharacterID;


    private static int idCount;
    private String Name;
    private String Alias;
    private String Origin;
    private String Status;
    private String Type;
    private DevilFruit DFPower;
    private int Wallet;


// constructor

    protected Character(String Name, String Alias, String Origin, String Status, int Wallet, String Type)
    {
        this.CharacterID = ++idCount;
        this.Name= Name;
        this.Alias= Alias;
        this.Origin = Origin;
        this.Status = "Alive";
        this.DFPower = null;
        this.Wallet = Wallet;
        this.Type = Type;
    }


// setters

    public void setName(String Name)
    {
        this.Name = Name;
    }

    public void setAlias(String Alias)
    {
        this.Alias = Alias;
    }

    public void setOrigin(String Origin)
    {
        this.Origin = Origin;
    }

    public void setStatus(String Status)
    {
        this.Status = Status;
    }

    public void setDFPower(DevilFruit DFPower)
    {
        this.DFPower = DFPower;      
    }

    public void setWallet(int Wallet)
    {
        if (Wallet >= 0)
        {
        this.Wallet = Wallet;
        }
        else
        {
            throw new IllegalArgumentException("Wallet Balance Can't Be Negative!");
        }
    }


// getters

    public int getCharacterID()
    {
        return this.CharacterID;
    }

    public String getName()
    {
        return this.Name;
    }

    public String getAlias()
    {
        return this.Alias;
    }

    public String getOrigin()
    {
        return this.Origin;
    }

    public String getStatus()
    {
        return this.Status;
    }

    public DevilFruit getDFPower()
    {
        return this.DFPower;   
    }

    public int getWallet()
    {
        return this.Wallet;
    }

    public String getType()
    {
        return this.Type;
    }


    public void DisplayProfile()
    {
     
        System.out.println("Name: " +getName());
        System.out.println("ID: " + getCharacterID());
        System.out.println("Alias: "+ getAlias());
        System.out.println("Origin: "+ getOrigin());
        System.out.println("Status: " + getStatus());
        System.out.print("DF Power: ");

        if(getDFPower() == null)
        {
            System.out.println("None");
        } else if (getDFPower() != null){
            System.out.println(getDFPower().getFruitName());
        }
        System.out.println("Wallet: " + getWallet());
        System.out.println("Class: "+getType());
    }



}
