
package pos_practicemidterm;

/**
 *  This is an interface called Receipt Strategy. It is an abstraction class
 *  that other receipt classes implement. 
 * 
 * @author Jessica Kramer
 */
public interface ReceiptStrategy {
    
    /**
     * This method will output a receipt
     */
    public abstract void outputReceipt();
    
    /**
     * This method will add items to the line item class
     * @param productId
     * @param qty 
     */
    public abstract void addLineItem(String productId, int qty);
    
    
    
    
    
}
