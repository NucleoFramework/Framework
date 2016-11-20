package gdn.nucleo.framework;


import gdn.nucleo.framework.http.HTTPServer;

/**
 * Created by Nathaniel on 11/16/2016.
 */
public class CoreServer {
    public static void main(String[] args) throws Exception{
        HTTPServer server = new HTTPServer();
        server.setup(8080, "0.0.0.0");
        new Thread(server).start();
        System.out.println("server started");
    }
}
