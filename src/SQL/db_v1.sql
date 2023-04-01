-- auto-generated definition
create table User (
    idUser   int auto_increment
        primary key,
    email    varchar(255)                    null,
    name     varchar(255)                    null,
    password varchar(255)                    null,
    roles    varchar(20) default 'ROLE_USER' not null
)
    engine = MyISAM;