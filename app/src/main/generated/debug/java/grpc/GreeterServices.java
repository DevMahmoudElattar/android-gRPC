// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Hello.proto

package grpc;

public final class GreeterServices {
  private GreeterServices() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_helloGreeter_HelloRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_helloGreeter_HelloRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_helloGreeter_HelloReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_helloGreeter_HelloReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013Hello.proto\022\014helloGreeter\"\034\n\014HelloRequ" +
      "est\022\014\n\004name\030\001 \001(\t\"\035\n\nHelloReply\022\017\n\007messa" +
      "ge\030\001 \001(\t2M\n\007Greeter\022B\n\010SayHello\022\032.helloG" +
      "reeter.HelloRequest\032\030.helloGreeter.Hello" +
      "Reply\"\000B\034\n\004grpcB\017GreeterServicesP\001\210\001\001b\006p" +
      "roto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_helloGreeter_HelloRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_helloGreeter_HelloRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_helloGreeter_HelloRequest_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_helloGreeter_HelloReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_helloGreeter_HelloReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_helloGreeter_HelloReply_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}