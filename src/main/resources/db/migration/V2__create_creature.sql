create table if not exists animals.creature(
                                 id_creature bigint not null ,
                                 name text not null,
                                 type_id int not null,
                                 age smallint not null
);

alter table animals.creature add primary key (id_creature);