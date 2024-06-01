create table animals.users(
    id bigint primary key,
    name varchar(50) unique,
    password varchar(256),
    role text
);