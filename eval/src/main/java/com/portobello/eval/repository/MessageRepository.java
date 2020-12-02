package com.portobello.eval.repository;

import com.portobello.eval.model.PracticalMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends MongoRepository<PracticalMessage, String> {
}
