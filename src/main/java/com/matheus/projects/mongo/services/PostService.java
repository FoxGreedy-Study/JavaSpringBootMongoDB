package com.matheus.projects.mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.projects.mongo.domain.Post;
import com.matheus.projects.mongo.repositories.PostRepository;
import com.matheus.projects.mongo.services.excepetion.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public Post findById(String id) {
		Optional<Post> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}
	
	public List<Post> findByTitle(String text){
		return repository.findByTitleContaining(text);
	}
	
	

}
