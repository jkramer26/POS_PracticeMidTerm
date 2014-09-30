
package pos_practicemidterm;

/**
 *
 * @author owner
 */
public class Receipt {
    private Register register; 
    private Store store;
    private FakeDatabase db;
    private double transactionNumber;
    private String productId;
    private int quantity;
    
    
    
    //constructor that gets register
    public Receipt(Register register) {
        this.register = register;
    }
    
    
    //create array
    LineItem [] lineItems = new LineItem[0];
    
    
    //just going to output things from register class and total up 
}
