/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package raucherproblem;

import static raucherproblem.Factory.*;

/**
 *
 * @author panos
 */
final class SmokerImpl implements Smoker {

    private final String name;
    private final Item item;

    private SmokerImpl(String name, Item item) {
        this.name = name;
        this.item = item;
    }
    
    static Smoker create(String name, Item item) {
        return new SmokerImpl(name, item);
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
