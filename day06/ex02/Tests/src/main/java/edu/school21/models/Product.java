package edu.school21.models;

import java.util.Objects;

public class Product {

    private Long Id;
    private String Name;
    private Long Price;

    public Product(Long id, String name, Long price) {
        this.Id = id;
        this.Name = name;
        this.Price = price;
    }

    public Product(){}

    public Long getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public Long getPrice() {
        return Price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(Id, product.Id) &&
                Objects.equals(Name, product.Name) &&
                Objects.equals(Price, product.Price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Name, Price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Price=" + Price +
                '}';
    }
}