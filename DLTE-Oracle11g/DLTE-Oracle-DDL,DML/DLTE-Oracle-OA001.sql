-- Query for creating a table 'card'
create table card(card_no int not null,car_holder varchar(25),card_pin int,card_expiry date,limit int);

alter table card add constraint card_pk primary key(card_number);

create sequence card_pk start with 1111444455556660 increment by 1;

insert into card(card_noumber,car_holder,card_pin,card_expiry,limit) values(card_pk.NEXTVAL,'Abhishek',1234,'04-30-2024',10000);

insert into card(card_number,car_holder,card_pin,card_expiry,limit) values(card_pk.NEXTVAL,'Gourav',9867,'01-30-2024',15000);

insert into card(card_number,car_holder,card_pin,card_expiry,limit) values(card_pk.NEXTVAL,'Shrinidhi',9422,'03-29-2024',2000);

insert into card(card_number,car_holder,card_pin,card_expiry,limit) values(card_pk.NEXTVAL,'Manvith',1245,'02-22-2024',20000);

insert into card(card_number,car_holder,card_pin,card_expiry,limit) values(card_pk.NEXTVAL,'Kirtan',3454,'02-28-2024',8000);

insert into card(card_number,car_holder,card_pin,card_expiry,limit) values(card_pk.NEXTVAL,'Amrutha',8822,'05-30-2024',2500);

insert into card(card_number,car_holder,card_pin,card_expiry,limit) values(card_pk.NEXTVAL,'Pooja',5657,'06-28-2024',6000);

insert into card(card_number,car_holder,card_pin,card_expiry,limit) values(card_pk.NEXTVAL,'Surya',0989,'07-28-2024',5700);

insert into card(card_number,car_holder,card_pin,card_expiry,limit) values(acrd_pk.NEXTVAL,'Apoorva',7224,'09-28-2024',19000);

insert into card(card_number,car_holder,card_pin,card_expiry,limit) values(card_pk.NEXTVAL,'Aishwarya',4689,'08-28-2024',8900);

select * from card;

update card set card_expiry='12-31-2099' where card_number=1111444455556660;

update card set card_expiry='12-31-2098' where card_number=1111444455556661;

update card set card_expiry='12-31-2097' where card_number=1111444455556662;

update card set card_expiry='12-31-2096' where card_number=1111444455556663;

update card set card_expiry='12-31-2095' where card_number=1111444455556664;

update card set card_expiry='12-31-2094' where card_number=1111444455556665;

update card set card_expiry='12-31-2093' where card_number=1111444455556666;

update card set card_expiry='12-31-2092' where card_number=1111444455556667;

update card set card_expiry='12-31-2091' where card_number=1111444455556668;

update card set card_expiry='12-31-2090' where card_number=1111444455556669;


