Create table payment_Details(
	id serial primary key not null,
	user_id int not null,
	network varchar(20) not null,
	amount int not null,
	mobile_no varchar(10)  not null,
	transaction_date timestamp default current_timestamp
	
)
