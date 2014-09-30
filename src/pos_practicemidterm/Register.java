
package pos_practicemidterm;

/**
 *
 * @author kramerj
 */
public class Register {
    private Store store;
    private FakeDatabase db;
    private double transactionNumber;
    private String productId;
    private int quantity;
    
    //get item number and quantity
    public void startNewTransaction(double transactionNumber, String productId, int quantity) {
        this.transactionNumber = transactionNumber;
        this.productId = productId;
        this.quantity = quantity;
    }
    
    //addItem method
    public void addProduct() {
        
    }
    
    //calculate 
    
    
}
