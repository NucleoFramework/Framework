package gdn.nucleo.framework;


import gdn.nucleo.framework.http.HTTPServer;
import gdn.nucleo.framework.ws.WebSocketServer;

/**
 * Created by Nathaniel on 11/16/2016.
 */
public class CoreServer {
    public static void main(String[] args) throws Exception{
        HTTPServer server = new HTTPServer();
        server.setup(8080, "0.0.0.0");
        new Thread(server).start();
        WebSocketServer wsserver = new WebSocketServer();
        wsserver.setup(8081, "0.0.0.0");
        new Thread(wsserver).start();
        System.out.println("server started");
    }
}
