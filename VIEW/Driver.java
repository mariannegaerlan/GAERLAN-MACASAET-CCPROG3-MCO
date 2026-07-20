import java.util.Scanner;
import java.io.File;
import java.io.IOException;


public class Driver {
    
    private static Scanner scanner = new Scanner(System.in); 
    private static int choice =0;
    private static boolean running = true;
    private static CharacterDatabase characterDB = new CharacterDatabase();
    private static AffiliationDatabase affiliationDB = new AffiliationDatabase();
    private static DevilFruitDatabase devilFruitDB = new DevilFruitDatabase();
    private static BountyDatabase bountyDB = new BountyDatabase();
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



/** The method is the main method of the program.
*
*@param none
*@return void

*/
    public static void main(String[] args) {

        // testCases();


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
        System.out.println("[4] Bounty Database");
        System.out.println("[5] Exit");
        System.out.print("Choice: ");

        if (scanner.hasNextInt())
        {
            choice = scanner.nextInt();

            if(checkIfValidOption(1,4,choice)==false) return;

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
                    displayBountyMenu();
                    break;
                case 5:
                    System.out.println("Goodbye GGEZ...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Choice. Please try again.");
                    return;
            }
        } else {
            System.out.println("Invalid choice. Please pick again.");
            displayMenu();
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
            scanner.nextLine();

            if(checkIfValidOption(1,5,choice)==false) displayCharacterMenu();

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
                    Driver.displayMenu();
                    break;
                default:
                    System.out.println("Invalid Choice. Please try again.");
                    return;
                

            }
        } else {
            System.out.println("Invalid choice. Please pick again.");
            displayCharacterMenu();
        }




    }

    public static void displayAffiliationMenu()
    {
        int choice = 0;
        System.out.println("========================================");
        System.out.println("======== Affiliation Database ==========");
        System.out.println("========================================");

        System.out.println("[1] Create Group");
        System.out.println("[2] View Groups");
        System.out.println("[3] Edit Group Attributes");
        System.out.println("[4] Add Members");
        System.out.println("[5] Remove Members");
        System.out.println("[6] Back to Main Menu: ");
        System.out.println("Choice: ");

            if (scanner.hasNextInt())
            {
            choice = scanner.nextInt();
                scanner.nextLine();

            if(checkIfValidOption(1,6,choice)==false) displayAffiliationMenu();

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

        } else {
            System.out.println("Invalid choice. Please pick again.");
            displayAffiliationMenu();
        }
    }

    public static void displayFruitMenu()
    {

        int choice = 0;

        System.out.println("========================================");
        System.out.println("======== Devil Fruit Database ==========");
        System.out.println("========================================");

        System.out.println("[1] Create Devil Fruit");
        System.out.println("[2] View Devil Fruit");
        System.out.println("[3] Assign Devil Fruit");
        System.out.println("[4] Back to Main Menu: ");
        System.out.print("Choice: ");
        
        
        if (scanner.hasNextInt())
        {
            choice = scanner.nextInt();
            scanner.nextLine();
            if(checkIfValidOption(1,4,choice)==false) displayFruitMenu();

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
        } else {
            System.out.println("Invalid choice. Please pick again.");
            displayFruitMenu();
        }
    }


    public static void displayBountyMenu()
    {

        int choice = 0;

        System.out.println("=================================");
        System.out.println("======== Bounty Database ========");
        System.out.println("=================================");

        System.out.println("[1] Register a Capture");
        System.out.println("[2] View Historical Captures");
        System.out.print("Choice: ");
        
        
        if (scanner.hasNextInt())
        {
            choice = scanner.nextInt();
            scanner.nextLine();
            if(checkIfValidOption(1,2,choice)==false) 
            {
            displayBountyMenu();
            return;
            }
            

            switch (choice)
            {
                case 1:
                    registerCapture();
                    break;
                case 2:
                    viewHistoricalCaptures();
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
                
            }
        } else {
            System.out.println("Invalid choice. Please pick again.");
            displayFruitMenu();
            return;
        }


    }

