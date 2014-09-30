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
    public Product(String productId, String productDescription, double unitPrice) {
        this.productId = productId;
        this.productDescription = productDescription;
        this.unitPrice = unitPrice;
    }
    
    
    //getters and setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    
    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }
    
    
    
}
