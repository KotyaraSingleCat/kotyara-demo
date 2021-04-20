create table roles
(
    id   int auto_increment
        primary key,
    role enum ('ADMIN', 'DEVELOPER', 'ANALYST') not null,
    constraint user_role_uindex
        unique (role)
);

create table action_points
(
    id   int auto_increment
        primary key,
    point enum ('VIEW_ALL_RECORDS', 'VIEW_OWN_RECORDS', 'CREATE_TICKET', 'CLOSE_TICKET') not null,
    constraint user_point_uindex
        unique (point)
);

create table action_points_roles
(
    id              int auto_increment
                       primary key,
    role_id         int not null,
    action_point_id int not null,
    constraint action_points_roles_ibfk_1
        foreign key (role_id) references roles (id)
            on delete cascade,
    constraint action_points_roles_ibfk_2
        foreign key (action_point_id) references action_points (id)
            on delete cascade
);

create index action_point_id
    on action_points_roles (action_point_id);

create index role_id
    on action_points_roles (role_id);

create table users
(
	id int auto_increment,
	firstName varchar(30) not null,
	lastName varchar(30) not null,
	email varchar(60) not null,
	password varchar(40) not null,
	role_id int not null,
	constraint id
		primary key (id),
	constraint user_email_uindex
        unique (email),
    FOREIGN KEY (role_id)
        REFERENCES roles(id)
        ON DELETE CASCADE
);

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
    created_date timestamp not null,
    type varchar(30) not null,
    constraint id
        primary key (id),
    constraint user_id FOREIGN KEY (user_id)
    references users(id)
);