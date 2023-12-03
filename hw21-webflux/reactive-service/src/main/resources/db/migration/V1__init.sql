create table if not exists products (
     id bigserial primary key,
     name varchar(255)
    );

insert into products(id,name) values (1,'Phone');
insert into products(id,name) values (2,'Auto');