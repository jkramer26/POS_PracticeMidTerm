
package pos_practicemidterm;

/**
 * This class represents a line item on a receipt. It calculates a line item's discount amount,
 * product amount, and then the subtotal amount after discount is taken off.
 * 
 * @Jessica Kramer
 */

public class LineItem {
    private Product product;               //Product instance variable
    private int quantity;                  //Quantity variable for a product
    private DatabaseStrategy db;           //Instance variable.
    private double lineProductTotal;       //Holds the total amount for all the products
    private double discountTotal;          //Holds the total discount the quantity of products
    private double lineItemTotal;          //Holds the total line item amount after discount is taken off
    //The constant below is used for formatting lineItem output
    private final String TWO_TAB = "\t\t";
    
    /**
     * LineItem constructor that has values passed in when object is created
     * @param productId Passes in a product id
     * @param db        Passes in a database object
     * @param quantity  Passes in the quantity & validates the input through setQuantity method
     */
    public LineItem(String productId, DatabaseStrategy db, int quantity) {
        //this finds a product from the database and instantiates a product object
        //with that paticular product's properties (description & unit price)
        product = db.findProduct(productId);
        this.db = db;
        setQuantity(quantity);
        
    }
    
    
    /**
     * Calculates the total for a line item by multiplying the quantity of a product
     * by the product's unit price
     * @return Will return the total amount for a line item
     */
    public double getLineItemProductTotal() {
        lineProductTotal = ((quantity * product.getUnitPrice()));
        
        return lineProductTotal;
    }
    
    /**
     * This method will calculate the total discount amount the quantity of products given
     * @return Will return the total discount amount
     */
    public double getLineItemDiscountTotal() {
        discountTotal = (product.getProductDiscount(quantity));
        
        return discountTotal;
    }
    
    /**
     * This method will calculate the true total for the line item. It takes the 
     * product line item total and subtracts it from the discount product total.
     * @return Will return the true line item total amount
     */
    public double calculateLineItemTotal(){
        getLineItemProductTotal();
        getLineItemProductTotal();
        lineItemTotal = (lineProductTotal - discountTotal);
        return lineItemTotal;
    }
    
    /**
     * This method will return the quantity for a product
     * @return Returns product quantity
     */
    public int getQuantity() {
        return quantity;
    }
    
    /**
     * This method sets the quantity for a product 
     * @param quantity Will only set quantity if it is not less than 0
     */
    public void setQuantity(int quantity) {
        if(quantity < 0) {
            throw new IllegalArgumentException();
        }
        
        this.quantity = quantity;
    }
    
    /**
     * This method will print out the a line items product's id, description, 
     * unit price, quantity, calculated total, & discount total.
     * 
     * The consoleReceipt.FOUR_TABS is a global constant from the consoleReceipt class
     */
    public void printLineItem(){

        System.out.println(product.getProductId() + TWO_TAB + product.getProductDescription() + TWO_TAB + product.getUnitPrice()
                            + TWO_TAB + getQuantity() +  TWO_TAB + "   " + calculateLineItemTotal());
        System.out.println(ConsoleReceipt.FOUR_TABS_OF_TWO + " Discount: -" + getLineItemDiscountTotal() +"\n");
    }    
    
}
