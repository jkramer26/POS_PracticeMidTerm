
package pos_practicemidterm;

/**
 * This class represents a simulation of a real receipt in a retail sales situation. 
 * It is responsible for managing miscellaneous receipt, customer and line item information. 
 * It also serves as a high-level service class, delegating to varying data access strategies 
 * and output strategies. 
 * @Jessica Kramer
 */

public class LineItem {
    private Product product;  //Product instance variable
    private int quantity;     //Quantity variable for a product
    private FakeDatabase db;  //Instance variable. Is composition
    private double lineTotal; //Calculates the total price for a product
    
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
    
    
    //productID - done
    //productDescript - done
    //UnitPrice - done
    //Qty - done
    
    //Need to calcualte below
    //Discount total
    //LineTotal
    
    
    public double getCalculatedLineTotal() {
        lineTotal = ((quantity * product.getUnitPrice()) /* - product.DiscountStart */);
        
        return lineTotal;
    }
    
    public String getProductID(){
        return product.getProductId();
    }
    
    public double getUnitPrice() {
        return product.getUnitPrice();
    }
    
    public String getDescription() {
        return product.getProductDescription();
    }
    public double getDiscount() {
        return product.getDiscountAmount();
    }
    
    //for testing purposes
    public static void main(String[] args) {
        //System.out.println("Product: " + product.setProductId("452"));
        FakeDatabase d = new FakeDatabase();
        
        LineItem line = new LineItem("A202", d, 2);
        
        System.out.println("LineTotal: " + line.getCalculatedLineTotal());
        System.out.println("ID: " + line.getProductID());
        System.out.println("Unit Price: " + line.getUnitPrice());
        System.out.println("Description: " + line.getDescription());
        System.out.println("Discount: " + line.product.getProductDiscount());
    }
    
    
}
