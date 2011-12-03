/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package raucherproblem;

import static raucherproblem.Values.Item;

/**
 *
 * @author panos
 */
public class Simulation {

    final static int SMOKING_TIME_MINIMUM = 1000;
    final static int SMOKING_TIME_MAXIMUM = 3000;
    final static boolean DEBUG = false;

    public static void main(String[] args) {
        Table table = new Table();
        Smoker tSmoker, pSmoker, mSmoker;
        tSmoker = new Smoker(table, Item.tobacco);
        pSmoker = new Smoker(table, Item.paper);
        mSmoker = new Smoker(table, Item.match);
        Agent agent = new Agent(table);

        new Thread(agent).start();
        new Thread(tSmoker).start();
        new Thread(pSmoker).start();
        new Thread(mSmoker).start();
    }
}
