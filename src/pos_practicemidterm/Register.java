package pos_practicemidterm;

/**
 *
 * @author kramerj
 */
public class Register {

    
    LineItem [] lineItems = new LineItem[0];
    private String productId;
    private int quantity;
    
    //get item number and quantity
    public void startNewTransaction(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    //addItem method. Added to lineItem
    public void addItem(String productId, int quantity) {
        
    }

    private void addToArray(final LineItem item) {
        // needs validation
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = item;
        lineItems = tempItems;
    }

    //calculate
    
}
