import java.util.HashMap;
import java.util.Map;

public class CharacterDatabase {
    
    private final Map<Integer,Character> characterMap;
    private final Map<Integer,Marine> marineMap;
    private final Map<Integer,Pirate> pirateMap;
    private final Map<Integer,PirateHunter> pirhunMap;
    private final Map<Integer,Civilian> civilianMap;

    public CharacterDatabase()
    {
        this.characterMap = new HashMap<>();
        this.marineMap = new HashMap<>();
        this.pirateMap = new HashMap<>();
        this.pirhunMap = new HashMap<>();
        this.civilianMap = new HashMap<>();
    }

    //add character methods
    public Map<Integer, Character> getCharacterMap()
    {
        return characterMap;
    }
    public Map<Integer, Pirate> getPirateMap()
    {
        return pirateMap;
    }
    public Map<Integer, Marine> getMarineMap()
    {
        return marineMap;
    }

    public void addCharacter(Character character)
    {
        if (character == null)
        {
            throw new IllegalArgumentException("Character doesn't Exist!");
        }
        if (characterMap.containsKey(character.getCharacterID()))
        {
            throw new IllegalArgumentException("Character ID already exists");
        }

        characterMap.put(character.getCharacterID(), character);

    }

    public void addMarine(Marine character)
    {
        if (character == null)
        {
            throw new IllegalArgumentException("Character doesn't Exist!");
        }
        if (pirateMap.containsKey(character.getCharacterID()))
        {
            throw new IllegalArgumentException("Character ID already exists");
        }

        marineMap.put(character.getCharacterID(), character);

    }

    public void addPirate(Pirate character)
    {
        if (character == null)
        {
            throw new IllegalArgumentException("Character doesn't Exist!");
        }
        if (pirateMap.containsKey(character.getCharacterID()))
        {
            throw new IllegalArgumentException("Character ID already exists");
        }

        pirateMap.put(character.getCharacterID(), character);

    }

    public void addPirateHunter(PirateHunter character)
    {
        if (character == null)
        {
            throw new IllegalArgumentException("Character doesn't Exist!");
        }
        if (pirhunMap.containsKey(character.getCharacterID()))
        {
            throw new IllegalArgumentException("Character ID already exists");
        }

        pirhunMap.put(character.getCharacterID(), character);

    }

    public void addCivlian(Civilian character)
    {
        if (character == null)
        {
            throw new IllegalArgumentException("Character doesn't Exist!");
        }
        if (civilianMap.containsKey(character.getCharacterID()))
        {
            throw new IllegalArgumentException("Character ID already exists");
        }

        civilianMap.put(character.getCharacterID(), character);

    }

    //get character methods

    public Character getCharacter (int characterID)
    {
        Character character = characterMap.get(characterID);

        return character;
    }

    public Marine getMarine (int characterID)
    {
        Marine character = marineMap.get(characterID);

        return character;
    }

    public Pirate getPirate (int characterID)
    {
        Pirate character = pirateMap.get(characterID);

        return character;
    }

    public PirateHunter getPirateHunter (int characterID)
    {
        PirateHunter character = pirhunMap.get(characterID);

        return character;
    }

    public Civilian getCivilian (int characterID)
    {
        Civilian character = civilianMap.get(characterID);

        return character;
    }

    //remove character methods

    public void removeCharacter (int characterID)
    {
        characterMap.remove(characterID);
        // System.out.println(removedCharacter.getName() + " has been removed.");
    }

    /*public void removeMarine (int characterID)
    {
        marineMap.remove(characterID);
        // System.out.println(removedCharacter.getName() + " has been removed.");
    }

    public void removePirate (int characterID)
    {
        pirateMap.remove(characterID);
        // System.out.println(removedCharacter.getName() + " has been removed.");
    }

    public void removePirateHunter (int characterID)
    {
        pirhunMap.remove(characterID);
        // System.out.println(removedCharacter.getName() + " has been removed.");
    }

    public void removeCivilian (int characterID)
    {
        civilianMap.remove(characterID);
        // System.out.println(removedCharacter.getName() + " has been removed.");
    }*/

    //display character methods

    public void displayCharacters()
    {

        System.out.println("\n====== ONE PIECE CHARACTERS ======");
        for (Character c: characterMap.values())
        {
           System.out.println("ID: " + c.getCharacterID() + "| Name: " +  c.getName());
            System.out.println("----------------------------");
        }
        
    }

    public void displayMarines(){

        System.out.println("\n====== ONE PIECE MARINES ======");
        for (Marine m : marineMap.values())
        {
           System.out.println("ID: " + m.getCharacterID() + "| Name: " +  m.getName());
            System.out.println("----------------------------");
        }
    }

    public void displayPirates(){

        System.out.println("\n====== ONE PIECE PIRATES ======");
        for (Pirate p: pirateMap.values())
        {
           System.out.println("ID: " + p.getCharacterID() + "| Name: " +  p.getName());
            System.out.println("----------------------------");
        }
    }

    public void displayHunters(){
        
 
        System.out.println("\n====== ONE PIECE PIRATE HUNTERS ======");
        for (PirateHunter ph: pirhunMap.values())
        {
           System.out.println("ID: " + ph.getCharacterID() + "| Name: " +  ph.getName());
            System.out.println("----------------------------");
        }
    }

    public void displayCitizens(){
        
 
        System.out.println("\n====== ONE PIECE CIVILIANS ======");
        for (Civilian c: civilianMap.values())
        {
           System.out.println("ID: " + c.getCharacterID() + "| Name: " +  c.getName());
            System.out.println("----------------------------");
        }
    }
}
