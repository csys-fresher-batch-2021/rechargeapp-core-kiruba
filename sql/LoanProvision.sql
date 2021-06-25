create table loan(
	id serial primary key not null,
	user_Id int not null,
	amount int default 35 ,
	status varchar(10) default 'success',
	loan_Date timeStamp default current_timestamp
);