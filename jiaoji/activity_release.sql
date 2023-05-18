create table jiaoji.activity_release
(
    user_id int null,
    act_id  int null,
    serial  int auto_increment
        primary key,
    constraint fk_release1
        foreign key (user_id) references jiaoji.userauth (user_id),
    constraint fk_release2
        foreign key (act_id) references jiaoji.activity_details (id)
);

