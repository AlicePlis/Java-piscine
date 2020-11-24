package edu.school21.repositories;

import edu.school21.models.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import java.util.Arrays;
import java.util.List;

class ProductsRepositoryJdbcImplTest {

    private EmbeddedDatabase database;
    private ProductsRepository repository;

    final List<Product> EXPECTED_FIND_ALL_PRODUCTS =
            Arrays.asList(
                    new Product(1L, "rose", 10L),
                    new Product(2L, "lily", 25L),
                    new Product(3L, "orchid", 30L),
                    new Product(4L, "pion", 35L),
                    new Product(5L, "petunia", 40L));
    final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product(2L, "lily", 25L);
    final Product EXPECTED_UPDATED_PRODUCT = new Product(1L, "rose", 45L);
    final Product EXPECTED_SAVED_PRODUCT =  new Product(6L, "poppy", 40L);

    @BeforeEach
    public void init() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        database = builder
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();
        repository = new ProductsRepositoryJdbcImpl(database);
    }

    @Test
    public void testFindAll() {
        Assertions.assertEquals(EXPECTED_FIND_ALL_PRODUCTS, repository.findAll());
    }

    @Test
    public void testFindById() {
        Assertions.assertEquals(EXPECTED_FIND_BY_ID_PRODUCT, repository.findById(2L).get());
    }

    @Test
    public void testUpdate() {
        repository.update(new Product(1L, "rose", 45L));
        Assertions.assertEquals(EXPECTED_UPDATED_PRODUCT, repository.findById(1L).get());
    }

    @Test
    public void testSave() {
        repository.save(new Product(6L, "poppy", 40L));
        Assertions.assertEquals(EXPECTED_SAVED_PRODUCT, repository.findById(6L).get());
    }

    @Test
    public void testDelete() {
        repository.delete(6L);
        Assertions.assertEquals(new Product(null, null, null), repository.findById(6L).get());
    }

    @AfterEach
    public void close() {
        database.shutdown();
    }
}
