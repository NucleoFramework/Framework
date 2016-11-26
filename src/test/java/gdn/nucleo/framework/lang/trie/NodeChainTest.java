package gdn.nucleo.framework.lang.trie;

import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nathaniel on 11/19/2016.
 */
public class NodeChainTest {
    @Test
    public void testNodeChainSize() throws  Exception{
        NodeChain nc = new NodeChain();

        Callable m = new Callable(this.getClass().getMethod("testNodeChainSize"));
        List<Callable> a = new ArrayList<>();
        a.add(m);

        nc.addLink(a);
        nc.addLink(a);
        nc.addLink(a);

        assertEquals(nc.length, 3);
    }

    @Test
    public void testNodeChainSizeAfterRemoval() throws  Exception{
        NodeChain nc = new NodeChain();

        Callable m = new Callable(this.getClass().getMethod("testNodeChainSize"));
        List<Callable> a = new ArrayList<>();
        a.add(m);

        nc.addLink(a);
        nc.addLink(a);
        nc.addLink(a);

        nc.next(); // should remove the first entry

        assertEquals(nc.length, 2);
    }

    @Test
    public void testNodeChainContents() throws  Exception{
        NodeChain nc = new NodeChain();

        Callable a = new Callable(this.getClass().getMethod("testNodeChainSize"));
        Callable b = new Callable(this.getClass().getMethod("testNodeChainSizeAfterRemoval"));
        List<Callable> al = new ArrayList<>();
        al.add(a);
        List<Callable> bl = new ArrayList<>();
        bl.add(b);

        nc.addLink(al);
        nc.addLink(bl);
        nc.addLink(al);

        assertEquals(nc.next().getCallables().get(0), a);
        assertEquals(nc.next().getCallables().get(0), b);
        assertEquals(nc.next().getCallables().get(0), a);
    }

    @Test
    public void testNodeChainEmpty() throws  Exception{
        NodeChain nc = new NodeChain();

        assertNull(nc.next());
    }

    @Test
    public void testNodeChainLastEqualsNull() throws  Exception{
        NodeChain nc = new NodeChain();

        Callable a = new Callable(this.getClass().getMethod("testNodeChainEmpty"));
        List<Callable> al = new ArrayList<>();
        al.add(a);

        nc.addLink(al);

        nc.next();

        assertNull(nc.last);
    }

    @Test
    public void testNodeChainRefill() throws  Exception{
        NodeChain nc = new NodeChain();

        Callable a = new Callable(this.getClass().getMethod("testNodeChainLastEqualsNull"));
        Callable b = new Callable(this.getClass().getMethod("testNodeChainRefill"));
        List<Callable> al = new ArrayList<>();
        al.add(a);
        List<Callable> bl = new ArrayList<>();
        bl.add(b);

        nc.addLink(al);

        nc.next();

        nc.addLink(al);
        nc.addLink(bl);

        nc.next();

        assertEquals(nc.next().getCallables().get(0), b);
    }
}
