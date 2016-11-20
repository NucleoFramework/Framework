package gdn.nucleo.framework.lang.trie;

import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.Method;

/**
 * Created by Nathaniel on 11/19/2016.
 */
public class NodeChainTest {
    @Test
    public void testNodeChainSize() throws  Exception{
        NodeChain nc = new NodeChain();

        Method m = this.getClass().getMethod("testNodeChainSize");

        nc.addLink(m);
        nc.addLink(m);
        nc.addLink(m);

        assertEquals(nc.length, 3);
    }

    @Test
    public void testNodeChainSizeAfterRemoval() throws  Exception{
        NodeChain nc = new NodeChain();

        Method m = this.getClass().getMethod("testNodeChainSize");

        nc.addLink(m);
        nc.addLink(m);
        nc.addLink(m);

        nc.next(); // should remove the first entry

        assertEquals(nc.length, 2);
    }

    @Test
    public void testNodeChainContents() throws  Exception{
        NodeChain nc = new NodeChain();

        Method a = this.getClass().getMethod("testNodeChainSize");
        Method b = this.getClass().getMethod("testNodeChainSizeAfterRemoval");

        nc.addLink(a);
        nc.addLink(b);
        nc.addLink(a);

        assertEquals(nc.next().method, a);
        assertEquals(nc.next().method, b);
        assertEquals(nc.next().method, a);
    }

    @Test
    public void testNodeChainEmpty() throws  Exception{
        NodeChain nc = new NodeChain();

        assertNull(nc.next());
    }

    @Test
    public void testNodeChainLastEqualsNull() throws  Exception{
        NodeChain nc = new NodeChain();

        Method a = this.getClass().getMethod("testNodeChainEmpty");

        nc.addLink(a);

        nc.next();

        assertNull(nc.last);
    }

    @Test
    public void testNodeChainRefill() throws  Exception{
        NodeChain nc = new NodeChain();

        Method a = this.getClass().getMethod("testNodeChainLastEqualsNull");
        Method b = this.getClass().getMethod("testNodeChainRefill");

        nc.addLink(a);

        nc.next();

        nc.addLink(a);
        nc.addLink(b);

        nc.next();

        assertEquals(nc.next().method, b);
    }
}
