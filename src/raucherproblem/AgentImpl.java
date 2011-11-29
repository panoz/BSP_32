/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package raucherproblem;

/**
 *
 * @author panos
 */
public class AgentImpl implements Agent {

    private AgentImpl() {
    }

    static Agent create() {
        return new AgentImpl();
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
