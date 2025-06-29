CREATE TABLE inventory (
    id INT NOT NULL,
    code VARCHAR(50) NOT NULL,
    quantity INT NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO inventory VALUES (1, 'IPPRO16P', 20),
                             (2, 'SAMSUNGG25', 50);