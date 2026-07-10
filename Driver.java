import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class Driver {
    
    private static Scanner scanner = new Scanner(System.in); 
    private static int choice =0;
    private static boolean running = true;
    private static CharacterDatabase characterDB = new CharacterDatabase();
    private static AffiliationDatabase affiliationDB = new AffiliationDatabase();
    private static DevilFruitDatabase devilFruitDB = new DevilFruitDatabase();

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

    private static void createCharacter()
    {
        int  choice = 0, i = 0;
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
                System.out.println("Enter Character Name: ");
                CharacterName = scanner.nextLine();


                if(!characterDB.getCharacterMap().isEmpty()){
                    for(i = 0; i<=characterDB.getCharacterMap().size(); i++){
                        if(characterDB.getCharacter(i).getName().compareToIgnoreCase(CharacterName)==0){
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

            Character newCharacter = null;
            Pirate newPirate = null;
            Marine newMarine = null;
            PirateHunter newHunter = null;
            Civilian newCivilian = null;

            switch (choice)
            {
                case 1:
                    System.out.print(" Enter Character Bounty: ");
                    Bounty = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print(" Enter Character Pirate Role: ");
                    PirateRole = scanner.nextLine();

                    scanner.nextLine();

                    characterDB.addCharacter(newCharacter = new Pirate(CharacterName, Alias, Origin, Status, Wallet, Bounty, isCaptain, PirateRole));
                    characterDB.addPirate(newPirate = new Pirate(CharacterName, Alias, Origin, Status, Wallet, Bounty, isCaptain, PirateRole));
                    System.out.println("Pirate Created, Hello " + CharacterName + "!");
                    break;
                case 2:

                    System.out.print("Enter Character Combat Style: ");
                    CombatStyle = scanner.nextLine();
                    System.out.print("Enter Character Confirmed Captures: ");
                    ConfirmedCaptures = scanner.nextInt();
                    scanner.nextLine();

                    characterDB.addCharacter(newCharacter = new PirateHunter(CharacterName, Alias, Origin, Status, Wallet, CombatStyle, ConfirmedCaptures));
                    characterDB.addPirateHunter(newHunter = new PirateHunter(CharacterName, Alias, Origin, Status, Wallet, CombatStyle, ConfirmedCaptures));
                    System.out.println("Pirate Hunter Created, Hello " + CharacterName + "!");
                    break;

                case 3:
                    System.out.print("Enter Character Rank: ");
                    Rank = scanner.nextLine();

                    characterDB.addCharacter(newCharacter = new Marine(CharacterName, Alias, Origin, Status, Wallet, Rank));
                    characterDB.addMarine(newMarine = new Marine(CharacterName, Alias, Origin, Status, Wallet, Rank));
                    System.out.println("Marine Created, Hello " + CharacterName + "!");
                    break;


                case 4:
                    System.out.print("Enter Character Profession: ");
                    Profession = scanner.nextLine();
                    System.out.print("Enter Character Residence: ");
                    Residence = scanner.nextLine();

                    
                    characterDB.addCharacter(newCharacter = new Civilian(CharacterName, Alias, Origin, Status, Wallet, Profession, Residence));
                    characterDB.addCivlian(newCivilian = new Civilian(CharacterName, Alias, Origin, Status, Wallet, Profession, Residence));
                    System.out.println("Civillian Created, Hello " + CharacterName + "!");
                    break;
                case 5:
                    Driver.displayCharacterMenu();
                    break;
                default:
                    System.out.println("Invalid Choice. Please try again.");
                    break;
                    
            }



        } else {
            System.out.println("Invalid choice. Please pick again.");
            createCharacter();
        }

 

    }

    private static void viewCharacter() 
    {

        if(ifCharMapIsEmpty() == true) return;
        System.out.println("--- View a Character ---");
        //System.out.println();

        if(scanner.hasNextInt()){
        System.out.print("Enter Character ID to view: ");
        int characterID = scanner.nextInt();
        if(checkIfValidOption(1, characterDB.getCharacterMap().size(), choice)==false) viewCharacter();
            
        Character character = characterDB.getCharacter(characterID);
        if (character != null)
        {
            character.DisplayProfile();
        }
        else
        {
            System.out.println("Character not found.");
        }
        } else {
            System.out.println("Invalid choice. Please pick again.");
            viewCharacter();
        }

    }

    private static void updateCharacter()
    {      
        if(ifCharMapIsEmpty() == true) return;
        
        characterDB.displayCharacters();


        System.out.println("Enter Character ID to update: ");
        int characterID = scanner.nextInt();
        if(checkIfValidOption(1, characterDB.getCharacterMap().size(), choice)==false) updateCharacter();

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

    private static void deleteCharacter()
    {
        if(ifCharMapIsEmpty() == true) return;

        characterDB.displayCharacters();

        System.out.print("Enter Character ID to delete: ");

        if(scanner.hasNextInt()){
            int characterID = scanner.nextInt();
            characterDB.removeCharacter(characterID);

            if(checkIfValidOption(1, characterDB.getCharacterMap().size(), choice)==false) deleteCharacter();

            System.out.println("Character deleted successfully.");
        } else {
            System.out.println("Invalid choice. Please pick again.");
            deleteCharacter();
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

        if(checkIfValidOption(1, 3, choice)==false) removeMembers();
        if(choice == 3) displayAffiliationMenu();

        switch(choice){
            case 1: 
                affiliationDB.displayCrews();
                System.out.print("Enter the index of the Pirate Crew you want to remove a member from: ");
                mChoice = scanner.nextInt();

                affiliationDB.getCrew(mChoice).getPirates();
                System.out.print("Enter the index of the pirate you want to remove from the crew: ");
                eChoice = scanner.nextInt();

                affiliationDB.getCrew(mChoice).removeCrewMember(affiliationDB.getCrew(mChoice).getPirates().get(eChoice));

            break;
            case 2: 
                affiliationDB.displayCorps();
                System.out.print("Enter the index of the Marine Corps you want to remove a member from: ");
                mChoice = scanner.nextInt();

                affiliationDB.getCorps(mChoice).getMarines();
                System.out.print("Enter the index of the marine you want to remove from the corps: ");
                eChoice = scanner.nextInt();

                affiliationDB.getCorps(mChoice).removeMarineMember(affiliationDB.getCorps(mChoice).getMarines().get(eChoice));
            break;
            default: System.out.println("Invalid choice."); break;
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

        if(checkIfValidOption(1, 3, choice)==false) addMembers();
        if(choice == 3) displayAffiliationMenu();

        switch(choice){
            case 1: 
                affiliationDB.displayCrews();
                System.out.print("Enter the index of the Pirate Crew you want to add a member to: ");
                mChoice = scanner.nextInt();

                characterDB.displayPirates();
                System.out.print("Enter the index of the pirate you want to add to the crew: ");
                eChoice = scanner.nextInt();

                if(checkIfInCrew(characterDB.getPirate(eChoice)))
                    System.out.println("The Pirate is already in a crew."); 
                else {
                    affiliationDB.getCrew(mChoice).recruitCrewMember(characterDB.getPirate(eChoice));
                }

            break;
            case 2: 
                affiliationDB.displayCorps();
                System.out.print("Enter the index of the Marine Corps you want to add a member to: ");
                mChoice = scanner.nextInt();

                characterDB.displayMarines();
                System.out.print("Enter the index of the marine you want to add to the corps: ");
                eChoice = scanner.nextInt();

                if(checkIfInCorps(characterDB.getMarine(eChoice)))
                    System.out.println("The Marine is already in a crew."); 
                else {
                    affiliationDB.getCorps(mChoice).recruitMarineMember(characterDB.getMarine(eChoice));
                }
            break;
            default: System.out.println("Invalid choice."); break;
        }
    }

    private static void createGroup(){

        int choice, money, i = 0;
        PirateCrew newCrew;
        MarineCorps newCorps;
        String groupName, baseOfOperations, buffer;

        System.out.println(" --- Create a Group ---");
        System.out.println("[1] Pirate Crew");
        System.out.println("[2] Marine Corps");
        System.out.println("[3] Back to Affiliation Menu");
        System.out.print("Choice: ");

        if(scanner.hasNextInt()){
            choice = scanner.nextInt();
            scanner.nextLine();

            if(checkIfValidOption(1, 3, choice)==false) createGroup();
            if(choice == 3) displayAffiliationMenu();

            switch(choice){
                case 1: 
                
               System.out.print("Enter the name of the Pirate Crew: ");
                groupName = scanner.nextLine();

                for(i = 0; i<=affiliationDB.getCrewMap().size(); i++){
                    if(affiliationDB.getCrew(i).getCrewName().compareToIgnoreCase(groupName)==0){
                    System.out.println("This Pirate Crew already exists.");
                    return;
                    }
                }

                System.out.print("Enter the name of the Pirate Crew's ship: ");
                baseOfOperations = scanner.nextLine();

                System.out.println( "Pirate Crew: " + groupName + " has been created!");
                affiliationDB.addPirateCrew(newCrew = new PirateCrew(baseOfOperations, groupName));

                break;
                case 2: 

                System.out.print("Enter the name of the Marine Corps: ");
                groupName = scanner.nextLine();

                for(i = 0; i<=affiliationDB.getCrewMap().size(); i++){
                    if(affiliationDB.getCorps(i).getcorpsName().compareToIgnoreCase(groupName)==0){
                    System.out.println("This Marine Corps already exists.");
                    return;
                    }
                }

                System.out.print("Enter the Marine Corps' base location: ");
                baseOfOperations = scanner.nextLine();
                System.out.print("Enter the operational funds of the Marine Crops: ");
                money = scanner.nextInt();

                System.out.println(  "Marine Corps: " + groupName + " has been created!");

                affiliationDB.addMarineCorp(newCorps = new MarineCorps(baseOfOperations, groupName, money));

                break;
                case 3:
                displayAffiliationMenu();
                break;
                default:
                    System.out.println("Invalid choice.");
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

        if(scanner.hasNextInt()){

            System.out.println("--- View a Group ---");
            System.out.println("[1] Pirate Crew");
            System.out.println("[2] Marine Corps");
            System.out.println("[3] Back to Affiliation Menu");
            System.out.print("Choice: ");

            choice = scanner.nextInt();

            if(checkIfValidOption(1, 3, choice)==false) viewGroups();
            if(choice == 3) displayAffiliationMenu();

            switch(choice){
                case 1: 
                affiliationDB.displayCrews();

                System.out.print("Pick the Pirate Crew you want to view: ");
                choice = scanner.nextInt();

                affiliationDB.getCrew(choice);
                
                break;
                case 2: 
                affiliationDB.displayCorps();

                System.out.print("Pick the Marine Corps you want to view: ");
                choice = scanner.nextInt();

                affiliationDB.getCorps(choice);
                
                break;
                default: break;
            }

        } else {
            System.out.println("Invalid choice. Please pick again.");
            viewGroups();
        }

    }

    private static void editGroups(){ 

        int choice, mChoice, eChoice, newMoney, captain;
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

        if(checkIfValidOption(1, 3, choice)==false) createGroup();
        if(choice == 3) displayAffiliationMenu();

        switch(choice){
            case 1: 
            
                affiliationDB.displayCrews();
                System.out.print("Enter the index of the Pirate Crew you want to edit: ");
                mChoice = scanner.nextInt();
                affiliationDB.getCrew(mChoice).viewPirateGroup();
                System.out.println("Edit Options for " + affiliationDB.getCrew(mChoice).getCrewName());
                System.out.println("[1] Change Ship");
                System.out.println("[2] Change Captain");
                System.out.println("[3] Change Name");
                System.out.println("[4] Delete " + affiliationDB.getCrew(mChoice).getCrewName());
                System.out.print("Choice: ");
                eChoice = scanner.nextInt();

                switch(eChoice){
                    case 1: 
                        System.out.println(affiliationDB.getCrew(mChoice).getCrewName() + "'s ship is currently the" 
                        + affiliationDB.getCrew(mChoice).getShipName() + ".\n");
                        
                        System.out.println("Where the name of " + affiliationDB.getCrew(mChoice).getCrewName() + "'s new ship called?");
                        newBase = scanner.nextLine();
                        affiliationDB.getCrew(mChoice).setShipName(newBase);

                        System.out.println(affiliationDB.getCrew(mChoice).getCrewName() + "'s ship is now the" 
                        + affiliationDB.getCrew(mChoice).getShipName() + ".\n");

                    break;

                    case 2: 
                    
                        System.out.println("The current Captain of " + affiliationDB.getCrew(mChoice).getCrewName()
                        + " Pirates is " + affiliationDB.getCrew(mChoice).getCaptain().getName() + ".\n");
                        System.out.println("\n ===== LIST OF ALL PIRATES ===");
                        characterDB.displayPirates();
                        System.out.println();
                        System.out.println("Select the index of the new Captain.");
                        captain = scanner.nextInt();

                        if(characterDB.getCharacter(captain).getType().equals("Pirate")){
                            affiliationDB.getCrew(mChoice).setCaptain(characterDB.getPirate(captain));
                        } else System.out.println("Invalid choice.");

                    break; 

                    case 3: 
                    
                        System.out.println(affiliationDB.getCrew(mChoice).getCrewName() + "is the current name for this crew of Pirates.\n");
                        
                        System.out.println("What is the new name for " + affiliationDB.getCrew(mChoice).getCrewName() + "?");
                        newName = scanner.nextLine();
                        affiliationDB.getCrew(mChoice).setCrewName(newName);;

                        System.out.println("This pirate crew is now known as" + affiliationDB.getCrew(mChoice).getCrewName() + ".\n");

                    break;
                    case 4: 
                        
                        System.out.println("Deleting " + affiliationDB.getCrew(mChoice).getCrewName() + "...\n");
                        
                        affiliationDB.removeCrew(mChoice);
                        
                    break;
                    default: 

                        System.out.println("Invalid choice.");
                    
                    break;
                }
            
            break;
            case 2: 

                affiliationDB.displayCorps();
                System.out.println("Enter the index of the Marine Corps you want to edit: ");
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

                switch(eChoice){
                    case 1: 
                        System.out.println(affiliationDB.getCorps(mChoice).getcorpsName() + "is currently located at" 
                        + affiliationDB.getCorps(mChoice).getBaseLocation() + ".\n");
                        
                        System.out.println("Where is " + affiliationDB.getCorps(mChoice).getcorpsName() + "now located?");
                        newBase = scanner.nextLine();
                        affiliationDB.getCorps(mChoice).setBaseLocation(newBase);

                        System.out.println(affiliationDB.getCorps(mChoice).getcorpsName() + "is now located at" 
                        + affiliationDB.getCorps(mChoice).getBaseLocation() + ".\n");

                    break;

                    case 2: 
                    
                        System.out.println("The current Commander of " + affiliationDB.getCorps(mChoice).getcorpsName()
                        + "is " + affiliationDB.getCorps(mChoice).getcorpsCommander().getName() + ".\n");
                        System.out.println("\n ===== LIST OF ALL MARINES ===");
                        characterDB.displayMarines();
                        System.out.println();
                        System.out.println("Select the index of the new Commander.");
                        captain = scanner.nextInt();

                        if(characterDB.getCharacter(captain).getType().equals("Marine")){
                            affiliationDB.getCorps(mChoice).setCorpsCommander(characterDB.getMarine(captain));
                        } else System.out.println("Invalid choice.");

                    break; 

                    case 3: 
                    
                        System.out.println(affiliationDB.getCorps(mChoice).getcorpsName() + "is the current designated name for this corps of Marines.\n");
                        
                        System.out.println("What is the new name for " + affiliationDB.getCorps(mChoice).getcorpsName() + "?");
                        newName = scanner.nextLine();
                        affiliationDB.getCorps(mChoice).setcorpsName(newName);;

                        System.out.println("This marine corps is now known as" + affiliationDB.getCorps(mChoice).getcorpsName() + ".\n");

                    break;
                    case 4: 
                        
                        System.out.println(affiliationDB.getCorps(mChoice).getcorpsName() + "currently has a total of "
                        + affiliationDB.getCorps(mChoice).getOperationalFunds() + " in operational funds.\n");
                        
                        System.out.println("How much operational funds does " + affiliationDB.getCorps(mChoice).getcorpsName() + " now have?");
                        newMoney = scanner.nextInt();
                        affiliationDB.getCorps(mChoice).setOperationalFunds(newMoney);

                        System.out.println(affiliationDB.getCorps(mChoice).getcorpsName() + "now has a total of "
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

   private static void createDevilFruit()
    {

        String fruitName, fruitCategory, fruitAbility;
        int i = 0;

        System.out.println(" --- Create a Devil Fruit ---");
        System.out.print("Enter Devil Fruit Name: ");
        fruitName = scanner.nextLine();

        for(i = 0; i<=devilFruitDB.getDFMap().size(); i++){
            if(devilFruitDB.getDevilFruit(i).getFruitName().compareToIgnoreCase(fruitName)==0){
                System.out.println("This Devil Fruit already exists.");
                return;
            }
        }

        System.out.print("Enter Devil Fruit Category: ");
        fruitCategory = scanner.nextLine();
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

        if(checkIfValidOption(1, devilFruitDB.getDFMap().size(), fruitID)==false) viewDevilFruit();

        devilFruitDB.viewDevilFruit(fruitID);
    }

    private static void assignDevilFruit(){

        int fruitID, charID;

        if(ifDFMapIsEmpty()==true) return;

        System.out.println(" --- Assign a Devil Fruit ---");
        
        devilFruitDB.displayFruits();

        System.out.print("Enter a Devil Fruit ID: ");
        fruitID = scanner.nextInt();

        System.out.println("");
        characterDB.displayCharacters();

        if(checkIfValidOption(1, devilFruitDB.getDFMap().size(), fruitID)==false) assignDevilFruit();

        System.out.print("Enter a Character ID: ");
        charID = scanner.nextInt();

        if(checkIfValidOption(1, characterDB.getCharacterMap().size(), charID)==false) assignDevilFruit();

        devilFruitDB.assignFruitToUser(fruitID, characterDB.getCharacter(charID));
        characterDB.getCharacter(charID).setDFPower(devilFruitDB.getDevilFruit(fruitID));

    }

    //helper functions

    private static boolean checkIfInCorps(Marine candidate){

        int j = 0, i = 0;

        for(MarineCorps m : affiliationDB.getCorpsMap().values()){
            j++;
            for(Marine mm : affiliationDB.getCorps(j).getMarines())
            {
                i++;
                if(candidate.equals(affiliationDB.getCorps(j).getMarines().get(i)))
                {
                    return true;
                };
            }
        }

        return false;
                
    }

    private static boolean checkIfInCrew(Pirate candidate){

        int j = 0, i = 0;

        for(PirateCrew m : affiliationDB.getCrewMap().values()){
            j++;
            for(Pirate mm : affiliationDB.getCrew(j).getPirates())
            {
                i++;
                if(candidate.equals(affiliationDB.getCrew(j).getPirates().get(i)))
                {
                    return true;
                };
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


}
