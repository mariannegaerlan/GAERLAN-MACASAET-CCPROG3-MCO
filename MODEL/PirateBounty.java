import java.util.ArrayList;

/**
 * This class is the Bounty class that deals with the bounty of the Pirate Class
 * Contributed by: Marianne Gaerlan 
 */



public class PirateBounty {

    private final int captureID;
    private static int count= 0;
    private ArrayList<String> bountyHistory = new ArrayList<>();
    private Pirate capturedPirate;
    private Character captor;


    public PirateBounty()
    {
        this.captureID = ++count;

    }

    public void setCaptured(Character captured)
    {
        this.capturedPirate = (Pirate) captured;
    }

    public void setCaptor(Character captor)
    {
        this.captor = captor;
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
*@param Character captor
*@return boolean
*/
    public static boolean validateCaptor(Character captor)
    {

        return captor instanceof Captor;

    }

/** processTargetStatus mutates the pirates status
 * 
 * @param none
 * @return void
 */

    public void processTargetStatus()
    {
        PirateCrew crew = capturedPirate.getPirateCrew();



        if (capturedPirate.getStatus().equalsIgnoreCase("Alive"))
        {
        capturedPirate.setStatus("Captured");

        if (crew!=null)
        {
        crew.modifyCrewBounty(capturedPirate);

        }


        }


        if  (capturedPirate.getStatus().equalsIgnoreCase("Dead"))
        {
            if (capturedPirate.getDFPower() !=null)
            {
            capturedPirate.getDFPower().triggerReincarnation();

            }
            if (crew!=null)
            {
            crew.removeCrewMember(capturedPirate);

            }
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
        if (captor instanceof Captor)
        {
            Captor c = (Captor) captor;
            c.claimBounty(capturedPirate.getBounty());
        }
    }

/** logTransaction logs the capture 
 * 
 * @param none
 * @return void
 */

    public void logTransaction()
    {
        bountyHistory.add(" | Captor: " + this.getCaptor().getAlias() + " | Captured: " + this.getCapturedPirate().getName());
        System.out.println(captor.getName() + " has captured " + capturedPirate.getName());
        
    }

    public String FileFormat()
     {

        return "| ID: " + getCaptureID() + "| CAPTOR: " + this.getCaptor().getAlias() + "| CAPTURED: " + this.getCapturedPirate().getName();

     }

}
