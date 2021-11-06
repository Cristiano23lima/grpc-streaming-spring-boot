package com.cristiano.grpcclient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.cristiano.grpcclient.stubs.usuario.Usuario;
import com.cristiano.grpcclient.stubs.usuario.UsuarioServiceGrpc;
import com.cristiano.grpcclient.stubs.usuario.Usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class GrpcclientApplication {

	public static void main(String[] args) throws Exception {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5001).usePlaintext().build();

		UsuarioServiceGrpc.UsuarioServiceBlockingStub stubBloking = UsuarioServiceGrpc.newBlockingStub(channel);
		UsuarioServiceGrpc.UsuarioServiceStub stubNonBloking = UsuarioServiceGrpc.newStub(channel);

		// Usuario response = stubBloking.salve(
		// Usuario.newBuilder().setFullname("Cristiano Rodrigues de
		// Lima").setEmail("email@teste.com").build());
		// log.info(response.getFullname());

		clientSideStream(stubNonBloking);
		channel.shutdown().awaitTermination(5, TimeUnit.MINUTES);
		// SpringApplication.run(GrpcclientApplication.class, args);
	}

	public static void clientSideStream(UsuarioServiceGrpc.UsuarioServiceStub stub) throws Exception {
		StreamObserver<Usuarios> responseObserver = new StreamObserver<Usuarios>() {
			@Override
			public void onNext(Usuarios value) {
				log.info("Foram salvos " + value.getUsuarioCount() + " Usuários");
			}

			@Override
			public void onCompleted() {
				log.info("Finalizado o envio de dados!");
			}

			@Override
			public void onError(Throwable t) {
				log.error(t.getMessage(), t);
			}
		};

		StreamObserver<Usuario> requestObserver = stub.salveAllStreamClient(responseObserver);

		try {
			for (Usuario usuario : getUsuarios()) {
				requestObserver.onNext(usuario);
				log.info("Mandando usuario: " + usuario.getFullname());
			}
		} catch (RuntimeException e) {
			requestObserver.onError(e);
			throw e;
		}

		requestObserver.onCompleted();
	}

	public static List<Usuario> getUsuarios() {
		Usuario usuario1 = Usuario.newBuilder().setFullname("Cristiano Rodrigues de Lima 1").setEmail("email@teste.com")
				.build();
		Usuario usuario2 = Usuario.newBuilder().setFullname("Cristiano Rodrigues de Lima 2").setEmail("email@teste.com")
				.build();
		Usuario usuario3 = Usuario.newBuilder().setFullname("Cristiano Rodrigues de Lima 3").setEmail("email@teste.com")
				.build();
		Usuario usuario4 = Usuario.newBuilder().setFullname("Cristiano Rodrigues de Lima 4").setEmail("email@teste.com")
				.build();
		Usuario usuario5 = Usuario.newBuilder().setFullname("Cristiano Rodrigues de Lima 5").setEmail("email@teste.com")
				.build();

		List<Usuario> listUsuarios = new ArrayList<>();
		listUsuarios.add(usuario1);
		listUsuarios.add(usuario2);
		listUsuarios.add(usuario3);
		listUsuarios.add(usuario4);
		listUsuarios.add(usuario5);

		return listUsuarios;
	}

}
