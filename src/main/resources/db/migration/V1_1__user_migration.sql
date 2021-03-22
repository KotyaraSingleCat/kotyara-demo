create table roles
(
    id   int auto_increment
        primary key,
    role enum ('ADMIN', 'DEVELOPER', 'ANALYST') not null
);

create table action_points
(
    id   int auto_increment
        primary key,
    point enum ('VIEW_ALL_RECORDS', 'VIEW_OWN_RECORDS', 'CREATE_TICKET', 'CLOSE_TICKET') not null
);

create table action_points_roles
(
    role_id   int,
    action_point_id int,
    FOREIGN KEY (role_id)
        REFERENCES roles(id)
        ON DELETE CASCADE,
    FOREIGN KEY (action_point_id)
        REFERENCES action_points(id)
        ON DELETE CASCADE
);

create table user
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
