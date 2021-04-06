CREATE TABLE Usuario(
    id bigint auto_increment,
    username varchar(50) not null,
    password varchar(50) not null,
    name varchar(100),
    email varchar(100),
    CONSTRAINT Usuario_pk PRIMARY KEY(id)
);