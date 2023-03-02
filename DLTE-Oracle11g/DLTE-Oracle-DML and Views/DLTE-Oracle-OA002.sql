create view low_limit as select * from card where limit<10000;
create view pin as select car_holder,card_pin from card;

select * from low_limit;
select * from pin;

