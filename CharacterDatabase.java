import java.util.HashMap;
import java.util.Map;

public class CharacterDatabase {
    
    private final Map<Integer,Character> characterMap;

    public CharacterDatabase()
    {
        this.characterMap = new HashMap<>();
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

    public Character getCharacter (int characterID)
    {
        Character character = characterMap.get(characterID);

        return character;
    }

    public void removeCharacter (int characterID)
    {
        Character removedCharacter = characterMap.remove(characterID);
        System.out.println( removedCharacter.getName() + " has been removed.");
    }

    public void displayCharacters()
    {
        if (characterMap.isEmpty())
        {
            System.out.println("The database is empty.");
            return;
        }
        System.out.println("\n====== ONE PIECE CHARACTERS ======");
        for (Character c: characterMap.values())
        {
           System.out.println("ID: " + c.getCharacterID() + "| Name: " +  c.getName());
            System.out.println("----------------------------");
        }
    }
}
