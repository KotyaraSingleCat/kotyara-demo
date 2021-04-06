create table tickets
(
    id int auto_increment,
    name varchar(50) not null,
    description varchar(120),
    user_id int not null,
    status enum ('ACTIVE', 'CLOSED', 'EXPIRED', 'READY TO TEST', 'IN PROGRESS') not null,
    priority enum ('CRITICAL', 'HIGH', 'MEDIUM', 'LOW', 'OPTIONAL') not null,
    time_spent varchar(30),
    time_estimated varchar(30) not null,
    created_date date not null,
    type varchar(30) not null,
    constraint id
        primary key (id),
    constraint user_id FOREIGN KEY (user_id)
    references users(id)
);