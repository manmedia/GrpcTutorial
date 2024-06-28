package org.example.service;


import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * This is the server which will contain the Service
 * The service will interact with client code through the Server
 *
 */

public class GreeterServer {

    private BindableService service;
    private int port;
    private Server server;


    public GreeterServer (BindableService service, int port) {
        this.service = service;
        this.port = port;
    }

    public void start() throws IOException {

        this.server = ServerBuilder.forPort(this.port).addService(this.service).build().start();
        if (this.server == null) {
            System.err.println("Why is this server null again????");
        }
        System.out.println("Started server on port " + this.port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.err.println("Shutting down gRPC server");
                try {
                    server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
            }
        });
    }

    public void awaitTermination() throws InterruptedException {
        this.server.awaitTermination();
    }




}
