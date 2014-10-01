/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_practicemidterm;

/**
 *
 * @author kramerj
 */
public class Product {
    private String productId;
    private String productDescription;
    private double unitPrice;
    private DiscountStrategy discountStrategy;
    
    //constructor
    //need to validate this
    //add discount strat
    //pass in DiscountStrat
    public Product(String productId, String productDescription, double unitPrice) {
        this.productId = productId;
        this.productDescription = productDescription;
        this.unitPrice = unitPrice;
    }
    
    
    //getters and setters
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

    public String getProductDescription() {
        return productDescription;
    }
    
    //need to validate
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getUnitPrice() {
        
        return unitPrice;
    }
    
    //need javadoc
    public void setUnitPrice(double unitPrice) {
        if(unitPrice < 0) {
            throw new IllegalArgumentException();
        }
        this.unitPrice = unitPrice;
    }
    
    
    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }
    
    //need to validate
    //need javadoc
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }
    
    
    
}
