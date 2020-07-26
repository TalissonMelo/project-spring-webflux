package com.talissonmelo.webflux.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talissonmelo.webflux.document.Playlist;
import com.talissonmelo.webflux.repository.PlaylistRepository;
import com.talissonmelo.webflux.service.PlaylistService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlaylistServiceImpl implements PlaylistService {

	@Autowired
	private PlaylistRepository repository;
	
	@Override
	public Flux<Playlist> findAll() {
		return repository.findAll();
	}

	@Override
	public Mono<Playlist> findById(String id) {
		return repository.findById(id);
	}

	@Override
	public Mono<Playlist> insertPlaylist(Playlist playlist) {
		return repository.save(playlist);
	}

}
