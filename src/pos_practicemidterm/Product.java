
package pos_practicemidterm;

/**
 * This class represents a product in a store. 
 * It is responsible for creating an id, description, & price for a product. 
 * This class implements a discountStrategy that can adjust the price for a product. 
 * @author Jessica Kramer
 */

public class Product {
    private String productId;
    private String productDescription;
    private double unitPrice;
    private DiscountStrategy discountStrategy;
    
    /**
     * Constructor that passes in below parameters and validates the input
     * @param productId             //Unique id for a product
     * @param productDescription    //The description for a product 
     * @param unitPrice             //The unit price for a product
     * @param discountStrategy      //Passing in a discountStrategy object
     */
    public Product(String productId, String productDescription, double unitPrice, DiscountStrategy discountStrategy) {
        setProductId(productId);
        setProductDescription(productDescription);
        setUnitPrice(unitPrice);
        setDiscountStrategy(discountStrategy);
    }
    
    /**
     * This method gets the discount amount for a product
     * @return This will return the discount amount
     */
    public double getProductDiscount() {
        return discountStrategy.getProductDiscount(unitPrice);
    }
    
    //getters and setters below
    /**
     * Returns the id for a product
     * @return 
     */
    public String getProductId() {
        return productId;
    }
    
    /**
     * This method stores the product id. 
     * @param productId The id is validated to make sure id
     * is not null or empty
     */
    public void setProductId(String productId) {
        //need to know whether null or empty conditions are permissible by client
        //we won't store productId if id is invalid
        if(productId == null || productId.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.productId = productId;
    }
    
    /**
     * This method returns the description for a product
     * @return 
     */
    public String getProductDescription() {
        return productDescription;
    }
    
    /**
     * This method stores a product description. 
     * @param productDescription The description is validated to make make sure
     * it is not null or empty
     */
    public void setProductDescription(String productDescription) {
        if(productId == null || productId.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.productDescription = productDescription;
    }

    /**
     * This method will return the unit price for a product
     * @return 
     */
    public double getUnitPrice() {
        
        return unitPrice;
    }
    
    /**
     * This method will store the unit price for a product
     * @param unitPrice is validated so that the price is not set less than 0 dollars
     */
    public void setUnitPrice(double unitPrice) {
        if(unitPrice < 0) {
            throw new IllegalArgumentException();
        }
        this.unitPrice = unitPrice;
    }
    
    /**
     * This will return a discount strategy object
     * @return 
     */
    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }
    
    //need to validate?
    /**
     * This will set a discount strategy object
     * @param discountStrategy 
     */
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }
    
    
    
    
}
