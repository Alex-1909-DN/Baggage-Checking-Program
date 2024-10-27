/**
 * The Baggage class represents a piece of baggage with specific dimensions and weight.
 * It includes methods to get and set the dimensions and weight of the baggage.
 * It also provides functionality to check if the baggage can be used as a carry-on and to calculate any applicable surcharges.
 */
public class Baggage {
    // Dimensions of the baggage in centimeters
    private int length, width, height;
    // Weight of the baggage in kilograms
    private double weight;

    // Default values for dimensions and weight
    private static final int DEFAULT_LENGTH = 65;
    private static final int DEFAULT_WIDTH = 25;
    private static final int DEFAULT_HEIGHT = 50;
    private static final double DEFAULT_WEIGHT = 10.0;

    /**
     * Default constructor initializes baggage with default dimensions and weight.
     */
    public Baggage() {
        this(DEFAULT_LENGTH, DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_WEIGHT);
    }

    /**
     * Parameterized constructor initializes baggage with specified dimensions and weight.
     * 
     * @param length The length of the baggage in centimeters.
     * @param width The width of the baggage in centimeters.
     * @param height The height of the baggage in centimeters.
     * @param weight The weight of the baggage in kilograms.
     */
    public Baggage(int length, int width, int height, double weight) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    /**
     * Gets the length of the baggage.
     * @return The length of the baggage in centimeters.
     */
    public int getLength() {
        return length;
    }

    /**
     * Sets the length of the baggage.
     * @param length The length of the baggage in centimeters.
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Gets the width of the baggage.
     * @return The width of the baggage in centimeters.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the width of the baggage.
     * @param width The width of the baggage in centimeters.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Gets the height of the baggage.
     * @return The height of the baggage in centimeters.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the height of the baggage.
     * @param height The height of the baggage in centimeters.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Gets the weight of the baggage.
     * @return The weight of the baggage in kilograms.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the weight of the baggage.
     * @param weight The weight of the baggage in kilograms.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Returns a string representation of the baggage, including its dimensions and weight.
     * Also indicates whether the baggage can be used as a carry-on and if there is any weight surcharge.
     * @return A formatted string describing the baggage and any applicable carry-on or surcharge information.
     */
    @Override
    public String toString() {
        String result = String.format("This bag has length %d cm, width %d cm, height %d cm, and weight %.2f kg.\n", length, width, height, weight);

        // Check if the baggage can be used as a carry-on
        if (BaggageChecker.isCarryOn(this)) {
            result += "This bag can be used as a carry-on.\n";
        }

        // Check if the baggage is overweight and calculate the surcharge if applicable
        if (BaggageChecker.allowedWeightIsMoreThanMax(this)) {
            double surcharge = BaggageChecker.calculateWeightSurcharge(this);
            double maxRegularWeight = BaggageChecker.MAX_REGULAR_WEIGHT;
            result += String.format("This bag is overweight; it exceeds the allowed weight of %.2f kg. A surcharge of $%.2f applies.\n",
                    maxRegularWeight, surcharge);
        }

        return result;
    }
}
