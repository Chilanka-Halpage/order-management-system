package com.csh.oms.product_service.dto;

public class ProductResponseDTO {
    private String id;
    private String name;
    private String description;
    private double price;

    private ProductResponseDTO(ProductResponseDTOBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
    }

    public static class ProductResponseDTOBuilder {
        private String id;
        private String name;
        private String description;
        private double price;

        public ProductResponseDTOBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public ProductResponseDTOBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ProductResponseDTOBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ProductResponseDTOBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public ProductResponseDTO build() {
            return new ProductResponseDTO(this);
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
