package gdn.nucleo.framework.event.format;

/**
 * Created by Nathaniel on 11/20/2016.
 */
public enum EventType {
    HTTP(null),
    WEBSOCKET(gdn.nucleo.framework.websocket.EventHandler.class),
    APPLICATION(null),
    COMMUNICATION(null),
    CUSTOM(null);

    private Class value;
    private EventType(Class clazz){
        this.value = clazz;
    }
    public Class getValue() {
        return value;
    }
}
