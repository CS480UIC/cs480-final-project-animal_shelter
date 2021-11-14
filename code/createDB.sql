CREATE DATABASE IF NOT EXISTS animal_shelter;

USE animal_shelter;

CREATE TABLE animal (
	id VARCHAR(10) NOT NULL UNIQUE,
    name VARCHAR(30) NOT NULL,
    species VARCHAR(50),
    age INT,
    physical_description VARCHAR(100) NOT NULL,
    microchip_id VARCHAR(10) UNIQUE,
    adoption_history VARCHAR(100) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE person (
	id VARCHAR(10) NOT NULL UNIQUE,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    dob DATE NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone CHAR(10) NOT NULL,
    street_address VARCHAR(50) NOT NULL,
    zip_code VARCHAR(10) NOT NULL,
    housing_status VARCHAR(20) NOT NULL,
    kids INT,
    adoption_history CHAR(50),
    PRIMARY KEY(id)
);

CREATE TABLE shelter_animal (
	animal_id VARCHAR(10) NOT NULL,
    shelter_id VARCHAR(10) NOT NULL UNIQUE,
    date_of_entry DATE NOT NULL,
    date_of_exit DATE,
    adopter_id VARCHAR(10),
    PRIMARY KEY(animal_id, shelter_id),
    FOREIGN KEY(animal_id) REFERENCES animal(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE medical (
	animal_id VARCHAR(10) NOT NULL UNIQUE,
    clinic_id VARCHAR(10) NOT NULL,
    vet_id VARCHAR(10) NOT NULL,
    date_of_visit DATE NOT NULL,
    diagnosis VARCHAR(100) NOT NULL,
    prescription VARCHAR(100) NOT NULL,
    total_due INT(10) NOT NULL,
    PRIMARY KEY(animal_id, clinic_id, vet_id), 
    FOREIGN KEY(animal_id) references animal(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE shelter_finance (
	transaction_id VARCHAR(10) NOT NULL UNIQUE,
    transaction_value INT NOT NULL,
    transaction_type VARCHAR(20) NOT NULL,
    donor_name VARCHAR(50),
    person_id VARCHAR(10),
    transaction_date DATE NOT NULL,
    PRIMARY KEY (transaction_id),
    FOREIGN KEY(person_id) references person(id) ON DELETE SET NULL ON UPDATE CASCADE
);


/* contents from the user.sql project file*/ 
CREATE DATABASE IF NOT EXISTS bookstore;

USE bookstore;

CREATE TABLE user
(
  
  username VARCHAR(50) primary key,
  `password` VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL
);


CREATE TABLE entity1 
(
  
  username VARCHAR(50) primary key,
  `password` VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL
);