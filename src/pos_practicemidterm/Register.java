package pos_practicemidterm;

/**
 *
 * @author kramerj
 */
public class Register {
    Receipt receipt;
    public static int receiptNum;
    
    //get item number and quantity
    /**
     * Method that starts a new transaction and creates a new receipt object
     * @param customerId Passes in the id of a customer
     */
    public void startNewTransaction(String customerId, DatabaseStrategy db) {
        receipt = new Receipt(customerId, db);
        
        receiptNum++;
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
