package gdn.nucleo.framework.event.bus;

import gdn.nucleo.framework.event.Skeleton;

/**
 * Created by Nathaniel on 11/20/2016.
 */
public class EventBus {
    public void publishEvent(Skeleton ev) throws Exception{
        Class c = ev.eventType.getValue();
        c.getMethod("request", Skeleton.class).invoke(c.newInstance(), ev);
    }
}
