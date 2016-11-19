package gdn.nucleo.framework.trie;

import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by Nathaniel on 11/19/2016.
 */
public class NodeString {

    public Method method = null;
    public HashMap<String, NodeString> nodes = new HashMap<String, NodeString>();

    public NodeString(Method method){
        this.method = method;
    }

    public NodeString nextString(String nextKey){
        if(nodes.containsKey(nextKey)){
            return nodes.get(nextKey);
        }
        return null;
    }
    public boolean addNextNode(NodeString node, String entry){
        if(nodes.containsKey(entry)){
            return false;
        }
        nodes.put(entry, node);
        return true;
    }
    public Class getMethodClass(){
        return method.getDeclaringClass();
    }
    public Method getMethod(){
        return method;
    }
}
