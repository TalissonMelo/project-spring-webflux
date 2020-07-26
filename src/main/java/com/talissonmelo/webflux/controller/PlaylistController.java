package com.talissonmelo.webflux.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talissonmelo.webflux.document.Playlist;
import com.talissonmelo.webflux.service.PlaylistService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
@RequestMapping(value = "/playlist")
public class PlaylistController {

	@Autowired
	private PlaylistService service;
	
	@GetMapping
	public Flux<Playlist> findAll(){
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Mono<Playlist> findById(@PathVariable String id){
		return service.findById(id);
	}
	
	@PostMapping
	public Mono<Playlist> insert(@RequestBody Playlist playlist){
		return service.insertPlaylist(playlist);
	}
	
	@GetMapping(value="/playlist/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Tuple2<Long, Playlist>> getPlaylistByWebflux(){

		Flux<Long> interval = Flux.interval(Duration.ofSeconds(5));
        Flux<Playlist> playlistFlux = service.findAll();
        return Flux.zip(interval, playlistFlux);
        
	}
}
