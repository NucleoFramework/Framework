package gdn.nucleo.framework.lang.trie;

import gdn.nucleo.framework.event.EventServer;

import java.lang.reflect.Method;

/**
 * Created by Nathaniel on 11/25/2016.
 */
public class Callable {
    public Method method = null;
    public EventServer server = null;
    public String eventCall;
    public Callable(Method method){
        this.method = method;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public EventServer getServer() {
        return server;
    }

    public void setServer(EventServer server) {
        this.server = server;
    }

    public String getEventCall() {
        return eventCall;
    }

    public void setEventCall(String eventCall) {
        this.eventCall = eventCall;
    }
}
