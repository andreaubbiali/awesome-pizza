-- liquibase formatted sql

-- changeset liquibase aubbiali:2
CREATE TABLE awesomepizza.orders (
    id SERIAL,
    insert_date DATE NOT NULL,
    order_date DATE NOT NULL,
    slot INT CONSTRAINT slot CHECK (slot >= 1 AND slot <= 2) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE awesomepizza.status(
    id SERIAL,
    status VARCHAR(25) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE awesomepizza.order_status (
    id_order INT,
    id_status INT,
    change_date Date NOT NULL,
    PRIMARY KEY (id_order, id_status),
    FOREIGN KEY (id_order) REFERENCES orders(id) ON DELETE no action ON UPDATE no action,
    FOREIGN KEY (id_status) REFERENCES status(id) ON DELETE no action ON UPDATE no action
);
CREATE TABLE awesomepizza.order_pizza (
    id_order INT,
    id_pizza INT,
    quantity INT CONSTRAINT quantity CHECK (quantity > 0) NOT NULL,
    Changes VARCHAR,
    PRIMARY KEY (id_order, id_pizza),
    FOREIGN KEY (id_order) REFERENCES orders(id) ON DELETE no action ON UPDATE no action,
    FOREIGN KEY (id_pizza) REFERENCES pizza(id) ON DELETE no action ON UPDATE no action
);