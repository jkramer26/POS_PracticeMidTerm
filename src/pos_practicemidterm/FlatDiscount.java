
package pos_practicemidterm;

/**
 * This class implements the discount strategy. It is responsible for calculating 
 * a discount amount based on a flat discount rate.
 * 
 * @Jessica Kramer
 */

public class FlatDiscount implements DiscountStrategy {
    private double flatDiscountRate = 3;
    private double discountAmount;
    private double discount;

    
    /**
     * This method calculates a flat discount rate by taking the unit price of a
     * product and subtracting it by the rate
     * @param unitPrice The unit price for a product
     * @return Will only return a discount amount if it is greater than 0 dollars
     */
    @Override
    public double getProductDiscount(double unitPrice) {
        discountAmount = (unitPrice - flatDiscountRate);
        if(discountAmount < 0) {
            throw new IllegalArgumentException();
        }
        return discount;
    }
    
    
}
