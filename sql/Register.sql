create table User(
    id serial PRIMARY KEY,
	username varchar(30)  unique not null,
	userpassword varchar(30) not null,
	email varchar(30) unique not null,
	mobile_Number varchar(10) unique,
	age int,
	adhaar_Number varchar(20)unique,
	CONSTRAINT age CHECK (age>0 AND age<=100)
	
);

select * from user_table;


