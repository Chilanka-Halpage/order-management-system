package com.csh.oms.product_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "product")
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private double price;

    public Product() {

    }

    private Product(ProductResponseDtoBuilder productBuilder) {
        this.id = productBuilder.id;
        this.name = productBuilder.name;
        this.description = productBuilder.description;
        this.price = productBuilder.price;
    }

    public static class ProductResponseDtoBuilder {
        private String id;
        private String name;
        private String description;
        private double price;

        public ProductResponseDtoBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public ProductResponseDtoBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ProductResponseDtoBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ProductResponseDtoBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        return price;
    }

}
