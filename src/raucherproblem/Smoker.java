/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package raucherproblem;

import java.util.Set;
import java.util.concurrent.BrokenBarrierException;
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
        while (true) {
            Set<Item> itemsOnTable = table.items();
            while (itemsOnTable.isEmpty()) {
//            try {
//                synchronized (table) {
//                    table.wait();
//                }
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Smoker.class.getName()).log(Level.SEVERE, null, ex);
//            }
                itemsOnTable = table.items();
            }
            if (Simulation.DEBUG) {
                System.out.println(this + " found items " + table.items());
            }
            boolean thirdItemFound = !itemsOnTable.contains(item);
            try {
                table.barrier().await();
            } catch (InterruptedException ex) {
                Logger.getLogger(Smoker.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BrokenBarrierException ex) {
                Logger.getLogger(Smoker.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (Simulation.DEBUG) {
                System.out.println(this + " passed barrier");
            }
            if (!thirdItemFound) {
                try {
                    synchronized (table) {
                        table.wait();
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Smoker.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                if (Simulation.DEBUG) {
                    System.out.println(this + " found the third item!");
                }
                removeItemsFromTable();
                smoke();
                synchronized (table) {
                    table.notifyAll();
//                try {
//                    table.wait();
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(Smoker.class.getName()).log(Level.SEVERE, null, ex);
//                }
                }
            }
        }
    }

    private void removeItemsFromTable() {
        table.clear();
    }

    private void smoke() {
        System.out.println(this + " begins to smoke");
        try {
            Thread.sleep((long) ((Simulation.SMOKING_TIME_MAXIMUM - Simulation.SMOKING_TIME_MINIMUM) * Math.random()));
        } catch (InterruptedException ex) {
            Logger.getLogger(Smoker.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(this + " has finished smoking");

    }

    @Override
    public String toString() {
        return "smoker[" + item + "]";
    }
}
