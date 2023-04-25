CREATE TABLE IF NOT EXISTS city.sights
(
    id uuid not null
        constraint sights_pkey primary key,
    name varchar,
    type varchar,
    address varchar,
    architect varchar,
    city_id uuid
);