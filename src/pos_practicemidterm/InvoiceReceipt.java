
package pos_practicemidterm;

/**
 * This class represents a simulation of a receipt that is in the layout of 
 * an invoice.
 * It is responsible for managing miscellaneous receipt, customer and line item information. 
 * It also serves as a high-level service class, delegating to varying data access strategies 
 * and output strategies.
 * 
 * @author Jessica Kramer
 */
public class InvoiceReceipt implements ReceiptStrategy {
    
    @Override
    public void addLineItem(String productId, int qty) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void outputReceipt() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
