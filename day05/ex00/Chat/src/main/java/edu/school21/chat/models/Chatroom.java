package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Chatroom {
	private Long id;
	private String name;
	private User creator;
	private List<Message> messages;

	public Chatroom(Long id, String name, User creator, List<Message> messages) {
		this.id = id;
		this.name = name;
		this.creator = creator;
		this.messages = messages;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public User getCreator() {
		return creator;
	}

	public List<Message> getMessages() {
		return messages;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Chatroom chatroom = (Chatroom) o;
		return Objects.equals(id, chatroom.id) &&
				Objects.equals(name, chatroom.name) &&
				Objects.equals(creator, chatroom.creator) &&
				Objects.equals(messages, chatroom.messages);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, creator, messages);
	}

	@Override
	public String toString() {
		return "Chatroom{" +
				"id=" + id +
				", name='" + name + '\'' +
				", creator=" + creator +
				", messages=" + messages +
				'}';
	}
}
