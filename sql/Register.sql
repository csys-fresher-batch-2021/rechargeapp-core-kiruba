create table user_table(
    id serial PRIMARY KEY,
	username varchar(30)  unique not null,
	userpassword varchar(30) not null,
	email varchar(30) unique not null,
	mobileNumber varchar(10) unique,
	age int,
	adhaarNo varchar(20)unique,
	CONSTRAINT age CHECK (age>0 AND age<=100)
	
);

select * from user_table;


