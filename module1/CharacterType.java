public class CharacterType {
    
    private int CharacterID;
    private String Name;
    private String Alias;
    private String Origin;
    private String Status;
    private String DFPower;
    private int Wallet;


// setters
    public void setCharacterID( int CharacterID)
    {
        this.CharacterID = CharacterID;
    }

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

    public void setDFPower(String DFPower)
    {
        this.DFPower = DFPower;      
    }

    public void setWallet(int Wallet)
    {
        this.Wallet = Wallet;
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

    public String getDFPower()
    {
        return this.DFPower;   
    }

    public int getWallet()
    {
        return this.Wallet;
    }


    public void DisplayProfile()
    {
        System.out.println("Name: " + getName() + " ID| "+ getCharacterID() + "Alias: |" + getAlias() + "Origin: " + getOrigin() + "| Status: " + getStatus() + "| DF Power: " + getDFPower() + "| Wallet: " + getWallet());
    }



}
