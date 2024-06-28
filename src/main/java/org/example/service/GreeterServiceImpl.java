package org.example.service;

import io.grpc.stub.StreamObserver;
import o.m.t.GreeterGrpc;
import o.m.t.HelloReply;
import o.m.t.HelloRequest;

public class GreeterServiceImpl extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        responseObserver.onNext(HelloReply.newBuilder().setMessage("Hello " + request.getName()).build());
        responseObserver.onCompleted();
    }


}
