alter table if exists plot
    add column if not exists amount_of_water int;

alter table if exists plot
    alter column irrigated_at set default current_timestamp;