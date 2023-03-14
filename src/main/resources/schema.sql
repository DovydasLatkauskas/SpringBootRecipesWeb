create table if not exists recipes (
    name varchar(255) PRIMARY KEY NOT NULL,
    author varchar(255),
    description varchar(2500),
    prepTimeMinutes INT,
    cookTimeMinutes INT,
    ingredients varchar(2500),
    directions varchar(2500),
    tags varchar(2500)
    );