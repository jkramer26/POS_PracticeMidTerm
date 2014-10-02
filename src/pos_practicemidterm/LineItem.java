
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
        discountTotal = (product.getProductDiscount() * quantity);
        
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
    
    //getters and setters. Should this be for every property
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
    
    public void printLineItem(){
//        System.out.println("Here is a line item");
//        System.out.println("Product ID: " + product.getProductId()); done
//        System.out.println("Product Description: " + product.getProductDescription()); done
//        System.out.println("Product Price: " + product.getUnitPrice()); done
//        System.out.println("Discount for a product: " + product.getProductDiscount()); not done
//        System.out.println("Total for products: " + getLineItemProductTotal()); not done
//        System.out.println("Total discount for products: " + getLineItemDiscountTotal());
//        System.out.println("Subtotal: " + calculateLineItemTotal());
//        System.out.println("____________________________________");
        
        System.out.println("Product \t" + "Product Description \t" + "Unit Price \t" + "Quantity \t" 
                            + "Total Discount \t" + "Subtotal ");
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println(product.getProductId() + "\t\t" + product.getProductDescription() + "\t\t" + product.getUnitPrice()
                            + "\t\t" + getQuantity() + "\t\t" + getLineItemDiscountTotal() + "\t\t" + calculateLineItemTotal() + "\n");
    }
    
    //for testing purposes
//    public static void main(String[] args) {
//        //System.out.println("Product: " + product.setProductId("452"));
//        FakeDatabase d = new FakeDatabase();
//        
//        LineItem line = new LineItem("A202", d, 2);
//        LineItem line2 = new LineItem("F485", d, 2);
//        LineItem line3 = new LineItem("E404", d, 2);
//        
//        line.printLineItem();
//        System.out.println("____________________________________");
//        
//        line2.printLineItem();
//        System.out.println("____________________________________");
//        
//        line3.printLineItem();
//        System.out.println("____________________________________");
//        
//    }
    
    
}
