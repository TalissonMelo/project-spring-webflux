package com.talissonmelo.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.talissonmelo.webflux.document.Playlist;
import com.talissonmelo.webflux.service.PlaylistService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@RestController
//@RequestMapping(value = "/playlist")
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
}
