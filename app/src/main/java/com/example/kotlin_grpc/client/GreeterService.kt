package com.example.kotlin_grpc.client

import grpc.*
import io.grpc.*
import io.grpc.stub.MetadataUtils
import kotlinx.coroutines.runBlocking



class GreeterService {

    companion object{
        private lateinit var helloReply: HelloReply

        val generalChannel = ManagedChannelBuilder
            .forAddress("192.168.1.2",9876)
            .usePlaintext()
            .keepAliveWithoutCalls(true)
            .build()

        val header: Metadata = Metadata()
        val auth: Metadata.Key<String> = Metadata.Key.of("auth",Metadata.ASCII_STRING_MARSHALLER)




        //header.Put(auth, "barer "+AWSMobileClient.getInstance().tokens.idToken.tokenString);

        //Stub = io.grpc.stub.MetadataUtils.attachHeaders(Stub, header )

        fun greetCoroutine() : String {
            lateinit var Res : String
            val client = GreeterCoroutine(generalChannel)
            runBlocking {
               Res =  client.greet("7ooooodaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
            }

            return Res?: "Failed"

        }

        fun greet1(data : HelloRequest) : HelloReply{
            try{
                //MetaData
                // create a custom header
//                val header: io.grpc.Metadata = io.grpc.Metadata()
//                val auth: io.grpc.Metadata.Key<String> = io.grpc.Metadata.Key.of("authorization", io.grpc.Metadata.ASCII_STRING_MARSHALLER)header.put(auth, "barer "+ AWSMobileClient.getInstance().tokens.idToken.tokenString);
//
//                Stub = io.grpc.stub.MetadataUtils.attachHeaders(Stub, header)

                //source :: https://stackoverflow.com/questions/67732631/android-adding-authorization-header-to-grpc-stub-erroronerror-io-grpc-status
                //REF    :: https://stackoverflow.com/questions/45125601/android-how-to-add-a-custom-header-in-grpc-client
                // Auth Example :: https://sultanov.dev/blog/securing-java-grpc-services-with-jwt-based-authentication/


                val managedChanel = ManagedChannelBuilder
                    .forAddress("41.153.26.252",9876)
                    .usePlaintext()
                    .keepAliveWithoutCalls(true)
                    .build()

                header.put(auth, "barer "+ "AWSMobileClient.getInstance().tokens.idToken.tokenString")

             var greetClient : GreeterGrpc.GreeterBlockingStub = GreeterGrpc.newBlockingStub(managedChanel).withInterceptors(MetadataUtils.newAttachHeadersInterceptor(header))
             var ReturnedData = greetClient.sayHello(data)

                return  ReturnedData


            }catch(err:Exception){
                //throw IOException(err.message)
                return HelloReply.newBuilder().setMessage(err.message).build()
            }
        }

        fun greet(data : HelloRequest) : HelloReply {
            try{
                val managedChanel = ManagedChannelBuilder
                    .forAddress("41.153.26.252",9876)
                    .usePlaintext()
                    .keepAliveWithoutCalls(true)
                    .useTransportSecurity()
                    .build()

                val client = GreeterGrpcKt.GreeterCoroutineStub(managedChanel)

                runBlocking {
                    helloReply = client.sayHello(data)
                }

                return  helloReply

            }catch (err : Exception){
                //throw IOException(err.message)
                return HelloReply.newBuilder().setMessage(err.message).build()
            }
        }
    }
}