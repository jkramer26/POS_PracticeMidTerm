
package pos_practicemidterm;

/**
 * This is an interface for called Discount Strategy. It is an abstraction class
 * that other discounts implement. 
 * 
 * @Jessica Kramer
 */

public interface DiscountStrategy {
    
    /**
     * This method will get the discount for a product & will be overridden
     * in the classes that implement it.
     * @param unitPrice Passes in a product's unit price
     * @return Will return a discount for a product
     */
    public abstract double getProductDiscount(double unitPrice, int qty);
    
}
