package gdn.nucleo.framework.event.bus.types;

import gdn.nucleo.framework.event.Skeleton;

/**
 * Created by Nathaniel on 11/20/2016.
 */
public interface EventTypeHandler {
    void handleEvent(Skeleton es);
}
