CREATE TABLE if not exists plot
(
    id                          serial                   NOT NULL,
    name                        varchar(500)             NOT NULL,
    description                 varchar(500),
    status                      varchar(150) NOT NULL default 'NEW',
    irrigation_period_in_hours  int,
    created_at                  timestamp with time zone default current_timestamp,
    irrigated_at                timestamp with time zone,
    primary key (id)
);