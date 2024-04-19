alter table animals.animals_habits ADD CONSTRAINT fk_animals_habits_animal_type FOREIGN KEY (id_animal_type) REFERENCES animals.animal_type(id_type);

alter table animals.animals_habits ADD CONSTRAINT fk_animals_habits_habitat FOREIGN KEY (id_area) REFERENCES animals.habitat(id_area);