package com.realtimechat.repositary;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.realtimechat.model.Message;

public interface MessageRepositary extends MongoRepository<Message, String> {
}
