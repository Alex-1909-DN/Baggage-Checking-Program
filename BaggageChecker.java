/**
 * The BaggageChecker class provides methods to evaluate baggage based on various criteria.
 * It includes methods to check if the baggage exceeds weight limits, calculate surcharges, and verify if it can be used as a carry-on.
 */
public class BaggageChecker {

    // Constant for the maximum regular weight allowed for baggage in kilograms
    public static final double MAX_REGULAR_WEIGHT = 22.0;
    // Constant for the surcharge per kilogram of overweight baggage
    public static final double SURCHARGE_PER_KG = 3.00;
    // Constant for the maximum allowed dimension for carry-on baggage in centimeters
    public static final int MAX_CARRYON_DIMENSION = 36;
    // Constant for the maximum allowed sum of dimensions for baggage in centimeters
    public static final int MAX_SUM_DIMENSIONS = 192;

    /**
     * Checks if the baggage weight exceeds the maximum allowed weight.
     * @param baggage The baggage to check.
     * @return True if the baggage weight exceeds the maximum weight, otherwise false.
     */
    public static boolean allowedWeightIsMoreThanMax(Baggage baggage) {
        return baggage.getWeight() > MAX_REGULAR_WEIGHT;
    }

    /**
     * Calculates the surcharge for overweight baggage.
     * @param baggage The baggage to calculate the surcharge for.
     * @return The surcharge amount based on the overweight baggage.
     */
    public static double calculateWeightSurcharge(Baggage baggage) {
        double overWeight = 0.0;
        if (baggage.getWeight() > MAX_REGULAR_WEIGHT) {
            overWeight = baggage.getWeight() - MAX_REGULAR_WEIGHT;
        }
        return overWeight * SURCHARGE_PER_KG;
    }

    /**
     * Checks if the baggage can be used as a carry-on based on its dimensions.
     * @param baggage The baggage to check.
     * @return True if the baggage dimensions are within the allowed carry-on dimensions, otherwise false.
     */
    public static boolean isCarryOn(Baggage baggage) {
        return baggage.getLength() < MAX_CARRYON_DIMENSION
                && baggage.getHeight() < MAX_CARRYON_DIMENSION
                && baggage.getWidth() < MAX_CARRYON_DIMENSION;
    }

    /**
     * Checks if the sum of the baggage dimensions exceeds the maximum allowed sum.
     * @param baggage The baggage to check.
     * @return True if the sum of the baggage dimensions exceeds the maximum allowed sum, otherwise false.
     */
    public static boolean sumDimensionsExceedsMax(Baggage baggage) {
        int sumDimensions = baggage.getHeight() + baggage.getLength() + baggage.getWidth();
        return sumDimensions > MAX_SUM_DIMENSIONS;
    }
}
