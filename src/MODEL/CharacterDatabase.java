package MODEL;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
        loadCharacterFile();
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
            System.out.println("Character already exists!");
            return;

        }

        characterMap.put(character.getCharacterID(), character);
        saveCharacterToFile(character);

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
        removedCharacter.setStatus("Dead");
        if (removedCharacter.getDFPower()!= null)
        {
        removedCharacter.getDFPower().triggerReincarnation();
        }
        if (!deadCharacters.contains(removedCharacter))
        {
        deadCharacters.add(removedCharacter);

        }
        // characterMap.remove(removedCharacter.getCharacterID());
        rewriteCharacterFile();
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
    

/** saveCharacterToFile utilizes file writer to save the logged characters into a text file
    * 
    *@param character
    *@return void

*/  


    public static void saveCharacterToFile(Character character)
    {
        if (character == null)
        {
            return;
        }

        try (FileWriter writer = new FileWriter ("CharacterList.txt", true))
        {
            PrintWriter pWriter = new PrintWriter(writer);

            pWriter.println(character.FileFormat());
            // System.out.println("Character " + character.getName() + " successfully saved!");
            
        }
        catch (IOException e)
        {
            System.out.println("Erorr: " + e.getMessage());

        }
    }

/** rewriteCharacterFile utilizes file writer to overwrite the current text file
    * 
    *@param none
    *@return void

*/  


    public void rewriteCharacterFile()
    {
        try (FileWriter writer = new FileWriter ("CharacterList.txt", false))
        {
            PrintWriter pWriter = new PrintWriter(writer);
        
            for (Character c: characterMap.values())
            {
                pWriter.println(c.FileFormat());
            }
        }
        catch (IOException e)
        {
            System.out.println("Erorr: " + e.getMessage());

        }
        
    }

/** loadCharacterFile utilizes file to load the character text file
    * 
    *@param none
    *@return void

*/  

        public void loadCharacterFile()
    {
        File file = new File("CharacterList.txt");

        if (!file.exists())
        {
            System.out.println("Character file doesn't contain anything");
            return;
        }

        try (Scanner scanner = new Scanner(file))
        {
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] segments = line.split("\\s*\\|\\s*");

                    String role = segments[0].split(":")[1].trim();
                    String name = segments[2].split(":")[1].trim();
                    String alias = segments[3].split(":")[1].trim();
                    String origin = segments[4].split(":")[1].trim();
                    String status = segments[5].split(":")[1].trim();
                    int wallet = Integer.parseInt(segments[6].split(":")[1].trim());


                    if (role.equalsIgnoreCase("PIRATE"))
                    {
                        int bounty = Integer.parseInt(segments[7].split(":")[1].trim());
                        String pirateRole = segments[8].split(":")[1].trim();

                       Pirate c = new Pirate(name, alias, origin, status, wallet, bounty, pirateRole);
                       characterMap.put(c.getCharacterID(),c);
                       pirateMap.put(c.getCharacterID(),c);

                    }
                    else if (role.equalsIgnoreCase("MARINE"))
                    {
                        String rank = segments[7].split(":")[1].trim();
                        
                       Marine c = new Marine(name, alias, origin, status, wallet, rank); 
                        characterMap.put(c.getCharacterID(),c);
                        marineMap.put(c.getCharacterID(),c);
            
                    }
                    else if (role.equalsIgnoreCase("PIRATE HUNTER"))
                    {
                      String combatstyle = segments[7].split(":")[1].trim();
                        
                       PirateHunter c = new PirateHunter(name, alias, origin, status, wallet, combatstyle);    
                            characterMap.put(c.getCharacterID(),c);
                            pirhunMap.put(c.getCharacterID(),c);

                    }
                    else if (role.equalsIgnoreCase("CIVILIAN"))
                    {
                      String residence = segments[7].split(":")[1].trim();
                      String profession = segments[8].split(":")[1].trim();

                       Civilian c = new Civilian(name, alias, origin, status, wallet, profession, residence);  
                        characterMap.put(c.getCharacterID(),c);
                        civilianMap.put(c.getCharacterID(),c);
               
                    }

            }
        }

        catch (Exception e)
        {
            System.out.println("Error loading character file: " + e.getMessage());
        }
    }
}
