package com.matheus.projects.mongo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.matheus.projects.mongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	@Query("{'title':{$regex: ?0, $options:'i'}}")
	List<Post> searchTitle(String text);

	@Query("{$and: { [ {date: {$gte: ?1} }, { {date: {$lte:?2 } } }, { $or: [{'title':{$regex: ?0, $options:'i'}}, {<expression2>}, {} ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);

	List<Post> findByTitleContaining(String text);

}
