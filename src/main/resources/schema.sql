create table if not exists RECIPES (
    NAME varchar(255) PRIMARY KEY NOT NULL,
    AUTHOR varchar(255),
    DESCRIPTION varchar(2500),
    PREP_TIME_MINUTES INT,
    COOK_TIME_MINUTES INT,
    INGREDIENTS varchar(2500),
    DIRECTIONS varchar(2500),
    TAGS varchar(2500)
    );