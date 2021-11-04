package com.cristiano.grpcclient;

import com.cristiano.grpcclient.stubs.usuario.Usuario;
import com.cristiano.grpcclient.stubs.usuario.UsuarioServiceGrpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class GrpcclientApplication {

	public static void main(String[] args) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5001).usePlaintext().build();

		UsuarioServiceGrpc.UsuarioServiceBlockingStub stub = UsuarioServiceGrpc.newBlockingStub(channel);

		Usuario response = stub.salve(
				Usuario.newBuilder().setFullname("Cristiano Rodrigues de Lima").setEmail("email@teste.com").build());

		log.info(response.toString());
		channel.shutdown();
		// SpringApplication.run(GrpcclientApplication.class, args);
	}

}