/* The method is facilitates the creation of characters.

@param none
@return void

*/

    private static void createCharacter()
    {
        int  choice = 0;
        System.out.println(" --- Create a Character ---");
        System.out.println("[1] Pirate");
        System.out.println("[2] Pirate Hunter");
        System.out.println("[3] Marine");
        System.out.println("[4] Civillian");
        System.out.println("[5] Back to Character Menu");
        System.out.print("Choice: ");

        

        if (scanner.hasNextInt())
        {

            choice = scanner.nextInt();

            if(checkIfValidOption(1, 5, choice)==false) createCharacter();
            if(choice == 5) displayCharacterMenu();


            scanner.nextLine(); 
                System.out.print("Enter Character Name: ");
                CharacterName = scanner.nextLine();


                if(!characterDB.getCharacterMap().isEmpty()){

                    for (Character character: characterDB.getCharacterMap().values())
                    {
                        if(character.getName().equalsIgnoreCase(CharacterName)){
                        System.out.println("This character already exists.");
                        return;       
                    }
                }
            }

                System.out.print("Enter Character Alias: ");
                Alias = scanner.nextLine();
                System.out.print("Enter Character Origin: ");
                Origin = scanner.nextLine();
                System.out.print("Enter Character Status: ");
                Status = scanner.nextLine();
                System.out.print("Enter Character Wallet: ");

               while (!scanner.hasNextInt())
               {
                System.out.println("Invalid Input. Please Enter a Whole Number");
                scanner.nextLine();
                System.out.print("Enter Character Wallet: ");
               }
                Wallet = scanner.nextInt();
                scanner.nextLine(); 

            Pirate newPirate = null;
            Marine newMarine = null;
            PirateHunter newHunter = null;
            Civilian newCivilian = null;

            switch (choice)
            {
                case 1:
                    System.out.print("Enter Character Bounty: ");
                    Bounty = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Enter Character Pirate Role: ");
                    PirateRole = scanner.nextLine();

                    // scanner.nextLine();

                    newPirate = new Pirate(CharacterName, Alias, Origin, Status, Wallet, Bounty, isCaptain, PirateRole);

                    characterDB.addCharacter(newPirate);
                    characterDB.addPirate(newPirate);
                    System.out.println("Pirate Created, Hello " + CharacterName + "!");
                    break;


                case 2:

                    System.out.print("Enter Character Combat Style: ");
                    CombatStyle = scanner.nextLine();
                    newHunter = new PirateHunter(CharacterName, Alias, Origin, Status, Wallet, CombatStyle);
                    characterDB.addCharacter(newHunter);
                    characterDB.addPirateHunter(newHunter);
                    System.out.println("Pirate Hunter Created, Hello " + CharacterName + "!");
                    break;

                case 3:


                    System.out.print("Enter Character Rank: ");
                    Rank = scanner.nextLine();

                    newMarine = new Marine(CharacterName, Alias, Origin, Status, Wallet, Rank);
                    characterDB.addCharacter(newMarine);
                    characterDB.addMarine(newMarine);
                    System.out.println("Marine Created, Hello " + CharacterName + "!");
                    break;


                case 4:


                    System.out.print("Enter Character Profession: ");
                    Profession = scanner.nextLine();
                    System.out.print("Enter Character Residence: ");
                    Residence = scanner.nextLine();

                    newCivilian = new Civilian(CharacterName, Alias, Origin, Status, Wallet, Profession, Residence);
                    
                    characterDB.addCharacter(newCivilian);
                    characterDB.addCivlian(newCivilian);
                    System.out.println("Civillian Created, Hello " + CharacterName + "!");
                    break;


                case 5:


                    Driver.displayCharacterMenu();
                    break;


                default:
                    System.out.println("Invalid Choice. Please try again.");
                    createCharacter();
                    break;
                    
            }



        } 
        else 
        {
            System.out.println("Invalid choice. Please pick again.");
            createCharacter();
        }
    }

    private static void viewCharacter() 
    {

        if(ifCharMapIsEmpty() == true) 
            return;
        System.out.println("--- View a Character ---");
        characterDB.displayCharacters();

      
        System.out.print("Enter Character ID to view: ");
        if(scanner.hasNextInt()){
        int characterID = scanner.nextInt();

        Character character = characterDB.getCharacter(characterID);
        if (character != null)
        {
            character.DisplayProfile();
        }
        else
        {
            System.out.println("Character not found.");
            viewCharacter();

        }


    }
}

    private static void updateCharacter()
    {      
        if(ifCharMapIsEmpty() == true) return;
        
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

            if(character.getType().contains("Pirate")){
                System.out.println("[6] Bounty");
                System.out.println("[7] Pirate Role");
            } else if(character.getType().contains("Marine")){
                System.out.println("[6] Rank");

            } else if(character.getType().contains("Pirate Hunter")){
                System.out.println("[6] Combat Style");
                
            } else if(character.getType().contains("Civilian")){
                System.out.println("[6] Profession");
                System.out.println("[7] Residence");
            } 
            
            
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            if(checkIfValidOption(1, 5, choice)==false) updateCharacter();

            switch (choice)
            {
                case 1:
                    System.out.print("Enter new Name: ");
                    String newName = scanner.nextLine();
                    character.setName(newName);
                    System.out.println("Name updated successfully.");
                    break;

                case 2:
                    System.out.print("Enter new Alias: ");
                    String newAlias = scanner.nextLine();
                    character.setAlias(newAlias);
                    System.out.println("Alias updated successfully.");
                    break;
                case 3:
                    System.out.print("Enter new Origin: ");
                    String newOrigin = scanner.nextLine();
                    character.setOrigin(newOrigin);
                    System.out.println("Origin updated successfully.");
                    break;
                case 4:
                    System.out.print("Enter new Status: ");
                    String newStatus = scanner.nextLine();
                    character.setAlias(newStatus);
                    System.out.println("Status updated successfully.");
                    break;
                case 5: 
                    System.out.print("Enter new Wallet: ");

                    while (!scanner.hasNextInt())
                    {
                        System.out.println("Invalid Input. Please Enter a Whole Number");
                        scanner.nextLine();
                        System.out.print("Enter new Wallet: ");
                    }
                    
                    int newWallet = scanner.nextInt();
                    character.setWallet(newWallet);
                    System.out.println("Wallet updated successfully.");
                    break;
                case 6: 
                    
                    if(character instanceof Pirate){

                        Pirate newPirate = (Pirate) character;
       
                        System.out.print("Set a new bounty [1] or add to the current one [2]?");
                        int bountyChoice = scanner.nextInt();
                        int money = 0;

                        switch(bountyChoice){
                            case 1: 
                            System.out.println("How much is " + character.getName() + "'s new bounty?");
                            money = scanner.nextInt();
                            newPirate.setBounty(money);
                            System.out.println("Bounty updated successfully");

                            break;
                            case 2:
                            System.out.println("How much is going to be added to " + character.getName() + " bounty?");
                            money = scanner.nextInt();
                            newPirate.ModifyBounty(money);
                            System.out.println("The new total bounty for " + newPirate.getName() + " is " + newPirate.getBounty());

                            break;
                            default: 
                                System.out.println("Invalid choice. Please try again.");
                                updateCharacter();
                                return;
                        }

                    } else if(character instanceof Marine){
                        Marine newMarine = (Marine) character;
                        System.out.print("Enter new Marine Rank: ");
                        String newRank = scanner.nextLine();
                        newMarine.setRank(newRank);
                        System.out.println("Rank updated successfully.");
                        
                        
                    } else if(character instanceof PirateHunter){
                        PirateHunter newPirateHunter = (PirateHunter) character;
                        System.out.print("Enter new Combat Style: ");
                        String combatStyle = scanner.nextLine();
                        newPirateHunter.setCombatStyle(combatStyle);
                        System.out.println("Combat Style updated successfully.");
                        
                        
                    } else if(character instanceof Civilian){
                        Civilian newCivilian = (Civilian) character;
                        System.out.print("Enter new Profession: ");
                        String profession = scanner.nextLine();
                        newCivilian.setProfession(profession);
                        System.out.println("Profession updated successfully.");
                                  
                    }

                break;
                case 7:

                    if(character instanceof Pirate){

                        Pirate newPirate = (Pirate) character;
       
                        System.out.print("Enter the new role: ");
                        String newRole = scanner.nextLine();
                        newPirate.setPirateRole(newRole);
                        System.out.println("Pirate Role updated successfully");
                        }
                        
                        else if(character instanceof Civilian){
                        Civilian newCivilian = (Civilian) character;
                        System.out.print("Enter New Residence: ");
                        String residence = scanner.nextLine();
                        newCivilian.setResidence(residence);
                        System.out.println("Residence updated successfully.");
                                  
                    } else if(character instanceof Marine){
                        System.out.println("Invalid choice. Please try again.");
                        updateCharacter();
                        return;   
                    }
 
                default:
                    System.out.println("Invalid choice. Please try again.");
                    updateCharacter();
                    return;

            }

        }
        else
        {
            System.out.println("Character not found.");
            updateCharacter();
        }

    }

    private static void deleteCharacter()
    {
        if(ifCharMapIsEmpty() == true) return;

        characterDB.displayCharacters();

        System.out.print("Enter Character ID to delete: ");

        if(scanner.hasNextInt()){
            int characterID = scanner.nextInt();
            scanner.nextLine();

            Character character = characterDB.getCharacter(characterID);

            if (character != null)
            {

                System.out.println(character.getName() + " has been Deleted.");
                characterDB.removeCharacter(character);
           
            }
            else
            {
            System.out.println("Character ID not found.");
            deleteCharacter();
            }
        } else {
            System.out.println("Invalid Choice.");
            deleteCharacter();
        }

    }

