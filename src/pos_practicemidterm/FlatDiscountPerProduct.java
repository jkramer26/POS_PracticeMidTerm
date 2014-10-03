
package pos_practicemidterm;

/**
 * This class implements the discount strategy. It is responsible for calculating 
 * & adding the discount amount per product based on a flat discount rate.
 * 
 * @Jessica Kramer
 */

public class FlatDiscountPerProduct implements DiscountStrategy {
    private double flatDiscountRate = 2;   //the flat rate discount amount
    private double totalProductDiscount;   //the price of product after discount if taken off

    
    /**
     * This method will calculate the total discount amount for the total 
     * number of products
     * @param unitPrice The unit price for a product
     * @param qty This is the quantity of a product
     * @return Will only return the discount amount is greater than 0
     */
    @Override
    public double getProductDiscount(double unitPrice, int qty) {
        totalProductDiscount = (qty * flatDiscountRate);
        if(totalProductDiscount <= 0) {
            throw new IllegalArgumentException();
        }
        return totalProductDiscount;
    }
    
    
}
