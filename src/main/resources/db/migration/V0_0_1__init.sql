CREATE SCHEMA IF NOT EXISTS test;
CREATE TABLE test.racks
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(255),
    description TEXT

);
CREATE TABLE test.products
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(255)        NOT NULL,
    description TEXT,
    price       DECIMAL(10, 2)      NOT NULL,
    article     VARCHAR(255) UNIQUE NOT NULL,
    rack_id     INTEGER REFERENCES test.racks (id)
);
CREATE TABLE test.additional_racks
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(255),
    description TEXT

);
CREATE TABLE test.products_and_Additional_racks
(
    id                  SERIAL PRIMARY KEY,
    product_id          INTEGER REFERENCES test.products (id),
    additional_racks_id INTEGER REFERENCES test.additional_racks (id)


);

CREATE TABLE test.orders
(
    id              SERIAL PRIMARY KEY,
    number_of_order INTEGER
);

CREATE TABLE test.products_in_order

(
    id         SERIAL PRIMARY KEY,
    product_id INTEGER REFERENCES test.products (id),
    order_id   INTEGER REFERENCES test.orders (id)

);



CREATE TABLE test.racks_of_products
(
    id         SERIAL PRIMARY KEY,
    rack_id INTEGER REFERENCES test.racks (id),
    main      BOOLEAN NOT NULL,
    quantity  INTEGER NOT NULL
);



INSERT INTO test.racks (name, description)
VALUES ('A', 'Rack for laptops and monitors'),
       ('B', 'Mobile phone rack'),
       ('ZH', 'Rack for other equipment');

INSERT INTO test.additional_racks (name, description)
VALUES ('Z', 'Additional phone rack'),
       ('V', 'Additional phone rack'),
       ('A', 'Additional rack for watches');



INSERT INTO test.products (name, description, price, article, rack_id)
VALUES ('Laptop', 'A powerful laptop for work and play', 50000, 'NB-123', 1),
       ('Monitor', '24" Full HD monitor', 15000, 'MN-456', 1),
       ('Smartphone', 'Smartphone with 6.5" screen and 4 cameras', 30000, 'TL-789', 2),
       ('Watch', '---', 20000, 'TL-790', 3),
       ('System unit', '---', 70000, 'TL-791', 3),
       ('Microphone', '---', 1000, 'TL-792', 3);


INSERT INTO test.products_and_Additional_racks (product_id, additional_racks_id)
VALUES (3, 1);

INSERT INTO test.products_and_Additional_racks (product_id, additional_racks_id)
VALUES (3, 2);

INSERT INTO test.products_and_Additional_racks (product_id, additional_racks_id)
VALUES (4, 3);


INSERT INTO test.orders(number_of_order)
VALUES (10);

INSERT INTO test.orders(number_of_order)
VALUES (11);

INSERT INTO test.orders(number_of_order)
VALUES (14);
INSERT INTO test.orders(number_of_order)
VALUES (15);


INSERT INTO test.products_in_order(product_id, order_id)
VALUES (1, 1);
INSERT INTO test.products_in_order(product_id, order_id)
VALUES (1, 1);

INSERT INTO test.products_in_order(product_id, order_id)
VALUES (3, 1);

INSERT INTO test.products_in_order(product_id, order_id)
VALUES (6, 1);


INSERT INTO test.products_in_order(product_id, order_id)
VALUES (2, 2);
INSERT INTO test.products_in_order(product_id, order_id)
VALUES (2, 2);
INSERT INTO test.products_in_order(product_id, order_id)
VALUES (2, 2);

INSERT INTO test.products_in_order(product_id, order_id)
VALUES (1, 3);
INSERT INTO test.products_in_order(product_id, order_id)
VALUES (1, 3);
INSERT INTO test.products_in_order(product_id, order_id)
VALUES (1, 3);


INSERT INTO test.products_in_order(product_id, order_id)
VALUES (5, 3);
INSERT INTO test.products_in_order(product_id, order_id)
VALUES (5, 3);
INSERT INTO test.products_in_order(product_id, order_id)
VALUES (5, 3);

INSERT INTO test.products_in_order(product_id, order_id)
VALUES (4, 4);



