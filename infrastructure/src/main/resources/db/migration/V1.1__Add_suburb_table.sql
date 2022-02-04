create table suburb
(
    id       bigserial    not null primary key,
    name     varchar(255) not null,
    postcode bigint       not null

);

create index index_suburb_post_code
    on suburb (postcode);