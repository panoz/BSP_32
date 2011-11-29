/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package raucherproblem;

/**
 *
 * @author panos
 */
public class Factory {

    private Factory() {
    }

    public static enum Item {

        tobacco, paper, match
    };

    static Agent newAgent() {
        return AgentImpl.create();
    }

    static Smoker newSmoker(String name, Item item) {
        return SmokerImpl.create(name, item);
    }
}
