package pos_practicemidterm;

/**
 * This class represents a simulation of a register in a retail sales situation. 
 * It is responsible for creating a receipt and for passing in new products & 
 * their quantities. 
 * 
 * @author Jessica Kramer
 */
public class Register {
    ReceiptStrategy receipt;                //creating an instance variable of Receipt Strategy
    public static int receiptNumber = 0;    //global variable that stores the number of a receipt
    
    
    /**
     * Method that starts a new transaction. Creates a new receipt object and 
     * increments a the receipt number every time a new transaction is started
     * @param receipt This passes in a receipt object that cannot be null
     */
    public void startNewTransaction(ReceiptStrategy receipt) {
        if(receipt == null) {
            throw new IllegalArgumentException();
        }  
        this.receipt = receipt;
        receiptNumber++;
        
    }

    
    /**
     * Method that adds another item to the transaction. 
     * This method delegates to the receipt class to add another line item
     * @param productId  Passes in the product id of the item
     * @param quantity   Passes in the quantity of the item
     */
    public void addItem(String productId, int quantity) {
        receipt.addLineItem(productId, quantity);
        
    }
    
    /**
     * This method ends a transaction and will have the receipt class
     * output a receipt
     */
    public void endTransaction(){
        receipt.outputReceipt();
    }
    
    
    
    
    
    
    
    
    
//    public static void main(String[] args) {
//        DatabaseStrategy db = new FakeDatabase();
//        Register r = new Register();
//        r.startNewTransaction("CB_101", db);
//        
//        r.addItem("A202", 2);
//        
//        r.endTransaction();
//    }
//    
    
}
