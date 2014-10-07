package pos_practicemidterm;

import java.text.NumberFormat;
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

    private Customer customer;                          //Instance variable of Customer class
    private DatabaseStrategy db;                        //Instance variable of DatabaseStrategy
    private double grandTotal;                          //Variable that holds the total of all the line items
    private double discountGrandTotal;                  //Variable that holds the total discount of all the line items
    private LineItem[] lineItems;                       //Creating an array of objects from class LineItem
    private String string;                              //String that holds the lineItems output
    private String storeMessage;                        //A message that the store will display
    private String lineDisplay;                         //Displays the title descriptions for each lineItem property
    private String receiptNumberPlusCustomer;           //String that will display receipt number & customer name
    private String displayGrandTotal;                   //String that will display the grandtotal
    private String displayDiscountTotal;                //String that will display the discount grand total
    
    //Below are constants that are used for formatting the receipt
    private final String LONG_SOLID_LINE = "_________________________________________________________________________________________________________________";
    private final String LONG_DOTTED_LINE = " - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ";
    private final String TWO_TAB = "\t\t";
    private final String TAB_TO_CENTER = "      \t          \t          \t            ";
    
    //this is used for displaying all the lineItems 
    StringBuilder lineItemOutputs = new StringBuilder();
    //this is used to format output into currency
    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    
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

    /**
     * This method will add a new product to the line item array & validates input
     * @param productId Passes in a product id
     * @param qty Passes in a product quantity
     */
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

    /**
     * This method outputs a GUI receipt. It formats the output to display 
     * properly to a customer. 
     */
    @Override
    public void outputReceipt() {
        
        //this will loops though all the lineitems and adds them to a string 
        //to be outputted
        for (LineItem lineItem : lineItems) {

            string = lineItem.printLineItem() + "\n";
            lineItemOutputs.append(string);
            
        }
        
        //this creates a string that has store message to be shown at top of receipt
        storeMessage = TAB_TO_CENTER + "Kohl's Department Store \n"
                                + TAB_TO_CENTER + "5555 W Howell Ave \n"
                                + TAB_TO_CENTER + "Oak Creek, WI 53154 \n"
                                + LONG_SOLID_LINE + "\n" 
                                + LONG_SOLID_LINE + "\n\n";
        
        //this creates a string that will output the receipt number & customer name
        receiptNumberPlusCustomer = "Register Number: " + Register.receiptNumber 
                                    + "\nCustomer Name: " + customer.getCustomerName() + "\n\n";
        
        //this creates a string that will display the titles for all of a lineitem's properties
        lineDisplay = (LONG_DOTTED_LINE + LONG_DOTTED_LINE + "\n" 
                + " Product  " + TWO_TAB + "Product Description \t" + "Unit Price " + TWO_TAB + "Qty " + TWO_TAB
                + " Subtotal  \n" + LONG_DOTTED_LINE + LONG_DOTTED_LINE + "\n\n");
        
        //this will create a string that displays a grandtotal
        displayGrandTotal = TAB_TO_CENTER + TWO_TAB + TWO_TAB + "          Grand Total: " + formatter.format(calculateGrandTotal()) + "\n";
        
        /*this will create a string that displays the total amount a customer saved through adding all the
         *lineitems discounts up
        **/
        displayDiscountTotal = "\n\n" + TAB_TO_CENTER + "YOU SAVED: " + formatter.format(calculateDiscountGrandTotal());
        
        //this will display all the created strings and shown them in a joptionpane
        JOptionPane.showMessageDialog(null, new JTextArea((storeMessage + receiptNumberPlusCustomer + lineDisplay + lineItemOutputs 
                                        + displayGrandTotal + displayDiscountTotal)));

        
        
        
        
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
