package com.talissonmelo.webflux.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Playlist {

	@Id
	private String id;
	private String music;
	public Playlist(String id, String music) {
		super();
		this.id = id;
		this.music = music;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMusic() {
		return music;
	}
	public void setMusic(String music) {
		this.music = music;
	}
	@Override
	public String toString() {
		return "Playlist id" + id + ", musica : " + music;
	}
	
	
}
