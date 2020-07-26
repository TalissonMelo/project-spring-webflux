package com.talissonmelo.webflux.service;

import com.talissonmelo.webflux.document.Playlist;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlaylistService {

	Flux<Playlist> findAll();
	Mono<Playlist> findById(String id);
	Mono<Playlist> insertPlaylist(Playlist playlist);
	
}
