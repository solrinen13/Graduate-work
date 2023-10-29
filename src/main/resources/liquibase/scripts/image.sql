--liquibase formatted sql
create table image
(
    id         bigint generated by default as identity
        primary key,
    data       byte,
    file_size  bigint not null,
    media_type varchar(255)
);