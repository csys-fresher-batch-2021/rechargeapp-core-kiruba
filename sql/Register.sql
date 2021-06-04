create table user_table(
	username varchar(30)  unique not null,
	userpassword varchar(30) not null,
	email varchar(30) unique not null,
	mobileNo varchar(10) unique,
	age int,
	adhaarNo varchar(20)unique
);

select * from user_table;

select * from register where age >0;