/* The method views the dead characters

@param none
@return void

*/

private static void viewDeletedCharacters()
{
    characterDB.displayDeadCharacter();
}


/* The method facilitates the creation of PirateCrew and MarineCorps objects.

@param none
@return void

*/

    private static void createGroup(){

        int choice, money;
        PirateCrew newCrew;
        MarineCorps newCorps;
        String groupName, baseOfOperations;

        System.out.println(" --- Create a Group ---");
        System.out.println("[1] Pirate Crew");
        System.out.println("[2] Marine Corps");
        System.out.println("[3] Back to Affiliation Menu");
        System.out.print("Choice: ");

        if(scanner.hasNextInt()){
            choice = scanner.nextInt();
            scanner.nextLine();

            if(checkIfValidOption(1, 3, choice)==false) 
                createGroup();
            if(choice == 3) 
                displayAffiliationMenu();

            
            switch(choice){
                case 1: 
                
               System.out.print("Enter the name of the Pirate Crew: ");
                groupName = scanner.nextLine();

                for (PirateCrew pirateCrew: affiliationDB.getCrewMap().values())
                {
                    if(pirateCrew.getCrewName().equalsIgnoreCase(groupName)){
                        System.out.println("This Pirate Crew already exists.");
                        return;       
                    }
                }

                System.out.print("Enter the name of the Pirate Crew's ship: ");
                baseOfOperations = scanner.nextLine();

                newCrew = new PirateCrew(baseOfOperations, groupName);

                System.out.println( "Pirate Crew: " + groupName + " has been created!");
                affiliationDB.addPirateCrew(newCrew);

                break;
                case 2: 

                System.out.print("Enter the name of the Marine Corps: ");
                groupName = scanner.nextLine();

                for (MarineCorps marineCorps: affiliationDB.getCorpsMap().values())
                {
                    if(marineCorps.getcorpsName().equalsIgnoreCase(groupName)){
                        System.out.println("This Marine Corp already exists.");
                        return;       
                    }
                }

                System.out.print("Enter the Marine Corps' base location: ");
                baseOfOperations = scanner.nextLine();
                System.out.print("Enter the operational funds of the Marine Crops: ");
                    while (!scanner.hasNextInt())
                    {
                        System.out.println("Invalid Input. Please Enter a Whole Number");
                        scanner.nextLine();
                        System.out.print("Enter the operational funds of the Marine Crops: ");
                    }
                money = scanner.nextInt();

                System.out.println(  "Marine Corps: " + groupName + " has been created!");
                newCorps = new MarineCorps(baseOfOperations, groupName, money);
                affiliationDB.addMarineCorp(newCorps);

                break;
                case 3:
                displayAffiliationMenu();
                break;
                default:
                    System.out.println("Invalid choice. Please try Again");
                    createGroup();
                    break;
            }
        }
    }

    private static void viewGroups(){ 

        int choice;

        if ( affiliationDB.getCrewMap().isEmpty() && affiliationDB.getCorpsMap().isEmpty())
        {
            System.out.println("Please Create a Group First.");
            return;
        }
            System.out.println("--- View a Group ---");
            System.out.println("[1] Pirate Crew");
            System.out.println("[2] Marine Corps");
            System.out.println("[3] Back to Affiliation Menu");
            System.out.print("Choice: ");


            if(scanner.hasNextInt()){
                choice = scanner.nextInt();


            if(checkIfValidOption(1, 3, choice)==false) 
                viewGroups();
            if(choice == 3) 
                displayAffiliationMenu();
            switch(choice){
                case 1: 
                affiliationDB.displayCrews();

                System.out.println("Pick the Pirate Crew you want to view: ");
                choice = scanner.nextInt();
                affiliationDB.getCrew(choice).viewPirateGroup();
                
                break;
                case 2: 
                affiliationDB.displayCorps();

                System.out.println("Pick the Marine Corps you want to view: ");
                choice = scanner.nextInt();
                affiliationDB.getCorps(choice).viewMarineGroup();
                
                break;
                default: 
                break;
            }

        } else {
            System.out.println("Invalid choice. Please pick again.");
            viewGroups();
        }

    }

    private static void editGroups(){ 

        int choice, mChoice, eChoice, newMoney, captainInt;
        String newName, newBase;

        if ( affiliationDB.getCrewMap().isEmpty() && affiliationDB.getCorpsMap().isEmpty())
        {
            System.out.println("Please Create a Group First.");
            return;
        }

        System.out.println(" --- Edit a Group ---");
        System.out.println("[1] Pirate Crew");
        System.out.println("[2] Marine Corps");
        System.out.println("[3] Back to Affiliation Menu");
        System.out.print("Choice: ");
        choice = scanner.nextInt();

        if(checkIfValidOption(1, 3, choice)==false) 
            createGroup();
        if(choice == 3) 
            displayAffiliationMenu();

        switch(choice){
            case 1: 
            
                affiliationDB.displayCrews();
                System.out.print("Enter the ID of the Pirate Crew you want to edit: ");
                mChoice = scanner.nextInt();
                affiliationDB.getCrew(mChoice).viewPirateGroup();
                System.out.println("Edit Options for " + affiliationDB.getCrew(mChoice).getCrewName());
                System.out.println("[1] Change Ship");
                System.out.println("[2] Change Captain");
                System.out.println("[3] Change Name");
                System.out.println("[4] Delete " + affiliationDB.getCrew(mChoice).getCrewName());
                System.out.print("Choice: ");
                eChoice = scanner.nextInt();
                scanner.nextLine();

                switch(eChoice){
                    case 1: 
                        System.out.println(affiliationDB.getCrew(mChoice).getCrewName() + "'s ship is currently the " 
                        + affiliationDB.getCrew(mChoice).getShipName() + ".\n");
                        
                        System.out.println("What is the name of " + affiliationDB.getCrew(mChoice).getCrewName() + "'s new ship called?");
                        newBase = scanner.nextLine();
                        affiliationDB.getCrew(mChoice).setShipName(newBase);

                        System.out.println(affiliationDB.getCrew(mChoice).getCrewName() + "'s ship is now the " 
                        + affiliationDB.getCrew(mChoice).getShipName() + ".\n");

                    break;

                    case 2: 

                    Pirate captain = affiliationDB.getCrew(mChoice).getCaptain();

                        if (captain == null)
                        {
                            System.out.println("This Crew has No Captain.");
                            return;

                        }
                    
                        System.out.println("The current Captain of " + affiliationDB.getCrew(mChoice).getCrewName()
                        + " Pirates is " + affiliationDB.getCrew(mChoice).getCaptain().getName() + ".\n");
                        System.out.println("\n ===== LIST OF ALL PIRATES ===");
                        characterDB.displayPirates();
                        System.out.println();
                        System.out.println("Select the ID of the new Captain.");
                        captainInt = scanner.nextInt();

                        if(characterDB.getCharacter(captainInt).getType().equals("Pirate")){
                            affiliationDB.getCrew(mChoice).setCaptain(characterDB.getPirate(captainInt));
                        } else System.out.println("Invalid choice.");

                    break; 

                    case 3: 
                    
                        System.out.println(affiliationDB.getCrew(mChoice).getCrewName() + " is the current name for this crew of Pirates.\n");
                        
                        System.out.println("What is the new name for " + affiliationDB.getCrew(mChoice).getCrewName() + " ?");
                        newName = scanner.nextLine();
                        affiliationDB.getCrew(mChoice).setCrewName(newName);;

                        System.out.println("This pirate crew is now known as " + affiliationDB.getCrew(mChoice).getCrewName() + " .\n");

                    break;
                    case 4: 
                        
                        System.out.println("Deleting " + affiliationDB.getCrew(mChoice).getCrewName() + " ...\n");
                        
                        affiliationDB.removeCrew(mChoice);
                        
                    break;
                    default: 

                        System.out.println("Invalid choice.");
                    
                    break;
                }
            
            break;
            case 2: 

                affiliationDB.displayCorps();
                System.out.println("Enter the ID of the Marine Corps you want to edit: ");
                mChoice = scanner.nextInt();
                affiliationDB.getCorps(mChoice).viewMarineGroup();
                System.out.println("Edit Options for " + affiliationDB.getCorps(mChoice).getcorpsName());
                System.out.println("[1] Change Base Location");
                System.out.println("[2] Change Commander");
                System.out.println("[3] Change Name");
                System.out.println("[4] Change Operational Funds");
                System.out.println("[5] Delete " + affiliationDB.getCorps(mChoice).getcorpsName());
                System.out.print("Choice: ");
                eChoice = scanner.nextInt();
                scanner.nextLine();

                switch(eChoice){
                    case 1: 
                        System.out.println(affiliationDB.getCorps(mChoice).getcorpsName() + " is currently located at " 
                        + affiliationDB.getCorps(mChoice).getBaseLocation() + ".\n");
                        
                        System.out.println("Where is " + affiliationDB.getCorps(mChoice).getcorpsName() + " now located?");
                        newBase = scanner.nextLine();
                        affiliationDB.getCorps(mChoice).setBaseLocation(newBase);

                        System.out.println(affiliationDB.getCorps(mChoice).getcorpsName() + " is now located at " 
                        + affiliationDB.getCorps(mChoice).getBaseLocation() + ".\n");

                    break;

                    case 2: 
                        Marine commander = affiliationDB.getCorps(mChoice).getcorpsCommander();
                        
                        if (commander == null)
                        {
                            System.out.println("This Corp has no Commander");
                            return;
                        }  
                        System.out.println("The current Commander of " + affiliationDB.getCorps(mChoice).getcorpsName()
                        + "is " + affiliationDB.getCorps(mChoice).getcorpsCommander().getName() + ".\n");
                        System.out.println("\n ===== LIST OF ALL MARINES ===");
                        characterDB.displayMarines();
                        System.out.println();
                        System.out.println("Select the ID of the new Commander.");
                        captainInt = scanner.nextInt();

                        if(characterDB.getCharacter(captainInt).getType().equals("Marine")){
                            affiliationDB.getCorps(mChoice).setCorpsCommander(characterDB.getMarine(captainInt));
                        } else System.out.println("Invalid choice.");

                    break; 

                    case 3: 
                    
                        System.out.println(affiliationDB.getCorps(mChoice).getcorpsName() + "is the current designated name for this corps of Marines.\n");
                        
                        System.out.println("What is the new name for " + affiliationDB.getCorps(mChoice).getcorpsName() + "?");
                        newName = scanner.nextLine();
                        affiliationDB.getCorps(mChoice).setcorpsName(newName);;

                        System.out.println("This marine corps is now known as " + affiliationDB.getCorps(mChoice).getcorpsName() + ".\n");

                    break;
                    case 4: 
                        
                        System.out.println(affiliationDB.getCorps(mChoice).getcorpsName() + " currently has a total of "
                        + affiliationDB.getCorps(mChoice).getOperationalFunds() + " in operational funds.\n");
                        
                        System.out.println("How much operational funds does " + affiliationDB.getCorps(mChoice).getcorpsName() + " now have?");
                        newMoney = scanner.nextInt();
                        affiliationDB.getCorps(mChoice).setOperationalFunds(newMoney);

                        System.out.println(affiliationDB.getCorps(mChoice).getcorpsName() + " now has a total of "
                        + affiliationDB.getCorps(mChoice).getOperationalFunds() + " in operational funds.\n");
                        
                    break;
                    case 5:
                        
                        System.out.println("Deleting " + affiliationDB.getCorps(mChoice).getcorpsName() + "...\n");
                        
                        affiliationDB.removeCorps(mChoice);
                        
                    break;
                    default: 

                        System.out.println("Invalid choice.");
                    
                    break;
                }

                break;
            default:

                System.out.println("Invalid choice.");
                break;
        }
    }

    
    private static void addMembers(){
        int choice, mChoice, eChoice;

        if ( affiliationDB.getCrewMap().isEmpty() && affiliationDB.getCorpsMap().isEmpty())
        {
            System.out.println("Please Create a Group First.");
            return;
        }

        System.out.println(" --- Add Members to a Group ---");
        System.out.println("[1] Pirate Crew");
        System.out.println("[2] Marine Corps");
        System.out.println("[3] Back to Affiliation Menu");
        System.out.print("Choice: ");
        choice = scanner.nextInt();

        if(checkIfValidOption(1, 3, choice)==false) 
            addMembers();
        if(choice == 3) 
            displayAffiliationMenu();

        switch(choice){
            case 1: 

                if (characterDB.getPirateMap().isEmpty())
                {
                    System.out.println("No Pirates Existing in The World. Please Create one First");
                    return;
                }
                affiliationDB.displayCrews();
                System.out.print("Enter the ID of the Pirate Crew you want to add a member to: ");
                mChoice = scanner.nextInt();

                characterDB.displayPirates();
                System.out.print("Enter the ID of the pirate you want to add to the crew: ");
                eChoice = scanner.nextInt();

                if(checkIfInCrew(characterDB.getPirate(eChoice)))
                    System.out.println("The Pirate is already in a crew."); 
                else {
                    affiliationDB.getCrew(mChoice).recruitCrewMember(characterDB.getPirate(eChoice));
                }

            break;
            case 2: 
                if (characterDB.getMarineMap().isEmpty())
                {
                    System.out.println("No Marines Existing in The World. Please Create one First");
                    return;
                }
                affiliationDB.displayCorps();
                System.out.print("Enter the ID of the Marine Corps you want to add a member to: ");
                mChoice = scanner.nextInt();

                characterDB.displayMarines();
                System.out.print("Enter the ID of the marine you want to add to the corps: ");
                eChoice = scanner.nextInt();

                if(checkIfInCorps(characterDB.getMarine(eChoice)))
                    System.out.println("The Marine is already in a crew."); 
                else {
                    affiliationDB.getCorps(mChoice).recruitMarineMember(characterDB.getMarine(eChoice));
                }
            break;
            default: 
            System.out.println("Invalid choice."); 
            break;
        }
    }
    
    private static void removeMembers(){
        int choice, mChoice, eChoice;

        if ( affiliationDB.getCrewMap().isEmpty() && affiliationDB.getCorpsMap().isEmpty())
        {
            System.out.println("Please Create a Group First.");
            return;
        }

        System.out.println(" --- Remove a Member from a Group ---");
        System.out.println("[1] Pirate Crew");
        System.out.println("[2] Marine Corps");
        System.out.println("[3] Back to Affiliation Menu");
        System.out.print("Choice: ");
        choice = scanner.nextInt();

        if(checkIfValidOption(1, 3, choice)==false) 
            removeMembers();
        if(choice == 3) 
            displayAffiliationMenu();

        switch(choice){
            case 1: 
                affiliationDB.displayCrews();
                System.out.print("Enter the ID of the Pirate Crew you want to remove a member from: ");
                mChoice = scanner.nextInt();

                affiliationDB.getCrew(mChoice).viewList();
                System.out.print("Enter the ID of the pirate you want to remove from the crew: ");
                eChoice = scanner.nextInt();

                Pirate removedPirate = characterDB.getPirate(eChoice);

                if (removedPirate != null)
                {
                affiliationDB.getCrew(mChoice).removeCrewMember(removedPirate);
                }
                else
                {
                    System.out.println("Pirate does not exist");
                    removeMembers();
                }
                


            break;
            case 2: 
                affiliationDB.displayCorps();
                System.out.print("Enter the ID of the Marine Corps you want to remove a member from: ");
                mChoice = scanner.nextInt();

                affiliationDB.getCorps(mChoice).viewList();
                System.out.print("Enter the ID of the marine you want to remove from the corps: ");
                eChoice = scanner.nextInt();


                Marine removedMarine = characterDB.getMarine(eChoice);

                if (removedMarine != null)
                {
                affiliationDB.getCorps(mChoice).removeMarineMember(removedMarine);
                }
                else
                {
                    System.out.println("Marine does not exist");
                    removeMembers();
                }
            break;
            default: System.out.println("Invalid choice."); 
            break;
        }
    }  

    //Devil Fruit Functions

    private static void createDevilFruit()
    {

        String fruitName, fruitAbility, fruitCategory = "";
        int choice;

        System.out.println(" --- Create a Devil Fruit ---");
        System.out.print("Enter Devil Fruit Name: ");
        fruitName = scanner.nextLine();


        for (DevilFruit devilFruit: devilFruitDB.getDFMap().values())
            {
            if(devilFruit.getFruitName().equalsIgnoreCase(fruitName)){
                System.out.println("This Devil Fruit already exists.");
                return;       
             }
        }

        System.out.println("Choose a Devil Fruit Category: ");
        System.out.println("[1] Paramecia");
        System.out.println("[2] Zoan");
        System.out.println("[3] Logia");

        choice = scanner.nextInt();

        if (scanner.hasNextInt())
        {
            switch(choice)
            {
                case 1: fruitCategory = "Paramecia"; 
                break;
                case 2: fruitCategory = "Zoan"; 
                break;
                case 3: fruitCategory = "Logia"; 
                break;
                default: System.out.println("Please enter a valid number."); 
                return;

            }
        }


        System.out.print("Enter Devil Fruit Ability: ");
        fruitAbility = scanner.nextLine();

        DevilFruit newFruit = new DevilFruit(fruitName, fruitCategory, fruitAbility);
        devilFruitDB.createDevilFruit(newFruit);
        System.out.println("[ NEW DEVIL FRUIT: " + fruitName);
        System.out.println("  CATEGORY: " + fruitCategory);
        System.out.println("  ABILITY: " + fruitAbility + " ]");
    }

    private static void viewDevilFruit(){

        int fruitID;

        if(ifDFMapIsEmpty()==true) return;

        devilFruitDB.displayFruits();
        if (devilFruitDB.getDFMap().isEmpty())
        {
            System.out.println("The database is empty. Please create a devil fruit first.");
            return;
        }

        System.out.println(" --- View a Devil Fruit ---");
        System.out.print("Enter a Devil Fruit ID: ");
        fruitID = scanner.nextInt();

        if (devilFruitDB.getDevilFruit(fruitID)!= null)
        {
        devilFruitDB.viewDevilFruit(fruitID);

        }
        else
        {
            System.out.println("Devil Fruit not Found.");
            viewDevilFruit();
        }
    }

    private static void assignDevilFruit(){

        int fruitID, charID;

        if(ifDFMapIsEmpty()==true) 
        {
            return;
        }


        System.out.println(" --- Assign a Devil Fruit ---");
        
        devilFruitDB.displayFruits();

        System.out.print("Enter a Devil Fruit ID: ");
        fruitID = scanner.nextInt();

        System.out.println("");
        characterDB.displayCharacters();

        if (devilFruitDB.getDevilFruit(fruitID)!= null)
        {
        System.out.print("Enter a Character ID: ");
        charID = scanner.nextInt();

            if (characterDB.getCharacter(charID)!=null)
            {
            devilFruitDB.assignFruitToUser(fruitID, characterDB.getCharacter(charID));
            characterDB.getCharacter(charID).setDFPower(devilFruitDB.getDevilFruit(fruitID));
            }
            else
            {
                System.out.println("Character does not exist");
                assignDevilFruit();
            }

            
        }
        else
        {
            System.out.println("Devil Fruit not Found.");
            assignDevilFruit();
        }


    }


    private static void registerCapture()
    {
    int charID=0;
    int charID2=0;

    System.out.println(" --- Register a Devil Fruit ---");
    characterDB.displayCharacters();
    System.out.println("Enter Character ID of the Captor: ");
    charID = scanner.nextInt();
    Character captor = characterDB.getCharacter(charID);
    System.out.println("Enter Character ID that you wish to Capture: ");
    charID2 = scanner.nextInt();

    Character captured = characterDB.getCharacter(charID2);

        if (captured.getStatus().equalsIgnoreCase("Captured"))
        {
            System.out.println(captured.getName()+ " has already been Captured!");
        }
        else if (captured.getStatus().equalsIgnoreCase("Dead"))
        {
            System.out.println(captured.getName()+ " is already dead!");
        }
        else if (!PirateBounty.validateCaptor(captor))
        {
        System.out.println("Invalid Captor. A Pirate cannot capture another Pirate #traitor lol");
        }
        else
        {
        PirateBounty bounty = new PirateBounty();
        bounty.setCaptor(captor);
        bounty.setCaptured(captured);
        bountyDB.registerCapture(bounty);
        bounty.processTargetStatus();
        bounty.routeFinancialRewards();
        bounty.logTransaction();
        }
        

    }


    private static void viewHistoricalCaptures()
    {
    System.out.println(" --- View Capture History ---");
    bountyDB.viewHistoralCaptures();

    }


