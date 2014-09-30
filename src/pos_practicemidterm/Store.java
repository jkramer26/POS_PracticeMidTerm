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
public class Store {
    private int storeNumber = 45;
    
    //could have constructor 
    
    public int getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(int storeNumber) {
        this.storeNumber = storeNumber;
    }
    
    
    public static void main(String[] args) {
        Store store = new Store(); 
        
        System.out.println("Store number: " + store.getStoreNumber());
    }
}

