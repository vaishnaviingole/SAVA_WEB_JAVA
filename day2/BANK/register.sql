use bankJd;
create table users(userid int primary key auto_increment,custName varchar(20), city varchar(20),email varchar(20),password varchar(20));

insert into users(custname,city,email,password) values ('Ram','Pune','ram@gmail.com','ram@123');

 insert into users(custname,city,email,password) values ('Sham','Pune','sham@gmail.com','sham@123');

insert into users(custname,city,email,password) values ('Seeta','Mumbai','seeta@gmail.com','seeta@123');