/* The method checks if a Marine object is in a MarineCorps object.

@param none
@return true of the Marine object is in a MarineCorps object and false if otherwise

*/

    private static boolean checkIfInCorps(Marine candidate){

        for(MarineCorps m : affiliationDB.getCorpsMap().values()){
       
                if(m.getMarines().contains(candidate))
                {
                    return true;
                }
        }
        return false;
                
    }

    private static boolean checkIfInCrew(Pirate candidate){


        for(PirateCrew m : affiliationDB.getCrewMap().values()){
           if (m.getPirates().contains(candidate))
                {
                    return true;
                }
            }


        return false;
                
    }

    private static boolean checkIfValidOption(int minOptions, int maxOptions, int userPick){
        if(userPick>maxOptions || userPick<minOptions){
            System.out.println("Invalid option. Please pick again.");
            return false;
        }

        return true;
    }

    private static boolean ifCharMapIsEmpty(){
        if (characterDB.getCharacterMap().isEmpty())
        {
            System.out.println("The database is empty. Please create a character first.");
            return true;
        } else return false;
    }

    private static boolean ifDFMapIsEmpty(){

        if (devilFruitDB.getDFMap().isEmpty())
        {
            System.out.println("The database is empty. Please create a devil fruit first.");
            return true;
        } else return false;

    }

