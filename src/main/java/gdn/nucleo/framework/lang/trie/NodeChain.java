package gdn.nucleo.framework.lang.trie;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nathaniel on 11/19/2016.
 */
public class NodeChain {
    public class Link{
        public Link(List<Callable> m){
            callables=new ArrayList<>(m);
        }
        public List<Callable> callables = new ArrayList<>();
        public Link next=null;
        public List<Callable> getCallables() {
            return callables;
        }
    }

    public Link current;
    public Link last;
    public int length = 0;

    public NodeChain(){
        current=null;
        last=null;
    }
    public boolean hasNext(){
        return current!=null;
    }
    public void addLink(List<Callable> m){
        if(current==null && last==null) {
            last = new Link(m);
            current = last;
        }else{
            last.next = new Link(m);
            last = last.next;
        }
        length++;
    }
    public Link next(){
        if(hasNext()) {
            Link link = current;
            current = current.next;
            if(current==null){
                last=null;
            }
            length--;
            return link;
        }
        return null;
    }
}
