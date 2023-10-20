CREATE TABLE client (
                        cpf VARCHAR(11) PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        email VARCHAR(255) NOT NULL,
                        date_of_birth DATE NOT NULL,
                        registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);


CREATE TABLE client_order (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       cpf VARCHAR(11) NOT NULL,
                       status VARCHAR(255) NOT NULL,
                       order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                       last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
                       FOREIGN KEY (cpf) REFERENCES client(cpf)
);

CREATE TABLE payment (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         order_id INT NOT NULL,
                         status VARCHAR(255) NOT NULL,
                         FOREIGN KEY (order_id) REFERENCES client_order(id)
);



CREATE TABLE item (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      description TEXT NOT NULL,
                      price DECIMAL(10, 2) NOT NULL,
                      type VARCHAR(50) NOT NULL
);

CREATE TABLE order_item (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            order_id INT NOT NULL,
                            item_id INT NOT NULL,
                            quantity INT NOT NULL,
                            total_price DECIMAL(10, 2) NOT NULL,
                            FOREIGN KEY (order_id) REFERENCES client_order(id),
                            FOREIGN KEY (item_id) REFERENCES item(id)
);