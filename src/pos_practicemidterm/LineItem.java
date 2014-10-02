
package pos_practicemidterm;

/**
 * This class represents a line item on a receipt. It calculates a line items discount amount,
 * product amount, and then the subtotal amount after discount is taken off.
 * 
 * @Jessica Kramer
 */

public class LineItem {
    private Product product;               //Product instance variable
    private int quantity;                  //Quantity variable for a product
    private FakeDatabase db;               //Instance variable. Is composition
    private double lineProductTotal;       //Holds the total amount for all the products
    private double discountTotal;          //Holds the total discount the quantity of products
    private double lineItemTotal;          //Holds the total line item amount after discount is taken off
    /**
     * LineItem constructor that has values passed in when object is created
     * @param productId Passes in a product id
     * @param db        Passes in a database object
     * @param quantity  Passes in the quantity for a particular product
     */
    public LineItem(String productId, FakeDatabase db, int quantity) {
        //this finds a product from the database and instantiates a product object
        //with that paticular product's properties (description & unit price)
        product = db.findProduct(productId);
        this.db = db;
        this.quantity = quantity;
        
    }
    
    
    /**
     * Calculates the total for a line item by multiplying the quantity of a product
     * by the product's unit price
     * @return Will return the total amount for a line item
     */
    public double getLineItemProductTotal() {
        lineProductTotal = ((quantity * product.getUnitPrice()) /* - product.DiscountStart */);
        
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
        lineItemTotal = (lineProductTotal - discountTotal);
        return lineItemTotal;
    }
   
    
    //for testing purposes
    public static void main(String[] args) {
        //System.out.println("Product: " + product.setProductId("452"));
        FakeDatabase d = new FakeDatabase();
        
        LineItem line = new LineItem("A202", d, 2);
        LineItem line2 = new LineItem("F485", d, 2);
        LineItem line3 = new LineItem("E404", d, 2);
        
        System.out.println("LineTotal: " + line.getLineItemProductTotal());
        System.out.println("ID: " + line.product.getProductId());
        System.out.println("Unit Price: " + line.product.getUnitPrice());
        System.out.println("Description: " + line.product.getProductDescription());
        System.out.println("Discount: " + line.product.getProductDiscount());
        System.out.println("Product Total Amount: " + line.getLineItemProductTotal());
        System.out.println("Discount Total Amount: " + line.getLineItemDiscountTotal());
        System.out.println("LineItem Subtotal: " + line.calculateLineItemTotal() + "\n");
        
        System.out.println("LineTotal: " + line2.getLineItemProductTotal());
        System.out.println("ID: " + line2.product.getProductId());
        System.out.println("Unit Price: " + line2.product.getUnitPrice());
        System.out.println("Description: " + line2.product.getProductDescription());
        System.out.println("Discount: " + line2.product.getProductDiscount());
        System.out.println("Product Total Amount: " + line2.getLineItemProductTotal());
        System.out.println("Discount Total Amount: " + line2.getLineItemDiscountTotal());
        System.out.println("LineItem Subtotal: " + line2.calculateLineItemTotal() + "\n");
        
        System.out.println("LineTotal: " + line3.getLineItemProductTotal());
        System.out.println("ID: " + line3.product.getProductId());
        System.out.println("Unit Price: " + line3.product.getUnitPrice());
        System.out.println("Description: " + line3.product.getProductDescription());
        System.out.println("Discount: " + line3.product.getProductDiscount());
        System.out.println("Product Total Amount: " + line3.getLineItemProductTotal());
        System.out.println("Discount Total Amount: " + line3.getLineItemDiscountTotal());
        System.out.println("LineItem Subtotal: " + line3.calculateLineItemTotal());
    }
    
    
}
