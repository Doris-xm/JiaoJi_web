create table jiaoji.activity_details
(
    id                int auto_increment
        primary key,
    name              varchar(255) null,
    content           varchar(255) null,
    location          varchar(255) null,
    signupTime        varchar(255) null,
    activityTime      varchar(255) null,
    departments       varchar(255) null,
    signupRestriction varchar(255) null,
    college           varchar(255) null,
    grade             varchar(255) null,
    club              varchar(255) null,
    recruitmentNumber int          null,
    remainingNumber   int          null,
    organizer         varchar(255) null,
    suScore           int          null,
    laborHour         int          null,
    status            int          null,
    comments          varchar(255) null,
    photo             varchar(255) null
);

