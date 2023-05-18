create table jiaoji.activity_signup
(
    user_id        int  null,
    act_id         int  null,
    state          int  null,
    comment        int  null,
    comment_detail text null,
    comment_photo  text null,
    posted         int  null,
    post_time      text null,
    serial         int auto_increment
        primary key,
    constraint fk_signup1
        foreign key (user_id) references jiaoji.userauth (user_id),
    constraint fk_signup2
        foreign key (act_id) references jiaoji.activity_details (id)
);

