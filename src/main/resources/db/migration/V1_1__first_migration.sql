create table user
(
    id        int auto_increment
        primary key,
    firstName varchar(30)                            not null,
    lastName  varchar(30)                            not null,
    email     varchar(60)                            not null,
    password  varchar(40)                            not null,
    role      enum ('ADMIN', 'DEVELOPER', 'ANALYST') null,
    constraint user_email_uindex
        unique (email)
);