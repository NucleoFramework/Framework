package gdn.nucleo.framework.lang.trie;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by Nathaniel on 11/19/2016.
 */
public class TrieNodeStringTest {
    @Test
    /*
        Test: Create node with a method and get the class from that method
    */
    public void testNodeStringMethodClass() throws Exception{
        NodeString n = new NodeString(this.getClass().getMethod("testNodeStringMethodClass"));

        assertEquals(n.getMethods().get(0).getDeclaringClass().getName(),"gdn.nucleo.framework.lang.trie.TrieNodeStringTest");
    }

    @Test
    /*
        Create 2 Nodes, add 1 node to another with the key "test" and make sure its there
     */
    public void testNodeStringAddNode() throws Exception{
        NodeString a = new NodeString(this.getClass().getMethod("testNodeStringMethodClass"));
        NodeString b = new NodeString(this.getClass().getMethod("testNodeStringAddNode"));

        a.addNextNode(b,"test");

        assertEquals(a.nextString("test"), b);
    }

    @Test
    /*
        Create 1 node check for non existent next node
     */
    public void testNodeStringAddNodeNullNext() throws Exception{
        NodeString a = new NodeString(this.getClass().getMethod("testNodeStringMethodClass"));

        assertNull(a.nextString("test"));
    }

    @Test
    /*
        Create 2 Nodes, add 1 node to another with the key "test" and make sure its there
     */
    public void testNodeStringAddNodeExistingEntry() throws Exception{
        NodeString a = new NodeString(this.getClass().getMethod("testNodeStringMethodClass"));
        NodeString b = new NodeString(this.getClass().getMethod("testNodeStringAddNode"));
        NodeString c = new NodeString(this.getClass().getMethod("testNodeStringAddNodeNullNext"));
        a.addNextNode(b,"test");

        assertFalse(a.addNextNode(c,"test"));
    }

    @Test
    /*
        Create 2 Nodes, add 1 node to another with the key "test" and make sure its there
     */
    public void testNodeStringAddNodeCheckModule() throws Exception{
        NodeString a = new NodeString(this.getClass().getMethod("testNodeStringMethodClass"));

        assertEquals(a.getMethods().get(0),this.getClass().getMethod("testNodeStringMethodClass"));
    }
}
