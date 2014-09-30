package pos_practicemidterm;

public class FakeDatabase {
    
    
    
    // 
    Product[] productList = {
        new Product("A202", "Pink Shirt", 13.23) //add discount strat
  
    };
    //find Product. Looping over.... 
    Product product;
    public Product findProduct(String productId){
        for (Product p : productList){
            if(productId.equals(product.getProductId())){
                product = p;
                //break out of loop if match is found
                break;
            }        
        }
        return product;
    }
    
     
}
