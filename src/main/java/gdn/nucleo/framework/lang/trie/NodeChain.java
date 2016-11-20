package gdn.nucleo.framework.lang.trie;

import java.lang.reflect.Method;

/**
 * Created by Nathaniel on 11/19/2016.
 */
public class NodeChain {
    public class Link{
        public Link(Method m){
            method = m;
        }
        public Method method;
        public Link next=null;
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
    public void addLink(Method m){
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
