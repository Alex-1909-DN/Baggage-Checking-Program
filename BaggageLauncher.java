/**
 * Description: This program interacts with the user to input baggage details, processes them,
 *              and provides a summary of the valid baggage entries.
 */


/**
 * Class: BaggageLauncher
 * Description: This class contains the main method for running the Baggage Handler Software Program.
 */
public class BaggageLauncher {

    /**
     * The main method runs the Baggage Handler Software Program.
     * It prompts the user for baggage details, validates the input, and
     * calculates and displays the total number of valid bags and their total weight.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
    
        double totalBaggageMass = 0.0;
        int count = 0;
        int length, width, height;
        double weight;
        String response;

        System.out.println("Welcome to the Baggage Handler Software Program");
        
        do {
            // Prompt the user for baggage dimensions and weight, validating input
            length = InputData.validateInt("Enter the length of the baggage (in cm): ");
            width = InputData.validateInt("Enter the width (in cm): ");
            height = InputData.validateInt("Enter the height (in cm): ");
            weight = InputData.validateDouble("Enter the weight (in kg): ");
        
            // Create a new Baggage object with the provided dimensions and weight
            Baggage baggage = new Baggage(length, width, height, weight);
            
            // Check if the baggage exceeds the maximum allowed dimensions
            if (BaggageChecker.sumDimensionsExceedsMax(baggage)) {
                System.out.println("This is oversized; it is not acceptable.\n");
            } else {
                // Display baggage details and update total weight and count
                String str = baggage.toString();
                System.out.println(str);
                totalBaggageMass += baggage.getWeight();
                count += 1;
            }

            // Ask the user if they wish to continue entering data
            response = InputData.validateString("Do you wish to continue? Enter 'No' to quit, anything else to continue: ");
    
        } while (!response.equalsIgnoreCase("no"));
        
        // Display the final summary of valid baggage processed
        System.out.printf("The total number of valid bags entered was: %d\n", count);
        System.out.printf("The total weight entered was: %.2f kg\n", totalBaggageMass);
        System.out.println("The program has terminated.");
    }
}
