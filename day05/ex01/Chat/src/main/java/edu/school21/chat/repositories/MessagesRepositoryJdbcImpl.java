package edu.school21.chat.repositories;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

    private DataSource dataSource;

    public MessagesRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {
        try {
            Connection connection = dataSource.getConnection();

            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM messages WHERE id=" + id + ";");
            long authorId = 0L, roomId = 0L;
            String textMessage = null;
            Timestamp date = null;

            if (set.next()) {
                authorId = (long) set.getInt("author");
                roomId = set.getLong("room");
                textMessage = set.getString("text");
                date = set.getTimestamp("date");
            }

            set = statement.executeQuery("SELECT * FROM users WHERE id=" + authorId + ";");
            String userLogin = null, userPassword = null;

            if (set.next()) {
                userLogin = set.getString("login");
                userPassword = set.getString("password");
            }

            User user = new User(authorId, userLogin, userPassword, null, null);
            set = statement.executeQuery("SELECT * FROM rooms WHERE id=" + roomId + ";");
            String roomName = null;

            if (set.next()) {
                roomName = set.getString("name");
            }

            Chatroom room = new Chatroom(roomId, roomName, null, null);
            connection.close();
            return Optional.of(new Message(id, user, room, textMessage, date));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
