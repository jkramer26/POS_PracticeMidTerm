package pos_practicemidterm;

/**
 * This class represents a simulation of a real receipt in a retail sales situation. 
 * It is responsible for managing miscellaneous receipt, customer and line item information. 
 * It also serves as a high-level service class, delegating to varying data access strategies 
 * and output strategies. 
 * @Jessica Kramer
 */

public class FakeDatabase {

    DiscountStrategy discountStrategy;
    
    // 
    Product[] productList = {
        //why does paren have to be after database/
        new Product("A202", "Pink Shirt", 5.00, new PercentDiscount()), 
        new Product("F485", "Baseball Bat", 15.00, new FlatDiscount()),
        new Product("E404", "Orange Towel", 10.00, new NoDiscount())
    };
    //find Product. Looping over.... 
    Product product;

    //look up enhanced for loop
    public Product findProduct(String productId) {
        for (int i = 0; i < productList.length; i++) {
            //add validationi for if the product id is null or if it is not a valid id
            //validation should be outside of the loop
            if (productId.equals(productList[i].getProductId())) {
            product = productList[i];
            }      
        }
        return product;
    }
    
    //add customer array as well

}
