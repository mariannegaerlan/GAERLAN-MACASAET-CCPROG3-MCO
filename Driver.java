import java.util.Scanner;

public class Driver {
    
    private static Scanner scanner = new Scanner(System.in); 
    private static int choice =0;
    private static boolean running = true;
    private static CharacterDatabase characterDB;
    private static AffiliationDatabase affiliationDB;
    private static DevilFruitDatabase devilFruitDB;

    private static String CharacterName;
    private static String Alias;
    private static String Origin;
    private static String Status;
    private static int Wallet;
    private static int Bounty;
    private static String PirateRole;
    private static boolean isCaptain;

    private static String CombatStyle;
    private static int ConfirmedCaptures;

    private static String Rank;

    private static String Profession;
    private static String Residence;

    public static void main(String[] args) {



        CharacterDatabase characterDB = new CharacterDatabase();
        AffiliationDatabase affiliationDB = new AffiliationDatabase();
        DevilFruitDatabase devilFruitDB = new DevilFruitDatabase();

        while (running)
        {
        displayMenu();
        }




    }

    public static void displayMenu()
    {
        
        System.out.println("======================================================");
        System.out.println("======== One Piece Universe Management System ========");
        System.out.println("======================================================");

        System.out.println("[1] Character Database");
        System.out.println("[2] Affiliation Database");
        System.out.println("[3] Devil Fruit Database");
        System.out.println("[4] Exit");
        System.out.print("Choice: ");

        if (scanner.hasNextInt())
        {
            choice = scanner.nextInt();

            switch(choice)
            {
                case 1:
                    displayCharacterMenu();
                    break;
                case 2:
                    displayAffiliationMenu();
                    break;
                case 3:
                    displayFruitMenu();
                    break;
                case 4:
                    System.out.println("Goodbye GGEZ...");
                    running = false;
                    break;


            }
        }
    }

    public static void displayCharacterMenu()
    {
        int choice = 0;

        System.out.println("======================================");
        System.out.println("======== Character Database ==========");
        System.out.println("======================================");

        System.out.println("[1] Create Character");
        System.out.println("[2] View Character");
        System.out.println("[3] Update Character");
        System.out.println("[4] Delete Character");
        System.out.println("[5] Back to Main Menu");
        System.out.print("Choice: ");

        if (scanner.hasNextInt())
        {
            choice = scanner.nextInt();

            switch(choice)
            {
                case 1:
                    createCharacter();
                    break;
                case 2:
                    viewCharacter();
                    break;
                case 3:
                    updateCharacter();
                    break;
                case 4:
                    deleteCharacter();
                    break;
                case 5:
                    displayMenu();
                    break;
                default:
                    System.out.println("Invalid Choice. Please try again.");
                    return;
                

            }
        }




    }

    public static void displayAffiliationMenu()
    {
        System.out.println("========================================");
        System.out.println("======== Affiliation Database ==========");
        System.out.println("========================================");

        System.out.println("[1] Create Group");
        System.out.println("[2] View Groups");
        System.out.println("[3] Edit Group Attributes");
        System.out.println("[4] Add Members");
        System.out.println("[5] Remove Members");
        System.out.print("[6] Back to Main Menu: ");
        System.out.print("Choice: ");

        int choice = scanner.nextInt();
        switch (choice)
        {
            case 1:
                createGroup();
                break;
            case 2:
                viewGroups();
                break;
            case 3:
                editGroups();
                break;
            case 4:
                addMembers();
                break;
            case 5:
                removeMembers();
                break;
            case 6:
                displayMenu();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }

    }

    public static void displayFruitMenu()
    {
        System.out.println("========================================");
        System.out.println("======== Devil Fruit Database ==========");
        System.out.println("========================================");

        System.out.println("[1] Create Devil Fruit");
        System.out.println("[2] View Devil Fruit");
        System.out.println("[3] Assign Devil Fruit");
        System.out.print("[4] Back to Main Menu: ");
        System.out.print("Choice: ");

        int choice = scanner.nextInt();

        switch (choice)
        {
            case 1:
                createDevilFruit();
                break;
            case 2:
                viewDevilFruit();
                break;
            case 3:
                assignDevilFruit();
                break;
            case 4:
                displayMenu();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
            
        }

    }


