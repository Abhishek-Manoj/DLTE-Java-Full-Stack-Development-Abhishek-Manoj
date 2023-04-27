-- CREATION OF TABLES
--BANK TABLE--
create table bank(bank_id int not null, bank_name varchar(255) not null,bank_address varchar(255) not null);
alter table bank add constraint bank_id_seq primary key(bank_id);
create sequence bank_id_seq start with 1 increment by 1;

--BRANCH TABLE--
create table branch(branch_id int not null, branch_name varchar(255) not null, branch_address varchar(255) not null, branch_ifsc varchar(255) not null, bank_id int not null);
create sequence branch_id_seq start with 10 increment by 1;
alter table branch add constraint branch_id_seq primary key(branch_id);
alter table branch add foreign key(bank_id) references bank(bank_id);

--CUSTOMER TABLE--
create table customer(customer_id int not null, customer_name varchar(255) not null,customer_address varchar(255) not null, customer_status varchar(255) not null,customer_contact int not null,username varchar(255) not null,password varchar(255) not null,failed_attempts int);
create sequence customer_id_seq start with 100 increment by 1;
alter table customer add constraint customer_id_seq primary key(customer_id);

--PROFILE TABLE--
create table profile(profile_id int not null, profile_pan varchar(255) not null, profile_aadhaar int not null, profile_status varchar(255) not null, customer_id int not null);
create sequence profile_id_seq start with 1000 increment by 1;
alter table profile add constraint profile_id_seq primary key(profile_id);
alter table profile add foreign key(customer_id) references customer(customer_id);

--ACCOUNT TABLE--
create table account(account_id int  not null, account_type varchar(255) not null,account_number int not null, account_avl_balance float not null,account_status varchar(255) not null,customer_id int not null,branch_id int not null);
create sequence account_id_seq start with 10000 increment by 1; 
alter table account add constraint account_id_seq primary key(account_id);
alter table account add foreign key(customer_id) references customer(customer_id);
alter table account add foreign key(branch_id) references branch(branch_id);
alter table account modify (account_number unique);

--LOAN TABLE--
create table loan(loan_app_id int not null, loan_amount float not null, loan_emi float not null,loan_scheme_id int not null,customer_id int not null,loan_tenure int not null);
create sequence loan_app_id_seq start with 20000 increment by 1;
alter table loan add constraint loan_app_id_seq primary key(loan_id);
alter table loan add foreign key(customer_id) references customer(customer_id);
alter table loan add foreign key(loan_scheme_id) references loan_scheme(loan_scheme_id);

--TRANSACTION TABLE--
create table transaction(txn_id int not null,txn_from int not null,txn_to int not null,txn_amount int not null,txn_status varchar(255)not null,txn_date date not null);
create sequence txn_id_seq start with 2000 increment by 1;
alter table transaction add constraint txn_id_seq primary key(txn_id);
alter table transaction add foreign key(txn_from) references account(account_number);
alter table transaction add foreign key(txn_to) references account(account_number);

--ROLE TABLE--
create table role(role_id int not null,role_name varchar(255)not null,role_decs varchar(255)not null,role_status varchar(255)not null,branch_id int not null);
create sequence role_seq start with 20 increment by 1;
alter table role add constraint role_seq primary key(role_id);
alter table role add foreign key(branch_id) references branch(branch_id);

--LOAN SCHEME TABLE--
create table loan_scheme(loan_scheme_id int not null, loan_scheme_type varchar(255) not null, loan_scheme_name varchar(255) not null,loan_scheme_decr varchar(255) not null,loan_scheme_duration int not null);
create sequence loan_type_id_seq start with 100000 increment by 1;
alter table loan_scheme add constraint loanscheme_seq primary key(loan_id);

--PAYEE TABLE--
create table payee(payee_id int not null, payee_name varchar(255) not null,payee_account_number int not null,customer_id int not null);
create sequence payee_seq start with 200 increment by 1;
alter table payee add constraint payee_seq primary key(payee_id);
alter table payee add foreign key(customer_id) references customer(customer_id);
alter table payee add foreign key(payee_account_number) references account(account_number);

-- INSERTION OF RECORDS
-- BANK
insert into bank values(bank_id_seq.NEXTVAL,'Vibe Bank','Sweden');

-- BRANCH 
insert into branch values(branch_id_seq.NEXTVAL,'Stockholm','Ragnar Östbergs Plan 1. Stadshuset, 105 35 STOCKHOLM, Sverige','VIBE5678876',1);
insert into branch values(branch_id_seq.NEXTVAL,'Gothenburg','Köpmansgatan 20,404 82 Göteborg,Sverige','VIBE8764456',1);
insert into branch values(branch_id_seq.NEXTVAL,'Abisko','Kalle Jons väg 13, 981 07 Abisko, Sweden','VIBE1234567',1);

