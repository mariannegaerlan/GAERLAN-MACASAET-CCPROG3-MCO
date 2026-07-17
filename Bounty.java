import java.util.ArrayList;

/**
 * This class is the Bounty class that deals with the bounty of the Pirate Class
 * Contributed by: Marianne Gaerlan 
 */



public class Bounty {

    private final int captureID;
    private static int count= 0;
    private ArrayList<String> bountyHistory = new ArrayList<>();
    private Pirate capturedPirate;
    private Character captor;


    Bounty()
    {
        this.captureID = ++count;

    }


    
    public int getCaptureID()
    {
        return this.captureID;
    }

    public ArrayList<String> getBountyHistory()
    {
        return this.bountyHistory;
    }

    public Pirate getCapturedPirate()
    {
        return this.capturedPirate;
    }
    public Character getCaptor()
    {
        return this.captor;
    }



/** validCaptor checks if the captor is able to cash in the bounty
*
*@param none
*@return boolean
*/
    public boolean validateCaptor()
    {

        if (captor.getType().equals("Marine") || captor.getType().equals("PirateHunter") || captor.getType().equals("Civilian") )
        {
            return true;
        }
        return false;

    }

/** processTargetStatus mutates the pirates status
 * 
 * @param none
 * @return void
 */

    public void processTargetStatus()
    {
        PirateCrew crew = capturedPirate.getPirateCrew();

        crew.getTotalBounty();

        if (capturedPirate.getStatus().equalsIgnoreCase("Alive"))
        {
        capturedPirate.setStatus("Captured");
        crew.modifyCrewBounty(capturedPirate);


        }


        if  (capturedPirate.getStatus().equalsIgnoreCase("Dead"))
        {
        capturedPirate.getDFPower().triggerReincarnation();
        crew.removeCrewMember(capturedPirate);
        capturedPirate.setBounty(0);
        }


    }

/** routeFinancialRewards adds bounty to the captors wallet
 * 
 * @param none
 * @return void
 */

    public void routeFinancialRewards()
    {

        if (captor instanceof Marine)
        {
            Marine marine = (Marine) captor;
            MarineCorps corps = marine.getMarineCorps();

            corps.setOperationalFunds(corps.getOperationalFunds() + capturedPirate.getBounty());

        }
        else if (captor instanceof PirateHunter)
        {
            PirateHunter hunter = (PirateHunter) captor;

            hunter.setWallet(hunter.getWallet()+ capturedPirate.getBounty());

        }
        else if (captor instanceof Civilian)
        {
            Civilian civilian = (Civilian) captor;

            civilian.setWallet(civilian.getWallet()+ capturedPirate.getBounty());            
        }
        else
        {
            System.out.println(" A Pirate cannot capture another Pirate.");
            return;
        }
        
        

    }

/** logTransaction logs the capture 
 * 
 * @param none
 * @return void
 */

    public void logTransaction()
    {

        bountyHistory.add(captor.getName() + "has captured" + capturedPirate.getName());
        
    }
    
}
