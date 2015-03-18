import static org.junit.Assert.*;
import java.util.Arrays;

/***************************************************************************
Scott Lim
2/27/2015

Filename: StampDispenser.java
File Description: Facilitates dispensing stamps for a postage stamp machine.
Acknowledgements: Russell Impagliazzo - for the topic of "Dynamic Programming"
                  Wikipedia - for a refresher on dynamic programming
***************************************************************************/ 

public class StampDispenser
{                 
  int[] denominations;       // Array used to hold the inputted denominations
  int numOfDenom;            // The number of denominations available
  
  /**
   * Constructs a new StampDispenser that will be able to dispense the given 
   * types of stamps.
   *
   * @param stampDenominations The values of the types of stamps that the 
   *     machine should have.  Should be sorted in descending order and 
   *     contain at least a 1.
   */
  public StampDispenser(int[] stampDenominations)
  {
    // Preserve input denominations for future use
    denominations = stampDenominations;
    // Preserve the number of denominations for future use
    numOfDenom = stampDenominations.length;
  }
  
  /**
   * Returns the minimum number of stamps that the machine can dispense to
   * fill the given request. Utilizes dynamic programming techniques to
   * search for all possible combinations of stamps for a given request.
   *
   * @param request The total value of the stamps to be dispensed.
   */
  public int calcMinNumStampsToFillRequest(int request) {
    
    /* An array that holds the minimum number of stamps are required to make 
     * requests from 0 to the desired number. The request will correspond to
     * the index of the array, and the value at the index will be the minimum
     * number of stamps required for that request.
     */
    int[] allMinStamps = new int[request+1];
    
    /* A temporary array that is used to help fill up the allMinStamps array.
     * It calculates the number of stamps needed using the denominations as 
     * the first value.
     */
    int[] tempArray = new int[numOfDenom];
    
    /* We iterate through all elements in allMinStamps. The indices are treated
     * as requests and the number of required stamps to fulfil the request is 
     * stored at the index. The subrequest can be used to help fill larger 
     * requests, thus utilizing the dynamic programming appraoch.
     */
    for (int subRequest = 1; subRequest <= request; subRequest++) {   
      
      /* Initialize all elements in tempArray to -1 since no requests can
       * be less than 0. Using -1 allows us to figure out if the request
       * can be made using the corresponding denomination.
       */
      Arrays.fill(tempArray,0,numOfDenom, -1);
      
      // Iterate through all denominations to check if request can be filled
      for (int i = 0; i < numOfDenom; i++){
        // If the sub-request is greater than the denomination, request can be fulfilled.
        if (subRequest >= denominations[i]) {
          /* Fill in allMinStamps. If the sub-request is equal to a denomination, then
           * (sub-request-denomination[i]) + 1 will equal 1, which is correct. Otherwise,
           * we will break the request into sub-requests and total up the number of stamps
           * required for each subrequest.
           */
          tempArray[i] = allMinStamps[subRequest - denominations[i]] + 1;
        }
      }
      
      // Reset the value at the sub-request for future use
      allMinStamps[subRequest] = -1;
      
      /* Now we iterate through the array to find out which denomination resulted
       * in the smallest value and store it.
       */
      for (int i = 0; i < numOfDenom; i++) {
        // Make sure that the using this denomination is possible
        if (tempArray[i] != -1) {
          // Fill the minimum number of stamps at sub-request if not filled yet
          if( allMinStamps[subRequest] == -1){
            allMinStamps[subRequest] = tempArray[i];
          } 
          // Replace value at allMinStamps if any value in tempArray is smaller
          if( tempArray[i] < allMinStamps[subRequest]){
            allMinStamps[subRequest] = tempArray[i];
          }
        }
      }
    }
    
    // allMinStamps[request] will contain the minimum number of stamps needed to fulfill request
    return allMinStamps[request];
  }
  
  
  public static void main(String[] args){
    int[] denominations = {90,30,24,10,6,2,1};
    int[] denominations2 = {512,256,128,64,32,16,8,4,2,1};
    
    StampDispenser stampDispenser = new StampDispenser(denominations);
    StampDispenser stampDispenser2 = new StampDispenser(denominations2);
    
    assertEquals(stampDispenser.calcMinNumStampsToFillRequest(18), 3);
    assertEquals(stampDispenser2.calcMinNumStampsToFillRequest(666), 5);
    assertEquals(stampDispenser.calcMinNumStampsToFillRequest(9034), 102);
    
    assertEquals(stampDispenser.calcMinNumStampsToFillRequest(1),1);
    assertEquals(stampDispenser.calcMinNumStampsToFillRequest(2) ,1);
    assertEquals(stampDispenser.calcMinNumStampsToFillRequest(5) ,3);
    assertEquals(stampDispenser.calcMinNumStampsToFillRequest(34), 2);
    assertEquals(stampDispenser.calcMinNumStampsToFillRequest(72) , 3);
    
    System.out.println("All Tests Passed.");
  }
  
}

