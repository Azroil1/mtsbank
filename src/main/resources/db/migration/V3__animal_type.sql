create table if not exists animals.animal_type(
    id_type bigint not null,
    type varchar(50),
    is_wild boolean
);

alter table animals.animal_type add primary key (id_type);