// /* The method instantiates objects for easier checking of the functionality of the different methods on this program.

// @param none
// @return void
// */

//     private static void testObjects(){
//          Pirate Luffy = new Pirate("Monkey D. Luffy", "Strawhat", "Foosha Village", "Alive", 10, 100000, false, "Captain");
//          Pirate Nami = new Pirate("Nami", "Cat Burglar", "Cocoyasi Village", "Alive", 100000, 100000, false, "Navigator");
//          Pirate Sanji = new Pirate("Vinsmoke Sanji", "Black Leg", "Baratie", "Alive", 10, 100000, false, "Cook");
//          Pirate Robin = new Pirate("Nico Robin", "Demon Child", "Ohara", "Alive", 10, 100000, false, "Historian");

//          Marine Garp = new Marine("Monkey D. Garp", "The Fist", "Foosha Village", "Dead", 10, "Vice Admiral");
//          Marine Smoker = new Marine("Smoker", "White Chase", "G-5", "Alive", 10, "Vice Admiral");
//          Marine Koby = new Marine("Koby", "Hero", "East Blue", "Alive", 10, "Captain");
//          Marine Akainu = new Marine("Akainu", "Red Dog", "North Blue", "Alive", 10, "Fleet Admiral");

//          PirateHunter Zoro = new PirateHunter("Roronoa Zoro", "Pirate Hunter", "Shimotsuki Village", "Alive", 10, "Three-Sword Style", 10);
//          PirateHunter Mihawk = new PirateHunter("Dracule Mihawk", "Strongest Swordsman in the World", "Karai Bari Island", "Alive", 10, "One-Sword Style", 100);

