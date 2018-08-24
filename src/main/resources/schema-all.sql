DROP TABLE people IF EXISTS;

CREATE TABLE people  (
    person_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    name VARCHAR(20),
    birthday DATE,
    sex VARCHAR(1)
);
