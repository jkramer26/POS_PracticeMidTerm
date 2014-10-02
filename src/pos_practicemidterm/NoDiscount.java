
package pos_practicemidterm;

/**
 * This class implements the discount strategy. It is responsible for making sure 
 * that there is not a discount amount. 
 * 
 * @Jessica Kramer
 */

public class NoDiscount implements DiscountStrategy {

    /**
     * This method will return a discount amount of 0 no matter what the product price is
     * @param unitPrice The price of a product
     * @return Will return 0 since we do not want a discount amount
     */
    @Override
    public double getProductDiscount(double unitPrice) {
        return 0;
    }
    
    
}
