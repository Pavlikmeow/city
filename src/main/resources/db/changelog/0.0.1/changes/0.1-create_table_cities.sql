CREATE TABLE IF NOT EXISTS city.cities
(
    id uuid not null
        constraint cities_pkey primary key,
    name varchar,
    country varchar,
    area int,
    population int
);