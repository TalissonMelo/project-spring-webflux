package com.talissonmelo.webflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.talissonmelo.webflux.document.Playlist;

public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String> {

}
