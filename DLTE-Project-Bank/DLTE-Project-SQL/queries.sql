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