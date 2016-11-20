package gdn.nucleo.framework.lang.trie;

import java.lang.reflect.Method;

/**
 * Created by Nathaniel on 11/19/2016.
 */
public class TrieString {
    public NodeString root;
    public TrieString(){
        root = new NodeString(null);
    }
    public boolean addToTree(Method m, String... args){
        if(args.length==0){
            return false;
        }
        int i = 0;
        int size = args.length;
        NodeString current = root;
        while(i < size){
            NodeString tmp;
            if((tmp = current.nextString(args[i]))!=null){
                current = tmp;
                if((i+1)==size){
                    if(tmp.getMethod()==null){
                        tmp.method=m;
                        return true;
                    }
                }
            }else{
                if((i+1)==size){
                    current.addNextNodeMethod(args[i], m);
                    return true;
                }else{
                    current.addNextNodeMethod(args[i], null);
                    current = current.nextString(args[i]);
                }
            }
            i++;
        }
        return false;
    }
    public NodeChain buildChain(String... args){
        if(args.length==0){
            return null;
        }
        NodeChain chain = new NodeChain();
        NodeString currentNode=root;
        int i=0;
        int size = args.length;
        while(i<size && (currentNode = currentNode.nextString(args[i]))!=null){
            if(currentNode.getMethod()!=null) {
                chain.addLink(currentNode.getMethod());
            }
            i++;
        }
        if(i==size){
            return chain;
        }else {
            return null;
        }
    }
}
