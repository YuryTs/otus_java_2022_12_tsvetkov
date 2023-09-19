create table Manager -- хорошая практика проверить что такая таблица не существует create `table if not exist Manager` и наименование таблицы писать через snake_case ('client_details')
(
    id    varchar(50) not null primary key,--не указывается как должен задаваться id т.е. означает что мы должны его задавать сами
    label varchar(50)
);

create table client
(
    id           bigserial   not null primary key, -- bigserial указывает как будет генерироваться ключи
    order_column int         not null,
    name         varchar(50) not null,
    manager_id   varchar(50) not null references Manager (id) --ссылается на Manager что означает что будет один ко многим (менеджер один а клиентов много)
);
create index idx_client_manager_id on client (manager_id); -- создается индекс для клиента по manager_id

create table client_details
(
    client_id bigint      not null references client (id), -- многие к одному (у одного клиента может быть несколько деталей)
    info      varchar(50) not null
);

create table table_with_pk --
(
    id_part1 varchar(10),
    id_part2 varchar(100),
    value    varchar(100)
);
alter table table_with_pk add primary key (id_part1, id_part2); -- сурагатный ключ состоит из двух полей
