package com.example.kotlin_grpc.client

import grpc.GreeterGrpcKt
import grpc.HelloRequest
import grpc.helloRequest
import io.grpc.ManagedChannel
import io.grpc.Metadata
import java.io.Closeable
import java.util.concurrent.TimeUnit

class GreeterCoroutine(private val channel: ManagedChannel) : Closeable {
    private val stub: GreeterGrpcKt.GreeterCoroutineStub = GreeterGrpcKt.GreeterCoroutineStub(channel)



    suspend fun greet(name: String) : String {

        var req1 = helloRequest {
            this.name = name
        }
        val response = stub.sayHello(req1)
        return  response.message
    }

    override fun close() {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS)
    }
}