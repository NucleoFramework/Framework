package gdn.nucleo.framework.lang.trie;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Nathaniel on 11/19/2016.
 */
public class NodeString {

    public List<Callable> callables = new ArrayList<>();
    public HashMap<String, NodeString> nodes = new HashMap<String, NodeString>();

    public NodeString(Callable callable){
        if(callable!=null) {
            this.callables.add(callable);
        }
    }

    public NodeString nextString(String nextKey){
        if(nodes.containsKey(nextKey)){
            return nodes.get(nextKey);
        }
        return null;
    }
    public boolean addNextNodeMethod(String entry, Callable m){
        return addNextNode(new NodeString(m), entry);
    }
    public boolean addNextNode(NodeString node, String entry){
        if(nodes.containsKey(entry)){
            return false;
        }
        nodes.put(entry, node);
        return true;
    }
    public List<Callable> getCallables(){
        return callables;
    }
}
