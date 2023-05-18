create table jiaoji.user
(
    userId    int          not null
        primary key,
    nickname  varchar(255) null,
    username  varchar(255) null,
    gender    int          null,
    tel       varchar(255) null,
    avatar    varchar(255) null,
    college   varchar(255) null,
    studentId varchar(255) null,
    club      varchar(255) null,
    mail      varchar(255) null,
    grade     int          null,
    constraint fk_userauth
        foreign key (userId) references jiaoji.userauth (user_id)
);

