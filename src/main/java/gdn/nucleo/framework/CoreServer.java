package gdn.nucleo.framework;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 * Created by Nathaniel on 11/16/2016.
 */
public class CoreServer {
    public static void main(String[] args) throws Exception{
        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        server.setHandler(context);
        server.start();
        server.join();
    }
}