//          Civilian Hiriluk = new Civilian("Hiriluk", "Doctor", "Drum Island", "Dead", 1, "Doctor", "Dead");
//          Civilian Vivi = new Civilian("Nefertari Vivi", "Princess of Alabasta", "Alabasta", "Alive", 10, "Princess", "Alabasta");


//          characterDB.addCharacter(Luffy);
//          characterDB.addCharacter(Nami);
//          characterDB.addCharacter(Sanji);
//          characterDB.addCharacter(Robin);
//          characterDB.addCharacter(Garp);
//          characterDB.addCharacter(Smoker);
//          characterDB.addCharacter(Koby);
//          characterDB.addCharacter(Akainu);
//          characterDB.addCharacter(Zoro);
//          characterDB.addCharacter(Mihawk);
//          characterDB.addCharacter(Hiriluk);
//          characterDB.addCharacter(Vivi);

//          characterDB.addPirate(Luffy);
//          characterDB.addPirate(Nami);
//          characterDB.addPirate(Sanji);
//          characterDB.addPirate(Robin);

//          characterDB.addPirateHunter(Zoro);
//          characterDB.addPirateHunter(Mihawk);

//          characterDB.addMarine(Smoker);
//          characterDB.addMarine(Koby);
//          characterDB.addMarine(Akainu);
//          characterDB.addMarine(Akainu);

//          characterDB.addCivlian(Hiriluk);
//          characterDB.addCivlian(Vivi);

//          DevilFruit gumGum = new DevilFruit("Gum-Gum Fruit", "Mythical Zoan", "Rubber body and also transform into a god I guess");
//          DevilFruit smokeSmoke = new DevilFruit("Smoke-Smoke Fruit", "Logia", "Create, control, and transform into smoke");
//          DevilFruit magmaMagma = new DevilFruit("Magma-Magma Fruit", "Logia", "Create, control, and transform into magma");
//          DevilFruit flowerFlower = new DevilFruit("Flower-Flower Fruit", "Paramecia", "Create and control body parts made of petals");

//          devilFruitDB.createDevilFruit(gumGum);
//          devilFruitDB.createDevilFruit(smokeSmoke);
//         devilFruitDB.createDevilFruit(magmaMagma);
//          devilFruitDB.createDevilFruit(flowerFlower);

//          System.out.println("Test cases created: Characters and Fruits");
//      }


}
