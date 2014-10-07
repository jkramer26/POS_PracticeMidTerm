package pos_practicemidterm;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * This class represents a simulation of a receipt outputted to a GUI. It is
 * responsible for managing miscellaneous receipt, customer and line item
 * information. It also serves as a high-level service class, delegating to
 * varying data access strategies and output strategies.
 *
 * @author Jessica Kramer
 */
public class GUIReceipt implements ReceiptStrategy {

    private Customer customer;
    private DatabaseStrategy db;
    private double grandTotal;
    private double discountGrandTotal;
    //creating an array of objects from class LineItem
    private LineItem[] lineItems;
    private String string;
    private String storeMessage;
    private String lineDisplay;
    private final String LONG_SOLID_LINE = "_________________________________________________________________________________________________________________";
    private final String LONG_DOTTED_LINE = " - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ";
    private final String TWO_TAB = "\t\t";
    private final String TAB_TO_CENTER = "      \t          \t          \t            ";

    /**
     *
     * @param customerId
     * @param db
     */
    public GUIReceipt(String customerId, DatabaseStrategy db) {
        if (customerId == null || customerId.isEmpty() || db == null) {
            throw new IllegalArgumentException();
        }

        customer = db.findCustomer(customerId);
        this.db = db;

        lineItems = new LineItem[0]; //this is an array to store line items within
    }

    @Override
    public void addLineItem(String productId, int qty) {
        if (productId == null || productId.isEmpty()
                || qty < 0) {
            throw new IllegalArgumentException();
        }

        LineItem item = new LineItem(productId, db, qty);
        addToArray(item);
    }

    /**
     * A private method to resize an existing array. Makes a temporary array one
     * size larger than lineItems array and then copies lineItems into the
     * tempItems. New item is added to tempArray and then lineItem array copies
     * the tempArray
     *
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
     * A private method that will calculate the total discount for all the line
     * items
     *
     * @return Will return the total discount
     */
    private double calculateDiscountGrandTotal() {
        for (LineItem lineItem : lineItems) {
            discountGrandTotal = (discountGrandTotal + lineItem.getLineItemDiscountTotal());
        }
        return discountGrandTotal;
    }

    /**
     * Method that calculates the total of all line items
     *
     * @return Will return a grand total
     */
    private double calculateGrandTotal() {
        for (LineItem lineItem : lineItems) {
            grandTotal = (grandTotal + lineItem.calculateLineItemTotal());
        }
        return grandTotal;
    }

    @Override
    public void outputReceipt() {
        
        StringBuilder lineItemOutputs = new StringBuilder();
        for (LineItem lineItem : lineItems) {

            string = lineItem.printLineItem() + "\n";
            lineItemOutputs.append(string);
            
        }
        
        storeMessage = TAB_TO_CENTER + "Kohl's Department Store \n"
                                + TAB_TO_CENTER + "5555 W Howell Ave \n"
                                + TAB_TO_CENTER + "Oak Creek, WI 53154 \n"
                                + LONG_SOLID_LINE + "\n" 
                                + LONG_SOLID_LINE + "\n\n";
        
        String receiptNumber = "Register Number: " + Register.receiptNumber + "\n\n";
                                
        lineDisplay = (LONG_DOTTED_LINE + LONG_DOTTED_LINE + "\n" 
                + " Product  " + TWO_TAB + "Product Description \t" + "Unit Price " + TWO_TAB + "Qty " + TWO_TAB
                + " Subtotal  \n" + LONG_DOTTED_LINE + LONG_DOTTED_LINE + "\n\n");
        
        
        
        JOptionPane.showMessageDialog(null, new JTextArea((storeMessage + receiptNumber + lineDisplay + lineItemOutputs)));

        
        
        
        
        //JLabel lineDisplayLabel = new JLabel(lineDisplay);
        //lineDisplayLabel.setFont(new Font("serif", Font.PLAIN, 14));
        //JOptionPane.showMessageDialog(null, "<html> <b> Has </b>Higher A Market Value</html> ");
//        
//        String msg = "<html>This is how to get:<ul><li><i>italics</i> and "
//        + "<li><b>bold</b> and "
//        + "<li><u>underlined</u>...</ul></html>";
//        JLabel label = new JLabel(msg);
//        label.setFont(new Font("serif", Font.PLAIN, 14));
//        JOptionPane.showMessageDialog(null, label);  
    }

}
