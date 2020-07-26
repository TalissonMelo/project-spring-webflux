package com.talissonmelo.webflux;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;

import com.talissonmelo.webflux.document.Playlist;
import com.talissonmelo.webflux.repository.PlaylistRepository;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class WebfluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ReactiveMongoOperations reactiveMongoOperations,
			PlaylistRepository playlistRepository) {

		return args -> {
			Flux<Playlist> playList = Flux.just(
					new Playlist(null, "The Black Eyed Peas - Where Is The Love?"),
					new Playlist(null, "The Chainsmokers - Closer ft. Halsey"),
					new Playlist(null, "Rihanna - Only Girl (In The World)"),
					new Playlist(null, "Skillet - Feel Invincible"),
					new Playlist(null, "Linkin Park - In The End"))
			.flatMap(playlistRepository::save);

			playList.thenMany(playlistRepository.findAll())
					.subscribe(System.out::println);
		};
	}
}
