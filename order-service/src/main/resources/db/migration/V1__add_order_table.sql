CREATE TABLE order_service.orders (
    order_id BINARY(16) NOT NULL,
    inventory_code VARCHAR(10) NOT NULL,
    description VARCHAR(50) NULL,
    quantity INT NOT NULL,
    price DOUBLE NOT NULL,
    PRIMARY KEY (order_id)
);
