-- liquibase formatted sql

-- changeset liquibase aubbiali:1
CREATE TABLE awesomepizza.pizza (
    id SERIAL,
    name VARCHAR(50) NOT NULL,
    cost INT CONSTRAINT cost CHECK (cost > 0) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE awesomepizza.ingredients (
    id SERIAL,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE awesomepizza.pizza_composition (
    id_pizza INT,
    id_ingredient INT,
    FOREIGN KEY (id_pizza) REFERENCES pizza(id) ON DELETE no action ON UPDATE no action,
    FOREIGN KEY (id_ingredient) REFERENCES ingredients(id) ON DELETE no action ON UPDATE no action,
    PRIMARY KEY(id_pizza, id_ingredient)
);