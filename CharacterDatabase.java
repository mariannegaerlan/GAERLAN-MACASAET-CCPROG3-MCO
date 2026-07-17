import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is the CharacterDatabase class to store the information about Character objects
 * Contributed by: Marianne Gaerlan and Marco Macasaet

*/

public class CharacterDatabase {
    
    private final Map<Integer,Character> characterMap;
    private final Map<Integer,Marine> marineMap;
    private final Map<Integer,Pirate> pirateMap;
    private final Map<Integer,PirateHunter> pirhunMap;
    private final Map<Integer,Civilian> civilianMap;

    private final List<Character> deadCharacters = new ArrayList<>();

    public CharacterDatabase()
    {
        this.characterMap = new HashMap<>();
        this.marineMap = new HashMap<>();
        this.pirateMap = new HashMap<>();
        this.pirhunMap = new HashMap<>();
        this.civilianMap = new HashMap<>();
    }

    public List<Character> getdeadCharacters()
    {
        return this.deadCharacters;
    }

    /** getCharacterMap gets the Character Hash Map
    * 
    *@param none
    *@return characterMap

    */   
    public Map<Integer, Character> getCharacterMap()
    {
        return characterMap;
    }

    /**  getPirateMap gets the Pirate Map
    * 
    *@param none
    *@return pirateMap

    */  

    public Map<Integer, Pirate> getPirateMap()
    {
        return pirateMap;
    }

    /**  getMarineMap gets the Marine Map
    * 
    *@param none
    *@return marineMap

    */  

    public Map<Integer, Marine> getMarineMap()
    {
        return marineMap;
    }

    /** addCharacter adds a character to the map
    * 
    *@param Character
    *@return void

    */  

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

    /** getMarineMap adds a Marine to the map
    * 
    *@param Marine
    *@return void

    */  

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

    /** addPirate adds a Pirate to the map
    * 
    *@param Pirate
    *@return void

    */  

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

    /** addPirateHunter adds a pirate hunter to the map
    * 
    *@param crewName
    *@return void

    */  

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

    /** add Civilian adds a civilian to the map
    * 
    *@param Civilian
    *@return void

    */  

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

    /** getCharacter gets the character
    * 
    *@param int characterID
    *@return Character

    */  

    public Character getCharacter (int characterID)
    {
        Character character = characterMap.get(characterID);

        return character;
    }

    /** getMarine gets the marine
    * 
    *@param int characterID
    *@return Marine

    */  

    public Marine getMarine (int characterID)
    {
        Marine character = marineMap.get(characterID);

        return character;
    }

    /** getPirate gets the pirate
    * 
    *@param int characterID
    *@return Pirate

    */  

    public Pirate getPirate (int characterID)
    {
        Pirate character = pirateMap.get(characterID);

        return character;
    }

    /** removeCharacter removes a character
    * 
    *@param int characterID
    *@return void

    */  

    public void removeCharacter (Character removedCharacter )
    {
        
        deadCharacters.add(removedCharacter);
        characterMap.remove(removedCharacter.getCharacterID());
    }

    /** displayCharacters displays the list of characters
    * 
    *@param none
    *@return void

    */  

    public void displayCharacters()
    {

        System.out.println("\n====== ONE PIECE CHARACTERS ======");
        for (Character c: characterMap.values())
        {
           System.out.println("ID: " + c.getCharacterID() + "| Name: " +  c.getName());
            System.out.println("----------------------------");
        }
        
    }

    /** displayMarines displays the list of marines
    * 
    *@param none
    *@return void

    */  

    public void displayMarines(){

        System.out.println("\n====== ONE PIECE MARINES ======");
        for (Marine m : marineMap.values())
        {
           System.out.println("ID: " + m.getCharacterID() + "| Name: " +  m.getName());
            System.out.println("----------------------------");
        }
    }

    /** displayPirates displays the list of pirates
    * 
    *@param none
    *@return void

    */  

    public void displayPirates(){

        System.out.println("\n====== ONE PIECE PIRATES ======");
        for (Pirate p: pirateMap.values())
        {
           System.out.println("ID: " + p.getCharacterID() + "| Name: " +  p.getName());
            System.out.println("----------------------------");
        }
    }

/** displayDeadCharacter displays the list of dead characters
    * 
    *@param none
    *@return void

*/  

    public void displayDeadCharacter()
    {
        System.out.println("\n====== DEAD CHARACTERS ======");

        if (deadCharacters.isEmpty())
        {
            System.out.println("No Characters Have Died or Have Been Deleted Yet.");
            return;
        }

        for (Character c: deadCharacters)
            {
                System.out.println("ID: "+ c.getCharacterID() + "| Name: "+ c.getName());
            }
    }
    
}
