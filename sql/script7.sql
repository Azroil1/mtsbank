create table animals.provider(id_provider int not null, name text, phone nchar(50));

create table animals.animals_provider(id_animal_type int not null , id_provider int not null);

alter table animals.animals_provider
    ADD CONSTRAINT fk_animals_provider_animal_type FOREIGN KEY (id_animal_type)
        REFERENCES animals.animal_type(id_type);

alter table animals.provider add primary key (id_provider);

alter table animals.animals_provider
    ADD CONSTRAINT fk_animal_provider_provider FOREIGN KEY (id_provider)
        REFERENCES animals.provider(id_provider);
