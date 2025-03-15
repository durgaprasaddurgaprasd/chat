package com.realtimechat.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "messages")  // Ensure this matches your MongoDB collection
public class Message {
    
    @Id
    private String id; // MongoDB document ID
    
    @JsonProperty("name")  // Ensure correct JSON mapping
    private String name;
    
    @JsonProperty("content")  // Ensure correct JSON mapping
    private String content;

    public Message() { }

    public Message(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    @Override
    public String toString() {
        return "Message [name=" + name + ", content=" + content + "]";
    }
}
