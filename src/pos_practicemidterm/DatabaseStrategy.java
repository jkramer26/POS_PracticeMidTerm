
package pos_practicemidterm;

/**
 *
 * @author Jessica Kramer
 */
public interface DatabaseStrategy {
    
    //find customer method
    public abstract Customer findCustomer(String customerId);
    
    //find product method
    public abstract Product findProduct(String productId);
}