-- ROLE
insert into role values(role_id_seq.NEXTVAL,'Admin','has all privileges','Active',10,'abhishek','abhipass');
insert into role values(role_id_seq.NEXTVAL,'Official','has privileges to manage the loans and account activities','Active',10,'manoj','manojpass');
insert into role values(role_id_seq.NEXTVAL,'Admin','has all privileges','Active',11,'sheeba','sheebapass');
insert into role values(role_id_seq.NEXTVAL,'Official','has privileges to manage the loans and account activities','Active',11,'dev','devpass');
insert into role values(role_id_seq.NEXTVAL,'Admin','has all privileges','Active',12,'anu','anupass');
insert into role values(role_id_seq.NEXTVAL,'Official','has privileges to manage the loans and account activities','Active',12,'aashu','aashupass');

-- CUSTOMER
insert into customer values(customer_id_seq.NEXTVAL,'Kiran','XYZ Road,ABC Street,122','Active',9876543223,'kiran','kiranpass');
insert into customer values(customer_id_seq.NEXTVAL,'Hemanth','GHI Road,KHF Street,988','Active',1234568775,'hemanth','hemanthpass');
insert into customer values(customer_id_seq.NEXTVAL,'Anvis','WER Street,ASD Road,654','Active',7864386458,'anvis','anvispass');
insert into customer values(customer_id_seq.NEXTVAL,'Mridul','YUI Road,RTY Street,975','Active',8768735558,'mridul','mridulpass');

-- ACCOUNT
insert into account values(account_id_seq.NEXTVAL,'Savings',123456789012,800000,'Active',100,10);
insert into account values(account_id_seq.NEXTVAL,'Current',876534567765,300000,'Active',100,12);
insert into account values(account_id_seq.NEXTVAL,'Savings',375487383718,900000,'Active',101,11);
insert into account values(account_id_seq.NEXTVAL,'Current',654323456797,450000,'Active',101,10);
insert into account values(account_id_seq.NEXTVAL,'Savings',987649866431,600000,'Active',102,12);
insert into account values(account_id_seq.NEXTVAL,'Current',963467643768,200000,'Active',102,12);
insert into account values(account_id_seq.NEXTVAL,'Savings',867876578618,850000,'Active',103,10);
insert into account values(account_id_seq.NEXTVAL,'Current',123456765432,550000,'Active',103,11);

-- TRANSACTIONS
insert into transaction values(txn_id_seq.NEXTVAL,123456789012,654323456797,10000,'completed','31-DEC-2022');
insert into transaction values(txn_id_seq.NEXTVAL,876534567765,375487383718,10000,'completed','31-DEC-2022');
insert into transaction values(txn_id_seq.NEXTVAL,375487383718,123456765432,23000,'completed','30-JAN-2023');
insert into transaction values(txn_id_seq.NEXTVAL,654323456797,963467643768,30000,'completed','30-MAR-2023');
insert into transaction values(txn_id_seq.NEXTVAL,987649866431,123456789012,50000,'processing','30-APR-2023');
insert into transaction values(txn_id_seq.NEXTVAL,963467643768,375487383718,40000,'processing','10-APR-2023');
insert into transaction values(txn_id_seq.NEXTVAL,867876578618,987649866431,25000,'pending','20-MAR-2023');
insert into transaction values(txn_id_seq.NEXTVAL,123456765432,876534567765,60000,'pending','28-FEB-2023');

-- PAYEE
insert into payee values(payee_id_seq.NEXTVAL,'Hemanth',654323456797,100);
insert into payee values(payee_id_seq.NEXTVAL,'Anvis',987649866431,100);
insert into payee values(payee_id_seq.NEXTVAL,'Mridul',123456765432,101);
insert into payee values(payee_id_seq.NEXTVAL,'Anvis',963467643768,101);
insert into payee values(payee_id_seq.NEXTVAL,'Kiran',123456789012,102);
insert into payee values(payee_id_seq.NEXTVAL,'Hemanth',375487383718,102);
insert into payee values(payee_id_seq.NEXTVAL,'Anvis',987649866431,103);
insert into payee values(payee_id_seq.NEXTVAL,'Kiran',876534567765,103);

-- PROFILE
insert into profile values(profile_id_seq.NEXTVAL,'QWERT1234Y',456776542345,'Active',100);
insert into profile values(profile_id_seq.NEXTVAL,'POIUY7890T',975678976712,'Active',101);
insert into profile values(profile_id_seq.NEXTVAL,'ASDGF3456H',123456654321,'Active',102);
insert into profile values(profile_id_seq.NEXTVAL,'CVBNM7612Z',876543345678,'Active',103);

-- LOAN_SCHEME
insert into loan_scheme values(loan_type_id_seq.NEXTVAL,'Education','StudieKredit','a sum of money borrowed to finance post-secondary education or higher education-related expenses',6);
insert into loan_scheme values(loan_type_id_seq.NEXTVAL,'Car','BilKredit','for the purpose of purchasing a car or other motor vehicle',4);
insert into loan_scheme values(loan_type_id_seq.NEXTVAL,'Housing','HemmaLan','for the purpose of purchasing a home or other residential property',2);

-- LOAN