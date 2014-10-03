package pos_practicemidterm;

/**
 * This class represents a simulation of a database. It is responsible for storing
 * products & customers and their associated properties. The class also has methods to 
 * find specific products & customers. 
 * 
 * @Jessica Kramer
 */

//need to create another database for customers. 
//the two should not be within the same database

public class FakeDatabase implements DatabaseStrategy {

    DiscountStrategy discountStrategy;  //Instance variable of discount strategy
    Product product;                    //Instance variable of product
    Customer customer;          //Instance variable of customer strategy
    
    /**
     * An array that stores multiple products
     */
    Product[] productList = {
        //why does paren have to be after database?
        new Product("A202", "Pink Shirt", 5.00, new PercentDiscount()), 
        new Product("F485", "Baseball Bat", 15.00, new FlatDiscountPerProduct()),
        new Product("E404", "Orange Towel", 10.00, new NoDiscount())
    };
    
    //look up enhanced for loop
    /**
     * This is a method that will determine if a passed in product id matches a
     * product id of one the products in the database. If a match is found then 
     * we break out of the loop.
     * @param productId Passes in a product id to find
     * @return Will return a found product & its properties
     */
    @Override
    public Product findProduct(String productId) {
        for (int i = 0; i < productList.length; i++) {
            //add validationi for if the product id is null or if it is not a valid id
            //validation should be outside of the loop
            if (productId.equals(productList[i].getProductId())) {
            product = productList[i];
            break;
            }      
        }
        return product;
    }
    
    /**
     * This is an array that stores multiple customers
     */
    Customer[] customerList = {
        new Customer("CB_101", "John Smith"),
        new Customer("CB_202", "Jane Doe"),
        new Customer("CB_303", "MaryJo Jones")
        
    };
    
    /**
     * This is a method that will determine if a passed in customer id matches a
     * customer id of one the customers in the database. If a match is found then 
     * we break out of the loop.
     * @param customerId Passes in a customer id to find
     * @return Will return a found customer & its properties
     */
    
    @Override
    public Customer findCustomer(String customerId) {
        //Customer customer = null;
        for (Customer customerList1 : customerList) {
            //add validationi for if the product id is null or if it is not a valid id
            //validation should be outside of the loop
            if (customerId.equals(customerList1.getCustomerId())) {
                customer = customerList1;
                break;
            }      
        }
        
        return customer; 
    }
}
