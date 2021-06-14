create table popular_plans(
	id serial primary key,
	plan int,
	network_name varchar(10),
	validity varchar(20),
	mobile_Data varchar(20),
	subscriptions varchar(30)
);
select * from popular_plans;

create table network(
	
	network_name varchar(20) unique not null
);
select * from network;