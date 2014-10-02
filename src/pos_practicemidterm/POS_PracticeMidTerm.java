
package pos_practicemidterm;

/**
 * This class is responsible for starting the program. It instantiates a database 
 * and receipt object. It is also responsible for starting a transaction,
 * adding items to a transaction, and ending a transaction. The end of a 
 * transaction causes a receipt to be outputted. 
 * 
 * @author Jessica Kramer
 */
public class POS_PracticeMidTerm {

    public static void main(String[] args) {
        
        //creates a fake database object
        DatabaseStrategy db = new FakeDatabase();
        
        //creates a register object
        Register r = new Register();
       
        r.startNewTransaction("CB_101", db);
        r.addItem("A202", 2);
        r.addItem("F485", 2);
        r.addItem("E404", 2);
        r.endTransaction();
       
        r.startNewTransaction("CB_202", db);
        r.addItem("A202", 2);
        r.addItem("F485", 2);
        r.addItem("E404", 2);
        r.endTransaction();
        
    }
    
}
