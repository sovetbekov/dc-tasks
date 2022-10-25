package org.example;

import java.io.IOException;


public class Consumer extends Thread {
    private final ThreadSafeQueue queue;

    public Consumer(ThreadSafeQueue queue) {
        this.queue = queue;
    }

    public void handle(RequestHandler handler) throws IOException {
        Processor proc = new Processor(handler.getSocket(), handler.getRequest());
        proc.process();
    }


    @Override
    public void run() {
        try {
            while (true) {
                // Wait for new element.
                RequestHandler elem = (RequestHandler) queue.pop();


                // Stop consuming if null is received.
                if (elem == null) {
                    return;
                }

                // Process element.
                handle(elem);
            }
        }
        catch (InterruptedException | IOException ex) {
            ex.printStackTrace();
        }
    }
}
