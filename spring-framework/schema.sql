create database if not exists demo;

use demo;

drop table if exists t_user;

create table if not exists t_user (
	id int primary key auto_increment,
    name varchar(50) unique not null,
    password varchar(128) not null
);

insert into t_user(name, password) 
values('admin', 'admin'),('reion', '123');


SELECT * FROM t_user;

delete from t_user where id = 6;

