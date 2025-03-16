package com.realtimechat.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "messages")
public class Message {

    @Id
    private String id;

    @JsonProperty("name")
    private String name; // User's name

    @JsonProperty("content")
    private String content; // Message content

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
