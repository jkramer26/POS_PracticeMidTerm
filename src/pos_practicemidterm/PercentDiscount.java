
package pos_practicemidterm;
//could expand this into a further abstraction
//have a percentDiscountStrat then have seperate classes with different percentage discounts

/**
 * This class implements the discount strategy. It is responsible for calculating 
 * a discount amount based on a percentage.
 * 
 * @Jessica Kramer
 */

public class PercentDiscount implements DiscountStrategy {
    
    private double discountAmount; //variable that holds the discount amount
    
    
    /**
     * This method calculates a discount based on a percentage & a product's unit price
     * @param unitPrice The price of a product
     * @return Discount will be returned as long as it is greater than 0
     */
    @Override
    public double getProductDiscount(double unitPrice) {
        discountAmount = (unitPrice * .10);
        if(discountAmount < 0) {
            throw new IllegalArgumentException();
        }
        return discountAmount;
    }
    
    
}
