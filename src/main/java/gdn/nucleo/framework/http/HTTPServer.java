package gdn.nucleo.framework.http;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;

/**
 * Created by Nathaniel on 11/20/2016.
 */
public class HTTPServer implements Runnable {
    Undertow server;
    public void setup(int port, String address) {
        server = Undertow.builder()
            .addHttpListener(port, address)
            .setHandler(new HttpHandler() {
                public void handleRequest(final HttpServerExchange exchange) throws Exception {
                    exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
                    exchange.getResponseSender().send("Hello World");
                }
            }).build();
    }

    public void run() {
        server.start();
    }
}
