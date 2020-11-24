package edu.school21.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import java.sql.SQLException;

public class EmbeddedDataSourceTest {
    private EmbeddedDatabase database;

    @BeforeEach
    public void init() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        database = builder
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();
    }

    @Test
    void connectionDbTest() throws SQLException {
        Assertions.assertNotNull(database.getConnection());
    }

    @AfterEach
    public void close() {
        database.shutdown();
    }
}
