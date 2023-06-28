package com.example.pathfinder2023.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class MessageEntity extends BaseEntity{

    @Column
    private LocalDateTime dateTime;

    @Column(name ="text_content", columnDefinition = "TEXT")
    private String textContent;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private UserEntity author;

   @ManyToOne
   @JoinColumn(name = "recipient_id")
   private UserEntity recipient;

    public MessageEntity() {
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public MessageEntity setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public String getTextContent() {
        return textContent;
    }

    public MessageEntity setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public MessageEntity setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    public UserEntity getRecipient() {
        return recipient;
    }

    public MessageEntity setRecipient(UserEntity recipient) {
        this.recipient = recipient;
        return this;
    }
}
//•	date time - Accepts Date and Time values
//•	text content - Accepts very long String values
//•	author - Accepts User Entities as values
//•	recipient - Accepts User Entities as values