create table client(
	id serial primary key,
	shared_key varchar(40) Unique,
	name varchar(100),
	phone varchar(10),
	email varchar(100) unique,
	start_date date,
	end_date date
)