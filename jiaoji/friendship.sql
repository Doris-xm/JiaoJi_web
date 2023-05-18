create table jiaoji.friendship
(
    user_a   int                                               not null,
    user_b   int                                               not null,
    relation enum ('WaitForA', 'WaitForB', 'Friend', 'Delete') null,
    primary key (user_a, user_b),
    constraint fk1_friendship
        foreign key (user_a) references jiaoji.user (userId),
    constraint fk2_friendship
        foreign key (user_b) references jiaoji.user (userId)
);

