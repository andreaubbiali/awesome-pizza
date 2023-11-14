#!/bin/bash

echo "Start insert data into database"

psql -U awesomepizza -h localhost -p 5432 <<EOF
INSERT INTO awesomepizza.ingredients (name) VALUES ('mozzarella');
INSERT INTO awesomepizza.ingredients (name) VALUES ('carciofi');
INSERT INTO awesomepizza.ingredients (name) VALUES ('spinaci');
INSERT INTO awesomepizza.ingredients (name) VALUES ('pomodoro');
INSERT INTO awesomepizza.ingredients (name) VALUES ('prosciutto');
INSERT INTO awesomepizza.ingredients (name) VALUES ('bufala');
INSERT INTO awesomepizza.ingredients (name) VALUES ('zucchina');
INSERT INTO awesomepizza.pizza (name, cost) VALUES ('margherita', 5);
INSERT INTO awesomepizza.pizza (name, cost) VALUES ('prosciutto', 6);
INSERT INTO awesomepizza.pizza (name, cost) VALUES ('bufala', 6);
INSERT INTO awesomepizza.pizza_composition (id_pizza, id_ingredient) VALUES ((SELECT id FROM awesomepizza.pizza WHERE name = 'margherita'), (SELECT id FROM awesomepizza.ingredients WHERE name = 'mozzarella'));
INSERT INTO awesomepizza.pizza_composition (id_pizza, id_ingredient) VALUES ((SELECT id FROM awesomepizza.pizza WHERE name = 'margherita'), (SELECT id FROM awesomepizza.ingredients WHERE name = 'pomodoro'));
INSERT INTO awesomepizza.pizza_composition (id_pizza, id_ingredient) VALUES ((SELECT id FROM awesomepizza.pizza WHERE name = 'prosciutto'), (SELECT id FROM awesomepizza.ingredients WHERE name = 'mozzarella'));
INSERT INTO awesomepizza.pizza_composition (id_pizza, id_ingredient) VALUES ((SELECT id FROM awesomepizza.pizza WHERE name = 'prosciutto'), (SELECT id FROM awesomepizza.ingredients WHERE name = 'pomodoro'));
INSERT INTO awesomepizza.pizza_composition (id_pizza, id_ingredient) VALUES ((SELECT id FROM awesomepizza.pizza WHERE name = 'prosciutto'), (SELECT id FROM awesomepizza.ingredients WHERE name = 'prosciutto'));
INSERT INTO awesomepizza.pizza_composition (id_pizza, id_ingredient) VALUES ((SELECT id FROM awesomepizza.pizza WHERE name = 'bufala'), (SELECT id FROM awesomepizza.ingredients WHERE name = 'bufala'));
INSERT INTO awesomepizza.status (status) VALUES ('CREATED');
INSERT INTO awesomepizza.status (status) VALUES ('IN_QUEUE');
INSERT INTO awesomepizza.status (status) VALUES ('IN_PROGRESS');
INSERT INTO awesomepizza.status (status) VALUES ('READY_FOR_PICKUP');
INSERT INTO awesomepizza.status (status) VALUES ('COMPLETED');
EOF