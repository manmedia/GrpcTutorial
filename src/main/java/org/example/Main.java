package org.example;

import org.example.service.GreeterServer;
import org.example.service.GreeterServiceImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        GreeterServer server = new GreeterServer(new GreeterServiceImpl(), 32122);
        server.start();
        server.awaitTermination();

    }
}