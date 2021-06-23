create table additionalplan_Payment(
	id serial primary key not null,
	userId int not null,
    scheme int not null,
	network varchar(20) not null,
	validity varchar(20) not null,
	mobile_Data varchar(20) not null,
	subscriptions varchar(20) not null,
	mobile_Number varchar(20) not null,
    transaction_Date timestamp default current_timestamp not null
	
);
create table extra_Plan(
	id serial primary key not null,
	plan int not null,
	network varchar(20) not null,
	validity varchar(20) not null,
	mobile_data varchar(20) not null,
	subscriptions varchar(20) not null
);