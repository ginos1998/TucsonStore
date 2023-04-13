-- auto-generated definition
create table pais
(
    id_pais int auto_increment
        primary key,
    pais    varchar(50) not null
);

-- auto-generated definition
create table provincia
(
    id_provincia int auto_increment
        primary key,
    id_pais      int         not null,
    provincia    varchar(50) not null,
    cod_postal   varchar(10) null,
    constraint foreign_key_name
        foreign key (id_pais) references pais (id_pais)
);

create table ciudad
(
    id_ciudad    int auto_increment,
    ciudad       varchar(50) not null,
    id_provincia int         not null,
    constraint pk_ciudad
        primary key (id_ciudad),
    constraint fk_provincia
        foreign key (id_provincia) references provincia (id_provincia)
);

alter table socio
    add id_ciudad int null;

alter table socio
    add constraint fk_socio_ciudad
        foreign key (id_ciudad) references ciudad (id_ciudad);

