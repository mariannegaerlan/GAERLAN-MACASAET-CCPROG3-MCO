package CONTROLLER;

public class CharacterMenu {
//     /* The method is facilitates the creation of characters.

// @param none
// @return void

// */

//     private static void createCharacter()
//     {
//         int  choice = 0;
//         System.out.println(" --- Create a Character ---");
//         System.out.println("[1] Pirate");
//         System.out.println("[2] Pirate Hunter");
//         System.out.println("[3] Marine");
//         System.out.println("[4] Civillian");
//         System.out.println("[5] Back to Character Menu");
//         System.out.print("Choice: ");

        

//         if (scanner.hasNextInt())
//         {

//             choice = scanner.nextInt();

//             if(checkIfValidOption(1, 5, choice)==false) createCharacter();
//             if(choice == 5) displayCharacterMenu();


//             scanner.nextLine(); 
//                 System.out.print("Enter Character Name: ");
//                 CharacterName = scanner.nextLine();


//                 if(!characterDB.getCharacterMap().isEmpty()){

//                     for (Character character: characterDB.getCharacterMap().values())
//                     {
//                         if(character.getName().equalsIgnoreCase(CharacterName)){
//                         System.out.println("This character already exists.");
//                         return;       
//                     }
//                 }
//             }

//                 System.out.print("Enter Character Alias: ");
//                 Alias = scanner.nextLine();
//                 System.out.print("Enter Character Origin: ");
//                 Origin = scanner.nextLine();
//                 System.out.print("Enter Character Status: ");
//                 Status = scanner.nextLine();
//                 System.out.print("Enter Character Wallet: ");

//                while (!scanner.hasNextInt())
//                {
//                 System.out.println("Invalid Input. Please Enter a Whole Number");
//                 scanner.nextLine();
//                 System.out.print("Enter Character Wallet: ");
//                }
//                 Wallet = scanner.nextInt();
//                 scanner.nextLine(); 

//             Pirate newPirate = null;
//             Marine newMarine = null;
//             PirateHunter newHunter = null;
//             Civilian newCivilian = null;

//             switch (choice)
//             {
//                 case 1:
//                     System.out.print("Enter Character Bounty: ");
//                     Bounty = scanner.nextInt();
//                     scanner.nextLine();
                    
//                     System.out.print("Enter Character Pirate Role: ");
//                     PirateRole = scanner.nextLine();

//                     // scanner.nextLine();

//                     newPirate = new Pirate(CharacterName, Alias, Origin, Status, Wallet, Bounty, PirateRole);

//                     characterDB.addCharacter(newPirate);
//                     characterDB.addPirate(newPirate);
//                     System.out.println("Pirate Created, Hello " + CharacterName + "!");
//                     break;


//                 case 2:

//                     System.out.print("Enter Character Combat Style: ");
//                     CombatStyle = scanner.nextLine();
//                     newHunter = new PirateHunter(CharacterName, Alias, Origin, Status, Wallet, CombatStyle);
//                     characterDB.addCharacter(newHunter);
//                     characterDB.addPirateHunter(newHunter);
//                     System.out.println("Pirate Hunter Created, Hello " + CharacterName + "!");
//                     break;

//                 case 3:


//                     System.out.print("Enter Character Rank: ");
//                     Rank = scanner.nextLine();

//                     newMarine = new Marine(CharacterName, Alias, Origin, Status, Wallet, Rank);
//                     characterDB.addCharacter(newMarine);
//                     characterDB.addMarine(newMarine);
//                     System.out.println("Marine Created, Hello " + CharacterName + "!");
//                     break;


//                 case 4:


//                     System.out.print("Enter Character Profession: ");
//                     Profession = scanner.nextLine();
//                     System.out.print("Enter Character Residence: ");
//                     Residence = scanner.nextLine();

//                     newCivilian = new Civilian(CharacterName, Alias, Origin, Status, Wallet, Profession, Residence);
                    
//                     characterDB.addCharacter(newCivilian);
//                     characterDB.addCivlian(newCivilian);
//                     System.out.println("Civillian Created, Hello " + CharacterName + "!");
//                     break;


//                 case 5:


//                     Driver.displayCharacterMenu();
//                     break;


//                 default:
//                     System.out.println("Invalid Choice. Please try again.");
//                     createCharacter();
//                     break;
                    
//             }



//         } 
//         else 
//         {
//             System.out.println("Invalid choice. Please pick again.");
//             createCharacter();
//         }
//     }

//     private static void viewCharacter() 
//     {

//         if(ifCharMapIsEmpty() == true) 
//             return;
//         System.out.println("--- View a Character ---");
//         characterDB.displayCharacters();

      
//         System.out.print("Enter Character ID to view: ");
//         if(scanner.hasNextInt()){
//         int characterID = scanner.nextInt();

//         Character character = characterDB.getCharacter(characterID);
//         if (character != null)
//         {
//             character.DisplayProfile();
//         }
//         else
//         {
//             System.out.println("Character not found.");
//             viewCharacter();

//         }


//     }
// }

//     private static void updateCharacter()
//     {      
//         if(ifCharMapIsEmpty() == true) return;
        
//         characterDB.displayCharacters();


//         System.out.println("Enter Character ID to update: ");
//         int characterID = scanner.nextInt();
 
//         Character character = characterDB.getCharacter(characterID);

//         if (character != null)
//         {
//             System.out.println("Choose Attribute to Update: ");
//             System.out.println("[1] Name");
//             System.out.println("[2] Alias");
//             System.out.println("[3] Origin");
//             System.out.println("[4] Status");
//             System.out.println("[5] Wallet");

//             if(character.getType().contains("Pirate")){
//                 System.out.println("[6] Bounty");
//                 System.out.println("[7] Pirate Role");
//             } else if(character.getType().contains("Marine")){
//                 System.out.println("[6] Rank");

//             } else if(character.getType().contains("Pirate Hunter")){
//                 System.out.println("[6] Combat Style");
                
//             } else if(character.getType().contains("Civilian")){
//                 System.out.println("[6] Profession");
//                 System.out.println("[7] Residence");
//             } 
            
            
//             System.out.print("Choice: ");

//             int choice = scanner.nextInt();
//             scanner.nextLine(); // Consume the newline character
//             if(checkIfValidOption(1, 5, choice)==false) updateCharacter();

//             switch (choice)
//             {
//                 case 1:
//                     System.out.print("Enter new Name: ");
//                     String newName = scanner.nextLine();
//                     character.setName(newName);
//                     System.out.println("Name updated successfully.");
//                     break;

//                 case 2:
//                     System.out.print("Enter new Alias: ");
//                     String newAlias = scanner.nextLine();
//                     character.setAlias(newAlias);
//                     System.out.println("Alias updated successfully.");
//                     break;
//                 case 3:
//                     System.out.print("Enter new Origin: ");
//                     String newOrigin = scanner.nextLine();
//                     character.setOrigin(newOrigin);
//                     System.out.println("Origin updated successfully.");
//                     break;
//                 case 4:
//                     System.out.print("Enter new Status: ");
//                     String newStatus = scanner.nextLine();
//                     character.setAlias(newStatus);
//                     System.out.println("Status updated successfully.");
//                     break;
//                 case 5: 
//                     System.out.print("Enter new Wallet: ");

//                     while (!scanner.hasNextInt())
//                     {
//                         System.out.println("Invalid Input. Please Enter a Whole Number");
//                         scanner.nextLine();
//                         System.out.print("Enter new Wallet: ");
//                     }
                    
//                     int newWallet = scanner.nextInt();
//                     character.setWallet(newWallet);
//                     System.out.println("Wallet updated successfully.");
//                     break;
//                 case 6: 
                    
//                     if(character instanceof Pirate){

//                         Pirate newPirate = (Pirate) character;
       
//                         System.out.print("Set a new bounty [1] or add to the current one [2]?");
//                         int bountyChoice = scanner.nextInt();
//                         int money = 0;

//                         switch(bountyChoice){
//                             case 1: 
//                             System.out.println("How much is " + character.getName() + "'s new bounty?");
//                             money = scanner.nextInt();
//                             newPirate.setBounty(money);
//                             System.out.println("Bounty updated successfully");

//                             break;
//                             case 2:
//                             System.out.println("How much is going to be added to " + character.getName() + " bounty?");
//                             money = scanner.nextInt();
//                             newPirate.ModifyBounty(money);
//                             System.out.println("The new total bounty for " + newPirate.getName() + " is " + newPirate.getBounty());

//                             break;
//                             default: 
//                                 System.out.println("Invalid choice. Please try again.");
//                                 updateCharacter();
//                                 return;
//                         }

//                     } else if(character instanceof Marine){
//                         Marine newMarine = (Marine) character;
//                         System.out.print("Enter new Marine Rank: ");
//                         String newRank = scanner.nextLine();
//                         newMarine.setRank(newRank);
//                         System.out.println("Rank updated successfully.");
                        
                        
//                     } else if(character instanceof PirateHunter){
//                         PirateHunter newPirateHunter = (PirateHunter) character;
//                         System.out.print("Enter new Combat Style: ");
//                         String combatStyle = scanner.nextLine();
//                         newPirateHunter.setCombatStyle(combatStyle);
//                         System.out.println("Combat Style updated successfully.");
                        
                        
//                     } else if(character instanceof Civilian){
//                         Civilian newCivilian = (Civilian) character;
//                         System.out.print("Enter new Profession: ");
//                         String profession = scanner.nextLine();
//                         newCivilian.setProfession(profession);
//                         System.out.println("Profession updated successfully.");
                                  
//                     }

//                 break;
//                 case 7:

//                     if(character instanceof Pirate){

//                         Pirate newPirate = (Pirate) character;
       
//                         System.out.print("Enter the new role: ");
//                         String newRole = scanner.nextLine();
//                         newPirate.setPirateRole(newRole);
//                         System.out.println("Pirate Role updated successfully");
//                         }
                        
//                         else if(character instanceof Civilian){
//                         Civilian newCivilian = (Civilian) character;
//                         System.out.print("Enter New Residence: ");
//                         String residence = scanner.nextLine();
//                         newCivilian.setResidence(residence);
//                         System.out.println("Residence updated successfully.");
                                  
//                     } else if(character instanceof Marine){
//                         System.out.println("Invalid choice. Please try again.");
//                         updateCharacter();
//                         return;   
//                     }
 
//                 default:
//                     System.out.println("Invalid choice. Please try again.");
//                     updateCharacter();
//                     return;

//             }
//             characterDB.rewriteCharacterFile();
//         }
//         else
//         {
//             System.out.println("Character not found.");
//             updateCharacter();
//         }

//     }

//     private static void deleteCharacter()
//     {
//         if(ifCharMapIsEmpty() == true) return;

//         characterDB.displayCharacters();

//         System.out.print("Enter Character ID to delete: ");

//         if(scanner.hasNextInt()){
//             int characterID = scanner.nextInt();
//             scanner.nextLine();

//             Character character = characterDB.getCharacter(characterID);

//             if (character != null)
//             {

//                 if (character.getStatus().equalsIgnoreCase("DEAD"))
//                 {
//                     System.out.println(character.getName() + " is already Dead!");
//                 }
//                 else
//                 {
//                 System.out.println(character.getName() + " has been Deleted.");
//                characterDB.removeCharacter(character);
//                     if (character instanceof Marine)
//                     {
//                         Marine marine = (Marine) character;

//                         if (marine.getMarineCorps()!=null)
//                         {
//                            marine.getMarineCorps().removeMarineMember(marine);
//                         }
//                         affiliationDB.rewriteCorpFile();
//                     }
//                     else if ( character instanceof Pirate)
//                     {
//                         Pirate pirate = (Pirate) character;
//                         if (pirate.getPirateCrew()!=null)
//                         {
//                            pirate.getPirateCrew().removeCrewMember(pirate);
//                         }
//                         affiliationDB.rewriteCrewFile();
//                     }
//                 devilFruitDB.rewriteFruitFile();
//                 }

//             }
//             else
//             {
//             System.out.println("Character ID not found.");
//             deleteCharacter();
//             }
//         } else {
//             System.out.println("Invalid Choice.");
//             deleteCharacter();
//         }

//     }

// /* The method views the dead characters

// @param none
// @return void

// */

// private static void viewDeletedCharacters()
// {
//     characterDB.displayDeadCharacter();
// }


}
