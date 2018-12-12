--재고
create table stock(
	Bean		number(6),
	Milk		number(6),
	Choco	number(6),
	Vanilla	number(6)
	);
select * from stock;

--직원
drop table employee;
create table employee(
	no				number(4) primary key,
	name			varchar2(20),
	tel				varchar2(20),
	Msalary		number(5),
	workhour 	number(2)
	);
select * from employee;
	
--회원	
drop table customer;
create table customer( --이름, 회원번호, 폰번호, 스탬프
	no				number(4) primary key,
	name			varchar2(20),
	tel				varchar2(20),
	stamp			number(4)
	);
select * from customer;


--일별 영업이익
drop table benefit;
create table benefit( 
	YYYYMMDD			varchar2(20),
	moneyofday		number(9)
	);
select * from benefit where yyyymmdd='2018/12/12';
insert into benefit values('2018/12/12', 0);
insert into benefit values('2018/12/13', 0);
