create table bank(cust_id int not null,password varchar(25) not null,name varchar(25) not null,balance int not null);

alter table bank add constraint bank_pk primary key(cust_id);

create sequence bank_pk start with 100000 increment by 1;

create table payee(Name varchar(25) not null,payee_acc int not null,cust_id int not null);

alter table payee add constraint payee_fk foreign key(cust_id) references bank(cust_id);

