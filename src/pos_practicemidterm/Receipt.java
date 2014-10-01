
package pos_practicemidterm;

/**
 * This class represents a simulation of a real receipt in a retail sales situation. 
 * It is responsible for managing miscellaneous receipt, customer and line item information. 
 * It also serves as a high-level service class, delegating to varying data access strategies 
 * and output strategies. 
 * @Jessica Kramer
 */
public class Receipt {
    
    private Store store;
    private FakeDatabase db;
    //private double transactionNumber;
    private String productId;
    private int quantity;
    private LineItem item;
    
     
    //private final Customer ... find customer
    
    /**
     * Adds a line item to the receipt
     * @param productId Unique identifier for a product
     * @param qty    The quantity of the product purchased
     */
    public void addLineItem(String productId, int qty) {
         item = new LineItem(productId, db, qty);
         addToArray(item);
    }
    
    //array to store lineItems
    LineItem [] lineItems = new LineItem[0];
    /**
     * A method to resize an existing array.
     * Makes a temporary array one size larger than lineItems array
     * and then copies lineItems into the tempItems. 
     * New item is added to tempArray and then lineItem array copies the tempArray
     * @param item 
     */
    private void addToArray(final LineItem item) {
        // needs validation
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = item;
        lineItems = tempItems;
    }
    
    //just going to output things from register class and total up 
}
