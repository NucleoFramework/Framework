package gdn.nucleo.framework.event;

import gdn.nucleo.framework.event.format.EventType;

import java.util.HashMap;

/**
 * Created by Nathaniel on 11/20/2016.
 */
public class Skeleton {
    public HashMap<Object, Object> bundle = new HashMap<Object, Object>();
    public EventType eventType;
}
