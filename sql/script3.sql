create table animals.animal_type(
    id_type bigint not null,
    type nchar(50),
    is_wild boolean
);

alter table animals.animal_type add primary key (id_type);