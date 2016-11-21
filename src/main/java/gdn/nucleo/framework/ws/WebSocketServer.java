package gdn.nucleo.framework.ws;

import io.undertow.Undertow;
import io.undertow.connector.PooledByteBuffer;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
import io.undertow.websockets.WebSocketConnectionCallback;
import io.undertow.websockets.core.*;
import io.undertow.websockets.spi.WebSocketHttpExchange;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

import static io.undertow.Handlers.path;
import static io.undertow.Handlers.websocket;

/**
 * Created by Nathaniel on 11/20/2016.
 */
public class WebSocketServer implements Runnable {
    private Undertow server;
    public void setup(int port, String address) {
        server = Undertow.builder()
                .addHttpListener(port, address)
                .setHandler(
                    path().addPrefixPath("/", websocket(new WebSocketConnectionCallback() {
                        public void onConnect(final WebSocketHttpExchange exchange, WebSocketChannel main) {
                            main.getReceiveSetter().set(new AbstractReceiveListener() {
                                @Override
                                protected void onClose(WebSocketChannel webSocketChannel, StreamSourceFrameChannel channel) throws IOException {
                                    super.onClose(webSocketChannel, channel);
                                }

                                @Override
                                protected void onText(WebSocketChannel webSocketChannel, StreamSourceFrameChannel messageChannel) throws IOException {
                                    super.onText(webSocketChannel, messageChannel);
                                }

                                @Override
                                protected void onBinary(WebSocketChannel webSocketChannel, StreamSourceFrameChannel messageChannel) throws IOException {
                                    super.onBinary(webSocketChannel, messageChannel);
                                }

                                @Override
                                protected void onError(WebSocketChannel channel, Throwable error) {
                                    super.onError(channel, error);
                                }

                                @Override
                                protected void onFullTextMessage(WebSocketChannel channel, BufferedTextMessage message) throws IOException {
                                    channel.send(WebSocketFrameType.TEXT).writeFinal(ByteBuffer.wrap("this is a test".getBytes(Charset.forName("UTF-8"))));
                                }

                                @Override
                                protected void onFullBinaryMessage(WebSocketChannel channel, BufferedBinaryMessage message) throws IOException {
                                    channel.send(WebSocketFrameType.BINARY).writeFinal(ByteBuffer.wrap("this is a test".getBytes(Charset.forName("UTF-8"))));
                                }

                                @Override
                                protected void onFullCloseMessage(WebSocketChannel channel, BufferedBinaryMessage message) throws IOException {
                                    super.onFullCloseMessage(channel, message);
                                }

                                @Override
                                protected void onCloseMessage(CloseMessage cm, WebSocketChannel channel) {
                                    super.onCloseMessage(cm, channel);
                                }
                            });
                            main.resumeReceives();
                        }
                    }))
                ).build();
    }

    public void run() {
        server.start();
    }
}
