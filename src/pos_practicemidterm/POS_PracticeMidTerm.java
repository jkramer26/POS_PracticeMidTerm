
package pos_practicemidterm;

/**
 *
 * @author kramerj
 */
public class POS_PracticeMidTerm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DatabaseStrategy db = new FakeDatabase();
        
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
