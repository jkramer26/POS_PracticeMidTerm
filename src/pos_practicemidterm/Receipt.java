
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
    private DatabaseStrategy db;
    private LineItem item;
    private Customer customer;
    
     
    //private final Customer ... find customer
    public Receipt(String customerId, DatabaseStrategy db) {
         customer = db.findCustomer(customerId);
         this.db = db;
         
    }

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
    
    private String receipt; //variable to output lineItems & their 
    //print receipt method that will loop through item array and output info 
    
    //calculate the total of the lineItems
    private double grandTotal;
    private double calculateGrandTotal() {
        for (LineItem lineItem : lineItems) {
            grandTotal = (grandTotal + lineItem.calculateLineItemTotal());
        }
        return grandTotal;
    }
    
    private String printReceipt() {
        for (LineItem lineItem : lineItems) {
            lineItem.printLineItem();
        }
        
        System.out.println("GrandTotal: " + calculateGrandTotal());
        
        return receipt;
    }
    
    public static void main(String[] args) {
        FakeDatabase d = new FakeDatabase();
        
//        LineItem line = new LineItem("A202", d, 2);
//        LineItem line2 = new LineItem("F485", d, 2);
//        LineItem line3 = new LineItem("E404", d, 2);
//        
        
        Receipt receipt = new Receipt("CB_101", d);
        System.out.println("First Receipt");
        receipt.addLineItem("A202", 2);
        receipt.addLineItem("F485", 2);
        receipt.addLineItem("E404", 2);
        receipt.printReceipt();
        System.out.println("__________________________________");
        
        Receipt receipt2 = new Receipt("CB_202", d);
        System.out.println("Second Receipt");
        receipt2.addLineItem("A202", 2);
        receipt2.addLineItem("F485", 2);
        receipt2.addLineItem("E404", 2);
        receipt2.printReceipt();
        System.out.println("__________________________________");
        
        Receipt receipt3 = new Receipt("CB_303", d);
        System.out.println("Third Receipt");
        receipt3.addLineItem("A202", 2);
        receipt3.addLineItem("F485", 2);
        receipt3.addLineItem("E404", 2);
        receipt3.printReceipt();
        System.out.println("__________________________________");
        
        
        
    }
    
}