    private static void createCharacter()
    {
        System.out.println(" --- Create a Character ---");
        System.out.println("[1] Pirate");
        System.out.println("[2] Pirate Hunter");
        System.out.println("[3] Marine");
        System.out.println("[4] Civillian");
        System.out.println("[5] Back to Character Menu");
        System.out.println("Choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Enter Character Name: ");
        CharacterName = scanner.nextLine();
        System.out.println("Enter Character Alias: ");
        Alias = scanner.nextLine();
        System.out.println("Enter Character Origin: ");
        Origin = scanner.nextLine();
        System.out.println("Enter Character Status: ");
        Status = scanner.nextLine();
        System.out.println("Enter Character Wallet: ");
        Wallet = scanner.nextInt();
        scanner.nextLine(); 

        Character newCharacter = null;

        switch (choice)
        {
            case 1:
                System.out.println(" Enter Character Bounty: ");
                Bounty = scanner.nextInt();
                scanner.nextLine();
                
                System.out.println(" Enter Character Pirate Role: ");
                PirateRole = scanner.nextLine();
                System.out.println(" Is the character a captain? (true/false): ");
                isCaptain = scanner.nextBoolean();
                scanner.nextLine();


                newCharacter = new Pirate(CharacterName, Alias, Origin, Status, Wallet, Bounty, isCaptain, PirateRole);
                characterDB.addCharacter(newCharacter);
                System.out.println("Pirate Created, Hello " + CharacterName + "!");
                break;
            case 2:

                System.out.println("Enter Character Combat Style: ");
                CombatStyle = scanner.nextLine();
                System.out.println("Enter Character Confirmed Captures: ");
                ConfirmedCaptures = scanner.nextInt();
                scanner.nextLine();

                scanner.nextLine(); // Consume the newline character

                newCharacter = new PirateHunter(CharacterName, Alias, Origin, Status, Wallet, CombatStyle, ConfirmedCaptures);
                characterDB.addCharacter(newCharacter);
                System.out.println("Pirate Hunter Created, Hello " + CharacterName + "!");
                break;

            case 3:
                System.out.println("Enter Character Rank: ");
                Rank = scanner.nextLine();

                newCharacter = new Marine(CharacterName, Alias, Origin, Status, Wallet, Rank);
                characterDB.addCharacter(newCharacter);
                System.out.println("Marine Created, Hello " + CharacterName + "!");
                break;


            case 4:
                System.out.println("Enter Character Profession: ");
                Profession = scanner.nextLine();
                System.out.println("Enter Character Residence: ");
                Residence = scanner.nextLine();

                newCharacter = new Civilian(CharacterName, Alias, Origin, Status, Wallet, Profession, Residence);
                characterDB.addCharacter(newCharacter);
                System.out.println("Civillian Created, Hello " + CharacterName + "!");
                break;
            case 5:
                displayCharacterMenu();
                break;
            default:
                System.out.println("Invalid Choice. Please try again.");
                return;
                
        }


    }

    public static void viewCharacter()
    {
        characterDB.displayCharacters();

        System.out.println("Enter Character ID to view: ");
        int characterID = scanner.nextInt();

        Character character = characterDB.getCharacter(characterID);
        if (character != null)
        {
            character.DisplayProfile();
        }
        else
        {
            System.out.println("Character not found.");
        }

    }

    public static void updateCharacter()
    {
        characterDB.displayCharacters();

        System.out.println("Enter Character ID to update: ");
        int characterID = scanner.nextInt();

        Character character = characterDB.getCharacter(characterID);

        if (character != null)
        {
            System.out.println("Choose Attribute to Update: ");
            System.out.println("[1] Name");
            System.out.println("[2] Alias");
            System.out.println("[3] Origin");
            System.out.println("[4] Status");
            System.out.println("[5] Wallet");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice)
            {
                case 1:
                    System.out.println("Enter new Name:");
                    String newName = scanner.nextLine();
                    character.setName(newName);
                    System.out.println("Name updated successfully.");
                    break;

                case 2:
                    System.out.println("Enter new Alias:");
                    String newAlias = scanner.nextLine();
                    character.setAlias(newAlias);
                    System.out.println("Alias updated successfully.");
                    break;
                case 3:
                    System.out.println("Enter new Origin: ");
                    String newOrigin = scanner.nextLine();
                    character.setOrigin(newOrigin);
                    System.out.println("Origin updated successfully.");
                    break;
                case 4:
                    System.out.println("Enter new Status: ");
                    String newStatus = scanner.nextLine();
                    character.setAlias(newStatus);
                    System.out.println("Status updated successfully.");
                    break;
                case 5: 
                    System.out.println("Enter new Wallet: ");
                    int newWallet = scanner.nextInt();
                    character.setWallet(newWallet);
                    System.out.println("Wallet updated successfully.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    return;

            }

        }
        else
        {
            System.out.println("Character not found.");
        }

    }



    public static void deleteCharacter()
    {

        characterDB.displayCharacters();
        System.out.println("Enter Character ID to delete:");
        int characterID = scanner.nextInt();
        characterDB.removeCharacter(characterID);

        System.out.println("Character deleted successfully.");

    }
    
}
