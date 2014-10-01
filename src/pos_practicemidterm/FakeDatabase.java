package pos_practicemidterm;

public class FakeDatabase {

    DiscountStrategy discountStrategy;

    // 
    Product[] productList = {
        new Product("A202", "Pink Shirt", 13.23), //add discount strat
        new Product("F485", "Baseball Bat", 15.25) //add discount strat
    };
    //find Product. Looping over.... 
    Product product;

    //Product test = new Product("A202", "Pink Shirt", 13.23);
//    public Product findProduct(String productId) {
//        if (productId.equals(productList[1].getProductId())) {
//            product = productList[1]; 
//        }
//        return product;
//    }
    public Product findProduct(String productId) {
        for (int i = 0; i < productList.length; i++) {
            //add validationi for if the product id is null
            if (productId.equals(productList[i].getProductId())) {
            product = productList[i];
            } else {
                System.out.println("This is not a valid Product ID.");
            }         
        }
        return product;
    }
    //add customer array as well

}
