CREATE TABLE WildlifeWarden (id serial PRIMARY KEY, name VARCHAR, tag INT, phone INT, email VARCHAR);

CREATE TABLE Wildlife (id serial PRIMARY KEY, name VARCHAR,health VARCHAR, age VARCHAR);

CREATE TABLE WildlifeEndangered(id serial PRIMARY KEY, name VARCHAR, health VARCHAR, age VARCHAR);

CREATE TABLE WildlifeLocation (id serial PRIMARY KEY, name VARCHAR);

CREATE TABLE WildlifeSighting (id SERIAL PRIMARY KEY, animalId INT, rangerId INT, locationId INT, time TIMESTAMP);
