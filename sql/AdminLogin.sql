create table admin(
	id serial primary key,
	admin_name varchar(20) unique not null,
	admin_password varchar(20) not null
);