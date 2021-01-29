DROP TABLE IF EXISTS BOOK;
DROP TABLE IF EXISTS library;
create table library(
    id int(11) AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL,
    description varchar(500) NULL
);
create table book(
    id int(11) AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL,
     author varchar(50) NOT NULL,
    library_id int(11) NOT NULL,
     FOREIGN KEY(library_id) REFERENCES library(id)

);