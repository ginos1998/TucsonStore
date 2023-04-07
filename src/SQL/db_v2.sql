-- auto-generated definition
create table user
(
    id_user                 int auto_increment
        primary key,
    username                varchar(20)      not null,
    password                varchar(255)     not null,
    email                   varchar(50)      not null,
    roles                   varchar(20)      not null,
    enabled                 char default 'S' not null,
    account_non_expired     char default 'S' not null,
    account_non_locked      char default 'S' not null,
    credentials_non_expired char default 'S' not null
);

-- auto-generated definition
create table socio
(
    id_socio  int auto_increment
        primary key,
    id_user   int         not null,
    nombre    varchar(20) not null,
    apellido  varchar(25) not null,
    dni       varchar(8)  not null,
    domicilio varchar(20) null,
    constraint fk_socio_user
        foreign key (id_user) references user (id_user)
);



