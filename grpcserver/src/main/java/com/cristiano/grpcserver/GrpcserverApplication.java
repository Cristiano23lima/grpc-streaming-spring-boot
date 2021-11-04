package com.cristiano.grpcserver;

import java.io.IOException;

import com.cristiano.grpcserver.services.UserServiceImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.grpc.Server;
import io.grpc.ServerBuilder;

@SpringBootApplication
public class GrpcserverApplication {

	public static void main(String[] args) throws Exception {
		Server server = ServerBuilder.forPort(5001).addService(new UserServiceImpl()).build();

		SpringApplication.run(GrpcserverApplication.class, args);
		try {
			server.start();
			server.awaitTermination();
		} catch (InterruptedException | IOException e) {
			throw new Exception(e.getMessage());
		}

	}

}
