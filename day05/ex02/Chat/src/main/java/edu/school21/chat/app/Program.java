package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        HikariConfig config = new HikariConfig();
        HikariDataSource dataSource = null;
        try {
            config.setJdbcUrl("jdbc:postgresql://localhost/postgres");
            config.setUsername("postgres");
            config.setPassword("1234");
            dataSource = new HikariDataSource(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Enter a message ID");
        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(dataSource);
        Scanner in = new Scanner(System.in);
        for (int i = in.nextInt(); i < 6; i = in.nextInt()) {
            Optional<Message> tmp = null;
            tmp = messagesRepository.findById((long) i);
            if (tmp.isPresent()) {
                Message message = tmp.get();
                System.out.println(message.toString());
            } else {
                System.out.println("Message not found!");
            }
            System.out.println("Enter a message ID");
        }
    }
}
