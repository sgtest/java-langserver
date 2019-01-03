package com.sourcegraph.lsp;

import com.sourcegraph.lsp.domain.Mapper;
import com.sourcegraph.lsp.jsonrpc.Message;
import org.java_websocket.WebSocket;

import java.util.function.Function;

/**
 * TODO(beyang): make true two-way connection, integrate with WebSocketAdapter class...
 */
public class LSPConnection {

    private WebSocket connection;

    public LSPConnection(WebSocket connection) {
        this.connection = connection;
    }

    public void send(Object message) {
        String serialized = Mapper.writeValueAsString(message);
        connection.send(serialized);
    }
}