package gdn.nucleo.framework.trie;

/**
 * Created by Nathaniel on 11/19/2016.
 */
public class TrieTreeString {
    NodeString root;
    public NodeChain buildChain(String... args){
        NodeChain chain = new NodeChain();
        NodeString currentNode=root;
        int i=0;
        int size = args.length;
        while(i<size && (currentNode = root.nextString(args[i]))!=null){
            chain.addLink(currentNode.getMethod());
            i++;
        }
        if(i==size){
            return chain;
        }else {
            return null;
        }
    }
}
