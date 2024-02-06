package com.fst.Commantaire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@SpringBootApplication
public class CommentaireApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommentaireApplication.class, args);
	}

}
