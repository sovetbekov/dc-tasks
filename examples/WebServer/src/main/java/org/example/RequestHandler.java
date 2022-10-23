package org.example;

import java.net.Socket;

public class RequestHandler {
    private final Socket socket;
    private final HttpRequest request;

    public RequestHandler(Socket socket, HttpRequest request) {
        this.socket = socket;
        this.request = request;
    }

    public Socket getSocket() {
        return socket;
    }

    public HttpRequest getRequest() {
        return request;
    }
}
