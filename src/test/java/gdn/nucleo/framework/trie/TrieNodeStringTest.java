package gdn.nucleo.framework.trie;

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

        assertEquals(n.getMethodClass().getName(),"gdn.nucleo.framework.trie.TrieNodeStringTest");
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

}
