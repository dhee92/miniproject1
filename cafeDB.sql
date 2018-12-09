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
	no				number(4),
	Msalary		number(5),
	name			varchar2(20),
	workhour 	number(2),
	tel				varchar2(20)
	);
		
--회원	
drop table customer;
create table customer( --이름, 회원번호, 폰번호, 스탬프
	no				number(4) primary key,
	name			varchar2(20),
	tel				varchar2(20),
	stamp			number(4)
	);
select * from customer;
insert into customer values(1, 'Dahee Lee', '01073706727', 1);

--일별 영업이익
drop table benefit;
create table benefit( 
	YYYMMDD			varchar2(20),
	moneyofday		number(9)
	);
select * from benefit;
insert into benefit values( 'AAAA', 12);
update benefit set moneyofday = moneyofday+10 where YYYMMDD='AAAA';
