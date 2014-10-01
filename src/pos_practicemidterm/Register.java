package pos_practicemidterm;

/**
 *
 * @author kramerj
 */
public class Register {
    Receipt receipt;
    private int customerId; 
    private String productId;
    private int quantity;
    
    
    
    //get item number and quantity
    /**
     * Method that starts a new transaction and creates a new receipt object
     * @param customerId Passes in the id of a customer
     * @param productId Passes in a product the customer has
     * @param quantity  Passes in the quantity of the product
     */
    public void startNewTransaction(int customerId, String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
        
        receipt = new Receipt();
    }

    //addItem method. Added to lineItem
    /**
     * Method that adds another item to the transaction. 
     * This method delegates to the receipt class to add another line item
     * @param productId  Passes in the product id of the item
     * @param quantity   Passes in the quantity of the item
     */
    public void addItem(String productId, int quantity) {
        receipt.addLineItem(productId, quantity);
    }
    
    
}
