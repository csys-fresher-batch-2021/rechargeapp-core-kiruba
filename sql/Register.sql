create table register(
	username varchar(30)  unique not null,
	userpassword varchar(30) unique,
	email varchar(30) not null,
	mobileNo varchar(10) unique,
	age varchar(10),
	adhaarNo varchar(20)unique
);

select * from register;