

package pos_practicemidterm;

/**
 * This class represents a customer. 
 * It is responsible for creating a name & id for a customer.  
 * @author Jessica Kramer
 */

public class Customer {
    private String customerId;
    private String name;
    
    /**
     * This is a constructor that passes in and validates customer id & customer name 
     * @param customerId Unique id for a customers
     * @param name A name for a customer
     */
    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }
    
    /**
     * This method will return a customer's id
     * @return Returns a customer's id
     */
    public String getCustomerId() {
         
        return customerId;
    }
    
    /**
     * This method will set a customers id
     * @param customerId Will only set id if the parameter is not null or empty
     */
    public void setCustomerId(String customerId) {
        if(customerId == null || customerId.isEmpty()) {
            throw new IllegalArgumentException();
        }
        
        this.customerId = customerId;
    }
    
    /**
     * This method will return the name of a customer
     * @return Will return a customer name
     */
    public String getCustomerName() {
        return name;
    }
    
    /**
     * This method will set the name of a customer
     * @param name Will only set name if the parameter is not null or empty. 
     */
    public void setCustomerName(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        
        this.name = name;
    }
    
    
    
}
