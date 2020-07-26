package com.talissonmelo.webflux.reactor;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.talissonmelo.webflux.document.Playlist;
import com.talissonmelo.webflux.service.PlaylistService;

import reactor.core.publisher.Mono;

//@Component
public class PlaylistHandler {

	@Autowired
	private PlaylistService service;
	
	public Mono<ServerResponse> findAll(ServerRequest request){
	return ok().contentType(MediaType.APPLICATION_JSON)
			.body(service.findAll(), Playlist.class);
	}
	
	public Mono<ServerResponse> findById(ServerRequest request){
		String id = request.pathVariable("id");
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findById(id), Playlist.class);
	}
	
	public Mono<ServerResponse> insert(ServerRequest request){
		final Mono<Playlist> playlist = request.bodyToMono(Playlist.class);
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(fromPublisher(playlist.flatMap(service::insertPlaylist), Playlist.class));
	}
}
