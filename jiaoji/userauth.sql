create table jiaoji.userauth
(
    user_id   int          not null
        primary key,
    username  varchar(255) null,
    password  varchar(255) null,
    user_type int          null
);

