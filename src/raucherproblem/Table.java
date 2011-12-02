/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package raucherproblem;

import java.util.Set;
import java.util.EnumSet;
import java.util.concurrent.CyclicBarrier;
import static raucherproblem.Values.Item;

/**
 *
 * @author panos
 */
public class Table {

    private final CyclicBarrier barrier;

    Table() {
        barrier = new CyclicBarrier(Item.values().length);
    }
    private EnumSet<Item> items = EnumSet.noneOf(Item.class);

//    boolean add(Item item) {
//        boolean add=false;
//        if (items.size()<=1) {
//            add=items.add(item);
//        }
//        return add;
//    }
    boolean addAll(Set<Item> items) {
        boolean addAll = false;
        if (this.items.isEmpty() && items.size() == 2) {
            addAll = this.items.addAll(items);
        }
        return addAll;
    }

    boolean contains(Item item) {
        return items.contains(item);
    }

    boolean remove(Item item) {
        return items.remove(item);
    }
    
    Set<Item> items() {
        return items;
    }
    
    CyclicBarrier barrier() {
        return barrier;
    }
}
