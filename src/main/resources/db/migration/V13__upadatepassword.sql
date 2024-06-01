CREATE EXTENSION pgcrypto;

UPDATE animals.users
SET password = crypt('123',gen_salt('bf', 10))
WHERE name = 'amir';