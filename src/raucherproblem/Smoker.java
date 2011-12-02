/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package raucherproblem;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import static raucherproblem.Values.Item;

/**
 *
 * @author panos
 */
final class Smoker implements Runnable {

    private final Item item;
    private final Table table;

    Smoker(Table table, Item item) {
        this.table = table;
        this.item = item;
    }

    @Override
    public void run() {
        Set<Item> itemsOnTable=table.items();
        while(itemsOnTable.isEmpty()) {
            try {
                table.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Smoker.class.getName()).log(Level.SEVERE, null, ex);
            }
            itemsOnTable=table.items();
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        return "smoker[" + item + "]";
    }
}
