
package pos_practicemidterm;

/**
 * This class implements the discount strategy. It is responsible for calculating 
 * a discount amount based on a flat discount rate.
 * 
 * @Jessica Kramer
 */

public class FlatDiscount implements DiscountStrategy {
    private double flatDiscountRate = 3;        //the flat rate discount amount
    private double productPriceAfterDiscount;   //the price of product after discount if taken off

    
    /**
     * This method will return a flat rate discount amount
     * @param unitPrice The unit price for a product
     * @return Will only return the discount amount if the price of the product
     * after the flat rate is taken off is greater than 0
     */
    @Override
    public double getProductDiscount(double unitPrice, int qty) {
        productPriceAfterDiscount = (unitPrice * qty - flatDiscountRate);
        if(productPriceAfterDiscount < 0) {
            throw new IllegalArgumentException();
        }
        return flatDiscountRate;
    }
    
    
}
