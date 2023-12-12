CREATE DATABASE IF NOT EXISTS motogp;
USE motogp;

CREATE TABLE IF NOT EXISTS campionato1972 (
    posizione int NOT NULL,
    pilota varchar(255) NOT NULL,
    punti int NOT NULL,
    PRIMARY KEY (posizione)
);