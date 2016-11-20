package gdn.nucleo.framework.ws;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
import io.undertow.websockets.WebSocketConnectionCallback;
import io.undertow.websockets.core.*;
import io.undertow.websockets.spi.WebSocketHttpExchange;

import java.io.IOException;

import static io.undertow.Handlers.path;
import static io.undertow.Handlers.websocket;

/**
 * Created by Nathaniel on 11/20/2016.
 */
public class WebSocketServer implements Runnable {
    Undertow server;
    public void setup(int port, String address) {
        server = Undertow.builder()
                .addHttpListener(port, address)
                .setHandler(
                    path().addPrefixPath("/", websocket(new WebSocketConnectionCallback() {
                        public void onConnect(WebSocketHttpExchange exchange, WebSocketChannel channel) {
                            channel.getReceiveSetter().set(new AbstractReceiveListener() {
                                @Override
                                public void handleEvent(WebSocketChannel channel) {
                                    super.handleEvent(channel);
                                }

                                @Override
                                protected void onPing(WebSocketChannel webSocketChannel, StreamSourceFrameChannel channel) throws IOException {
                                    super.onPing(webSocketChannel, channel);
                                }

                                @Override
                                protected void onClose(WebSocketChannel webSocketChannel, StreamSourceFrameChannel channel) throws IOException {
                                    super.onClose(webSocketChannel, channel);
                                }

                                @Override
                                protected void onPong(WebSocketChannel webSocketChannel, StreamSourceFrameChannel messageChannel) throws IOException {
                                    super.onPong(webSocketChannel, messageChannel);
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
                                protected long getMaxBinaryBufferSize() {
                                    return super.getMaxBinaryBufferSize();
                                }

                                @Override
                                protected long getMaxPongBufferSize() {
                                    return super.getMaxPongBufferSize();
                                }

                                @Override
                                protected long getMaxCloseBufferSize() {
                                    return super.getMaxCloseBufferSize();
                                }

                                @Override
                                protected long getMaxPingBufferSize() {
                                    return super.getMaxPingBufferSize();
                                }

                                @Override
                                protected long getMaxTextBufferSize() {
                                    return super.getMaxTextBufferSize();
                                }

                                @Override
                                protected void onFullTextMessage(WebSocketChannel channel, BufferedTextMessage message) throws IOException {
                                    super.onFullTextMessage(channel, message);
                                }

                                @Override
                                protected void onFullBinaryMessage(WebSocketChannel channel, BufferedBinaryMessage message) throws IOException {
                                    super.onFullBinaryMessage(channel, message);
                                }

                                @Override
                                protected void onFullPingMessage(WebSocketChannel channel, BufferedBinaryMessage message) throws IOException {
                                    super.onFullPingMessage(channel, message);
                                }

                                @Override
                                protected void onFullPongMessage(WebSocketChannel channel, BufferedBinaryMessage message) throws IOException {
                                    super.onFullPongMessage(channel, message);
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
                        }
                    }))
                ).build();
    }

    public void run() {
        server.start();
    }
}
