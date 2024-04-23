insert into animals.animal_type(type)
values ('Wolf'),
       ('COW'),
       ('FISH'),
       ('CAT');

UPDATE animals.animal_type SET is_wild = true
where type = 'Wolf';

select * from animals.animal_type;

insert into animals.habitat(id_area, area)
values (1, 'Дом'),
       (2, 'Дикая среда');

insert into animals.animals_habits(id_animal_type, id_area)
VALUES (1,2),
       (2,1),
       (3,2),
       (4,1);

insert into animals.provider(id_provider, name, phone)
VALUES (1, 'Wolf provider', '+75444540663'),
       (2, 'COW provider', '+12324934392'),
       (3, 'FISH provider', '+9213232811192'),
       (4, 'CAT provider', '+103243943929');

insert into animals.animals_provider(id_animal_type, id_provider)
VALUES (1,1),
       (2,2),
       (3,3),
       (4,4);

insert into animals.creature(name, type_id, age, birth_date)
values ('My Wolf', 1, 2, to_date('22/04/2022','DD/MM/YYYY')),
       ('Murka', 2, 10, to_date('19/01/2014','DD/MM/YYYY')),
       ('Nemo', 3, 1, to_date('05/02/2023','DD/MM/YYYY')),
       ('Bars', 4,9, to_date('17/10/2014','DD/MM/YYYY'));
