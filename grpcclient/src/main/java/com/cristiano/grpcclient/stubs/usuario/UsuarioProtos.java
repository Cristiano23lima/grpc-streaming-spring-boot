// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Usuario.proto

package com.cristiano.grpcclient.stubs.usuario;

public final class UsuarioProtos {
  private UsuarioProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Usuario_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Usuario_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Usuarios_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Usuarios_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rUsuario.proto\"<\n\007Usuario\022\020\n\010fullname\030\001" +
      " \001(\t\022\r\n\005email\030\002 \001(\t\022\020\n\010password\030\003 \001(\t\"%\n" +
      "\010Usuarios\022\031\n\007usuario\030\001 \003(\0132\010.Usuario2\265\001\n" +
      "\016UsuarioService\022\033\n\005salve\022\010.Usuario\032\010.Usu" +
      "ario\022-\n\024salveAllStreamClient\022\010.Usuario\032\t" +
      ".Usuarios(\001\022-\n\024salveAllStreamServer\022\t.Us" +
      "uarios\032\010.Usuario0\001\022(\n\016salveAllStream\022\010.U" +
      "suario\032\010.Usuario(\0010\001B9\n&com.cristiano.gr" +
      "pcclient.stubs.usuarioB\rUsuarioProtosP\001b" +
      "\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_Usuario_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Usuario_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Usuario_descriptor,
        new java.lang.String[] { "Fullname", "Email", "Password", });
    internal_static_Usuarios_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Usuarios_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Usuarios_descriptor,
        new java.lang.String[] { "Usuario", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
