-- auto-generated definition
create table rubro
(
    id_rubro   int auto_increment
        primary key,
    rubro      varchar(40)      not null,
    habilitado char default 'S' null
);

-- auto-generated definition
create table marca
(
    id_marca   int auto_increment
        primary key,
    marca      varchar(40)      not null,
    habilitada char default 'S' null
);

-- auto-generated definition
create table subrubro
(
    id_subrubro int auto_increment
        primary key,
    id_rubro    int              not null,
    subrubro    varchar(40)      not null,
    habilitado  char default 'S' null,
    constraint subrubro_rubro_null_fk
        foreign key (id_rubro) references rubro (id_rubro)
);

-- auto-generated definition
create table producto
(
    id_producto   int auto_increment
        primary key,
    producto      varchar(100)     not null,
    id_marca      int              not null,
    id_rubro      int              not null,
    id_subrubro   int              null,
    precio        double           not null,
    ctd_diponible int  default 1   not null,
    id_user       int              not null,
    habilitado    char default 'S' null,
    constraint producto_marca_null_fk
        foreign key (id_marca) references marca (id_marca),
    constraint producto_rubro_null_fk
        foreign key (id_rubro) references rubro (id_rubro),
    constraint producto_subrubro_null_fk
        foreign key (id_subrubro) references subrubro (id_subrubro),
    constraint producto_user_id_user_fk
        foreign key (id_user) references user (id_user)
);

