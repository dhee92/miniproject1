create table stock(
	Bean		number(6),
	Milk		number(6),
	Choco	number(6),
	Vanilla	number(6)
	);
select * from stock;
insert into stock 
values(6000, 10000, 2000, 2000); 

drop table employee;
create table employee(
	no				number(4),
	Msalary		number(5),
	name			varchar2(20),
	workhour 	number(2),
	tel				varchar2(20)
	);
