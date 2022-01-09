create table roles
(
    id   serial primary key,
    name varchar(64)
);

create table user_roles
(
    user_id int,
    role_id int
);

create table users
(
    id       serial primary key,
    email    varchar(64) unique,
    password text,
    username varchar(64) unique
);

alter table user_roles
    add constraint user_roles_user_id_fk
        foreign key (user_id) references users (id);

alter table user_roles
    add constraint user_roles_role_id_fk
        foreign key (role_id) references roles (id);

insert into roles (name)
values ('ROLE_USER');
insert into roles (name)
values ('ROLE_ADMIN');

create table plant
(
    id              serial primary key,
    insolation integer,
    irrigation integer,
    name            varchar(256),
    latin_name      varchar(256),
    plant_type      integer,
    soil_type       integer,
    user_id         integer
);

create table fertilization
(
    id        serial primary key,
    name      varchar(256),
    amount    decimal,
    date_from date,
    date_to   date,
    user_id   integer,
    plant_id integer
);

create table formation
(
    id             serial primary key,
    formation_type varchar(256),
    date_from      date,
    date_to        date,
    user_id        integer,
    plant_id integer
);

create table irrigation_date
(
    id      serial primary key,
    note    varchar(256),
    date    date,
    user_id integer,
    plant_id integer
);

create table prune
(
    id        serial primary key,
    note      varchar(256),
    amount    decimal,
    date_from date,
    date_to   date,
    user_id   integer,
    plant_id integer
);

create table repotting
(
    id      serial primary key,
    note    varchar(256),
    date    date,
    user_id integer,
    plant_id integer
);

create table spraying
(
    id        serial primary key,
    name      varchar(256),
    amount    decimal,
    date_from date,
    date_to   date,
    user_id   integer,
plant_id integer
);






