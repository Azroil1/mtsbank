create sequence id_creature_sequence OWNED BY animals.creature.id_creature;
alter table animals.creature ALTER id_creature SET DEFAULT nextval('id_creature_sequence');

create sequence id_type_sequence OWNED BY animals.animal_type.id_type;
alter table animals.animal_type ALTER id_type SET DEFAULT nextval('id_type_sequence');

alter table animals.animal_type ADD CONSTRAINT unique_type_name UNIQUE (type);

alter table animals.creature ADD CONSTRAINT fk_creature_animal_type FOREIGN KEY (type_id) REFERENCES animals.animal_type(id_type) ;

alter table animals.animal_type ALTER Column is_wild SET DEFAULT false;

alter table animals.creature ADD COLUMN birth_date DATE default NOW();