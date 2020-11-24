package edu.school21.chat.models;

import java.security.Timestamp;
import java.util.Objects;

public class Message {
    private Long id;
    private User author;
    private Chatroom room;
    private String text;
    private Timestamp date;

    public Message(Long id, User author, Chatroom room, String text, Timestamp date) {
        this.id = id;
        this.author = author;
        this.room = room;
        this.text = text;
        this.date = date;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setRoom(Chatroom room) {
        this.room = room;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Chatroom getRoom() {
        return room;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Timestamp getDate() {
        return date;
    }

    public User getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(id, message.id) &&
                Objects.equals(author, message.author) &&
                Objects.equals(room, message.room) &&
                Objects.equals(text, message.text) &&
                Objects.equals(date, message.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, room, text, date);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", author=" + author +
                ", room=" + room +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}
