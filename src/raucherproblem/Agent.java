/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package raucherproblem;

import java.util.Set;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static raucherproblem.Values.Item;

/**
 *
 * @author panos
 */
final class Agent implements Runnable {

    private final Table table;

    Agent(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
//        throw new UnsupportedOperationException("Not supported yet.");
        while (true) {
            Set<Item> items = twoRandomItems();
            table.addAll(items);
            System.out.println("Agent put " + items + " on the table");
            System.out.println("Agent waits until smoker has finished");
            waitUntilSmokerHasFinished();
            System.out.println("Agent wakes up");
            System.out.println("\n----------------------------------------------------------------------\n");
        }
    }

    private Set<Item> twoRandomItems() {
        List<Item> itemList = new ArrayList<Item>(EnumSet.noneOf(Item.class));
        itemList.remove((int) (Item.values().length * Math.random()));
        return EnumSet.copyOf(itemList);
    }

    private void waitUntilSmokerHasFinished() {
        try {
            table.wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(Agent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
