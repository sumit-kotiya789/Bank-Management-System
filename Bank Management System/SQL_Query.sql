create database bankmanagementsystem;
show databases;
use bankmanagementsystem;

create table signup(
	formNum varchar(30),
	name varchar(30),
	fatherName varchar(30),
	dob varchar(30),
	gender varchar(30),
	email varchar(30),
	marital varchar(30),
	address varchar(50),
	city varchar(30),
	pinCode varchar(30),
	state varchar(30)
);

create table signup2(
	formNo varchar(30) primary key,
	religion varchar(30),
	category varchar(30),
	income varchar(30),
	education varchar(30),
	occupation varchar(30),
	aadharNum varchar(30),
	panNum varchar(50),
	seniorCitizen varchar(30),
	existingAccount varchar(30)
);

create table signup3(
	formNo varchar(30),
	AccountType varchar(30),
	Card_Number varchar(30),
	PIN varchar(30),
	Services varchar(100)
);

create table login(
	formNo varchar(30),
	Card_Number varchar(30),
	PIN varchar(30)
);

select*from signup;
select*from signup2;
select*from signup3;
select*from login;
