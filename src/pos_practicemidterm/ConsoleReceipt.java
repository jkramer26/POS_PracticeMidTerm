
package pos_practicemidterm;

import java.text.NumberFormat;

/**
 * This class represents a simulation of a real receipt in a retail sales situation. 
 * It is responsible for managing miscellaneous receipt, customer and line item information. 
 * It also serves as a high-level service class, delegating to varying data access strategies 
 * and output strategies. 
 * This receipt will output to the console.
 * 
 * @Jessica Kramer
 */
public class ConsoleReceipt implements ReceiptStrategy {
    private DatabaseStrategy db;        //DatabaseStrategy instance variable
    private Customer customer;          //Customer instance variable
    //private Store store;
    private LineItem [] lineItems;      //variable name for an array 
    private double grandTotal = 0;          //variable that holds the grandtotal of all line items
    private double discountGrandTotal = 0;  //variable that holds the total discount for all line items
    
    //below are constants used for formatting the receipt
    //all are global and able to be accessed by other classes
    private final String LONG_SOLID_LINE = "____________________________________________________________________________________________________";
    private final String LONG_DOTTED_LINE = "---------------------------------------------------------------------------------------------------";
    private final String FOUR_TABS_OF_TWO = "\t\t \t\t \t\t \t\t";
    
    NumberFormat formatter = NumberFormat.getCurrencyInstance();

    
    /**
     * This is a constructor that passes in a customer id and a database 
     * object. The method finds a customer's id in a database and also initializes
     * an array. The parameters will only be passed in if they are not null
     * or empty. 
     * @param customerId Passes in a customer's id
     * @param db Passes in a database strategy object
     */
    public ConsoleReceipt(String customerId, DatabaseStrategy db) {
         if(customerId == null || customerId.isEmpty() || db == null) {
             throw new IllegalArgumentException();
         }
         customer = db.findCustomer(customerId);
         this.db = db;
         lineItems = new LineItem[0];   //this is an array to store line items within
    }

    /**
     * Adds a line item to the receipt
     * @param productId Unique identifier for a product
     * @param qty    The quantity of the product purchased
     */
    @Override
    public void addLineItem(String productId, int qty) {
        if(productId == null || productId.isEmpty() ||
                qty < 0) {
            throw new IllegalArgumentException();
        }
        LineItem item = new LineItem(productId, db, qty);
        addToArray(item);
    }
    
   
    /**
     * A private method to resize an existing array.
     * Makes a temporary array one size larger than lineItems array
     * and then copies lineItems into the tempItems. 
     * New item is added to tempArray and then lineItem array copies the tempArray
     * @param item passes in a lineItem to the array
     */
    private void addToArray(final LineItem item) {
        // needs validation
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = item;
        lineItems = tempItems;
    }
    
    /**
     * A private method that will calculate the total discount for all the line items
     * @return Will return the total discount
     */
    private double calculateDiscountGrandTotal(){
        for (LineItem lineItem : lineItems) {
            discountGrandTotal = (discountGrandTotal + lineItem.getLineItemDiscountTotal());
        }
        return discountGrandTotal;
    }
    
    /**
     * Method that calculates the total of all line items
     * @return Will return a grand total
     */
    private double calculateGrandTotal() {
        for (LineItem lineItem : lineItems) {
            grandTotal = (grandTotal + lineItem.calculateLineItemTotal());
        }
        return grandTotal;
    }
    
    /**
     * Method that will print out a receipt with all line items and a grand total
     * while formatting all the information. 
     */
    //make the println's below be final variables and store them at the top above
    @Override
    public void outputReceipt() {
        
        System.out.println(LONG_SOLID_LINE);
        System.out.println(LONG_SOLID_LINE);
        System.out.println("Receipt #: " + Register.receiptNumber);
        System.out.println("Customer Name: " + customer.getCustomerName() + "\n\n");
        System.out.println("Product \t" + "Product Description \t" + "Unit Price \t" + "Qty \t" 
                            + "\t Subtotal ");
        System.out.println(LONG_DOTTED_LINE);
        
        for (LineItem lineItem : lineItems) {
            System.out.println(lineItem.printLineItem());
        }
        
        System.out.print(FOUR_TABS_OF_TWO + "--------------------\n");
        
        System.out.println(FOUR_TABS_OF_TWO + "GrandTotal: " + formatter.format(calculateGrandTotal()));
        System.out.println(FOUR_TABS_OF_TWO + "____________________");
        System.out.println("\n \t\t\t YOU SAVED: " + formatter.format(calculateDiscountGrandTotal()));
        System.out.println(LONG_SOLID_LINE);
        System.out.println(LONG_SOLID_LINE + "\n\n");
    }
    
    
}
